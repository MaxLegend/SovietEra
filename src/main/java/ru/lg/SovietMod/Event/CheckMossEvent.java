package ru.lg.SovietMod.Event;

import net.minecraft.block.BlockDirectional;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.BlockMoss;

public class CheckMossEvent {
	@SubscribeEvent
	public void check(BlockEvent.BreakEvent e) {
		if(!e.getWorld().isRemote) {
	  	for(EnumFacing f : BlockDirectional.FACING.getAllowedValues()) {

    		if(e.getWorld().getBlockState(e.getPos().offset(f)).getBlock() == RegBlocks.block_moss) {
    			
    			e.getWorld().setBlockState(e.getPos().offset(f), Blocks.AIR.getDefaultState());
    		}
    	}
		}
	}
}
