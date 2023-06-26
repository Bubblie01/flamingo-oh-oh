package io.github.bnnuycorps.flamingoh.entities.ai;

import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.Vec3d;

public class FlamingoSwimGoal extends SwimGoal {
	MobEntity mob;

	public FlamingoSwimGoal(MobEntity mob) {
		super(mob);
		this.mob = mob;
	}

	@Override
	public void tick() {

		if (mob.isTouchingWater()) {
			this.mob.setVelocity(this.mob.getVelocity().add(0.0, 0.005, 0.0));
		}


		if(mob.isSubmergedInWater()){
			this.mob.setVelocity(this.mob.getVelocity().add(0.0, 0.03f, 0.0));
		}

	}
}

