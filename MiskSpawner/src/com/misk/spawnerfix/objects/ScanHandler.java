package com.misk.spawnerfix.objects;

import com.misk.spawnerfix.SpawnerFix;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

public class ScanHandler {
    private final SpawnerFix spawnerFix;
    public ScanHandler(SpawnerFix spawnerFix) {
        this.spawnerFix = spawnerFix;
    }

    public void init() {
        for(String locations : spawnerFix.getConfig().getConfigurationSection("locations").getKeys(false)) {
            String worldName = spawnerFix.getConfig().getString("locations." + locations + ".world");
            double x = spawnerFix.getConfig().getDouble("locations." + locations + ".x"), y = spawnerFix.getConfig().getDouble("locations." + locations + ".y"), z = spawnerFix.getConfig().getDouble("locations." + locations + ".z");

            if(Bukkit.getWorld(worldName) == null) {
                spawnerFix.getLogger().severe("[ERROR] MiskSpawner >> World " + worldName + " could not be parsed for location " + locations + "!");
            }

            else {
                World world = Bukkit.getWorld(worldName);
                Location location = new Location(world,x,y,z);

                String toSpawn = spawnerFix.getConfig().getString("locations." + locations + ".entity");

                EntityType entityType;

                try {
                    entityType = EntityType.valueOf(toSpawn);
                } catch(IllegalArgumentException ex) {
                    entityType = null;
                    spawnerFix.getLogger().severe("[ERROR] MiskSpawner >> Entity type " + toSpawn + " could not be parsed for location " + locations + "!");
                }

                if(entityType != null) {

                    Block block = location.getBlock();
                    Chunk chunk = block.getChunk();
                    if(!chunk.isLoaded()) {
                        chunk.load(true);
                    }

                    if (block.getType() == Material.AIR || block.getType() != Material.MOB_SPAWNER) {
                        block.setType(Material.MOB_SPAWNER);
                    }

                    BlockState blockState = block.getState();
                    CreatureSpawner spawner = (CreatureSpawner) blockState;

                    spawner.setSpawnedType(entityType);
                    spawner.update();
                }
            }
        }

        if(spawnerFix.hasDisplayResetMessage()) spawnerFix.getLogger().warning("Spawners reset");
    }
}
