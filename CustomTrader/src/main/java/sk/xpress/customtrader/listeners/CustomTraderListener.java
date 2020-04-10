package sk.xpress.customtrader.listeners;

import org.bukkit.Bukkit;
import org.bukkit.StructureType;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.scheduler.BukkitRunnable;
import sk.xpress.customtrader.Main;
import sk.xpress.customtrader.handlers.ItemBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class CustomTraderListener implements Listener {
    @EventHandler
    private void onVillagerCareerChangeEvent(VillagerCareerChangeEvent e){
        final Villager villager = e.getEntity();
        if(e.getProfession() != Villager.Profession.CARTOGRAPHER)
            return;

        new BukkitRunnable() {
            public void run() {
                List<MerchantRecipe> recipes2 = new ArrayList<MerchantRecipe>(villager.getRecipes());

                if(villager.getWorld().getEnvironment() == World.Environment.NETHER) {
                    ItemStack netherFortressMap = new ItemBuilder(getExplorerMap(villager, StructureType.NETHER_FORTRESS)).setName("§eFortress Explorer map").build();
                    recipes2.add(createCustomTrade(new ItemBuilder(Material.EMERALD).setAmount(24).build(), new ItemBuilder(Material.COMPASS).setAmount(1).build(),  netherFortressMap ));

                }else if(villager.getWorld().getEnvironment() == World.Environment.NORMAL){
                    ItemStack outPostMap = new ItemBuilder(getExplorerMap(villager,StructureType.PILLAGER_OUTPOST)).setName("§ePillager outpost Explorer map").build();
                    ItemStack swampHutMap = new ItemBuilder(getExplorerMap(villager, StructureType.SWAMP_HUT)).setName("§eSwamp hut explorer map").build();
                    recipes2.add(createCustomTrade(new ItemBuilder(Material.EMERALD).setAmount(24).build(), new ItemBuilder(Material.COMPASS).setAmount(1).build(), outPostMap));
                    recipes2.add(createCustomTrade(new ItemBuilder(Material.EMERALD).setAmount(22).build(), new ItemBuilder(Material.COMPASS).setAmount(1).build(),  swampHutMap));

                }
                villager.setRecipes(recipes2);
            }
        }.runTaskLater(Main.getInstance(), 10L);
    }

    private ItemStack getExplorerMap(Entity ent, StructureType type){
        return Bukkit.getServer().createExplorerMap(ent.getWorld(), ent.getLocation(), type, 15000, false);
    }

    private MerchantRecipe createCustomTrade(ItemStack ing1, ItemStack ing2, ItemStack result){
        MerchantRecipe recipe = new MerchantRecipe(result, 100);
        List<ItemStack> customTrade = new ArrayList<ItemStack>();
        customTrade.add(ing1);
        if(ing2 != null ) customTrade.add(ing2);
        recipe.setIngredients(customTrade);
        return recipe;
    }
}
