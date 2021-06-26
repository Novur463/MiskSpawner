package com.misk.spawnerfix.objects.command;

import com.misk.spawnerfix.SpawnerFix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    private final SpawnerFix spawnerFix;
    public ReloadCommand(SpawnerFix spawnerFix) {
        this.spawnerFix = spawnerFix;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player)sender;

            if(!player.hasPermission("miskspawner.reload")) {
                player.sendMessage(spawnerFix.getStringUtil().color(spawnerFix.getConfig().getString("noPermission")));
                return true;
            }
        }

        spawnerFix.reload();
        sender.sendMessage(spawnerFix.getStringUtil().color(spawnerFix.getConfig().getString("configReloaded")));
        return true;
    }


}
