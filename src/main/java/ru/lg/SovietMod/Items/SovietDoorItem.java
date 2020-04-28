package ru.lg.SovietMod.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.SovietCore;

public class SovietDoorItem extends ItemDoor {

	public SovietDoorItem(String name, Block block) {
		super(block);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(SovietCore.tabMain);
	}
	 
}
