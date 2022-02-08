package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;

public class SovietTable extends BasicBlock {

	public static final PropertyBool DEFAULT = PropertyBool.create("default");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool CENTER = PropertyBool.create("center");

	protected static final AxisAlignedBB[] AABB_BY_INDEX = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D)
	};
	protected static final AxisAlignedBB[] CLIP_AABB_BY_INDEX = new AxisAlignedBB[] {
			AABB_BY_INDEX[0].setMaxY(1D), AABB_BY_INDEX[1].setMaxY(1D),
			AABB_BY_INDEX[2].setMaxY(1D), AABB_BY_INDEX[3].setMaxY(1D),
			AABB_BY_INDEX[4].setMaxY(1D), AABB_BY_INDEX[5].setMaxY(1D),
			AABB_BY_INDEX[6].setMaxY(1D), AABB_BY_INDEX[7].setMaxY(1D),
			AABB_BY_INDEX[8].setMaxY(1D), AABB_BY_INDEX[9].setMaxY(1D),
			AABB_BY_INDEX[10].setMaxY(1D), AABB_BY_INDEX[11].setMaxY(1D),
			AABB_BY_INDEX[12].setMaxY(1D), AABB_BY_INDEX[13].setMaxY(1D),
			AABB_BY_INDEX[14].setMaxY(1D), AABB_BY_INDEX[15].setMaxY(1D)
	};


	public SovietTable(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DEFAULT, Boolean.valueOf(true)).withProperty(CENTER, Boolean.valueOf(false))
				.withProperty(NORTH, Boolean.valueOf(false))
				.withProperty(SOUTH, Boolean.valueOf(false))
				.withProperty(EAST, Boolean.valueOf(false))
				.withProperty(WEST, Boolean.valueOf(false)));
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	{
		return false;
	}
    public boolean isTopSolid(IBlockState state)
    {
        return true;
    }
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	@Override

	public boolean isFullCube(IBlockState state) {
		return false;
	}
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return false;
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		state = this.getActualState(state, source, pos);
		return AABB_BY_INDEX[getAABBIndex(state)];
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
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
	{
		if (!p_185477_7_)
		{
			state = this.getActualState(state, worldIn, pos);
		}

		addCollisionBoxToList(pos, entityBox, collidingBoxes, CLIP_AABB_BY_INDEX[getAABBIndex(state)]);
	}


	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState();
	}
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return 0;
	}

	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		if(world.getBlockState(pos.east()).getBlock() == RegBlocks.soviet_table && world.getBlockState(pos.west()).getBlock() == RegBlocks.soviet_table) return state.withProperty(CENTER, true).withProperty(DEFAULT, false);
		if(world.getBlockState(pos.south()).getBlock() == RegBlocks.soviet_table && world.getBlockState(pos.north()).getBlock() == RegBlocks.soviet_table) return state.withProperty(CENTER, true).withProperty(DEFAULT, false);
		if(world.getBlockState(pos.north()).getBlock() == RegBlocks.soviet_table)return state.withProperty(NORTH, true).withProperty(DEFAULT, false);
		if(world.getBlockState(pos.south()).getBlock() == RegBlocks.soviet_table)return state.withProperty(SOUTH, true).withProperty(DEFAULT, false);
		if(world.getBlockState(pos.west()).getBlock() == RegBlocks.soviet_table)return state.withProperty(WEST, true).withProperty(DEFAULT, false);
		if(world.getBlockState(pos.east()).getBlock() == RegBlocks.soviet_table)return state.withProperty(EAST, true).withProperty(DEFAULT, false);

		else return state;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {DEFAULT,CENTER, NORTH, EAST, WEST, SOUTH});
	}



	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return face != EnumFacing.UP && face != EnumFacing.DOWN ? BlockFaceShape.MIDDLE_POLE : BlockFaceShape.CENTER;
	}




}
