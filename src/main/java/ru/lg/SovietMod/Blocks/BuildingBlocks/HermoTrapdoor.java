package ru.lg.SovietMod.Blocks.BuildingBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockTrapdoor;

public class HermoTrapdoor extends BasicBlockTrapdoor {

	public HermoTrapdoor(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);

	}
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		Item activeItem = playerIn.getHeldItem(hand).getItem();
		if(state.getValue(OPEN).booleanValue() == true) {
			state = state.cycleProperty(OPEN);
			worldIn.setBlockState(pos, state, 2);
			worldIn.playSound(null, pos, getSound(), SoundCategory.BLOCKS, 0.9F, 1.0F);
		} else {
			if(facing == EnumFacing.UP) {
				if(activeItem == RegItems.wrench) {
					state = state.cycleProperty(OPEN);
					worldIn.setBlockState(pos, state, 2);
					worldIn.playSound(null, pos, getSound(), SoundCategory.BLOCKS, 0.9F, 1.0F);
					return true;
				} else {
					return false;
				}
			} else if(facing == EnumFacing.DOWN){
				state = state.cycleProperty(OPEN);
				worldIn.setBlockState(pos, state, 2);
				worldIn.playSound(null, pos, getSound(), SoundCategory.BLOCKS, 0.9F, 1.0F);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	@Override
	public SoundEvent getSound() {

		return RegSounds.openhermodoor;
	}

}