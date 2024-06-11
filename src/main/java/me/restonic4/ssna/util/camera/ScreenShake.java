package me.restonic4.ssna.util.camera;

import net.minecraft.client.Camera;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class ScreenShake {
    public static float intensity;
    public static float yawOffset;
    public static float pitchOffset;

    public static final RandomSource RANDOM = RandomSource.create();

    public static void tick(Camera camera, RandomSource random, float deltaTime) {
        if (intensity >= 0.1) {
            if (intensity >= 6) {
                intensity = 6;
            }

            yawOffset = randomizeOffset(random);
            pitchOffset = randomizeOffset(random);
            camera.setRotation(camera.getYRot() + yawOffset, camera.getXRot() + pitchOffset);

            intensity -= 0.2f * deltaTime;

            if (intensity <= 0) {
                intensity = 0f;
            }
        }
    }

    public static void addScreenShake(float intensity) {
        ScreenShake.intensity += intensity;
    }

    private static float randomizeOffset(RandomSource random) {
        return Mth.nextFloat(random, -intensity * 2, intensity * 2);
    }
}
