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
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;

public class BlockKafel extends BasicBlock
{
    public static final PropertyEnum<BlockKafel.EnumType> VARIANT = PropertyEnum.<BlockKafel.EnumType>create("variant", BlockKafel.EnumType.class);

    public BlockKafel(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK, name, resistanse, resistanse, soundtype);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockKafel.EnumType.KAFEL_1));
        this.setCreativeTab(SovietCore.tabMain);

    }

    public int damageDropped(IBlockState state)
    {
        return ((BlockKafel.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (BlockKafel.EnumType blockstone$enumtype : BlockKafel.EnumType.values())
        {
            items.add(new ItemStack(this, 1, blockstone$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockKafel.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((BlockKafel.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        KAFEL_1(0, "kafel_1", true),
        KAFEL_2(1, "kafel_2", true),
        KAFEL_3(2, "kafel_3", true),
        KAFEL_1B(3, "kafel_1b", true),
        KAFEL_2B(4, "kafel_2b", true),
        KAFEL_3B(5, "kafel_3b", true),
        KAFEL_1C(6, "kafel_1c", true),
        KAFEL_2C(7, "kafel_2c", true),
        KAFEL_3C(8, "kafel_3c", true),
        KAFEL_4(9, "kafel_4", true),
        KAFEL_5(10, "kafel_5", true),
        KAFEL_6(11, "kafel_6", true),
        KAFEL_7(12, "kafel_7", true);

        private static final BlockKafel.EnumType[] META_LOOKUP = new BlockKafel.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final boolean isNatural;

        private EnumType(int meta, String name, boolean isNatural)
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

        public static BlockKafel.EnumType byMetadata(int meta)
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
            for (BlockKafel.EnumType blockstone$enumtype : values())
            {
                META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
            }
        }
    }
}