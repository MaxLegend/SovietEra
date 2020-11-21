package ru.lg.SovietMod.Event;

import net.minecraft.block.BlockStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.Blocks.BlockBeton;
import ru.lg.SovietMod.Blocks.BlockKafel;
import ru.lg.SovietMod.Blocks.SovietWindow;
import ru.lg.SovietMod.Blocks.SovietWindowLeaf;

public class HammerEvent {
	@SubscribeEvent
	public void replace(PlayerInteractEvent.LeftClickBlock e) {
		if(!e.getWorld().isRemote) { 
			if(!e.getEntityPlayer().isCreative()) {
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()) == RegBlocks.betons.getDefaultState().withProperty(BlockBeton.VARIANT, BlockBeton.EnumType.GRAY_BETON)) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.kafels.getDefaultState().withProperty(BlockBeton.VARIANT, BlockBeton.EnumType.GRAY_BETON_CRACK));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()) == RegBlocks.betons.getDefaultState().withProperty(BlockBeton.VARIANT, BlockBeton.EnumType.GREEN_BETON)) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.kafels.getDefaultState().withProperty(BlockBeton.VARIANT, BlockBeton.EnumType.GREEN_BETON_CRACK));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()) == RegBlocks.betons.getDefaultState().withProperty(BlockBeton.VARIANT, BlockBeton.EnumType.WHITE_BETON)) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.kafels.getDefaultState().withProperty(BlockBeton.VARIANT, BlockBeton.EnumType.WHITE_BETON_CRACK));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()) == RegBlocks.kafels.getDefaultState().withProperty(BlockKafel.VARIANT, BlockKafel.EnumType.KAFEL_3)) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.kafels.getDefaultState().withProperty(BlockKafel.VARIANT, BlockKafel.EnumType.KAFEL_3C));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()) == RegBlocks.kafels.getDefaultState().withProperty(BlockKafel.VARIANT, BlockKafel.EnumType.KAFEL_2)) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.kafels.getDefaultState().withProperty(BlockKafel.VARIANT, BlockKafel.EnumType.KAFEL_2C));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()) == RegBlocks.kafels.getDefaultState().withProperty(BlockKafel.VARIANT, BlockKafel.EnumType.KAFEL_1)) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.kafels.getDefaultState().withProperty(BlockKafel.VARIANT, BlockKafel.EnumType.KAFEL_1C));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}


				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.soviet_window) {
					EnumFacing facing = e.getWorld().getBlockState(e.getPos()).getValue(SovietWindow.FACING);
					e.getWorld().setBlockState(e.getPos(), RegBlocks.soviet_window.getDefaultState().withProperty(SovietWindow.BROKEN, true).withProperty(SovietWindow.FACING, facing));
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.soviet_window_leaf) {
					EnumFacing facing = e.getWorld().getBlockState(e.getPos()).getValue(SovietWindowLeaf.FACING);
					e.getWorld().setBlockState(e.getPos(), RegBlocks.soviet_window_leaf.getDefaultState().withProperty(SovietWindowLeaf.BROKEN, true).withProperty(SovietWindowLeaf.FACING, facing));
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.glazed_tile) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.glazed_tile_cracked.getDefaultState());

					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.tile, 3));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.glazed_tile_blue) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.glazed_tile_blue_cracked.getDefaultState());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.tile, 3));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.glazed_tile_white) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.glazed_tile_white_cracked.getDefaultState());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.tile, 3));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.tilled_block) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.tilled_block_cracked.getDefaultState());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.quad_tile, 2));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.glazed_tile_black) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.glazed_tile_black_cracked.getDefaultState());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.tile, 3));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.small_tiles_blue) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.small_tiles_blue_cracked.getDefaultState());
					e.getItemStack().damageItem(1, e.getEntityPlayer());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.quad_tile_small, 5));
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.small_tiles) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.small_tiles_cracked.getDefaultState());
					e.getItemStack().damageItem(1, e.getEntityPlayer());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.quad_tile_small, 5));
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.aquamarine_tile) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.aquamarine_tile_cracked.getDefaultState());
					e.getItemStack().damageItem(1, e.getEntityPlayer());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.big_tile, 2));
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.brown_tile) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.brown_tile_crack.getDefaultState());
					e.getItemStack().damageItem(1, e.getEntityPlayer());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.big_tile, 2));
				}
				if(e.getItemStack().getItem() == RegItems.hammer && e.getWorld().getBlockState(e.getPos()).getBlock() == RegBlocks.blue_tilled_block) {
					e.getWorld().setBlockState(e.getPos(), RegBlocks.blue_tilled_block_cracked.getDefaultState());
					e.getWorld().getBlockState(e.getPos()).getBlock().spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(RegItems.quad_tile, 2));
					e.getItemStack().damageItem(1, e.getEntityPlayer());
				}
			}
		}
	}
//	@SubscribeEvent
	public void onDrop(BlockEvent.HarvestDropsEvent event) {		
		EntityPlayer player = (EntityPlayer)event.getHarvester();
		if(!event.getWorld().isRemote) { 	
			if(player != null) {
				ItemStack is = player.getHeldItem(EnumHand.MAIN_HAND);
				if (is != null && is.getItem() == RegItems.hammer && event.getState() == Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE)) {
				
						event.getDrops().clear();
						event.getDrops().add(new ItemStack(RegItems.andesite_rock,event.getWorld().rand.nextInt(5),0));
						is.damageItem(1, player);
					
				}
			}
		}

	}
}
