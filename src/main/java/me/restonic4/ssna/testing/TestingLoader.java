package me.restonic4.ssna.testing;

import me.restonic4.ssna.util.particles.BeamParticlesHelper;
import me.restonic4.ssna.util.particles.RingParticlesHelper;
import me.restonic4.ssna.util.particles.SphereParticlesHelper;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec3;

public class TestingLoader {
    public static void load() {
        PlayerBlockBreakEvents.AFTER.register((level, player, blockPos, blockState, blockEntity) -> {
            RingParticlesHelper.spawn(ParticleTypes.SOUL, level, blockPos.offset(0, 1, 0), 20, 1, new Vec3(1, 2, 2));
            BeamParticlesHelper.spawn(ParticleTypes.SOUL_FIRE_FLAME, level, blockPos.getCenter(), player.position(), 0.1f);
            SphereParticlesHelper.spawn(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, level, blockPos.getCenter(), 4, 800,  true);
        });
    }
}
