package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.SovietCore;

public class ContactWire extends Block{
	
	private static AxisAlignedBB AABB = new AxisAlignedBB(0.02D, 0.7D, 0.02D, 0.98D, 0.74D, 0.98D);

	public static final PropertyBool IS_ACTIVE = PropertyBool.create("is_active");
	public static final PropertyBool isDEF = PropertyBool.create("def");
	public static final PropertyBool isR = PropertyBool.create("is_r");
	public static final PropertyBool isL = PropertyBool.create("is_l");
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);


	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return	AABB;

		case NORTH:
		default:
			return	AABB;
		case WEST:
			return	AABB;

		case EAST:
			return	AABB;

		
		}
		

	}
	public ContactWire(String name, float hardness)
	{
		super(Material.IRON);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
		//	this.setTickRandomly(true);
		//	this.isPoweredBlock = isPowered;
		this.setDefaultState(this.blockState.getBaseState().withProperty(isDEF, Boolean.valueOf(true)).withProperty(FACING, EnumFacing.NORTH).withProperty(isL, Boolean.valueOf(false)).withProperty(isR, Boolean.valueOf(false)).withProperty(IS_ACTIVE, false));
		
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
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return side == EnumFacing.DOWN ? super.shouldSideBeRendered(blockState, blockAccess, pos, side) : true;
	}
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}


	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (!world.isRemote)
		{	 
			
			if(entityIn instanceof EntityLivingBase) {
				
				world.setBlockState(pos, state.withProperty(IS_ACTIVE, true));
				world.scheduleUpdate(pos, state.getBlock(), 20);
			}

		} 
	}
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
	
		world.setBlockState(pos, state.withProperty(IS_ACTIVE, false));
	}
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return ((Boolean)blockState.getValue(IS_ACTIVE)).booleanValue() ? 15 : 0;
	}

	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return getWeakPower(blockState, blockAccess, pos, side);
	}
	public boolean canProvidePower(IBlockState state)
	{
		return true;
	}


	public boolean isFullCube(IBlockState state)
	{
		return false;
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

	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		IBlockState state = world.getBlockState(pos);
		Block connector = world.getBlockState(pos.offset(facing)).getBlock();
		if (state.getBlock() instanceof ContactWire )
		{
			if(!state.getBlock().isSideSolid(state, world, pos, facing)) {
				return connector instanceof ContactWire || connector == RegBlocks.contact_wire_base|| connector == RegBlocks.contact_wire_angle;
			}
		} 
		return false;

	}

	private static int getBoundingBoxIndex(EnumFacing p_185729_0_)
	{
		return 1 << p_185729_0_.getHorizontalIndex();
	}


	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		switch(state.getValue(FACING)) {
		case NORTH:
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.WEST)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.EAST));

		case SOUTH:
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.WEST)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.EAST));
		case EAST:
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.SOUTH)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.NORTH));
		case WEST:
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.SOUTH)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.NORTH));

		default:
			break;

		}
		return state;

	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, isL, isR, isDEF, IS_ACTIVE});
	}

}
