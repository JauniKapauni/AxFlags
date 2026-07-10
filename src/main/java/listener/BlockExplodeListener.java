package listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class BlockExplodeListener implements Listener {

    AxFlags reference;
    public BlockExplodeListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "explosions")){
            e.setCancelled(true);
        }
    }
}
