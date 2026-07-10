package listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;

public class BlockBurnListener implements Listener {

    AxFlags reference;
    public BlockBurnListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent e){
        String world = e.getBlock().getWorld().getName();
        if(!reference.getFlag(world, "fire")){
            e.setCancelled(true);
        }
    }
}
