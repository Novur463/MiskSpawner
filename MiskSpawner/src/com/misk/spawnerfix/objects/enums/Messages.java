package com.misk.spawnerfix.objects.enums;

public enum Messages {
    NO_PERMISSION("messages.no_permission", ""),
    CONFIG_RELOADED("messages.config_reloaded", ""),
    WAND_RECEIVED("messages.wand_received", ""),
    WAND_BLOCK_SELECTED("messages.wand_block_selected", "");

    String path, message;

    Messages(String path, String message) {
        this.path = path;
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}