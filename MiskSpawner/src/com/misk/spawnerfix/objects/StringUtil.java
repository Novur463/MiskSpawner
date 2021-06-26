package com.misk.spawnerfix.objects;

import com.misk.spawnerfix.SpawnerFix;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private final SpawnerFix spawnerFix;
    public StringUtil(SpawnerFix spawnerFix) {
        this.spawnerFix = spawnerFix;
    }

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public List<String> color(List<String> stringList) {
        List<String> colorList = new ArrayList<>();
        stringList.forEach( string -> colorList.add(color(string)));
        return colorList;
    }

    public void send(Player player, String message) {
        player.sendMessage(color(message));
    }

    public void send(Player player, List<String> stringList) {
        stringList.forEach(string -> player.sendMessage(color(string)));
    }
}
