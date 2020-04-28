package ru.lg.SovietMod.Blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class Fence_PO_2 extends BasicBlockSideWithCustomModel{

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(-1D, 0D, 0.25D, 2D, 2D, 0.75D),
			new AxisAlignedBB(0D, 0D, 0.25D, 1D, 1D, 0.75D),
			new AxisAlignedBB(0.25D, 0D, 0D, 0.75D, 1D, 1D),
			new AxisAlignedBB(0.25D, 0D, 0D, 0.75D, 1D, 1D)
	};
	public Fence_PO_2(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
	
	}
	protected RayTraceResult rayTrace(BlockPos pos, Vec3d start, Vec3d end, AxisAlignedBB boundingBox)
	{
		Vec3d vec3d = start.subtract((double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
		Vec3d vec3d1 = end.subtract((double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
		RayTraceResult raytraceresult = boundingBox.calculateIntercept(vec3d, vec3d1);
		return raytraceresult == null ? null : new RayTraceResult(raytraceresult.hitVec.addVector((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()), raytraceresult.sideHit, pos);
	}
	@Override
	public RayTraceResult collisionRayTrace(IBlockState blockState, World world, BlockPos pos, Vec3d start, Vec3d end)
	{
		RayTraceResult[] rtr = new RayTraceResult[] {this.rayTrace(pos.west(), start, end, SIDE_AABB[0]),
				this.rayTrace(pos, start, end, SIDE_AABB[1]),
				this.rayTrace(pos, start, end, SIDE_AABB[2]),
				this.rayTrace(pos, start, end, SIDE_AABB[3])};

		RayTraceResult raytraceresult = null;

		double d1 = 0.0D;



		switch (blockState.getValue(FACING))
		{
		case SOUTH:
			RayTraceResult raytraceresult1 = rtr[0];
			{
				RayTraceResult rtt = rtr[2];
				if(rtt != null)
				{

					double d0 = rtt.hitVec.squareDistanceTo(end);
					if(d0 > d1)
					{

						d1 = d0;
						return rtt;
					}
				}
			}
			{
				RayTraceResult rtt = rtr[0];
				if(rtt != null)
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
		case NORTH:
		default:
			RayTraceResult raytraceresult2 = rtr[1];
			{
				RayTraceResult rtt = rtr[1];
				if(rtt != null)
				{

					double d0 = rtt.hitVec.squareDistanceTo(end);
					if(d0 > d1)
					{

						d1 = d0;
						return rtt;
					}
				}
			}
			{
				RayTraceResult rtt = rtr[3];
				if(rtt != null)
				{

					double d0 = rtt.hitVec.squareDistanceTo(end);
					if(d0 > d1)
					{

						d1 = d0;
						return rtt;
					}
				}
			}
			return raytraceresult2;

		case WEST:
			RayTraceResult raytraceresult3 = rtr[2];
			{
				RayTraceResult rtt = rtr[1];
				if(rtt != null)
				{

					double d0 = rtt.hitVec.squareDistanceTo(end);
					if(d0 > d1)
					{

						d1 = d0;
						return rtt;
					}
				}
			}
			{
				RayTraceResult rtt = rtr[2];
				if(rtt != null)
				{

					double d0 = rtt.hitVec.squareDistanceTo(end);
					if(d0 > d1)
					{

						d1 = d0;
						return rtt;
					}
				}
			}
			return raytraceresult3;

		case EAST:
			RayTraceResult raytraceresult4 = rtr[3];
			{
				RayTraceResult rtt = rtr[0];
				if(rtt != null)
				{

					double d0 = rtt.hitVec.squareDistanceTo(end);
					if(d0 > d1)
					{

						d1 = d0;
						return rtt;
					}
				}
			}
			{
				RayTraceResult rtt = rtr[3];
				if(rtt != null)
				{

					double d0 = rtt.hitVec.squareDistanceTo(end);
					if(d0 > d1)
					{

						d1 = d0;
						return rtt;
					}
				}
			}
			return raytraceresult4;

		}

	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.po_2_down);

	}
	
	
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			addCollisionBoxToList(pos.west(), entityBox, collidingBoxes, this.SIDE_AABB[0]);
			addCollisionBoxToList(pos.east(), entityBox, collidingBoxes, this.SIDE_AABB[0]);
			addCollisionBoxToList(pos.west().up(), entityBox, collidingBoxes, this.SIDE_AABB[0]);
			addCollisionBoxToList(pos.east().up(), entityBox, collidingBoxes, this.SIDE_AABB[0]);
			addCollisionBoxToList(pos.up(), entityBox, collidingBoxes, this.SIDE_AABB[0]);
			return;
		case NORTH:
		default:
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[1]);
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[3]);
			return;
		case WEST:
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[1]);
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[2]);
			return;
		case EAST:
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[0]);
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[3]);
			return;
		}

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
	}
