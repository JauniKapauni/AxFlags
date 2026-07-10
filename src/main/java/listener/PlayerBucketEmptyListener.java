package listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class PlayerBucketEmptyListener implements Listener {

    AxFlags reference;
    public PlayerBucketEmptyListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent e){
        String world = e.getPlayer().getWorld().getName();
        if(!reference.getFlag(world, "buckets")){
            e.setCancelled(true);
        }
    }
}
