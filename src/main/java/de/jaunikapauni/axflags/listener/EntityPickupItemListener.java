package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class EntityPickupItemListener implements Listener {

    AxFlags reference;
    public EntityPickupItemListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e){
        String world = e.getEntity().getWorld().getName();
        if(!reference.getFlag(world, "item-pickup")){
            e.setCancelled(true);
        }
    }
}
