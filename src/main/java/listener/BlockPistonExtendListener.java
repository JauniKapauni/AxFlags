package listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;

public class BlockPistonExtendListener implements Listener {

    AxFlags reference;
    public BlockPistonExtendListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onPistonExtend(BlockPistonExtendEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "pistons")){
            e.setCancelled(true);
        }
    }
}
