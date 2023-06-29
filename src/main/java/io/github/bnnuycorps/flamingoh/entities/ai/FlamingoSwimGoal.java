package io.github.bnnuycorps.flamingoh.entities.ai;

import net.minecraft.block.BlockState;
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
	public boolean canStart() {
		BlockState up = this.mob.getWorld().getBlockState(this.mob.getBlockPos().up());
		BlockState down = this.mob.getWorld().getBlockState(this.mob.getBlockPos().down());
		if(!(up.getFluidState().getFluid().matchesType(Fluids.EMPTY)) && !(down.getFluidState().getFluid().matchesType(Fluids.EMPTY)))
			return super.canStart();
		return false;
	}
}

