package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    AxFlags reference;
    public PlayerDeathListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        String world = e.getEntity().getWorld().getName();
        if(reference.getFlag(world, "keep-inventory")){
            e.setKeepInventory(true);
            e.getDrops().clear();
            e.setDroppedExp(0);
        }
    }
}
