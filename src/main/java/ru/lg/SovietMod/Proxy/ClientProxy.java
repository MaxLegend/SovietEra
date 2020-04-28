package ru.lg.SovietMod.Proxy;

import com.google.common.collect.ImmutableMap;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegFluids;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Entity.EntityDspPanel1;
import ru.lg.SovietMod.Entity.EntityRedBanner;
import ru.lg.SovietMod.Entity.EntityWallCarpet;
import ru.lg.SovietMod.Entity.EntityWallTile1;
import ru.lg.SovietMod.Entity.EntityWallTile2;
import ru.lg.SovietMod.Entity.EntityWallpaper;
import ru.lg.SovietMod.Entity.EntityWallpaper2;
import ru.lg.SovietMod.Entity.EntityWallpaper3;
import ru.lg.SovietMod.Entity.EntityWallpaper4;
import ru.lg.SovietMod.Entity.EntityWallpaper5;
import ru.lg.SovietMod.Entity.Render.RenderEntityDspPanel1;
import ru.lg.SovietMod.Entity.Render.RenderEntityRedBanner;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallCarpet;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallTile1;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallTile2;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallpaper1;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallpaper2;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallpaper3;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallpaper4;
import ru.lg.SovietMod.Entity.Render.RenderEntityWallpaper5;
import ru.lg.SovietMod.Event.RegEvents.Client;

public class ClientProxy extends CommonProxy {

	//public static final SoundType ECHOING_STEP = new SoundType(1, 1, null, null, null, null, null);
	
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		new Client();
		RegFluids.registerRender();
		  OBJLoader.INSTANCE.addDomain(SovietCore.MODID);
		  
	//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNumberSign.class, new TileEntityNumberSignRender());
		  
		  
		  
	//	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySovSign.class, new SovTileEntitySignRender());
		
		
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrapAnimDoor.class, new AnimationTESR<TileEntityTrapAnimDoor>() {
//            @Override
//            public void handleEvents(TileEntityTrapAnimDoor tileEntity, float time, Iterable<Event> pastEvents) {
//                super.handleEvents(tileEntity, time, pastEvents);
//                tileEntity.handleEvents(time, pastEvents);
//            }
//        });
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBigHermoDoor.class, new AnimationTESR<TileEntityBigHermoDoor>() {
//            @Override
//            public void handleEvents(TileEntityBigHermoDoor tileEntity, float time, Iterable<Event> pastEvents) {
//                super.handleEvents(tileEntity, time, pastEvents);
//                tileEntity.handleEvents(time, pastEvents);
//            }
//        });
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHermoDoor.class, new AnimationTESR<TileEntityHermoDoor>() {
//            @Override
//            public void handleEvents(TileEntityHermoDoor tileEntity, float time, Iterable<Event> pastEvents) {
//                super.handleEvents(tileEntity, time, pastEvents);
//                tileEntity.handleEvents(time, pastEvents);
//            }
//        });
		
			RenderingRegistry.registerEntityRenderingHandler(EntityDspPanel1.class, new IRenderFactory() {
				@Override
				public Render createRenderFor(RenderManager manager) {
					return new RenderEntityDspPanel1(manager);
				}});
		RenderingRegistry.registerEntityRenderingHandler(EntityWallTile2.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallTile2(manager);
			}});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWallTile1.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallTile1(manager);
			}});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWallpaper5.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallpaper5(manager);
			}});
		RenderingRegistry.registerEntityRenderingHandler(EntityWallpaper4.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallpaper4(manager);
			}});
		RenderingRegistry.registerEntityRenderingHandler(EntityWallpaper3.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallpaper3(manager);
			}});
		RenderingRegistry.registerEntityRenderingHandler(EntityWallpaper2.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallpaper2(manager);
			}});
		RenderingRegistry.registerEntityRenderingHandler(EntityWallpaper.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallpaper1(manager);
			}});
		RenderingRegistry.registerEntityRenderingHandler(EntityRedBanner.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityRedBanner(manager);
			}});
		RenderingRegistry.registerEntityRenderingHandler(EntityWallCarpet.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				return new RenderEntityWallCarpet(manager);
			}});
	
	}

	
	@Override
    public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters) {
        return ModelLoaderRegistry.loadASM(location, parameters);
    }
/*	 private static TextureFont fontTexture;
	 

	   public static  SovFontRenderer  fr;*/
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	@Override
	public void init(FMLInitializationEvent event) {
		
		RegBlocks.registerRender();
		RegItems.registerRender();
		
		
		super.init(event);
		 
/*		ResourceLocation rl = new ResourceLocation(SovietCore.MODID, "textures/font/soviet_font.png");
		IResourceManager rs = Minecraft.getMinecraft().getResourceManager();
		TextureManager tmg = Minecraft.getMinecraft().renderEngine;

		fr = new SovFontRenderer(Minecraft.getMinecraft().gameSettings, rl, tmg, true);
		fr.onResourceManagerReload(rs);
	
	
	
		
		IReloadableResourceManager rs2 = (IReloadableResourceManager)Minecraft.getMinecraft().getResourceManager();
		rs2.registerReloadListener(this.fr);*/
		
	}

	

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	
	}
}