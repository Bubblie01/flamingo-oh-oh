package io.github.bnnuycorps.flamingoh.entities;

import io.github.bnnuycorps.flamingoh.FlamingohRegistry;
import io.github.bnnuycorps.flamingoh.Main;
import io.github.bnnuycorps.flamingoh.entities.ai.FlamingoSwimGoal;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;
import org.quiltmc.qsl.entity.impl.QuiltEntityType;

public class FlamingoEntity extends AnimalEntity {

	public static final EntityType<FlamingoEntity> FLAMINGO_ENTITY_TYPE = Registry.register(Registries.ENTITY_TYPE, new Identifier(Main.MOD_ID, "flamingo_entity"), QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, FlamingoEntity::new).setDimensions(EntityDimensions.changing(1.0f,2.1f)).build());

	public float flapProgress;
	public float maxWingDeviation;
	public float prevMaxWingDeviation;
	public float prevFlapProgress;
	public float flapSpeed = 1.0F;
	//private float nextFlap = 1.0F;
	public int eggLayTime = this.random.nextInt(6000) + 6000;
	protected FlamingoEntity(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new EscapeDangerGoal(this, 1.0));
		this.goalSelector.add(1, new TemptGoal(this, 1.0, Ingredient.ofItems(FlamingohRegistry.SHRIMP_ITEM), false));
		this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
		this.goalSelector.add(3, new WanderAroundGoal(this, 0.8));
		this.goalSelector.add(5, new LookAroundGoal(this));
		this.goalSelector.add(6, new FlamingoSwimGoal(this));
		this.goalSelector.add(7, new FollowParentGoal(this, 1.0));
		this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6F));
		this.goalSelector.add(9, new LookAtEntityGoal(this, FlamingoEntity.class, 6F));
	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return FLAMINGO_ENTITY_TYPE.create(world);
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		this.prevFlapProgress = this.flapProgress;
		this.prevMaxWingDeviation = this.maxWingDeviation;
		this.maxWingDeviation += (this.isOnGround() ? -1.0F : 4.0F) * 0.3F;
		this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0F, 1.0F);
		if (!this.isOnGround() && this.flapSpeed < 1.0F) {
			this.flapSpeed = 1.0F;
		}
		//if(isTouchingWater())
			//this.setMovementSpeed(this.getMovementSpeed()+2.0f);
	}

	@Override
	public void travel(Vec3d movementInput) {
		super.travel(movementInput);
		if(this.isTouchingWater())
			this.updateVelocity(0.1f,movementInput);


	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.isOf(FlamingohRegistry.SHRIMP_ITEM);
	}

	public static void registerFlamingoEntityAttributes() {
		FabricDefaultAttributeRegistry.register(FLAMINGO_ENTITY_TYPE, createAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 5.0f).add(EntityAttributes.GENERIC_MAX_HEALTH, 8f));
	}
}
