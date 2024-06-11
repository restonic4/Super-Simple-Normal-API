package me.restonic4.ssna.mixin;

import me.restonic4.ssna.util.camera.ScreenShake;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.restonic4.ssna.util.camera.ScreenShake.RANDOM;

@Environment(EnvType.CLIENT)
@Mixin(Camera.class)
public abstract class CameraMixin {
    @Inject(method = "setup", at = @At("RETURN"))
    private void onPlace(BlockGetter area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        Minecraft client = Minecraft.getInstance();
        float deltaTime = client.getDeltaFrameTime();

        ScreenShake.tick((Camera) (Object) this, RANDOM, deltaTime);
    }
}
