package ru.lg.SovietMod.Blocks.BuildingBlocks.Doors;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;
import ru.lg.SovietMod.API.BasicMetadataBlock;

public class BigHermodoor extends BasicMetadataBlock {

	public BigHermodoor(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype,
			CreativeTabs tab) {
		super(materialIn, name, hardness, resistanse, soundtype, tab);
		
	}

	
	public static enum EnumDoorPart implements IStringSerializable
    {
        UPPER,
        LEFT_UPPER,
        LEFT_LOWER;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this.toString();
        }
    }


	@Override
	protected IProperty<?>[] createBlockProperties() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected IBlockState createDefaultState() {
		// TODO Auto-generated method stub
		return null;
	}
}
