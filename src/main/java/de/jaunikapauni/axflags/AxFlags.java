package de.jaunikapauni.axflags;

import org.bukkit.plugin.java.JavaPlugin;

public final class AxFlags extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean getFlag(String world, String flag){
        return getConfig().getBoolean("worlds." + world + "." + flag, true);
    }
}
