package io.github.bnnuycorps.flamingoh.mixin;

import io.github.bnnuycorps.flamingoh.FlamingohRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {


	@Shadow
	protected abstract void renderOverlay(GuiGraphics graphics, Identifier texture, float opacity);



	@Inject(method = "Lnet/minecraft/client/gui/hud/InGameHud;render(Lnet/minecraft/client/gui/GuiGraphics;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;getLastFrameDuration()F"))
	private void flamingoh$_addPinkEffect(GuiGraphics graphics, float tickDelta, CallbackInfo ci) {
		MinecraftClient client = MinecraftClient.getInstance();
		if(client.player != null) {
			StatusEffectInstance statusEffect = client.player.getStatusEffect(FlamingohRegistry.FLAMINGO_STATUS_EFFECT);
			if (statusEffect != null) {
				float opacity = (float)(statusEffect.getAmplifier() + 1)/2;
				System.out.println(opacity);
				this.renderOverlay(graphics, FlamingohRegistry.FLAMINGO_EFFECT_TEXTURE, opacity);

			}
		}
	}

}
