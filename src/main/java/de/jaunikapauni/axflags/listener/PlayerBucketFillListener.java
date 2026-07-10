package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class PlayerBucketFillListener implements Listener {

    AxFlags reference;
    public PlayerBucketFillListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent e){
        String world = e.getPlayer().getWorld().getName();
        if(!reference.getFlag(world, "buckets")){
            e.setCancelled(true);
        }
    }
}
