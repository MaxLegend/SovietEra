package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class TurnStileOff extends BasicBlockSideWithCustomModel{
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1D, 0.65D),
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1D, 0.65D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1D, 1D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1D, 1D)
	};
	private static AxisAlignedBB[] COLLIS_SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1.5D, 0.65D),
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1.5D, 0.65D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1.5D, 1D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1.5D, 1D)
	};
	public TurnStileOff(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			if(worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, RegBlocks.turnstile_on.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
		}
	}
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{
			if(worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, RegBlocks.turnstile_on.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
		}
	}
	
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.COLLIS_SIDE_AABB[1];
		case NORTH:
		default:
			return this.COLLIS_SIDE_AABB[0];
		case WEST:
			return this.COLLIS_SIDE_AABB[3];
		case EAST:
			return this.COLLIS_SIDE_AABB[2];
		}
    	
    	
    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{

		switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.SIDE_AABB[1];
		case NORTH:
		default:
			return this.SIDE_AABB[0];
		case WEST:
			return this.SIDE_AABB[3];
		case EAST:
			return this.SIDE_AABB[2];
		}
	}
}
