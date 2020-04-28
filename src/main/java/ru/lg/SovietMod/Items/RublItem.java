package ru.lg.SovietMod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RublItem extends Item{
	public RublItem(String name,CreativeTabs tab){
		this.setRegistryName(name);
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);

		

	}

}
