package io.github.bnnuycorps.flamingoh.entities.renderer;

import io.github.bnnuycorps.flamingoh.Main;
import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import io.github.bnnuycorps.flamingoh.entities.models.FlamingoEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class FlamingoEntityRenderer extends MobEntityRenderer<FlamingoEntity, FlamingoEntityModel<FlamingoEntity>> {

	private final Identifier FLAMINGO_TEXTURE = new Identifier(Main.MOD_ID, "textures/entities/flamingo_texture.png");
	private final Identifier FLAMINGO_BABY_TEXTURE = new Identifier(Main.MOD_ID, "textures/entities/baby_flamingo_texture.png");
	public FlamingoEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new FlamingoEntityModel(context.getPart(FlamingoEntityModel.FLAMINGO_MODEL_LAYER)), 0.6f);
	}

	@Override
	protected void scale(FlamingoEntity entity, MatrixStack matrices, float amount) {
		if(this.model.child) {
			matrices.scale(0.5f, 0.5f, 0.5f);
		}
		super.scale(entity, matrices, amount);
	}

	@Override
	protected float getAnimationProgress(FlamingoEntity entity, float tickDelta) {
			float g = MathHelper.lerp(tickDelta, entity.prevFlapProgress, entity.flapProgress);
			float h = MathHelper.lerp(tickDelta, entity.prevMaxWingDeviation, entity.maxWingDeviation);
			return (MathHelper.sin(g) + 0.5f) * h;
	}



	@Override
	public Identifier getTexture(FlamingoEntity entity) {
		if(this.model.child)
			return FLAMINGO_BABY_TEXTURE;
		return FLAMINGO_TEXTURE;
	}
}
