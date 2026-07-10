package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PVPListener implements Listener {

    AxFlags reference;
    public PVPListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onPVP(EntityDamageByEntityEvent e){
        String world = e.getEntity().getWorld().getName();
        if(!reference.getFlag(world, "pvp")){
            e.setCancelled(true);
        }
    }
}
