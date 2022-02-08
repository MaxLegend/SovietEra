package ru.lg.SovietMod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.lg.SovietMod.Blocks.BlocksLino;
import ru.lg.SovietMod.Blocks.NIIBlocks;
import ru.lg.SovietMod.Blocks.BuildingBlocks.BlockBeton;
import ru.lg.SovietMod.Blocks.BuildingBlocks.BlockKafel;

public class RegRenderMetaBlocks {
	
	    @SubscribeEvent
	    public void registerMetaBlocks(ModelRegistryEvent e) {
	            registerBeton(RegBlocks.betons);
	            registerKafel(RegBlocks.kafels);
	            registerNIIBlocks(RegBlocks.nii_blocks);
	            registerLinoBlocks(RegBlocks.linos);
	            
	    }


	    public void registerBeton(Block block)
	    {
	        for(BlockBeton.EnumType type : BlockBeton.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	    }
	    public void registerKafel(Block block)
	    {
	        for(BlockKafel.EnumType type : BlockKafel.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	    }
	    
	    public void registerNIIBlocks(Block block)
	    {
	        for(NIIBlocks.EnumType type : NIIBlocks.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	    }
	    public void registerLinoBlocks(Block block)
	    {
	        for(BlocksLino.EnumType type : BlocksLino.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	    }

	}