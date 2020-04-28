package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;


public class BigHermodoorCorner extends BasicBlock {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<BigHermodoorCorner.Rotate> ROTATE = PropertyEnum.<BigHermodoorCorner.Rotate>create("rotate", BigHermodoorCorner.Rotate.class);
	
	public BigHermodoorCorner(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
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
