package ru.lg.SovietMod.Blocks.BuildingBlocks.Windows;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class FactoryWindow extends BasicBlockSideWithCustomModel{
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.81D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 0.19D),
			new AxisAlignedBB(0D, 0D, 0D, 0.19D, 1D, 1D),
			new AxisAlignedBB(0.81D, 0D, 0D, 1D, 1D, 1D)
	};
	  @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.TRANSLUCENT;
	    }
	public FactoryWindow(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		
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
}
