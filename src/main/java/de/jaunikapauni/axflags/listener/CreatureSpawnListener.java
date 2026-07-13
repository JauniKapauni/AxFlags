package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnListener implements Listener {

    AxFlags reference;
    public CreatureSpawnListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e){
        String world = e.getLocation().getWorld().getName();
        if(!reference.getFlag(world, "mob-spawning")){
            e.setCancelled(true);
        }
    }
}
