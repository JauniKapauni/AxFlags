package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

    AxFlags reference;
    public PlayerDropItemListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        String world = e.getPlayer().getWorld().getName();
        if(!reference.getFlag(world, "item-drop")){
            e.setCancelled(true);
        }
    }
}
