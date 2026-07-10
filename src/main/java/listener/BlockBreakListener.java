package listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    AxFlags reference;
    public BlockBreakListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "break")){
            e.setCancelled(true);
        }
    }
}
