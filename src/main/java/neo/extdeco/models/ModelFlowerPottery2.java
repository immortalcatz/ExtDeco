package neo.extdeco.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlowerPottery2 extends ModelBase {

	ModelRenderer Bottom;
	ModelRenderer Middle;
	ModelRenderer Plant1;
	ModelRenderer Plant2;
	ModelRenderer Plant3;
	ModelRenderer Plant4;
	ModelRenderer Plant5;
	ModelRenderer Plant6;

	public ModelFlowerPottery2() {
		textureWidth = 128;
		textureHeight = 64;

		Bottom = new ModelRenderer(this, 0, 0);
		Bottom.addBox(0F, 0F, 0F, 14, 2, 14);
		Bottom.setRotationPoint(-7F, 8F, -7F);
		Bottom.setTextureSize(128, 64);
		Bottom.mirror = true;
		setRotation(Bottom, 0F, 0F, 0F);
		Middle = new ModelRenderer(this, 0, 17);
		Middle.addBox(0F, 0F, 0F, 16, 6, 16);
		Middle.setRotationPoint(-8F, 10F, -8F);
		Middle.setTextureSize(128, 64);
		Middle.mirror = true;
		setRotation(Middle, 0F, 0F, 0F);
		Plant1 = new ModelRenderer(this, 69, 0);
		Plant1.addBox(0F, 0F, 0F, 12, 8, 0);
		Plant1.setRotationPoint(-1F, 24F, 7F);
		Plant1.setTextureSize(128, 64);
		Plant1.mirror = true;
		setRotation(Plant1, 3.141593F, 0.7853982F, 0F);
		Plant2 = new ModelRenderer(this, 101, 0);
		Plant2.addBox(0F, 0F, 0F, 12, 8, 0);
		Plant2.setRotationPoint(-5F, 24F, -7.1F);
		Plant2.setTextureSize(128, 64);
		Plant2.mirror = true;
		setRotation(Plant2, 3.166027F, -0.7853982F, 0F);
		Plant3 = new ModelRenderer(this, 101, 0);
		Plant3.addBox(0F, 0F, 0F, 12, 8, 0);
		Plant3.setRotationPoint(-1F, 24F, -1.6F);
		Plant3.setTextureSize(128, 64);
		Plant3.mirror = true;
		setRotation(Plant3, 3.141593F, -0.7853982F, 0F);
		Plant4 = new ModelRenderer(this, 69, 0);
		Plant4.addBox(0F, 0F, 0F, 12, 8, 0);
		Plant4.setRotationPoint(-5F, 24F, 1.5F);
		Plant4.setTextureSize(128, 64);
		Plant4.mirror = true;
		setRotation(Plant4, 3.166027F, 0.7853982F, 0F);
		Plant5 = new ModelRenderer(this, 101, 0);
		Plant5.addBox(0F, 0F, 0F, 12, 8, 0);
		Plant5.setRotationPoint(-8F, 24F, -0.9666666F);
		Plant5.setTextureSize(128, 64);
		Plant5.mirror = true;
		setRotation(Plant5, 3.141593F, -0.7853982F, 0F);
		Plant6 = new ModelRenderer(this, 69, 0);
		Plant6.addBox(0F, 0F, 0F, 12, 8, 0);
		Plant6.setRotationPoint(-8F, 24F, 7F);
		Plant6.setTextureSize(128, 64);
		Plant6.mirror = true;
		setRotation(Plant6, 3.141593F, 0.7853982F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Bottom.render(f5);
		Middle.render(f5);
		Plant1.render(f5);
		Plant2.render(f5);
		Plant3.render(f5);
		Plant4.render(f5);
		Plant5.render(f5);
		Plant6.render(f5);
	}

	public void renderModel(float f5) {
		Bottom.render(f5);
		Middle.render(f5);
		Plant1.render(f5);
		Plant2.render(f5);
		Plant3.render(f5);
		Plant4.render(f5);
		Plant5.render(f5);
		Plant6.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

}
