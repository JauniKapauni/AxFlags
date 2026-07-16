package de.jaunikapauni.axflags.command;

import de.jaunikapauni.axflags.AxFlags;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    AxFlags reference;
    public ReloadCommand(AxFlags reference){
        this.reference = reference;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if(!(sender instanceof Player)){
            return false;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("axflags.reload")){
            p.sendMessage(ChatColor.RED + "You don't have the permission! [axflags.reload]");
            return false;
        }
        reference.reloadFlags();
        return true;
    }
}
