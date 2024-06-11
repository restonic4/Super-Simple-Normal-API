package me.restonic4.ssna.util.particles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SphereParticlesHelper {
    public static void spawn(ParticleOptions particleOptions, Level level, Vec3 position, double radius, int density, boolean fillInside) {
        if (level instanceof ServerLevel serverLevel) {
            for (int i = 0; i < density; i++) {
                double r = fillInside ? radius * Math.cbrt(Math.random()) : radius;
                double theta = Math.random() * 2 * Math.PI;
                double phi = Math.acos(2 * Math.random() - 1);
                double x = position.x + r * Math.sin(phi) * Math.cos(theta);
                double y = position.y+ r * Math.sin(phi) * Math.sin(theta);
                double z = position.z + r * Math.cos(phi);

                serverLevel.sendParticles(particleOptions, x, y, z, 1, 0.0, 0.0, 0.0, 0.0);
            }
        }
    }
}
