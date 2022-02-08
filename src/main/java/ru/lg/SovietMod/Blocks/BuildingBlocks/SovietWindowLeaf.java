package ru.lg.SovietMod.Blocks.BuildingBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class SovietWindowLeaf extends BasicBlockSideWithCustomModel {
	
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.81D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 0.19D),
			new AxisAlignedBB(0D, 0D, 0D, 0.19D, 1D, 1D),
			new AxisAlignedBB(0.81D, 0D, 0D, 1D, 1D, 1D)
	};
	
	public static final PropertyBool BROKEN = PropertyBool.create("broken");

	public static final PropertyBool PANE_DOWN = PropertyBool.create("down");

	
	public SovietWindowLeaf(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(PANE_DOWN, Boolean.FALSE).withProperty(FACING, EnumFacing.NORTH).withProperty(BROKEN, false));
	}
	  @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT_MIPPED;
	    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.SIDE_AABB[1];
		case NORTH:
		default:
			return this.SIDE_AABB[0];
		case WEST:
			return this.SIDE_AABB[3];
		case EAST:
			return this.SIDE_AABB[2];
		}
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
	//	state = state.withProperty(PANE_UP, this.attachesToBlock(state,worldIn, pos.up())).withProperty(FACING, state.getValue(FACING)).withProperty(BROKEN, state.getValue(BROKEN));
		state = state.withProperty(PANE_DOWN, this.attachesToBlock(state, worldIn, pos.down())).withProperty(FACING, state.getValue(FACING)).withProperty(BROKEN, state.getValue(BROKEN));
		return state;
	}
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING,PANE_DOWN,BROKEN});
	}
	
	private boolean attachesToBlock(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		Block block = world.getBlockState(pos).getBlock();
		return block instanceof SovietWindow || block instanceof SovietWindowLeaf;

	}
}


