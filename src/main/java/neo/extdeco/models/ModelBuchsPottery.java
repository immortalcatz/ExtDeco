package net.neocromicon.src.ExtDecoPottery;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelBuchsPottery extends ModelBase
{
  //fields
    ModelRenderer Shape0;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public ModelBuchsPottery()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape0 = new ModelRenderer(this, 0, 32);
      Shape0.addBox(0F, 0F, 0F, 14, 2, 14);
      Shape0.setRotationPoint(-7F, 8F, -7F);
      Shape0.setTextureSize(128, 64);
      Shape0.mirror = true;
      setRotation(Shape0, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 6, 16);
      Shape1.setRotationPoint(-8F, 10F, -8F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 22);
      Shape2.addBox(0F, 0F, 0F, 2, 8, 2);
      Shape2.setRotationPoint(-1F, 16F, -1F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 64, 0);
      Shape3.addBox(0F, 0F, 0F, 10, 7, 10);
      Shape3.setRotationPoint(-5F, 24F, -5F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, entity);
    Shape0.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f4, ent);
  }

  public void renderModel(float f1)
  {
	Shape0.render(f1);
    Shape1.render(f1);
    Shape2.render(f1);   
    Shape3.render(f1);   
  }
}
