package com.misk.spawnerfix.objects.item;

import com.misk.spawnerfix.SpawnerFix;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemHandler {
    private final SpawnerFix spawnerFix;
    ItemStack spawnerWand = null;
    public ItemHandler(SpawnerFix spawnerFix) {
        this.spawnerFix = spawnerFix;
    }

    private void init() {
        spawnerWand = new ItemStack(Material.WOOD_HOE);

    }

    public void reload() {
        init();
    }
}
