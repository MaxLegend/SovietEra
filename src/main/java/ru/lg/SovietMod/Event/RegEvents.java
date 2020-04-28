package ru.lg.SovietMod.Event;

import net.minecraftforge.common.MinecraftForge;
import ru.lg.SovietMod.RegRenderMetaBlocks;
import ru.lg.SovietMod.RegSounds;

public class RegEvents {

	public static class Client {
		public Client() {
			 register(new EventGetClickedSide());
			 register(new  RegistryEvents());
			 register(new RegRenderMetaBlocks());
			 register(new DrawCollisionBoxWires());
			 register(new DrawCollisionBoxAngle());
			 register(new DrawCollisionBoxGofroHandhold());
		}
	}

	public static class Server {
		public Server() {
		
			 register(new CheckMossEvent());
			 register(new HammerEvent());
		}
	}
	static void register(Object object) {
		MinecraftForge.EVENT_BUS.register(object);
	}
}

