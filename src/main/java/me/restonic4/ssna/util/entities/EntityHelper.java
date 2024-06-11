package me.restonic4.ssna.util.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;

public class EntityHelper {
    public static void spawn(Entity entity, Level level, BlockPos blockPos) {
        if (level instanceof ServerLevel) {
            entity.moveTo(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, 0, 0);
            level.addFreshEntity(entity);
        }
    }
}
