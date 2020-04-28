package gloomyfolken.hooklib.example;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.server.SPacketSignEditorOpen;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;

public class AnnotationHooks {
	
//	@Hook(returnCondition=ReturnCondition.ALWAYS) 
	public static void handleSignEditorOpen(NetHandlerPlayClient clas,SPacketSignEditorOpen packetIn)
    {
		Minecraft mc = Minecraft.getMinecraft();
		World world = Minecraft.getMinecraft().world;
        PacketThreadUtil.checkThreadAndEnqueue(packetIn, clas, mc);
        TileEntity tileentity = world.getTileEntity(packetIn.getSignPosition());

        if (!(tileentity instanceof TileEntitySign))
        {
            tileentity = new TileEntitySign();
            tileentity.setWorld(world);
            tileentity.setPos(packetIn.getSignPosition());
        }

        mc.player.openEditSign((TileEntitySign)tileentity);
    }
}

//	@Hook(returnCondition=ReturnCondition.ALWAYS,injectOnExit=true) 
//	public static void renderBlockLayer(RenderGlobal rg,BlockRenderLayer blockLayerIn)
//  {
//		   rg.mc.mcProfiler.endStartSection("culling");
//		Entity viewEntity = Minecraft.getMinecraft().getRenderViewEntity();
//        double d3 = viewEntity.lastTickPosX + (viewEntity.posX - viewEntity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks();
//        double d4 = viewEntity.lastTickPosY + (viewEntity.posY - viewEntity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks();
//        double d5 = viewEntity.lastTickPosZ + (viewEntity.posZ - viewEntity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks();
//		  BlockPos blockpos1 = new BlockPos(d3, d4 + (double)Minecraft.getMinecraft().getRenderViewEntity().getEyeHeight(), d5);
//	        RenderChunk renderchunk = rg.viewFrustum.getRenderChunk(blockpos1); 
//	        BlockPos blockpos = new BlockPos(MathHelper.floor(d3 / 16.0D) * 16, MathHelper.floor(d4 / 16.0D) * 16, MathHelper.floor(d5 / 16.0D) * 16);
//	        rg.displayListEntitiesDirty = rg.displayListEntitiesDirty || !rg.chunksToUpdate.isEmpty() || viewEntity.posX != rg.lastViewEntityX || viewEntity.posY != rg.lastViewEntityY || viewEntity.posZ != rg.lastViewEntityZ || (double)viewEntity.rotationPitch != rg.lastViewEntityPitch || (double)viewEntity.rotationYaw != rg.lastViewEntityYaw;
//	        rg.lastViewEntityX = Minecraft.getMinecraft().getRenderViewEntity().posX;
//	        rg.lastViewEntityY = Minecraft.getMinecraft().getRenderViewEntity().posY;
//	        rg.lastViewEntityZ = Minecraft.getMinecraft().getRenderViewEntity().posZ;
//	        rg.lastViewEntityPitch = (double)Minecraft.getMinecraft().getRenderViewEntity().rotationPitch;
//	        rg.lastViewEntityYaw = (double)Minecraft.getMinecraft().getRenderViewEntity().rotationYaw;
//	        boolean flag = rg.debugFixedClippingHelper != null;
//	        rg.mc.mcProfiler.endSection();
//}
//	
//}
//	@Hook(returnCondition=ReturnCondition.ALWAYS) 
//    public static int renderBlockLayer(RenderGlobal rg,BlockRenderLayer blockLayerIn, double partialTicks, int pass, Entity entityIn)
//    {
//		List renderInfos = rg.renderInfos;
//        RenderHelper.disableStandardItemLighting();
//
//        if (blockLayerIn == BlockRenderLayer.TRANSLUCENT)
//        {
//        	rg.mc.mcProfiler.startSection("translucent_sort");
//            double d0 = entityIn.posX - rg.prevRenderSortX;
//            double d1 = entityIn.posY - rg.prevRenderSortY;
//            double d2 = entityIn.posZ - rg.prevRenderSortZ;
//
//            if (d0 * d0 + d1 * d1 + d2 * d2 > 1.0D)
//            {
//                rg.prevRenderSortX = entityIn.posX;
//                rg.prevRenderSortY = entityIn.posY;
//                rg.prevRenderSortZ = entityIn.posZ;
//                int k = 0;
//
//                for (ContainerLocalRenderInformation cr : renderInfos)
//                {
//                    if (cr.renderChunk.compiledChunk.isLayerStarted(blockLayerIn) && k++ < 15)
//                    {
//                    	rg.renderDispatcher.updateTransparencyLater(cr.renderChunk);
//                    }
//                }
//            }
//
//            Minecraft.getMinecraft().mcProfiler.endSection();
//        }
//
//        Minecraft.getMinecraft().mcProfiler.startSection("filterempty");
//        int l = 0;
//        boolean flag = blockLayerIn == BlockRenderLayer.TRANSLUCENT;
//        int i1 = flag ? rg.renderInfos.size() - 1 : 0;
//        int i = flag ? -1 : rg.renderInfos.size();
//        int j1 = flag ? -1 : 1;
//
//        for (int j = i1; j != i; j += j1)
//        {
//            RenderChunk renderchunk = (rg.renderInfos.get(j)).renderChunk;
//
//            if (!renderchunk.getCompiledChunk().isLayerEmpty(blockLayerIn))
//            {
//                ++l;
//                rg.renderContainer.addRenderChunk(renderchunk, blockLayerIn);
//            }
//        }
//
//        Minecraft.getMinecraft().mcProfiler.func_194339_b(() ->
//        {
//            return "render_" + blockLayerIn;
//        });
//        renderBlockLayer(rg, blockLayerIn);
//        Minecraft.getMinecraft().mcProfiler.endSection();
//        return l;
//    }
//	
//	   @SideOnly(Side.CLIENT)
//	    class ContainerLocalRenderInformation
//	    {
//	        final RenderChunk renderChunk;
//	        final EnumFacing facing;
//	        byte setFacing;
//	        final int counter;
//
//	        private ContainerLocalRenderInformation(RenderChunk renderChunkIn, EnumFacing facingIn, @Nullable int counterIn)
//	        {
//	            this.renderChunk = renderChunkIn;
//	            this.facing = facingIn;
//	            this.counter = counterIn;
//	        }
//
//	        public void setDirection(byte p_189561_1_, EnumFacing p_189561_2_)
//	        {
//	        	this.setFacing = (byte)(this.setFacing | p_189561_1_ | 1 << p_189561_2_.ordinal());
//	        }
//
//	        public boolean hasDirection(EnumFacing p_189560_1_)
//	        {
//	            return (this.setFacing & 1 << p_189560_1_.ordinal()) > 0;
//	        }
//	    }
//	    public static void renderBlockLayer(RenderGlobal rg, BlockRenderLayer blockLayerIn)
//	    {
//	        Minecraft.getMinecraft().entityRenderer.enableLightmap();
//
//	        if (OpenGlHelper.useVbo())
//	        {
//	            GlStateManager.glEnableClientState(32884);
//	            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
//	            GlStateManager.glEnableClientState(32888);
//	            OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
//	            GlStateManager.glEnableClientState(32888);
//	            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
//	            GlStateManager.glEnableClientState(32886);
//	        }
//
//	        rg.renderContainer.renderChunkLayer(blockLayerIn);
//
//	        if (OpenGlHelper.useVbo())
//	        {
//	            for (VertexFormatElement vertexformatelement : DefaultVertexFormats.BLOCK.getElements())
//	            {
//	                VertexFormatElement.EnumUsage vertexformatelement$enumusage = vertexformatelement.getUsage();
//	                int k1 = vertexformatelement.getIndex();
//
//	                switch (vertexformatelement$enumusage)
//	                {
//	                    case POSITION:
//	                        GlStateManager.glDisableClientState(32884);
//	                        break;
//	                    case UV:
//	                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + k1);
//	                        GlStateManager.glDisableClientState(32888);
//	                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
//	                        break;
//	                    case COLOR:
//	                        GlStateManager.glDisableClientState(32886);
//	                        GlStateManager.resetColor();
//	                }
//	            }
//	        }
//
//	        Minecraft.getMinecraft().entityRenderer.disableLightmap();
//	    }
