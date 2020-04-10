package sk.xpress.customtrader;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sk.xpress.customtrader.listeners.CustomTraderListener;

public final class Main extends JavaPlugin {

    private static Plugin instance;

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
    }

    public static Plugin getInstance() {
        return instance;
    }
}
