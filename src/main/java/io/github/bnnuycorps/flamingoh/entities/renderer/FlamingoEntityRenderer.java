package io.github.bnnuycorps.flamingoh.entities.renderer;

import io.github.bnnuycorps.flamingoh.Main;
import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import io.github.bnnuycorps.flamingoh.entities.models.FlamingoEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FlamingoEntityRenderer extends MobEntityRenderer<FlamingoEntity, FlamingoEntityModel<FlamingoEntity>> {

	private final Identifier FLAMINGO_TEXTURE = new Identifier(Main.MOD_ID, "textures/entities/flamingo_texture.png");

	public FlamingoEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new FlamingoEntityModel(context.getPart(FlamingoEntityModel.FLAMINGO_MODEL_LAYER)), 0.6f);
	}

	@Override
	public Identifier getTexture(FlamingoEntity entity) {
		return FLAMINGO_TEXTURE;
	}
}
