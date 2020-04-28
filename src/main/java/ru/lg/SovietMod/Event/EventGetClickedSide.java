package ru.lg.SovietMod.Event;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventGetClickedSide {
	static EnumFacing facing;
	static EnumHand hand;
	static BlockPos pos;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void getClickSide(PlayerInteractEvent.RightClickBlock e) {
		 facing = e.getFace();
		 hand = e.getHand();
		 pos = e.getPos();
		 
	}
	public static EnumFacing clickSide() {
		return facing;
	}
	public static EnumHand getHandClicked() {
		return hand;
	}
	public static BlockPos getBlockPosClick() {
		return pos;
	}
}
