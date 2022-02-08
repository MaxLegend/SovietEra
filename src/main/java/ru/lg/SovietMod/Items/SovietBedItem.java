package ru.lg.SovietMod.Items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.DecorativeBlocks.SovietBed;

public class SovietBedItem extends BasicItem {
	public SovietBedItem(String name, int maxStackSize, CreativeTabs tab) {
		super(name, maxStackSize, tab);
		// TODO Auto-generated constructor stub
	}

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{

			int i = MathHelper.floor((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			EnumFacing enumfacing = EnumFacing.getHorizontal(i);
			BlockPos blockpos = pos.up().offset(enumfacing);
			ItemStack itemstack = player.getHeldItem(hand);

			if (worldIn.getBlockState(pos.down()).isTopSolid() && worldIn.getBlockState(blockpos.down()).isTopSolid())
			{

				IBlockState stateBack = RegBlocks.soviet_bed.getDefaultState().withProperty(SovietBed.PART, SovietBed.EnumHalf.FOOT);
				IBlockState stateHead = RegBlocks.soviet_bed.getDefaultState().withProperty(SovietBed.PART, SovietBed.EnumHalf.HEAD);
				worldIn.setBlockState(pos.up(), RegBlocks.soviet_bed.getDefaultState().withProperty(SovietBed.FACING, enumfacing).withProperty(SovietBed.PART, SovietBed.EnumHalf.FOOT),10);
				worldIn.setBlockState(blockpos, RegBlocks.soviet_bed.getDefaultState().withProperty(SovietBed.FACING, enumfacing).withProperty(SovietBed.PART, SovietBed.EnumHalf.HEAD),4);
	
				itemstack.shrink(1);

			
}
		
		return  EnumActionResult.SUCCESS;
	

	}
}
