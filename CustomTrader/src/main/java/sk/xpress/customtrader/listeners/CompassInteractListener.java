package sk.xpress.customtrader.listeners;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;
import sk.xpress.customtrader.Main;
import sk.xpress.customtrader.handlers.ItemBuilder;
import sk.xpress.customtrader.handlers.Nbt;

public class CompassInteractListener implements Listener {

    private static final String COMPASS_ITEM_NAME = "§bStructure locator";
    private static String[] COMPASS_ITEM_LORE = new String[] {
            "§r",
            "§7With this item is possible to",
            "§7locate nearest structures.",
            "§7Use R.CLICK",
            "§r",
            "§7Locating: ",
            "§r"};

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getHand() != EquipmentSlot.HAND)
            return;

        switch (event.getAction()) {
            case PHYSICAL:
            case LEFT_CLICK_BLOCK:
            case LEFT_CLICK_AIR:
                return;

            default:
                break;
        }
        ItemStack itemStack = event.getItem();
        if(!event.hasItem())
            return;

        if (itemStack == null || !itemStack.hasItemMeta() || !itemStack.getItemMeta().hasDisplayName() || !itemStack.getItemMeta().getDisplayName().equals(COMPASS_ITEM_NAME))
            return;

        int structureTypeID = Nbt.getNbt_Int(itemStack, Main.ITEM_STRUCTURE_TYPE_KEY_NBT, -1);
        if(!Nbt.getNbt_Bool(itemStack, Main.ITEM_STRUCTURE_KEY_NBT, false) || structureTypeID == -1)
            return;

        StructureAvailable structureAvailable = StructureAvailable.getByID(structureTypeID);
        if(structureAvailable == null)
            return;

        int id = structureTypeID + 1;
        if(StructureAvailable.values().length-1 < id) id = 0;

        structureAvailable = StructureAvailable.getByID(structureTypeID);

        Player player = event.getPlayer();
        ItemStack compass = Nbt.setNbt_Int(getCompass(player, structureAvailable), Main.ITEM_STRUCTURE_TYPE_KEY_NBT, id);
        player.getInventory().setItemInMainHand(compass);
        player.sendMessage("§7§oLocating new structure " + structureAvailable.getStructureType().getName());
    }

    public static ItemStack getCompass(Entity entity, StructureAvailable structureAvailable) {

        COMPASS_ITEM_LORE[5] = "§7Locating: " + structureAvailable.getStructureType().getName();

        ItemStack compass = new ItemBuilder(Material.COMPASS)
                .setName(COMPASS_ITEM_NAME)
                .setLore(COMPASS_ITEM_LORE)
                .addEnchant(Enchantment.ARROW_DAMAGE, 1)
                .addItemFlag(ItemFlag.HIDE_ENCHANTS)
                .build();

        ItemMeta itemMeta = compass.getItemMeta();
        Location locationStructure = null;
        Location entityLocation = entity.getLocation();
        //if(structureAvailable.getStructureType() == StructureType.NETHER_FORTRESS && entityLocation.getWorld().getName().equals("skyblock_nether"))

        locationStructure = entity.getWorld().locateNearestStructure(entityLocation, structureAvailable.getStructureType(), 15000, false);

        CompassMeta compassMeta = ((CompassMeta) itemMeta);
        compassMeta.setLodestoneTracked(false);
        compassMeta.setLodestone(locationStructure);
        compass.setItemMeta(itemMeta);

        compass = Nbt.setNbt_Bool(compass, Main.ITEM_STRUCTURE_KEY_NBT, true);
        compass = Nbt.setNbt_Int(compass, Main.ITEM_STRUCTURE_TYPE_KEY_NBT, structureAvailable.getId());
        return compass;
    }

    public enum StructureAvailable {

        NETHER_FORTRESS(0, StructureType.NETHER_FORTRESS),
        SWAMP_HUT(1, StructureType.SWAMP_HUT),
        PILLAGER_OUTPOST(2, StructureType.PILLAGER_OUTPOST);

        private int id;
        private StructureType structureType;

        StructureAvailable(int id, StructureType structureType) {
            this.id = id;
            this.structureType = structureType;
        }

        public int getId() {
            return id;
        }

        private static StructureAvailable getByID(int id) {
            return StructureAvailable.values()[id];
        }

        public StructureType getStructureType() {
            return structureType;
        }
    }
}
