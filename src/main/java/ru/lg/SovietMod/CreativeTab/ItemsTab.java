package ru.lg.SovietMod.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.lg.SovietMod.RegItems;

public class ItemsTab extends CreativeTabs {
	public ItemsTab(String label) {
		super(label);
	}
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(RegItems.armature);
	}
}