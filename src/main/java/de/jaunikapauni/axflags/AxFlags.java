package de.jaunikapauni.axflags;

import de.jaunikapauni.axflags.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class AxFlags extends JavaPlugin {

    Map<String, Map<String, Boolean>> flags = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        loadFlags();
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerBucketEmptyListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerBucketFillListener(this), this);
        getServer().getPluginManager().registerEvents(new PVPListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockExplodeListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityExplodeListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBurnListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockIgniteListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockPistonExtendListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockPistonRetractListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityChangeBlockListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItemListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityPickupItemListener(this), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(this), this);
        getServer().getPluginManager().registerEvents(new CreatureSpawnListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        getServer().getPluginManager().registerEvents(new WeatherChangeListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean getFlag(String world, String flag){
        return flags.getOrDefault(world, Collections.emptyMap()).getOrDefault(flag, true);
    }

    public void loadFlags(){
        for(String w : getConfig().getConfigurationSection("worlds").getKeys(false)){
            Map<String, Boolean> worldFlags = new HashMap<>();
            for(String flag : getConfig().getConfigurationSection("worlds." + w).getKeys(false)){
                worldFlags.put(flag, getConfig().getBoolean("worlds." + w + "." + flag));
            }
            flags.put(w, worldFlags);
        }
    }
}
