package ru.lg.SovietMod.Blocks.BuildingBlocks;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;

public class WiresBlock extends BasicBlockWithCustomModel {
	public List<AxisAlignedBB> collisionBlock;
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public static final PropertyBool DEF = PropertyBool.create("default");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 1D, 1D, 1D, 0.9D),
			new AxisAlignedBB(0D, 0D, 0.1D, 1D, 1D, 0D),
			new AxisAlignedBB(0.1D, 0D, 1D, 0D, 1D, 0D),
			new AxisAlignedBB(1D, 0D, 0D, 0.9D, 1D, 1D)
	};
	public WiresBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(DEF, true));
	}
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
	}
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
	}
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		EnumFacing facing = EnumFacing.fromAngle(placer.getRotationYawHead());
		world.setBlockState(pos, state.withProperty(FACING, facing));
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | state.getValue(FACING).getHorizontalIndex();
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, NORTH, SOUTH, WEST, EAST, DEF});
	}
	 public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	    {

	        return state
	        		.withProperty(DEF, Boolean.valueOf(true))
	        		.withProperty(NORTH, canBeConnectedTo(worldIn, pos, EnumFacing.NORTH))
	        		.withProperty(EAST, canBeConnectedTo(worldIn, pos, EnumFacing.EAST))
	        		.withProperty(SOUTH, canBeConnectedTo(worldIn, pos, EnumFacing.SOUTH))
	        		.withProperty(WEST, canBeConnectedTo(worldIn, pos, EnumFacing.WEST)).withProperty(FACING, state.getValue(FACING));
	    }


	    public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_)
	    {
	        return p_193383_4_ != EnumFacing.UP && p_193383_4_ != EnumFacing.DOWN ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
	    }

	    

	    @Override
	    public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	    {
	        IBlockState state = world.getBlockState(pos.offset(facing));
	        if (state.isFullBlock())
	        {     
	        	
	            return true;
	        } else
	        return false;
	    }

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.SIDE_AABB[0];
		case NORTH:
		default:
			return this.SIDE_AABB[1];
		case WEST:
			return this.SIDE_AABB[2];
		case EAST:
			return this.SIDE_AABB[3];
		}
	}

	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end)
	{
		RayTraceResult raytraceresult = null;

		RayTraceResult[] rtrs = new RayTraceResult[] {this.rayTrace(pos, start, end, SIDE_AABB[0]),this.rayTrace(pos, start, end, SIDE_AABB[1]),this.rayTrace(pos, start, end, SIDE_AABB[2]),this.rayTrace(pos, start, end, SIDE_AABB[3])};
	if(state.getValue(FACING) == EnumFacing.SOUTH) {
		RayTraceResult raytraceresult1 = rtrs[0];
		double d1 = 0.0D;
		if(world.getBlockState(pos.west()).isFullBlock()){

			RayTraceResult rtt = rtrs[2];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.east()).isFullBlock()){

			RayTraceResult rtt = rtrs[3];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.north()).isFullBlock()){

			RayTraceResult rtt = rtrs[1];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		return raytraceresult1;
		}
	if(state.getValue(FACING) == EnumFacing.NORTH) {
		RayTraceResult raytraceresult1 = rtrs[1];
		double d1 = 0.0D;
		if(world.getBlockState(pos.west()).isFullBlock()){

			RayTraceResult rtt = rtrs[2];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.east()).isFullBlock()){

			RayTraceResult rtt = rtrs[3];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.south()).isFullBlock()){

			RayTraceResult rtt = rtrs[0];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		return raytraceresult1;
		}
	
	if(state.getValue(FACING) == EnumFacing.WEST) {
		RayTraceResult raytraceresult1 = rtrs[2];
		double d1 = 0.0D;
		if(world.getBlockState(pos.north()).isFullBlock()){

			RayTraceResult rtt = rtrs[1];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.east()).isFullBlock()){

			RayTraceResult rtt = rtrs[3];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.south()).isFullBlock()){

			RayTraceResult rtt = rtrs[0];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		return raytraceresult1;
		}
	if(state.getValue(FACING) == EnumFacing.EAST) {
		RayTraceResult raytraceresult1 = rtrs[3];
		double d1 = 0.0D;
		if(world.getBlockState(pos.north()).isFullBlock()){

			RayTraceResult rtt = rtrs[1];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.west()).isFullBlock()){

			RayTraceResult rtt = rtrs[2];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		if(world.getBlockState(pos.south()).isFullBlock()){

			RayTraceResult rtt = rtrs[0];

			if(rtt != null )
			{
				double d0 = rtt.hitVec.squareDistanceTo(end);
				if(d0 > d1)
				{
					d1 = d0;
					return rtt;
				}
			}
		}
		return raytraceresult1;
		}
			return raytraceresult;

	}


}
