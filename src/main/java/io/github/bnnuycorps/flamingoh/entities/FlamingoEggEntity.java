package io.github.bnnuycorps.flamingoh.entities;

import io.github.bnnuycorps.flamingoh.FlamingohRegistry;
import io.github.bnnuycorps.flamingoh.Main;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class FlamingoEggEntity extends ThrownItemEntity {

	public static final EntityType<FlamingoEggEntity> FLAMINGO_EGG_ENTITY_TYPE = Registry.register(Registries.ENTITY_TYPE, new Identifier(Main.MOD_ID, "flamingo_egg_entity"),QuiltEntityTypeBuilder.<FlamingoEggEntity>create(SpawnGroup.MISC, FlamingoEggEntity::new).setDimensions(EntityDimensions.changing(0.25F, 0.25F)).build());

	public FlamingoEggEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public FlamingoEggEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
		super(entityType, d, e, f, world);
	}

	public FlamingoEggEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
		super(entityType, livingEntity, world);
	}


	@Override
	public void handleStatus(byte status) {
		if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
			double d = 0.08;

			for(int i = 0; i < 8; ++i) {
				this.getWorld()
						.addParticle(
								new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()),
								this.getX(),
								this.getY(),
								this.getZ(),
								((double)this.random.nextFloat() - 0.5) * 0.08,
								((double)this.random.nextFloat() - 0.5) * 0.08,
								((double)this.random.nextFloat() - 0.5) * 0.08
						);
			}
		}
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		//super.onCollision(hitResult);
		if (!this.getWorld().isClient) {
			if (this.random.nextInt(8) == 0) {
				int i = 1;
				if (this.random.nextInt(32) == 0) {
					i = 4;
				}

				for (int j = 0; j < i; ++j) {
					FlamingoEntity flamingoEntity = FlamingoEntity.FLAMINGO_ENTITY_TYPE.create(this.getWorld());
					if (flamingoEntity != null) {
						flamingoEntity.setBreedingAge(-24000);
						flamingoEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
						this.getWorld().spawnEntity(flamingoEntity);
					}
				}
			}

			this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
			this.discard();
		}
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), 0.0F);
	}

	@Override
	protected Item getDefaultItem() {
		return FlamingohRegistry.FLAMINGO_EGG_ITEM;
	}
}
