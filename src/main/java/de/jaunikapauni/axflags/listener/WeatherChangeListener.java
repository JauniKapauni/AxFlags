package de.jaunikapauni.axflags.listener;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener implements Listener {

    AxFlags reference;
    public WeatherChangeListener(AxFlags reference){
        this.reference = reference;
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        String world = e.getWorld().getName();
        if(!reference.getFlag(world, "weather")){
            if(e.toWeatherState()){
                e.setCancelled(true);
            }
        }
    }
}
