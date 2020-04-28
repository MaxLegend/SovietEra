package ru.lg.SovietMod.Blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class GofroHandholdAngle extends BasicBlockSideWithCustomModel {

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 1D, 1D, 1D, 0.9D),
			new AxisAlignedBB(0D, 0D, 0.1D, 1D, 1D, 0D),
			new AxisAlignedBB(0.1D, 0D, 1D, 0D, 1D, 0D),
			new AxisAlignedBB(1D, 0D, 0D, 0.9D, 1D, 1D)
	};
	public GofroHandholdAngle(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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

	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return this.SIDE_AABB[0];
		//		switch (blockState.getValue(FACING))
		//		{
		//		case SOUTH:
		//			return this.SIDE_AABB[0];
		//		case NORTH:
		//		default:
		//			return this.SIDE_AABB[1];
		//		case WEST:
		//			return this.SIDE_AABB[2];
		//		case EAST:
		//			return this.SIDE_AABB[3];
		//		}
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
		RayTraceResult[] rtr = new RayTraceResult[] {this.rayTrace(pos, start, end, SIDE_AABB[0]),
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
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[0]);
			addCollisionBoxToList(pos, entityBox, collidingBoxes, this.SIDE_AABB[2]);
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

}
