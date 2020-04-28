package ru.lg.SovietMod.Blocks.Basic;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Proxy.CommonProxy;

public class BasicItemBlock extends ItemBlock {
	String type, color ;
	public BasicItemBlock(String color,String type, Block block) {
		super(block);
	this.type = type;
	this.color = color;

	}
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tt, ITooltipFlag flagIn)
	{
		tt.add(I18n.format(type));
		tt.add(I18n.format(color));
	}

}