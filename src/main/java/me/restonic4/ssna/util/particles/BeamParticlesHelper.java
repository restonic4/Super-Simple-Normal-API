package me.restonic4.ssna.util.particles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BeamParticlesHelper {
    public static void spawn(ParticleOptions particleOptions, Level level, Vec3 startPosition, Vec3 endPosition, float spacing) {
        if (level instanceof ServerLevel serverLevel) {
            Vec3 direction = endPosition.subtract(startPosition).normalize();
            double distance = startPosition.distanceTo(endPosition);

            for (double d = 0; d < distance; d += spacing) {
                Vec3 point = startPosition.add(direction.scale(d));

                PlayerList playerList = level.getServer().getPlayerList();

                for (ServerPlayer playerFound : playerList.getPlayers()) {
                    serverLevel.sendParticles(playerFound, particleOptions, true, point.x, point.y, point.z, 0, 0, 0, 0, 0);
                }
            }
        }
    }
}
