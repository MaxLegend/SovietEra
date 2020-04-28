package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class LabGlassCase extends BasicBlockSideWithCustomModel{

	public LabGlassCase(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		
	}
	  @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT_MIPPED;
	    }
	  
		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
		{
			return new AxisAlignedBB(0,0,0,1,0.5D,1);
		}
		@Override
		public void onBlockAdded(World world, BlockPos pos, IBlockState state)
		{
			if (!world.isRemote)
			{
				if(state.getValue(LabGlassCase.FACING) == EnumFacing.SOUTH && world.isAirBlock(pos.north())) {
					world.setBlockState(pos.east(), RegBlocks.fantom_slabd.getDefaultState());
				}
				if(state.getValue(LabGlassCase.FACING) == EnumFacing.NORTH && world.isAirBlock(pos.south())) {
					world.setBlockState(pos.west(), RegBlocks.fantom_slabd.getDefaultState());
				}
				if(state.getValue(LabGlassCase.FACING) == EnumFacing.EAST && world.isAirBlock(pos.west())) {
					world.setBlockState(pos.north(), RegBlocks.fantom_slabd.getDefaultState());
				}
				if(state.getValue(LabGlassCase.FACING) == EnumFacing.WEST && world.isAirBlock(pos.east())) {
					world.setBlockState(pos.south(), RegBlocks.fantom_slabd.getDefaultState());
				}
			}
		}
}
