package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonRetractEvent;

public class BlockPistonRetractListener implements Listener {

    AxFlags reference;
    public BlockPistonRetractListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onPistonRetract(BlockPistonRetractEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "pistons")){
            e.setCancelled(true);
        }
    }
}
