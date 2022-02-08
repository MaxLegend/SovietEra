package ru.lg.SovietMod.Blocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import ru.lg.SovietMod.Blocks.NIIBlocks;
import ru.lg.SovietMod.Blocks.BuildingBlocks.BlockBeton.EnumType;

public class ItemBlockNIIBlocks extends ItemMultiTexture{

    public ItemBlockNIIBlocks(Block block) {
        super(block, block, new String[] {"nii_wall_1, nii_wall_2"} );
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
        return super.getUnlocalizedName() + "." + NIIBlocks.EnumType.byMetadata(stack.getMetadata()).getName();
    }
}
