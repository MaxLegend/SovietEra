package ru.lg.SovietMod.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

public class VibroWire extends Block{
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1D, 0.55D),
			new AxisAlignedBB(0D, 0D, 0.45D, 1D, 1D, 0.7D),
			new AxisAlignedBB(0.45D, 0D, 0D, 0.7D, 1D, 1D),
			new AxisAlignedBB(0.3D, 0D, 0D, 0.55D, 1D, 1D)

	};
	public static final PropertyBool POWERED = PropertyBool.create("powered" );
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
	public VibroWire(String name, float hardness)
	{
		super(Material.IRON);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
		//this.setTickRandomly(true);
		//	this.isPoweredBlock = isPowered;
		this.setDefaultState(this.blockState.getBaseState().withProperty(isDEF, Boolean.valueOf(true))
				.withProperty(FACING, EnumFacing.NORTH).withProperty(isL, Boolean.valueOf(false)).withProperty(isR, Boolean.valueOf(false)).withProperty(POWERED, false));

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



	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{

		if (!worldIn.isRemote)
		{	 
			//			if(state.getValue(POWERED)) {
			//				playerIn.attackEntityFrom(DamageSource.CACTUS, 4.0F);
			//				return true;
			//			} else if(!worldIn.isBlockPowered(pos)){
			//				disableBlocks(state, worldIn, pos);
			//			}
			//	enableBlocks(state, worldIn, pos);
			if(worldIn.isBlockPowered(pos) ) {

				enableBlocks(state, worldIn, pos);

				return true;
			}
			else {
				if(facing == state.getValue(FACING)) {
				disableBlocks(state, worldIn, pos);
				}
				return true;
			}
		}
		return true;
	}   
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		if (!worldIn.isRemote)
		{	 
			IBlockState state = worldIn.getBlockState(pos);
			if(state.getBlock() instanceof VibroWire) {
				if(worldIn.isBlockPowered(pos) || state.getValue(POWERED)) {

					playerIn.attackEntityFrom(DamageSource.CACTUS, 4.0F);
				}
			} 
		}
	}

	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (!worldIn.isRemote)
		{	 


			if(worldIn.isBlockPowered(pos) ||state.getValue(POWERED)) {
				if(entityIn instanceof EntityLivingBase) {
					entityIn.attackEntityFrom(DamageSource.CACTUS, 4.0F);
				}
			}
		} 


	}


	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
	{

	}
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if(!world.isRemote) {

		}

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
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(POWERED, Boolean.valueOf((meta & 8) > 0));
	}

	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

		if (((Boolean)state.getValue(POWERED)).booleanValue())
		{
			i |= 8;
		}

		return i;
	}

	public void enableBlocks(IBlockState state, World world, BlockPos pos) {

		if (state == RegBlocks.vibro_wire.getDefaultState().withProperty(POWERED, false).withProperty(FACING, state.getValue(FACING)).withProperty(isL, state.getValue(isL)).withProperty(isR, state.getValue(isR))
			) { 
			ArrayList<BlockPos> poss = new ArrayList(); 
			ArrayList<BlockPos> unposs = new ArrayList(); 

			poss.add(pos); 
			for (int a = 0; a < 6; a++) 
				unposs.add(pos.add(EnumFacing.VALUES[a].getDirectionVec()));

			while (unposs.size() > 0) { 
				ArrayList<BlockPos> newSet = new ArrayList(); 
				for (BlockPos upp : unposs) {
					if (world.getBlockState(upp) == RegBlocks.vibro_wire.getDefaultState().withProperty(POWERED, false).withProperty(FACING, state.getValue(FACING))) {
						//  System.out.println("pos " + pos);
						poss.add(upp);
						for (int a = 0; a < 6; a++) {
							BlockPos pp = upp.add(EnumFacing.VALUES[a].getDirectionVec()); 
							if (!poss.contains(pp)) 
								world.setBlockState(upp, state.withProperty(POWERED, true));
							world.setBlockState(pos, state.withProperty(POWERED, true));
							newSet.add(pp); 
						}
					}  

					newSet.remove(upp); 
				}
				unposs = newSet; 
			}


		}
	}

	public void disableBlocks(IBlockState state, World world, BlockPos pos) {

		if (state == RegBlocks.vibro_wire.getDefaultState().withProperty(POWERED, true).withProperty(FACING, state.getValue(FACING)).withProperty(isL, state.getValue(isL)).withProperty(isR, state.getValue(isR))
			) { 
			ArrayList<BlockPos> poss = new ArrayList(); 
			ArrayList<BlockPos> unposs = new ArrayList(); 

			poss.add(pos); 
			for (int a = 0; a < 6; a++) 
				unposs.add(pos.add(EnumFacing.VALUES[a].getDirectionVec()));

			while (unposs.size() > 0) { 
				ArrayList<BlockPos> newSet = new ArrayList(); 
				for (BlockPos upp : unposs) {
					if (world.getBlockState(upp) == RegBlocks.vibro_wire.getDefaultState().withProperty(POWERED, true).withProperty(FACING, state.getValue(FACING))) {
						//	  System.out.println("pos2 " + pos);
						poss.add(upp);
						for (int a = 0; a < 6; a++) {
							BlockPos pp = upp.add(EnumFacing.VALUES[a].getDirectionVec()); 
							if (!poss.contains(pp)) 
								world.setBlockState(upp, state.withProperty(POWERED, false));
							world.setBlockState(pos, state.withProperty(POWERED, false));
							newSet.add(pp); 
						}
					}  
					
				
					newSet.remove(upp); 
				}
				unposs = newSet; 
			}


		}
	}
	public int getWeakPower(IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return 0;

	}

	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return getWeakPower(blockState, blockAccess, pos, side);
	}
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		IBlockState state = world.getBlockState(pos);
		Block connector = world.getBlockState(pos.offset(facing)).getBlock();
		if (state.getBlock() instanceof VibroWire || state.getBlock() == RegBlocks.vibro_wire_b )
		{
			if(!state.getBlock().isSideSolid(state, world, pos, facing)) {
				return connector instanceof VibroWire || connector == RegBlocks.vibro_wire_b || state.isSideSolid(world, pos, facing) || connector == RegBlocks.vibro_wire_lever;
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
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.WEST)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.EAST)).withProperty(POWERED, state.getValue(POWERED));

		case SOUTH:
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.WEST)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.EAST)).withProperty(POWERED, state.getValue(POWERED));
		case EAST:
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.SOUTH)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.NORTH)).withProperty(POWERED, state.getValue(POWERED));
		case WEST:
			return state.withProperty(isDEF, Boolean.valueOf(true)).withProperty(isR, canBeConnectedTo(worldIn, pos, EnumFacing.SOUTH)).withProperty(isL, canBeConnectedTo(worldIn, pos, EnumFacing.NORTH)).withProperty(POWERED, state.getValue(POWERED));

		default:
			break;

		}
		return state;

	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, isL, isR, isDEF, POWERED});
	}

}
