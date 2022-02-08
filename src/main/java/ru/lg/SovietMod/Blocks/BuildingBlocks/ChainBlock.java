package ru.lg.SovietMod.Blocks.BuildingBlocks;


import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;

public class ChainBlock extends BasicBlockWithCustomModel {
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public ChainBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(DOWN, false));
	}
	
	private static AxisAlignedBB AABB = new AxisAlignedBB(0.42D, 0D, 0.42D, 0.58D, 1D, 0.58D);
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return AABB;
	}
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return 0;
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(UP, false).withProperty(DOWN, false);
	}
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		if(worldIn.getBlockState(pos.up()).isSideSolid(worldIn, pos, EnumFacing.DOWN)) {
			state = state.withProperty(UP, true);
		}
		if(worldIn.getBlockState(pos.down()) != RegBlocks.chain.getDefaultState()) {
			state = state.withProperty(DOWN, true);	
		}
		
		return state;
	}
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {UP,DOWN});
	}

}
