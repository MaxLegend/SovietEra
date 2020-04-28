package ru.lg.SovietMod.Items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BasicItemWithInfo extends Item {
	 String info;
	public BasicItemWithInfo(String name,int maxStackSize,CreativeTabs tab,String info){
		this.setRegistryName(name);
		this.setCreativeTab(tab);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
		this.info = info;
	}
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tt, ITooltipFlag ttAdd)
    {
    	tt.add(I18n.format(info));
    }
}
