package ru.lg.SovietMod.Blocks.BuildingBlocks;

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

public class BlockBeton extends BasicBlock
{
    public static final PropertyEnum<BlockBeton.EnumType> VARIANT = PropertyEnum.<BlockBeton.EnumType>create("variant", BlockBeton.EnumType.class);

    public BlockBeton(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK, name, resistanse, resistanse, soundtype);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockBeton.EnumType.GRAY_BETON));
        this.setCreativeTab(SovietCore.tabMain);

    }

    public int damageDropped(IBlockState state)
    {
        return ((BlockBeton.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (BlockBeton.EnumType blockstone$enumtype : BlockBeton.EnumType.values())
        {
            items.add(new ItemStack(this, 1, blockstone$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockBeton.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((BlockBeton.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        GRAY_BETON(0, MapColor.DIRT, "gray_beton", true),
        GREEN_BETON(1, MapColor.QUARTZ, "green_beton", true),
        GRAY_BETON_CRACK(2, MapColor.STONE, "gray_beton_crack", true),
    	GREEN_BETON_CRACK(3, MapColor.STONE, "green_beton_crack", true),
    	WHITE_BETON(4, MapColor.QUARTZ, "white_beton", true),
    	WHITE_BETON_CRACK(5, MapColor.STONE, "white_beton_crack", true),
    	BLUE_BETON(6, MapColor.QUARTZ, "blue_beton", true),
    	BLUE_BETON_CRACK(7, MapColor.STONE, "blue_beton_crack", true),
    	BEIGE_BETON(8, MapColor.QUARTZ, "beige_beton", true),
    	BEIGE_BETON_CRACK(9, MapColor.STONE, "beige_beton_crack", true),
    	BEIGE_BETON2(10, MapColor.QUARTZ, "beige_beton2", true),
    	BEIGE_BETON2_CRACK(11, MapColor.STONE, "beige_beton2_crack", true),
    	RED_BETON(12, MapColor.QUARTZ, "red_beton", true),
    	RED_BETON_CRACK(13, MapColor.STONE, "red_beton_crack", true),
     	YELLOW_BETON(14, MapColor.QUARTZ, "yellow_beton", true),
    	YELLOW_BETON_CRACK(15, MapColor.STONE, "yellow_beton_crack", true);

        private static final BlockBeton.EnumType[] META_LOOKUP = new BlockBeton.EnumType[values().length];
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

        public static BlockBeton.EnumType byMetadata(int meta)
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
            for (BlockBeton.EnumType blockstone$enumtype : values())
            {
                META_LOOKUP[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
            }
        }
    }
}