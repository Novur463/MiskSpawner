package com.misk.spawnerfix;

import com.misk.spawnerfix.objects.enums.Messages;
import com.misk.spawnerfix.objects.ScanHandler;
import com.misk.spawnerfix.objects.StringUtil;
import com.misk.spawnerfix.objects.command.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnerFix extends JavaPlugin {
    private ScanHandler scanHandler;
    private StringUtil stringUtil;

    public int delayInMinutes;
    public boolean displayResetMessage;

    public static String nbtID = "spawnerwand";

    @Override
    public void onEnable() {
        scanHandler = new ScanHandler(this);
        stringUtil = new StringUtil(this);

        delayInMinutes = getConfig().getInt("scanDelay");
        displayResetMessage = getConfig().getBoolean("displayResetMessage");

        getCommand("reloadspawner").setExecutor(new ReloadCommand(this));

        for(Messages messages : Messages.values()) {
            messages.setMessage(getConfig().getString(messages.getPath()));
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                scanHandler.init();
            }
        }.runTaskTimer(this,10L,getDelay());

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    public void reload() {
        reloadConfig();
        delayInMinutes = getConfig().getInt("scanDelay");
        displayResetMessage = getConfig().getBoolean("displayResetMessage");

        for(Messages messages : Messages.values()) {
            messages.setMessage(getConfig().getString(messages.getPath()));
        }
    }

    public StringUtil getStringUtil() {
        return stringUtil;
    }

    private long getDelayInSeconds() {
        return delayInMinutes * 60;
    }

    private long getDelay() {
        return getDelayInSeconds() * 20;
    }

    public boolean hasDisplayResetMessage() {
        return displayResetMessage;
    }
}
