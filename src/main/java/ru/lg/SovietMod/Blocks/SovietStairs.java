package ru.lg.SovietMod.Blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import ru.lg.SovietMod.SovietCore;

public class SovietStairs extends BlockStairs {

	public SovietStairs(String name, IBlockState modelState, float hardness) {
		super(modelState);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(hardness);
		this.setCreativeTab(SovietCore.tabMain);
	}
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	@Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }
}
