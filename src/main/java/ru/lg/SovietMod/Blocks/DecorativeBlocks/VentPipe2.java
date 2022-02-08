package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;
import ru.lg.SovietMod.Blocks.RedWire.RedWire;

public class VentPipe2 extends BasicBlock {
	public VentPipe2(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DEFAULT, Boolean.valueOf(false)));
	}

	public static final PropertyBool DEFAULT = PropertyBool.create("default");
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		state = this.getActualState(state, source, pos);
		return AABB_BY_INDEX[getAABBIndex(state)];
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
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	@Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return false;
	}

	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState();
	}

	public int getMetaFromState(IBlockState state)
	{
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
				.withProperty(DEFAULT, Boolean.valueOf(true))
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
		if(connector instanceof VentPipe2 || connector instanceof BiolabTableUp || connector == RegBlocks.vent_pipe2_base || connector == RegBlocks.vent_circle || connector == RegBlocks.vent_filter) {
			return true;
		} else return false;
	}
}


