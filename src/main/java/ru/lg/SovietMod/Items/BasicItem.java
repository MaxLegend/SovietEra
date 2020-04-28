package ru.lg.SovietMod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
/**
 * Basics API class by Item
 * @author LegendGamer
 */
public class BasicItem extends Item{
	public BasicItem(String name,int maxStackSize,CreativeTabs tab){
		this.setRegistryName(name);
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
		

	}

}
