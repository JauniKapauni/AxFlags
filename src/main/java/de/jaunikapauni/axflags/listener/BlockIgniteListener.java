package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class BlockIgniteListener implements Listener {

    AxFlags reference;
    public BlockIgniteListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "fire")){
            e.setCancelled(true);
        }
    }
}
