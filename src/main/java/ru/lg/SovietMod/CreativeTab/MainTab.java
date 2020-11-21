package ru.lg.SovietMod.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.lg.SovietMod.RegBlocks;

public class MainTab extends CreativeTabs {
	public MainTab(String label) {
		super(label);
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(RegBlocks.tilled_block));
	}
}
