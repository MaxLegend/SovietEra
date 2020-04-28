package ru.lg.SovietMod.Blocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import ru.lg.SovietMod.Blocks.BlockBeton.EnumType;

public class ItemBlockBeton extends ItemMultiTexture{

    public ItemBlockBeton(Block block) {
        super(block, block, new String[] {"gray_beton","green_beton","gray_beton_crack","green_beton_crack","white_beton","white_beton_crack"} );
        this.setHasSubtypes(true);
    }
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
   
            this.block.getSubBlocks(tab, items);
        }
    }
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + EnumType.byMetadata(stack.getMetadata()).getName();
    }
}
