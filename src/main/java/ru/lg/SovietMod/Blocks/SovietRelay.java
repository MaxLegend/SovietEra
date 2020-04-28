package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;

public class SovietRelay extends BasicBlock{
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public SovietRelay(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype)
	{
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(POWERED, Boolean.valueOf(false)));
	}


	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.368D, 0.368D, 1D, 0.632D, 0.632D, 0.9D),
			new AxisAlignedBB(0.368D, 0.368D, 0.0D, 0.632D, 0.632D, 0.1D),
			new AxisAlignedBB(0.9D, 0.368D, 0.368D, 1D, 0.632D, 0.632D),
			new AxisAlignedBB(0.0D, 0.368D, 0.368D, 0.1D, 0.632D, 0.632D)

	};
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case NORTH:
			return this.SIDE_AABB[0];
		case SOUTH:
		default:
			return this.SIDE_AABB[1];
		case WEST:
			return this.SIDE_AABB[2];
		case EAST:
			return this.SIDE_AABB[3];
		}
	}
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	public boolean isFullCube(IBlockState state)
	{
		return false;
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
	public RayTraceResult getRayTraceToBlock(EntityLivingBase entity_base, float fasc, double dist, boolean interact) {
		Vec3d vec3 = new Vec3d(entity_base.posX, entity_base.posY + entity_base.getEyeHeight(), entity_base.posZ);
		Vec3d vec31 = entity_base.getLook(fasc);
		Vec3d vec32 = vec3.addVector(vec31.x * dist, vec31.y * dist, vec31.z * dist);
		RayTraceResult mop = entity_base.world.rayTraceBlocks(vec3, vec32, interact);
		return mop;
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
	{
		if(placer instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)placer;
			if(!player.isCreative()) {
				player.getHeldItem(hand).shrink(1);
			}
		}
		IBlockState iblockstate = this.getDefaultState().withProperty(POWERED, Boolean.valueOf(false));
		if(facing == EnumFacing.DOWN || facing == EnumFacing.UP) return iblockstate;
		world.setBlockState(pos, iblockstate.withProperty(FACING, facing));
		return iblockstate.withProperty(FACING, facing);

	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{

		if (worldIn.isRemote)
		{
			return true;
		}
		else
		{
			state = state.cycleProperty(POWERED);
			worldIn.setBlockState(pos, state, 3);
			float f = ((Boolean)state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F;
			worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, f);
			worldIn.notifyNeighborsOfStateChange(pos, this, false);
			EnumFacing enumfacing = state.getValue(FACING);
			worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing.getOpposite()), this, false);

			return true;
		}
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(POWERED, Boolean.valueOf((meta & 8) > 0));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | state.getValue(FACING).getHorizontalIndex();
        if (((Boolean)state.getValue(POWERED)).booleanValue())
        {
            i |= 8;
        }
		return i;
	}
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (((Boolean)state.getValue(POWERED)).booleanValue())
		{
			worldIn.notifyNeighborsOfStateChange(pos, this, false);
			EnumFacing enumfacing = state.getValue(FACING);
			worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing.getOpposite()), this, false);
		}

		super.breakBlock(worldIn, pos, state);
	}
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return ((Boolean)blockState.getValue(POWERED)).booleanValue() ? 15 : 0;
	}

	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		if (!((Boolean)blockState.getValue(POWERED)).booleanValue())
		{
			return 0;
		}
		else
		{
			return blockState.getValue(FACING) == side ? 15 : 0;
		}
	}
	public boolean canProvidePower(IBlockState state)
	{
		return true;
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, POWERED});
	}


}
