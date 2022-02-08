package ru.lg.SovietMod.Event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.BuildingBlocks.RastyHandholdAngle;

public class DrawCollisionBoxGofroHandhold {

	@SubscribeEvent
	public void drawSelectionBoxHandholdAngle(DrawBlockHighlightEvent e)
	{

		if(e.getTarget().typeOfHit == RayTraceResult.Type.BLOCK)
		{
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.glLineWidth(2.0F);
			GlStateManager.disableTexture2D();
			GlStateManager.depthMask(false);
			IBlockState iblockstate = e.getPlayer().getEntityWorld().getBlockState(e.getTarget().getBlockPos());
			if(iblockstate.getBlock() == RegBlocks.gofro_handhold_angle || iblockstate.getBlock() == RegBlocks.street_fence_angle) {
				double d3 = e.getPlayer().lastTickPosX + (e.getPlayer().posX - e.getPlayer().lastTickPosX) * (double)e.getPartialTicks();
				double d4 = e.getPlayer().lastTickPosY + (e.getPlayer().posY - e.getPlayer().lastTickPosY) * (double)e.getPartialTicks();
				double d5 = e.getPlayer().lastTickPosZ + (e.getPlayer().posZ - e.getPlayer().lastTickPosZ) * (double)e.getPartialTicks();
				drawSelectionBoundingBox(iblockstate.getSelectedBoundingBox(e.getPlayer().getEntityWorld(), e.getTarget().getBlockPos()).grow(0.0020000000949949026D).offset(-d3, -d4, -d5), 0F, 0.0F, 0.0F, 0.4F, iblockstate.getValue(RastyHandholdAngle.FACING), iblockstate, e.getTarget().getBlockPos(),e.getPlayer().getEntityWorld());
				GlStateManager.depthMask(true);
				GlStateManager.enableTexture2D();
				GlStateManager.disableBlend();
			}
		}


	}

	public  void drawSelectionBoundingBox(AxisAlignedBB box, float red, float green, float blue, float alpha, EnumFacing facing, IBlockState state, BlockPos pos, World world)
	{
		drawBoundingBox(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, red, green, blue, alpha, facing,state,pos,world);
	}
	public  void drawBoundingBox(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, float red, float green, float blue, float alpha,EnumFacing facing, IBlockState state, BlockPos pos, World world)
	{
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
		drawBoundingBox(bufferbuilder, minX, minY, minZ, maxX, maxY, maxZ, red, green, blue, 0.4F, facing, state,pos,world);
		tessellator.draw();
	}
	public  void drawBoundingBox(BufferBuilder buffer, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, float red, float green, float blue, float alpha,EnumFacing facing, IBlockState state, BlockPos pos, World world)
	{
		if(facing == EnumFacing.SOUTH) {
			buffer.pos(minX , minY, minZ).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX , minY, minZ-0.9).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX +0.1, minY, minZ-0.9).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX +0.1, minY, minZ).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX +0.1, maxY, minZ).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX +0.1, maxY, minZ-0.9).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX +0.1, minY, minZ-0.9).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX, minY, minZ-0.9).color(red, green, blue, 0).endVertex();
			buffer.pos(minX, maxY, minZ-0.9).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX+0.1, maxY, minZ-0.9).color(red, green, blue, alpha).endVertex();
			buffer.pos(minX, maxY, minZ-0.9).color(red, green, blue, 0).endVertex();
			buffer.pos(minX, maxY, minZ).color(red, green, blue, alpha).endVertex();
		} else
			if(facing == EnumFacing.NORTH) {
				buffer.pos(maxX , minY, maxZ).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX , minY, maxZ+0.9).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX -0.1, minY, maxZ+0.9).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX -0.1, minY, maxZ).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX -0.1, maxY, maxZ).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX -0.1, maxY, maxZ+0.9).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX -0.1, minY, maxZ+0.9).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX, minY, maxZ+0.9).color(red, green, blue, 0).endVertex();
				buffer.pos(maxX, maxY, maxZ+0.9).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX-0.1, maxY, maxZ+0.9).color(red, green, blue, alpha).endVertex();
				buffer.pos(maxX, maxY, maxZ+0.9).color(red, green, blue, 0).endVertex();
				buffer.pos(maxX, maxY, maxZ).color(red, green, blue, alpha).endVertex();
			}else
				if(facing == EnumFacing.EAST) {
					buffer.pos(minX , minY, maxZ).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX -0.9 , minY, maxZ).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX -0.9 , maxY, maxZ).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX , maxY, maxZ).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX , maxY, maxZ-0.1).color(red, green, blue, 0).endVertex();
					buffer.pos(minX -0.9, maxY, maxZ-0.1).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX -0.9, maxY, maxZ).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX -0.9, minY, maxZ).color(red, green, blue, 0).endVertex();
					buffer.pos(minX -0.9, minY, maxZ-0.1).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX -0.9, maxY, maxZ-0.1).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX, minY, maxZ-0.1).color(red, green, blue, 0).endVertex();
					buffer.pos(minX, maxY, maxZ-0.1).color(red, green, blue, alpha).endVertex();
					buffer.pos(minX-0.9, minY, maxZ-0.1).color(red, green, blue, 0).endVertex();
					buffer.pos(minX, minY, maxZ-0.1).color(red, green, blue, alpha).endVertex();
				} else
					if(facing == EnumFacing.WEST) {
						buffer.pos(maxX , minY, minZ).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX +0.9 , minY, minZ).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX +0.9 , maxY, minZ).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX , maxY, minZ).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX , maxY, minZ+0.1).color(red, green, blue, 0).endVertex();
						buffer.pos(maxX +0.9, maxY, minZ+0.1).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX +0.9, maxY, minZ).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX +0.9, minY, minZ).color(red, green, blue, 0).endVertex();
						buffer.pos(maxX +0.9, minY, minZ+0.1).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX +0.9, maxY, minZ+0.1).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX, minY, minZ+0.1).color(red, green, blue, 0).endVertex();
						buffer.pos(maxX, maxY, minZ+0.1).color(red, green, blue, alpha).endVertex();
						buffer.pos(maxX+0.9, minY, minZ+0.1).color(red, green, blue, 0).endVertex();
						buffer.pos(maxX, minY, minZ+0.1).color(red, green, blue, alpha).endVertex();
					}
	}
}
