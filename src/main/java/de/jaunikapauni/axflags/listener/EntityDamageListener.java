package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    AxFlags reference;
    public EntityDamageListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)){
            return;
        }
        Player p = (Player) e.getEntity();
        String world = p.getWorld().getName();
        if(!reference.getFlag(world, "damage")){
            e.setCancelled(true);
        }
    }
}
