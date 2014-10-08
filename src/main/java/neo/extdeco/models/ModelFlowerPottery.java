package neo.extdeco.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlowerPottery extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape3;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
  
  public ModelFlowerPottery()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 14, 2, 14);
      Shape1.setRotationPoint(-7F, 8F, -7F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 17);
      Shape2.addBox(0F, 0F, 0F, 16, 6, 16);
      Shape2.setRotationPoint(-8F, 10F, -8F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 69, 0);
      Shape4.addBox(0F, 0F, 0F, 12, 8, 0);
      Shape4.setRotationPoint(-1F, 24F, 7F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 3.141593F, 0.7853982F, 0F);
      Shape5 = new ModelRenderer(this, 101, 0);
      Shape5.addBox(0F, 0F, 0F, 12, 8, 0);
      Shape5.setRotationPoint(-5F, 24F, -7.1F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 3.166027F, -0.7853982F, 0F);
      Shape6 = new ModelRenderer(this, 101, 0);
      Shape6.addBox(0F, 0F, 0F, 12, 8, 0);
      Shape6.setRotationPoint(-1F, 24F, -0.9666666F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 3.141593F, -0.7853982F, 0F);
      Shape7 = new ModelRenderer(this, 69, 0);
      Shape7.addBox(0F, 0F, 0F, 12, 8, 0);
      Shape7.setRotationPoint(-5F, 24F, 0.8666667F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 3.166027F, 0.7853982F, 0F);
      Shape3 = new ModelRenderer(this, 101, 0);
      Shape3.addBox(0F, 0F, 0F, 12, 8, 0);
      Shape3.setRotationPoint(-8F, 24F, -0.9666666F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 3.141593F, -0.7853982F, 0F);
      Shape8 = new ModelRenderer(this, 69, 0);
      Shape8.addBox(0F, 0F, 0F, 12, 8, 0);
      Shape8.setRotationPoint(-8F, 24F, 7F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 3.141593F, 0.7853982F, 0F);
      Shape9 = new ModelRenderer(this, 101, 0);
      Shape9.addBox(0F, 0F, 0F, 12, 8, 0);
      Shape9.setRotationPoint(-8F, 11F, -0.9666666F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, -0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape3.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
  }
  
  public void renderModel(float f5) {
	Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);   
    Shape4.render(f5);   
    Shape5.render(f5);   
    Shape6.render(f5);   
    Shape7.render(f5);   
    Shape8.render(f5);   
    Shape9.render(f5);   
    
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f4, null);
  }

}