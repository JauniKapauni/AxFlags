package de.jaunikapauni.axflags;

import listener.BlockBreakListener;
import listener.BlockPlaceListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AxFlags extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean getFlag(String world, String flag){
        return getConfig().getBoolean("worlds." + world + "." + flag, true);
    }
}
