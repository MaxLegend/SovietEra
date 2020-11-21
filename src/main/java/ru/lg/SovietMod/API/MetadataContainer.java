package ru.lg.SovietMod.API;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

import java.util.stream.Collectors;

//Metadata Builder by mousecray for RealismCraft
public class MetadataContainer extends BlockStateContainer {

    private final ImmutableMap<IBlockState, Integer> stateToMeta;

    public MetadataContainer(Block blockIn, IProperty<?>... properties) {
        super(blockIn, properties);
        stateToMeta = ImmutableMap.copyOf(getValidStates().stream().collect(Collectors.toMap(key -> key, value -> getValidStates().indexOf(value))));
    }

    public int getMetaFromState(IBlockState state) {
        return stateToMeta.get(state);
    }

    public IBlockState getStateFromMeta(int meta) {
        return getValidStates().get(meta);
    }
}

