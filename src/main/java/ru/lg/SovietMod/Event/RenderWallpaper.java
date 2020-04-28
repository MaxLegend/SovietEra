package ru.lg.SovietMod.Event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.SovietCore;

public class RenderWallpaper {

	Minecraft mc = Minecraft.getMinecraft();
	Block block;
	boolean isClicked;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void isClickRight(PlayerInteractEvent.RightClickBlock e) {
		isClicked = false;
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void isClickLeft(PlayerInteractEvent.LeftClickBlock e) {
		isClicked = true;
	}
	private static final String DATA_NAME = SovietCore.MODID + "_coordData";
	static boolean IS_GLOBAL;
	
//	@SubscribeEvent
	public void handleWorldLoad(WorldEvent.Load event) {
		MapStorage storage = IS_GLOBAL ? event.getWorld().getMapStorage() : event.getWorld().getPerWorldStorage();
		CoordSaveData data = (CoordSaveData) storage.getOrLoadData(CoordSaveData.class, DATA_NAME);
		event.getWorld().getMapStorage().getOrLoadData(CoordSaveData.class, DATA_NAME);
		
		if (data == null) {
			data = new CoordSaveData(DATA_NAME);
			event.getWorld().getMapStorage().setData(DATA_NAME, data);
		}
		event.getWorld().getMapStorage().setData(DATA_NAME, data);
	}


	public class CoordSaveData extends WorldSavedData
	{
	    public List<BlockPos> list = new ArrayList<>();

	    private final EntityPlayer player = mc.player;
	    private final World world = mc.world;
	    private final RayTraceResult raytraceresult = RenderWallpaper.rayTrace(world, player, true);
	    private final BlockPos blockpos = raytraceresult.getBlockPos();
	

	    public CoordSaveData(String name)
	    {
	        super(name);
	    }

	    @Override
	    public void readFromNBT(NBTTagCompound nbt)
	    {
	        list.clear();
	        final int size = nbt.getInteger("size");
	     
	        for (int i = 0; i < size; i++)
	        {
	            final int posX = nbt.getInteger("posX_" + i);
	            final int posY = nbt.getInteger("posY_" + i);
	            final int posZ = nbt.getInteger("posZ_" + i);
	            list.add(new BlockPos(posX, posY, posZ));
	        }
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	    {
	        nbt.setInteger("size", list.size());

	        for (int i = 0; i < list.size(); i++)
	        {
	            nbt.setInteger("posX_" + i, blockpos.getX());
	            nbt.setInteger("posY_" + i, blockpos.getY());
	            nbt.setInteger("posZ_" + i, blockpos.getZ());
	        }
	        return nbt;
	    }
	}

	@SideOnly(Side.CLIENT)
//	@SubscribeEvent
	public void render(RenderWorldLastEvent event) {
		EntityPlayer player = mc.player;

		World world = Minecraft.getMinecraft().world;
		RayTraceResult raytraceresult = this.rayTrace(world, player, false);

		BlockPos blockpos = raytraceresult.getBlockPos();
		EnumFacing facing = raytraceresult.sideHit;
		CoordSaveData data = (CoordSaveData)world.loadData(CoordSaveData.class, DATA_NAME); 

		if(!mc.isGamePaused()) {
			GlStateManager.enableBlend();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
			GlStateManager.doPolygonOffset(-3.0F, -3.0F);
			GlStateManager.enablePolygonOffset();
			GlStateManager.alphaFunc(516, 0.1F);
			GlStateManager.enableAlpha();
			GlStateManager.pushMatrix();

			block = mc.world.getBlockState(blockpos).getBlock();


			int x = blockpos.getX();
			int y = blockpos.getY();
			int z = blockpos.getZ();

			BlockPos pos = new BlockPos(x,y,z);

			
			if(blockpos == null || !blockpos.equals(blockpos.down())) {
			//	if(block == Blocks.DIRT)
				//	data.list.add(pos);
				//	drawBlockTexture(mc.player, 0.5f, data.coordX, data.coordY , data.coordZ, mc.world, "soviet:blocks/wallpaper_1");
				//data.blockpos.add(x,y,z);
			} 
			GlStateManager.disableAlpha();
			GlStateManager.doPolygonOffset(0F, 0.0F);
			GlStateManager.disablePolygonOffset();
			GlStateManager.enableAlpha();
			GlStateManager.depthMask(true);
			GlStateManager.popMatrix();
		}

	}

	public static void drawBlockTexture(Entity entityIn, float partialTicks, int x,int y,int z, World world, String texture) {
		BlockPos  pos = new BlockPos(x,y,z);
		double d3 = entityIn.lastTickPosX + (entityIn.posX - entityIn.lastTickPosX) * (double) partialTicks;
		double d4 = entityIn.lastTickPosY + (entityIn.posY - entityIn.lastTickPosY) * (double) partialTicks;
		double d5 = entityIn.lastTickPosZ + (entityIn.posZ - entityIn.lastTickPosZ) * (double) partialTicks;
		Tessellator tessellatorIn = Tessellator.getInstance();
		BufferBuilder bufferBuilderIn = tessellatorIn.getBuffer();
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		bufferBuilderIn.begin(7, DefaultVertexFormats.BLOCK);
		bufferBuilderIn.setTranslation(-d3, -d4, -d5);
		bufferBuilderIn.noColor();
		IBlockState state = world.getBlockState(new BlockPos(x,y,z));
		TextureMap texturemap = Minecraft.getMinecraft().getTextureMapBlocks();
		BlockModelRenderer blockModelRenderer = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelRenderer();
		BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
		BlockModelShapes bms = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes();
		IBakedModel ibakedmodel = bms.getModelForState(state);
		List<BakedQuad> ql = ibakedmodel.getQuads(state, EnumFacing.getFacingFromVector(x, y, z), (long)1);;
		blockModelRenderer.renderModel(world, ibakedmodel, state, pos, Tessellator.getInstance().getBuffer(), true);
		tessellatorIn.draw();
		bufferBuilderIn.setTranslation(0D, 0.0D, 0D);

	}

	public static RayTraceResult rayTrace(World worldIn, EntityPlayer playerIn, boolean useLiquids)
	{
		float f = playerIn.rotationPitch;
		float f1 = playerIn.rotationYaw;
		double d0 = playerIn.posX;
		double d1 = playerIn.posY + (double)playerIn.getEyeHeight();
		double d2 = playerIn.posZ;
		Vec3d vec3d = new Vec3d(d0, d1, d2);
		float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
		float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
		float f4 = -MathHelper.cos(-f * 0.017453292F);
		float f5 = MathHelper.sin(-f * 0.017453292F);
		float f6 = f3 * f4;
		float f7 = f2 * f4;
		double d3 = playerIn.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();
		Vec3d vec3d1 = vec3d.addVector((double)f6 * d3, (double)f5 * d3, (double)f7 * d3);
		return worldIn.rayTraceBlocks(vec3d, vec3d1, useLiquids, !useLiquids, false);
	}

}
