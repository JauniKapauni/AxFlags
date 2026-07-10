package listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    AxFlags reference;
    public PlayerInteractListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        String world = e.getPlayer().getWorld().getName();
        if(!reference.getFlag(world, "interact")){
            e.setCancelled(true);
        }
    }
}
