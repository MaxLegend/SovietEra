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

public class BlocksLino extends BasicBlock
{
    public static final PropertyEnum<BlocksLino.EnumType> VARIANT = PropertyEnum.<BlocksLino.EnumType>create("variant", BlocksLino.EnumType.class);

    public BlocksLino(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK, name, resistanse, resistanse, soundtype);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlocksLino.EnumType.LINO1));
        this.setCreativeTab(SovietCore.tabMain);

    }

    public int damageDropped(IBlockState state)
    {
        return ((BlocksLino.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (BlocksLino.EnumType blockstone$enumtype : BlocksLino.EnumType.values())
        {
            items.add(new ItemStack(this, 1, blockstone$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlocksLino.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((BlocksLino.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        LINO1(0, MapColor.DIRT, "lino1", true),
        LINO2(1, MapColor.DIRT, "lino2", true),
        LINO3(2, MapColor.DIRT, "lino3", true),
        LINO4(3, MapColor.DIRT, "lino4", true),
        LINO5(4, MapColor.DIRT, "lino5", true),
        LINO6(5, MapColor.DIRT, "lino6", true),
    	 LINO7(6, MapColor.DIRT, "lino7", true),
    	 LINO8(7, MapColor.DIRT, "lino8", true);

        private static final BlocksLino.EnumType[] META_LOOKUP = new BlocksLino.EnumType[values().length];
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

        public static BlocksLino.EnumType byMetadata(int meta)
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
            for (BlocksLino.EnumType blockstone$enumtype : values())
            {
                META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
            }
        }
    }
}
