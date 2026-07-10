package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class EntityChangeBlockListener implements Listener {

    AxFlags reference;
    public EntityChangeBlockListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "entity-change-block")){
            e.setCancelled(true);
        }
    }
}
