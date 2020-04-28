package ru.lg.SovietMod.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;
import ru.lg.SovietMod.SovietCore;

public class SovietDoorWoodIntoItem extends ItemDoor {

	public SovietDoorWoodIntoItem(String name, Block block) {
		super(block);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(SovietCore.tabMain);
	}
	 
}
