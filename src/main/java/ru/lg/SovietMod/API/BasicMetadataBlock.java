package ru.lg.SovietMod.API;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;

public abstract class BasicMetadataBlock extends BasicBlock {
    protected final MetadataContainer overrideBlockState;

    public BasicMetadataBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype, CreativeTabs tab) {
        super(materialIn, name, hardness, resistanse, soundtype);
        overrideBlockState = (MetadataContainer) blockState;
        setDefaultState(createDefaultState());
    }

    @Override
    protected final BlockStateContainer createBlockState() {
        return new MetadataContainer(this, createBlockProperties());
    }

    protected abstract IProperty<?>[] createBlockProperties();

    protected abstract IBlockState createDefaultState();

    @Override
    public final int getMetaFromState(IBlockState state) {
        return overrideBlockState.getMetaFromState(state);
    }

    @Override
    public final IBlockState getStateFromMeta(int meta) {
        return overrideBlockState.getStateFromMeta(meta);
    }
}