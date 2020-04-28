package ru.lg.SovietMod.Blocks.RedWire;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;

//TODO сделать блокстейт запитан\незапитан
public class RedWire extends Block
{
	public static final PropertyBool DEFAULT = PropertyBool.create("default");
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");

	boolean isOn;
	private boolean isPower;
	protected static final AxisAlignedBB[] AABB_BY_INDEX = new AxisAlignedBB[] {
			/*1*/	new AxisAlignedBB(0.375D, 0.375D, 0.375D, 0.625D, 0.625D, 0.625D),//одиночный кубик, + если (снизу\сверху, дефолт)
			/*2*/	new AxisAlignedBB(0.375D, 0.375D, 0.375D, 0.625D, 0.625D, 1D),//когда что то есть на +Z
			/*3*/	new AxisAlignedBB(0D, 0.375D, 0.375D, 0.625D, 0.625D, 0.625D),//когда что то есть на -X
			/*4*/	new AxisAlignedBB(0D, 0.375D, 0.375D, 0.625D, 0.625D, 1D),//когда есть что то на -X и +Z
			/*5*/	new AxisAlignedBB(0.375D, 0.375D, 0.625D, 0.625D, 0.625D, 0D),//когда что то есть на -Z
			/*6*/	new AxisAlignedBB(0.375D, 0.375D, 0D, 0.625D, 0.625D, 1D), //когда что то есть на -Z и +Z
			/*7*/	new AxisAlignedBB(0D, 0.375D, 0.625D, 0.625D, 0.625D, 0D),//когда что то есть на -X и -Z
			/*8*/	new AxisAlignedBB(0.625D, 0.375D, 0D, 0D, 0.625D, 1D),//когда что то есть на +Z, -Z и -X
			/*9*/	new AxisAlignedBB(0.375D, 0.375D, 0.375D, 1D, 0.625D, 0.625D),//когда что то есть на +X
			/*10*/	new AxisAlignedBB(0.375D, 0.375D, 0.375D, 1D, 0.625D, 1D),//когда что то есть на +X и +Z
			/*11*/	new AxisAlignedBB(0D, 0.375D, 0.375D, 1D, 0.625D, 0.625D),//когда что то есть на -X и +X
			/*12*/	new AxisAlignedBB(0D, 0.375D, 0.375D, 1D, 0.625D, 1D),//когда что то есть на -X и +X и +Z	
			/*13*/	new AxisAlignedBB(0.375D, 0.375D, 0.625D, 1D, 0.625D, 0D),//когда что то есть на +X, -Z
			/*14*/	new AxisAlignedBB(0.375D, 0.375D, 0D, 1D, 0.625D, 1D),//когда что то есть на -Z и +Z и +X
			/*15*/	new AxisAlignedBB(0D, 0.375D, 0.375D, 1D, 0.625D, 0D),//когда что то есть на -X и +X и +Z
			/*16*/	new AxisAlignedBB(0D, 0.375D, 0D, 1D, 0.625D, 1D),//все четыре стороны
	};   
	protected static final AxisAlignedBB[] CLIP_AABB_BY_INDEX = new AxisAlignedBB[] {
			AABB_BY_INDEX[0].setMaxY(0.5D),
			AABB_BY_INDEX[1].setMaxY(0.5D),
			AABB_BY_INDEX[2].setMaxY(0.5D),
			AABB_BY_INDEX[3].setMaxY(0.5D),
			AABB_BY_INDEX[4].setMaxY(0.5D),
			AABB_BY_INDEX[5].setMaxY(0.5D),
			AABB_BY_INDEX[6].setMaxY(0.5D),
			AABB_BY_INDEX[7].setMaxY(0.5D),
			AABB_BY_INDEX[8].setMaxY(0.5D),
			AABB_BY_INDEX[9].setMaxY(0.5D),
			AABB_BY_INDEX[10].setMaxY(0.5D),
			AABB_BY_INDEX[11].setMaxY(0.5D),
			AABB_BY_INDEX[12].setMaxY(0.5D),
			AABB_BY_INDEX[13].setMaxY(0.5D),
			AABB_BY_INDEX[14].setMaxY(0.5D),
			AABB_BY_INDEX[15].setMaxY(0.5D)};


