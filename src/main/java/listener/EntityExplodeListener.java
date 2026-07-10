package listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplodeListener implements Listener {

    AxFlags reference;
    public EntityExplodeListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e){
        String world = e.getLocation().getWorld().getName();
        if(!reference.getFlag(world, "explosions")){
            e.setCancelled(true);
        }
    }
}
