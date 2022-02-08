package ru.lg.SovietMod.Blocks.DecorativeBlocks;

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

public class ChemStuff extends BasicBlockSideWithCustomModel {
	private static AxisAlignedBB SIDE_AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 0.25D, 1D);

	public ChemStuff(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return SIDE_AABB;
	}
	  @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT_MIPPED;
	    }
}
