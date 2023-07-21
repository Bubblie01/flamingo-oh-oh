package io.github.bnnuycorps.flamingoh.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class GardenFlamingoBlock extends Block {

	public GardenFlamingoBlock(Settings settings) {
		super(settings);
		//this.setDefaultState(this.stateManager.getDefaultState().with(HorizontalFacingBlock.FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.434375, 0.9025, 0.16875, 0.565625, 1.0025, 0.2375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.925, 0.19375, 0.5625, 1, 0.30625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.925, 0.30625, 0.5625, 1.05, 0.49375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.7375, 0.36875, 0.5625, 0.925, 0.49375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4875, 0.30625, 0.5625, 0.8, 0.43125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.425, 0.36875, 0.625, 0.6125, 0.74375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.425, 0.36875, 0.6875, 0.6125, 0.68125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.425, 0.36875, 0.375, 0.6125, 0.68125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.34375, 0.45625, 0.74375, 0.6375, 0.59375, 0.78125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.48125, 0.78125, 0.60625, 0.59375, 0.81875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.3625, 0.36875, 0.625, 0.425, 0.74375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.525, -0.06875, 0.6125, 0.55625, 0.35, 0.6125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.540625, -0.06875, 0.596875, 0.540625, 0.35, 0.628125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4625, 0, 0.496875, 0.49375, 0.3625, 0.496875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.478125, 0, 0.48125, 0.478125, 0.3625, 0.5125));
		return shape;
	}


}