	public RedWire(String name, boolean isOn)
	{

		super(Material.ROCK);
		this.isOn = isOn;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DEFAULT, Boolean.valueOf(false)));

	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		state = this.getActualState(state, source, pos);
		return AABB_BY_INDEX[getAABBIndex(state)];
	}
	public boolean canProvidePower(IBlockState state)
	{
		return true;
	}

	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return this.isOn ? 15 : 0;
	}

	public Block getPoweredBlock() {
		return this;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!world.isRemote)
		{
			world.scheduleBlockUpdate(pos, this,1, 0);
			if (this.isOn && !world.isBlockPowered(pos))
			{
		//		if(world.getBlockState(fromPos) == RegBlocks.red_wire_on.getDefaultState()) {
		//		world.setBlockState(pos, RegBlocks.red_wire_on.getDefaultState());
		//		}
			}

			if (!this.isOn && world.isBlockPowered(pos))
			{
		//		world.setBlockState(pos, RegBlocks.red_wire.getDefaultState());
			}

		}
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!world.isRemote)
		{
			super.updateTick(world, pos, state, rand);
			world.scheduleBlockUpdate(pos, this,1, 0);


		}
		if (!world.isBlockPowered(pos))
		{
			

		}
		if (world.isBlockPowered(pos)) {
		
		}


	}



	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
	{
		if (!p_185477_7_)
		{
			state = this.getActualState(state, worldIn, pos);
		}

		addCollisionBoxToList(pos, entityBox, collidingBoxes, CLIP_AABB_BY_INDEX[getAABBIndex(state)]);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		blockState = this.getActualState(blockState, worldIn, pos);
		return CLIP_AABB_BY_INDEX[getAABBIndex(blockState)];
	}
	@Override
	public boolean getWeakChanges(IBlockAccess world, BlockPos pos)
	{
		return true;
	}
	private static int getAABBIndex(IBlockState state)
	{
		int i = 0;


		if (((Boolean)state.getValue(NORTH)).booleanValue())
		{
			i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
		}

		if (((Boolean)state.getValue(EAST)).booleanValue())
		{
			i |= 1 << EnumFacing.EAST.getHorizontalIndex();
		}

		if (((Boolean)state.getValue(SOUTH)).booleanValue())
		{
			i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
		}
		if (((Boolean)state.getValue(WEST)).booleanValue())
		{
			i |= 1 << EnumFacing.WEST.getHorizontalIndex();
		}

		return i;
	}


	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	private boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing p_176253_3_)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, pos, p_176253_3_);
		boolean flag = blockfaceshape == BlockFaceShape.MIDDLE_POLE_THICK || blockfaceshape == BlockFaceShape.MIDDLE_POLE && block instanceof BlockFenceGate;
		return  blockfaceshape == BlockFaceShape.SOLID || flag;
	}

	public int damageDropped(IBlockState state)
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return side == EnumFacing.DOWN ? super.shouldSideBeRendered(blockState, blockAccess, pos, side) : true;
	}

	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState();
	}

	public int getMetaFromState(IBlockState state)
	{
		return 0;
	}


	public int getCountRedWire(IBlockState state, BlockPos pos, World world) {

	//	if (state.getBlock() == RegBlocks.red_wire_on) { 
			HashSet<BlockPos> poss = new HashSet(); 
			HashSet<BlockPos> unposs = new HashSet(); 
			poss.add(pos); 
			for (int a = 0; a < 6; a++) 
				unposs.add(pos.add(EnumFacing.VALUES[a].getDirectionVec()));

			while (unposs.size() > 0) { 
				HashSet<BlockPos> newSet = new HashSet(); 
				for (BlockPos upp : unposs) {
	//				if (world.getBlockState(upp).getBlock() == RegBlocks.red_wire_on) {
						poss.add(upp);
						for (int a = 0; a < 6; a++) {
							BlockPos pp = upp.add(EnumFacing.VALUES[a].getDirectionVec()); // Позиция соседа
							if (!poss.contains(pp))
								newSet.add(pp); 
	//					}
	//				}  
					newSet.remove(upp);
				}
				unposs = newSet; 
			}
			return poss.size();
		}
		return 0;
	}

	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		boolean flag0 =  canWallConnectTo(worldIn, pos, EnumFacing.DOWN);
		boolean flag4 =  canWallConnectTo(worldIn, pos, EnumFacing.UP);
		boolean flag =  canWallConnectTo(worldIn, pos, EnumFacing.NORTH);
		boolean flag1 = canWallConnectTo(worldIn, pos, EnumFacing.EAST);
		boolean flag2 = canWallConnectTo(worldIn, pos, EnumFacing.SOUTH);
		boolean flag3 = canWallConnectTo(worldIn, pos, EnumFacing.WEST);
		return state
				.withProperty(DEFAULT, Boolean.valueOf(!flag4))
				.withProperty(UP, Boolean.valueOf(flag4))
				.withProperty(NORTH, Boolean.valueOf(flag))
				.withProperty(EAST, Boolean.valueOf(flag1))
				.withProperty(SOUTH, Boolean.valueOf(flag2))
				.withProperty(WEST, Boolean.valueOf(flag3))
				.withProperty(DOWN, Boolean.valueOf(flag0));
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {DEFAULT, DOWN, UP, NORTH, EAST, WEST, SOUTH});
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess iba, IBlockState state, BlockPos pos, EnumFacing facing)
	{
		return facing != EnumFacing.UP && facing != EnumFacing.DOWN ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
	}

	private boolean canWallConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		Block connector = world.getBlockState(pos.offset(facing)).getBlock();
		IBlockState state_connector = world.getBlockState(pos.offset(facing));
		if(connector instanceof RedWire || connector instanceof BlockRedstoneWire|| connector instanceof BlockRedstoneDiode) {
			return true;
		} else return false;
	}
}