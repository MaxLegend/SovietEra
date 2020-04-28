package ru.lg.SovietMod;

import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.lg.SovietMod.Proxy.CommonProxy;

@Mod(modid = SovietCore.MODID, name = SovietCore.NAME, version = SovietCore.VERSION)
public class SovietCore
{
    public static final String MODID = "soviet";
    public static final String NAME = "Soviet Mod";
    public static final String VERSION = "0.4.1 Custom";
	public static final String[] AUTHORS = new String[] {"LegendGamer"};
	
	public static CreativeTabs tabMain = new MainTab("tabMain");
	public static CreativeTabs tabItems = new ItemsTab("tabItems");
	
	public static CreativeTabs tabSymbols = new SymbolTab("tabSymbols");
	@Mod.Instance(SovietCore.MODID)
    public static SovietCore INSTANCE;
    @SidedProxy(clientSide = "ru.lg.SovietMod.Proxy.ClientProxy", serverSide = "ru.lg.SovietMod.Proxy.CommonProxy")
    public static CommonProxy proxy;
    
    private static Logger logger;
 

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    	 proxy.preInit(event); 	
    	 new RegSounds();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	   proxy.init(event);
    	   RegSounds.init();
    }



}
