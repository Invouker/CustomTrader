package sk.xpress.customtrader;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sk.xpress.customtrader.listeners.CompassInteractListener;
import sk.xpress.customtrader.listeners.CustomTraderListener;
public final class Main extends JavaPlugin {

    private static Plugin instance;

    public static final String ITEM_STRUCTURE_KEY_NBT = "STRUCTURE_LOCATE_ITEM";
    public static final String ITEM_STRUCTURE_TYPE_KEY_NBT = "STRUCTURE_LOCATE_ITEM_STRUCTURETYPE";

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic

        registerListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new CustomTraderListener(), this);
        pm.registerEvents(new CompassInteractListener(), this);
    }

    public static Plugin getInstance() {
        return instance;
    }
}
