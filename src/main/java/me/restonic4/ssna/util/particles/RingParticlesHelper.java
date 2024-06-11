package me.restonic4.ssna.util.particles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Range;

public class RingParticlesHelper {
    public static void spawn(ParticleOptions particleOptions, Entity entity, double radius, float velocity) {
        spawn(particleOptions, entity.level(), entity.blockPosition(), radius, velocity);
    }

    public static void spawn(ParticleOptions particleOptions, Level level, BlockPos blockPos, double radius, float velocity) {
        spawn(particleOptions, level, blockPos, radius, new Vec3(velocity, velocity, velocity));
    }

    public static void spawn(ParticleOptions particleOptions, Level level, BlockPos blockPos, double radius, Vec3 velocity) {
        spawn(particleOptions, level, blockPos, 20, radius, velocity);
    }

    public static void spawn(ParticleOptions particleOptions, Level level, BlockPos blockPos, @Range(from = 0, to = 360) int compressionLevel, double radius, Vec3 velocity) {
        int realCompressionValue = compressionLevel + 2;

        if (level instanceof ServerLevel serverLevel) {
            for(int i = 0; i < 360; i++) {
                if(i % realCompressionValue == 0) {
                    serverLevel.sendParticles(particleOptions,
                            blockPos.getX() + 0.5d + Math.cos(Math.toRadians(i)) * radius,
                            blockPos.getY(),
                            blockPos.getZ() + 0.5d + Math.sin(Math.toRadians(i)) * radius,
                            0,
                            Math.cos(Math.toRadians(i)) * velocity.x, velocity.y, Math.sin(Math.toRadians(i)) * velocity.z,
                            1
                    );
                }
            }
        }
    }
}
