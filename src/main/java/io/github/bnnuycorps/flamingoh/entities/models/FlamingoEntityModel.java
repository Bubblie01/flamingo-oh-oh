package io.github.bnnuycorps.flamingoh.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.bnnuycorps.flamingoh.Main;
import io.github.bnnuycorps.flamingoh.entities.FlamingoEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class FlamingoEntityModel<FlamingoEntity> extends SinglePartEntityModel<io.github.bnnuycorps.flamingoh.entities.FlamingoEntity> {
private final ModelPart root;
private final ModelPart head;
private final ModelPart neck;
private final ModelPart main_body;
private final ModelPart wing_right;
private final ModelPart wing_left;
private final ModelPart leg_left;
private final ModelPart leg_right;

	public static final EntityModelLayer FLAMINGO_MODEL_LAYER = new EntityModelLayer(new Identifier(Main.MOD_ID, "flaming_entity_model"), "flamingo_entity_model");

	public FlamingoEntityModel(ModelPart root) {
		this.root = root.getChild("root");

		this.head = this.root.getChild("head");

		this.neck = this.root.getChild("neck");

		this.main_body = this.root.getChild("main_body");

		this.wing_right = this.root.getChild("wing_right");

		this.wing_left = this.root.getChild("wing_left");

		this.leg_left = this.root.getChild("leg_left");

		this.leg_right = this.root.getChild("leg_right");

	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 6.0F, 0.75F));

		ModelPartData head = root.addChild("head", ModelPartBuilder.create(), ModelTransform.of(0.0F, -12.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData mirror_r1 = head.addChild("mirror_r1", ModelPartBuilder.create().uv(13, 44).mirrored().cuboid(-1.0F, -0.219F, -0.6315F, 2.0F, 2.0F, 2.0F, new Dilation(0.05F)).mirrored(false), ModelTransform.of(0.0F, 0.7119F, -5.5015F, -0.5672F, 0.0F, 0.0F));

		ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(12, 38).cuboid(-1.0F, -0.2756F, -1.6941F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.2263F, -4.2074F, 0.0873F, 0.0F, 0.0F));

		ModelPartData head_r2 = head.addChild("head_r2", ModelPartBuilder.create().uv(10, 30).cuboid(-1.5F, -0.7756F, -2.1941F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.501F, -0.9782F, 0.0873F, 0.0F, 0.0F));

		ModelPartData neck = root.addChild("neck", ModelPartBuilder.create().uv(0, 30).cuboid(-1.0F, -12.45F, -0.45F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 43).cuboid(-1.0F, -5.04F, -3.13F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.75F, -6.75F));

		ModelPartData neck_6_r1 = neck.addChild("neck_6_r1", ModelPartBuilder.create().uv(0, 48).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.4224F, -0.5104F, 0.7854F, 0.0F, 0.0F));

		ModelPartData neck_5_r1 = neck.addChild("neck_5_r1", ModelPartBuilder.create().uv(0, 43).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.3283F, -1.9135F, 0.2618F, 0.0F, 0.0F));

		ModelPartData neck_3_r1 = neck.addChild("neck_3_r1", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.7977F, -1.0897F, -0.48F, 0.0F, 0.0F));

		ModelPartData neck_2_r1 = neck.addChild("neck_2_r1", ModelPartBuilder.create().uv(0, 43).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.8031F, 0.2985F, -0.3054F, 0.0F, 0.0F));

		ModelPartData main_body = root.addChild("main_body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -3.75F, -1.75F, 7.0F, 9.0F, 9.0F, new Dilation(0.0F))
				.uv(33, 0).cuboid(-3.0F, -3.25F, -3.75F, 6.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, -2.0F));

		ModelPartData tail_main_body = main_body.addChild("tail_main_body", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 1.0F, 1.25F));

		ModelPartData tail_main_body_3_r1 = tail_main_body.addChild("tail_main_body_3_r1", ModelPartBuilder.create().uv(31, 23).cuboid(-2.5F, -1.25F, -3.5F, 4.0F, 4.0F, 1.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.5726F, 11.4718F, -0.2618F, 0.0F, 0.0F));

		ModelPartData tail_main_body_2_r1 = tail_main_body.addChild("tail_main_body_2_r1", ModelPartBuilder.create().uv(17, 21).cuboid(-3.0F, -2.75F, -4.0F, 5.0F, 6.0F, 1.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.9564F, 11.0019F, -0.1745F, 0.0F, 0.0F));

		ModelPartData tail_main_body_1_r1 = tail_main_body.addChild("tail_main_body_1_r1", ModelPartBuilder.create().uv(0, 19).cuboid(-3.0F, -3.75F, -1.75F, 6.0F, 7.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, 7.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData front_main_body = main_body.addChild("front_main_body", ModelPartBuilder.create().uv(47, 12).cuboid(-2.0F, -2.75F, -6.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(34, 13).cuboid(-3.0F, -1.75F, -6.0F, 5.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(47, 10).cuboid(-2.0F, 2.25F, -6.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 1.0F, 1.25F));

		ModelPartData wing_right = root.addChild("wing_right", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, -2.5F, 0.75F));

		ModelPartData wing_right_r1 = wing_right.addChild("wing_right_r1", ModelPartBuilder.create().uv(34, 21).cuboid(-0.5F, -0.635F, -4.435F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData wing_left = root.addChild("wing_left", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -2.5F, 0.75F));

		ModelPartData wing_left_r1 = wing_left.addChild("wing_left_r1", ModelPartBuilder.create().uv(34, 21).cuboid(-0.5F, -0.6805F, -3.9141F, 1.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData leg_left = root.addChild("leg_left", ModelPartBuilder.create(), ModelTransform.pivot(1.5F, 4.75F, -1.25F));

		ModelPartData up_leg = leg_left.addChild("up_leg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.25F, 0.75F));

		ModelPartData leg_left_top_r1 = up_leg.addChild("leg_left_top_r1", ModelPartBuilder.create().uv(57, 0).cuboid(-0.5F, -3.5F, -0.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.25F, 0.25F, 0.0873F, 0.0F, 0.0F));

		ModelPartData leg_left_body_r1 = up_leg.addChild("leg_left_body_r1", ModelPartBuilder.create().uv(28, 41).cuboid(-0.75F, -0.625F, -0.75F, 1.5F, 1.25F, 1.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.1369F, -0.0224F, 0.0873F, 0.0F, 0.0F));

		ModelPartData knee_leg = leg_left.addChild("knee_leg", ModelPartBuilder.create().uv(55, 9).cuboid(-1.0F, -0.5149F, -1.0615F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.2649F, 1.3115F));

		ModelPartData leg_left_bottom_r1 = knee_leg.addChild("leg_left_bottom_r1", ModelPartBuilder.create().uv(57, 13).cuboid(-0.5F, -3.1149F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -0.5F, -0.1745F, 0.0F, 0.0F));

		ModelPartData feet = leg_left.addChild("feet", ModelPartBuilder.create().uv(55, 21).cuboid(-0.76F, -0.175F, -1.95F, 1.5F, 0.25F, 2.0F, new Dilation(0.0F))
				.uv(57, 24).cuboid(-0.25F, -0.175F, -2.25F, 0.5F, 0.25F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.01F, 13.175F, 0.75F));

		ModelPartData leg_right = root.addChild("leg_right", ModelPartBuilder.create().uv(55, 9).cuboid(-1.0F, 6.75F, 0.25F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(55, 21).cuboid(-0.75F, 13.0F, -1.2F, 1.5F, 0.25F, 2.0F, new Dilation(0.0F))
				.uv(57, 24).cuboid(-0.24F, 13.0F, -1.5F, 0.5F, 0.25F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, 4.75F, -1.25F));

		ModelPartData leg_right_bottom_r1 = leg_right.addChild("leg_right_bottom_r1", ModelPartBuilder.create().uv(57, 13).cuboid(-0.5F, -3.1149F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.2649F, 0.8115F, -0.1745F, 0.0F, 0.0F));

		ModelPartData leg_right_top_r1 = leg_right.addChild("leg_right_top_r1", ModelPartBuilder.create().uv(57, 0).cuboid(-0.5F, -3.5F, -0.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.5F, 1.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData leg_right_body_r1 = leg_right.addChild("leg_right_body_r1", ModelPartBuilder.create().uv(48, 15).cuboid(-0.75F, -0.625F, -0.75F, 1.5F, 1.25F, 1.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.3869F, 0.7276F, 0.0873F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
			this.root.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
			/*
			this.head.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
			this.neck.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
			this.main_body.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
			this.leg_left.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
			this.leg_right.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
			this.wing_left.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);
			this.wing_right.render(matrices,vertexConsumer,light,overlay,red,green,blue,alpha);

			 */
		}

	@Override
	public ModelPart getPart() {
		return this.root;
	}


	@Override
	public void setAngles(io.github.bnnuycorps.flamingoh.entities.FlamingoEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.head.pitch = headPitch * (float) (Math.PI / 180.0);
		this.head.yaw = headYaw * (float) (Math.PI / 180.0);
		this.leg_right.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.leg_left.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 1.4F * limbDistance;
		this.wing_right.roll = animationProgress;
		this.wing_left.roll = -animationProgress;
	}
}
