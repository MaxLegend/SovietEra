package ru.lg.SovietMod.Entity.Model;

//Made with Blockbench
//Paste this code into your mod.

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class SovSignModel2 extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public SovSignModel2() {
		textureWidth = 28;
		textureHeight = 28;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -5.0F, 7.0F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -10.0F, 7.0F, 14, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -9.0F, 7.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -9.0F, 7.0F, 1, 4, 1, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -6.0F, -9.0F, 7.5F, 12, 4, 0, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -1.0F, -12.0F, -16.0F, 34, 12, 20, 0.0F, false));
	}
	public void renderSign()
    {
		bone.render(0.0625F);
		bone2.render(0.0625F);
		bone3.render(0.0625F);
    }

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}