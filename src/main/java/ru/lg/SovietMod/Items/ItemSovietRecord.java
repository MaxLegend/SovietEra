package ru.lg.SovietMod.Items;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import ru.lg.SovietMod.SovietCore;

public class ItemSovietRecord extends ItemRecord
{

	public ItemSovietRecord(String name, String nameDesc, SoundEvent soundIn) {
		super(nameDesc, soundIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(SovietCore.tabMain);
	}
   
}