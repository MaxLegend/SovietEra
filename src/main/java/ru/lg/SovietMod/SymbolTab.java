package ru.lg.SovietMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SymbolTab extends CreativeTabs {
	public SymbolTab(String label) {
		super(label);
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SymbolList.a);
	}
}
