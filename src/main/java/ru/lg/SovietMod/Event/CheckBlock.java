package ru.lg.SovietMod.Event;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CheckBlock {
	@SubscribeEvent
	public void check(PlayerInteractEvent.RightClickBlock e) {
		BlockPos pos = e.getPos();
		EntityPlayer player = e.getEntityPlayer();
		World world = e.getEntityPlayer().getEntityWorld();
		if (world.getBlockState(pos).getBlock() == Blocks.OBSIDIAN) { // Если наш блок изначально обсидиан
			  ArrayList<BlockPos> poss = new ArrayList(); // Множество кол-ва наших блоков
			  ArrayList<BlockPos> unposs = new ArrayList(); // Множество кол-ва непроверенных блоков

			  poss.add(pos); // Добавляем наш блок в это множество
			  for (int a = 0; a < 6; a++) // В этом цикле происходи подбор соседей изначального блока
			    unposs.add(pos.add(EnumFacing.VALUES[a].getDirectionVec()));

			  while (unposs.size() > 0) { // В этом цикле происходит проверка и создание новых непроверенных блоков
				  ArrayList<BlockPos> newSet = new ArrayList(); // Создание нового множества, на замену unposs
			    for (BlockPos upp : unposs) {
			      if (e.getWorld().getBlockState(upp).getBlock() == Blocks.OBSIDIAN) {
			        poss.add(upp);
			        
			        for (int a = 0; a < 6; a++) {
			          BlockPos pp = upp.add(EnumFacing.VALUES[a].getDirectionVec()); // Позиция соседа
			          if (!poss.contains(pp)) // Проверка, что сосед не обсидиан, который мы уже добавляли
			            newSet.add(pp); // Добавление нового соседа на проверку
			        }
			      }  
			      newSet.remove(upp); // Проверили - удалили
			    }
			    unposs = newSet; // Замена множества с "правками"
			  }

			  System.out.println(poss.size());
			}
	}
}
