package ru.lg.SovietMod.Blocks.BuildingBlocks.Doors;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockDoor;

public class SovietDoorWoodInto extends BasicBlockDoor {

	public SovietDoorWoodInto(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, resistanse, resistanse, soundtype);
		this.setCreativeTab(null);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(this.getItem());
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return RegItems.wood_door_into_item;
	}
	private Item getItem()
	{ 
		return RegItems.wood_door_into_item;
	}

	@Override
	public SoundEvent getSound() {

		return RegSounds.alm_door;
	}
}
