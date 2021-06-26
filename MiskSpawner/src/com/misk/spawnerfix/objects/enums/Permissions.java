package com.misk.spawnerfix.objects.enums;

import org.bukkit.entity.Player;

public enum Permissions {
    WAND("miskspawner.wand"),
    RELOAD("miskspawner.reload"),
    ALL("miskspawner.*");

    String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public static boolean isPermissable(Player player, Permissions permissions) {
        return player.hasPermission(permissions.getPermission());
    }
}
