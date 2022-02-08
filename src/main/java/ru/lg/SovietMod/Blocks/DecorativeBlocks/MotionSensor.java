package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class MotionSensor extends BasicBlockSideWithCustomModel {
	public static final PropertyBool IS_ACTIVE = PropertyBool.create("is_active");

	public static final PropertyBool DOWN = PropertyBool.create("down");

	private static AxisAlignedBB[] FANTOM_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 1D, 1D, 1D, -6D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 7D),
			new AxisAlignedBB(0D, 0D, 0D, 7D, 1D, 1D),
			new AxisAlignedBB(1D, 0D, 0D, -6D, 1D, 1D),
	};
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.23D, 0.3D, 0.81D, 0.76D, 0.75D, 1D),
			new AxisAlignedBB(0.23D, 0.3D, 0D, 0.76D, 0.75D, 0.19D),
			new AxisAlignedBB(0D, 0.3D, 0.23D, 0.19D, 0.75D, 0.76D),
			new AxisAlignedBB(0.81D, 0.3D, 0.23D, 1D, 0.75D, 0.76D)
	};

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	public MotionSensor(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(IS_ACTIVE, false).withProperty(DOWN, false));
		this.setTickRandomly(true);
	}
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{

		return state.withProperty(FACING, state.getValue(FACING)).withProperty(IS_ACTIVE, state.getValue(IS_ACTIVE))
				.withProperty(DOWN, canConnectTo(world, pos));
	}

	private boolean canConnectTo(IBlockAccess world, BlockPos pos)
	{
		{
			//System.out.println("facing " + world.getBlockState(pos.up()).isSideSolid(world, pos.down(), EnumFacing.DOWN));
			if(world.getBlockState(pos.down()).isFullBlock()) {
				return true;
			} 

		}
		return false;
	}
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{

		EnumFacing facing = EnumFacing.fromAngle(placer.getRotationYawHead());
		world.scheduleUpdate(pos, state.getBlock(), 40);
		world.setBlockState(pos, state.withProperty(FACING, facing));
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(IS_ACTIVE, Boolean.valueOf((meta & 8) > 0));
	}

	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

		if (((Boolean)state.getValue(IS_ACTIVE)).booleanValue())
		{
			i |= 8;
		}

		return i;
	}

	public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end)
	{
		return this.rayTrace(pos, start, end, blockState.getCollisionBoundingBox(worldIn, pos));
	}
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return SIDE_AABB[0];
		case NORTH:
		default:
			return SIDE_AABB[1];
		case WEST:
			return SIDE_AABB[2];
		case EAST:
			return SIDE_AABB[3];
		}
	}


	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (!world.isRemote)
		{	 

			if(entityIn instanceof EntityLivingBase ) {
				world.setBlockState(pos, state.withProperty(IS_ACTIVE, true));
				world.scheduleUpdate(pos, state.getBlock(), 20);
			}

		} 
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!world.isRemote)
		{	 
			world.scheduleUpdate(pos, state.getBlock(), 10);
			List <? extends Entity > list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, state.getBoundingBox(world, pos).offset(pos));
			if (!list.isEmpty())
			{
				
				if(state.getValue(FACING) == EnumFacing.SOUTH) {
					world.setBlockState(pos, state.withProperty(IS_ACTIVE, true));
					list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, FANTOM_AABB[0].offset(pos));
				}
				if(state.getValue(FACING) == EnumFacing.NORTH) {
					world.setBlockState(pos, state.withProperty(IS_ACTIVE, true));
					list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, FANTOM_AABB[1].offset(pos));
				}
				if(state.getValue(FACING) == EnumFacing.WEST) {
					world.setBlockState(pos, state.withProperty(IS_ACTIVE, true));
					list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, FANTOM_AABB[2].offset(pos));
				}
				if(state.getValue(FACING) == EnumFacing.EAST) {
					world.setBlockState(pos, state.withProperty(IS_ACTIVE, true));
					list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, FANTOM_AABB[3].offset(pos));
				}

			} else {
				world.setBlockState(pos, state.withProperty(IS_ACTIVE, false));
			}
		}
	}
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return ((Boolean)blockState.getValue(IS_ACTIVE)).booleanValue() ? 15 : 0;
	}

	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return getWeakPower(blockState, blockAccess, pos, side);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return SIDE_AABB[0].offset(pos);
		case NORTH:
		default:
			return SIDE_AABB[1].offset(pos);
		case WEST:
			return SIDE_AABB[2].offset(pos);
		case EAST:
			return SIDE_AABB[3].offset(pos);
		}

	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return FANTOM_AABB[0];
		case NORTH:
		default:
			return FANTOM_AABB[1];
		case WEST:
			return FANTOM_AABB[2];
		case EAST:
			return FANTOM_AABB[3];
		}
	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, IS_ACTIVE,DOWN});
	}
}
