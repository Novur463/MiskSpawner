package com.misk.spawnerfix.objects.command;

import com.misk.spawnerfix.SpawnerFix;
import com.misk.spawnerfix.objects.enums.Messages;
import com.misk.spawnerfix.objects.enums.Permissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WandCommand implements CommandExecutor {
    private final SpawnerFix spawnerFix;
    public WandCommand(SpawnerFix spawnerFix) {
        this.spawnerFix = spawnerFix;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(!Permissions.isPermissable(player,Permissions.WAND)) {
                spawnerFix.getStringUtil().send(player, Messages.NO_PERMISSION.getMessage());
                return true;
            }

            
        }
        return true;
    }
}
