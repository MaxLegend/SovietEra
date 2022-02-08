package ru.lg.SovietMod.Blocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import ru.lg.SovietMod.Blocks.BlocksLino;

public class ItemBlockLino extends ItemMultiTexture{

    public ItemBlockLino(Block block) {
        super(block, block, new String[] {"lino1","lino2","lino3","lino4","lino5","lino6","lino7","lino8"} );
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
        return super.getUnlocalizedName() + "." + BlocksLino.EnumType.byMetadata(stack.getMetadata()).getName();
    }
}

