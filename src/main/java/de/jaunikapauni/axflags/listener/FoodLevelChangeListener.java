package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {

    AxFlags reference;
    public FoodLevelChangeListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e){
        String world = e.getEntity().getWorld().getName();
        if(!reference.getFlag(world, "hunger")){
            e.setCancelled(true);
        }
    }
}
