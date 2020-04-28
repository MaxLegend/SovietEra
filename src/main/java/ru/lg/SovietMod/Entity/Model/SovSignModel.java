package ru.lg.SovietMod.Entity.Model;

//Made with Blockbench
//Paste this code into your mod.

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class SovSignModel extends ModelBase {
	public final ModelRenderer bone;
	public final ModelRenderer bone2;

	public SovSignModel() {
		textureWidth = 28;
		textureHeight = 28;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -25.0F, 0.0F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -30.0F, 0.0F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -29.0F, 0.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -29.0F, 0.0F, 1, 4, 1, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -6.0F, -29.0F, 0.5F, 12, 4, 0, 0.0F, false));
	}

	public void renderS() {
		bone.render(0.0625F);
		bone2.render(0.0625F);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}