package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    AxFlags reference;
    public BlockPlaceListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "build")){
            e.setCancelled(true);
        }
    }
}
