package ru.lg.SovietMod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class LabCoat extends ItemArmor{

	public LabCoat(String name, int maxStackSize, CreativeTabs tab, EntityEquipmentSlot slot, ArmorMaterial arm) {
		super(arm, 1, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(tab);
	
	}

	
}
