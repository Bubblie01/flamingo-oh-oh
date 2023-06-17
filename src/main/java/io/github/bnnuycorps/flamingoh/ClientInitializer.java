package io.github.bnnuycorps.flamingoh;

import io.github.bnnuycorps.flamingoh.entities.FlamingoEggEntity;
import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import io.github.bnnuycorps.flamingoh.entities.models.FlamingoEntityModel;
import io.github.bnnuycorps.flamingoh.entities.renderer.FlamingoEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ClientInitializer implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {


		EntityRendererRegistry.register(FlamingoEggEntity.FLAMINGO_EGG_ENTITY_TYPE, ((context -> {
			return new FlyingItemEntityRenderer<FlamingoEggEntity>(context);
		})));

		EntityModelLayerRegistry.registerModelLayer(FlamingoEntityModel.FLAMINGO_MODEL_LAYER, FlamingoEntityModel::getTexturedModelData);
		EntityRendererRegistry.register(FlamingoEntity.FLAMINGO_ENTITY_TYPE, ((context -> {
			return new FlamingoEntityRenderer(context);
		})));






	}
}
