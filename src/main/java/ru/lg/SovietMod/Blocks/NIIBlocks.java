package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;

public class NIIBlocks extends BasicBlock
{
    public static final PropertyEnum<NIIBlocks.EnumType> VARIANT = PropertyEnum.<NIIBlocks.EnumType>create("variant", NIIBlocks.EnumType.class);

    public NIIBlocks(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK, name, resistanse, resistanse, soundtype);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, NIIBlocks.EnumType.NII_WALL_3));
        this.setCreativeTab(SovietCore.tabMain);

    }

    public int damageDropped(IBlockState state)
    {
        return ((NIIBlocks.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (NIIBlocks.EnumType blockstone$enumtype : NIIBlocks.EnumType.values())
        {
            items.add(new ItemStack(this, 1, blockstone$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, NIIBlocks.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((NIIBlocks.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        NII_WALL_3(0, MapColor.DIRT, "nii_wall_3", true),
        NII_WALL_2(1, MapColor.QUARTZ, "nii_wall_2", true),
        NII_FLOOR_1(2, MapColor.DIRT, "nii_floor_1", true),
    	NII_WALL_4(3, MapColor.DIRT, "nii_wall_4", true);

        private static final NIIBlocks.EnumType[] META_LOOKUP = new NIIBlocks.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final boolean isNatural;

        private EnumType(int meta, MapColor mapColor, String name, boolean isNatural)
        {
            this(meta, name, name, isNatural);
        }

        private EnumType(int meta, String name, String Uname, boolean isNatural)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = Uname;
          
            this.isNatural = isNatural;
        }

        public int getMetadata()
        {
            return this.meta;
        }


        public String toString()
        {
            return this.name;
        }

        public static NIIBlocks.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        public boolean isNatural()
        {
            return this.isNatural;
        }

        static
        {
            for (NIIBlocks.EnumType blockstone$enumtype : values())
            {
                META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
            }
        }
    }
}
