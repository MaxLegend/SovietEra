package ru.lg.SovietMod.Blocks.BigHermodoor;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockTrapdoor;

public class BigHermodoorEdge extends BasicBlock {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<BigHermodoorEdge.Rotate> ROTATE = PropertyEnum.<BigHermodoorEdge.Rotate>create("rotate", BigHermodoorEdge.Rotate.class);
	
	public BigHermodoorEdge(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
	}
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		
		return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
	}
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | state.getValue(FACING).getHorizontalIndex();
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	
	  public static enum Rotate implements IStringSerializable
	    {
	        LEFT("left"),
	        RIGHT("right"),
	        UP("up"),
	        DOWN("down");

	        private final String name;

	        private Rotate(String name)
	        {
	            this.name = name;
	        }

	        public String toString()
	        {
	            return this.name;
	        }

	        public String getName()
	        {
	            return this.name;
	        }
	    }
}
