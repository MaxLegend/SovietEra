package ru.lg.SovietMod.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegItems;

public class InsDecoTab extends CreativeTabs {
	public InsDecoTab(String label) {
		super(label);
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(RegBlocks.turnstile_off));
	}
}