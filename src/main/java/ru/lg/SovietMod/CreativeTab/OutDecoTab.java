package ru.lg.SovietMod.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.lg.SovietMod.RegBlocks;

public class OutDecoTab extends CreativeTabs {
	public OutDecoTab(String label) {
		super(label);
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(RegBlocks.street_light_false));
	}
}