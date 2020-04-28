package ru.lg.SovietMod.Items;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import ru.lg.SovietMod.RegBlocks;

public class ItemHammer extends ItemPickaxe{
	 private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(
			 RegBlocks.blue_tilled_block, RegBlocks.blue_tilled_block_cracked, RegBlocks.blue_tilled_block_moss,
			 RegBlocks.glazed_tile, RegBlocks.glazed_tile_blue,RegBlocks.glazed_tile_blue_cracked,RegBlocks.glazed_tile_cracked,
			 RegBlocks.glazed_tile_white,RegBlocks.glazed_tile_white_cracked);

	public ItemHammer(String name,int maxStackSize,CreativeTabs tab) {
		super(ToolMaterial.IRON);
		this.setRegistryName(name);
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
	
	}
	  @Override
	     public ItemStack getContainerItem(ItemStack stack) {
	    stack.attemptDamageItem(1, new Random(), null);
	         return stack.copy();
	       }
	  
	  @Override
	  public boolean hasContainerItem(ItemStack stack) {
	   
	         return true;
	     }
}
