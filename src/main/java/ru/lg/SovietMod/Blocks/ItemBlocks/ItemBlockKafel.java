package ru.lg.SovietMod.Blocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import ru.lg.SovietMod.Blocks.BuildingBlocks.BlockKafel;

public class ItemBlockKafel extends ItemMultiTexture{

    public ItemBlockKafel(Block block) {
        super(block, block, new String[] {"kafel_1","kafel_2","kafel_3"} );
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
        return super.getUnlocalizedName() + "." + BlockKafel.EnumType.byMetadata(stack.getMetadata()).getName();
    }
}
