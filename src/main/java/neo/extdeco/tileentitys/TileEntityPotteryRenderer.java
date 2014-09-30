package net.neocromicon.src.ExtDecoPottery;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.neocromicon.src.ExtDecoBase.ExtDecoMod;

import org.lwjgl.opengl.GL11;

public class TileEntityPotteryRenderer extends TileEntitySpecialRenderer
{
	private ModelFlowerPottery aModelFlowers;
	private ModelBuchsPottery aModelBuchs;
	private ModelCactusPottery aModelCactus;
	
    public TileEntityPotteryRenderer()
    {
    	aModelFlowers = new ModelFlowerPottery();
    	aModelBuchs = new ModelBuchsPottery();
    	aModelCactus = new ModelCactusPottery();
    }

    public void renderAModelAt(TileEntityPottery tileentity1, double d, double d1, double d2, float f)
    {   
    	GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 - 0.5F, (float)d2 + 0.5F);
        
        //Rose
        if (tileentity1.getBlockType() == ExtDecoMod.RosePotteryWhiteBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/rosepotterywhite.png");
         GL11.glPushMatrix();
         //GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
         //GL11.glScalef(1.0F, -1F, -1F); //if you read this comment out this line and you can see what happens
         aModelFlowers.renderModel(0.0625f);
         }
        if (tileentity1.getBlockType() == ExtDecoMod.RosePotteryBlackBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/rosepotteryblack.png");
         GL11.glPushMatrix();
         aModelFlowers.renderModel(0.0625f);}
        
        //Flower
        if (tileentity1.getBlockType() == ExtDecoMod.FlowerPotteryWhiteBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/flowerpotterywhite.png");
         GL11.glPushMatrix();
         aModelFlowers.renderModel(0.0625f);}
        if (tileentity1.getBlockType() == ExtDecoMod.FlowerPotteryBlackBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/flowerpotteryblack.png");
         GL11.glPushMatrix();
         aModelFlowers.renderModel(0.0625f);} 
        
        //Buchs
        if (tileentity1.getBlockType() == ExtDecoMod.BuchsPotteryWhiteBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/buchspotterywhite.png");
         GL11.glPushMatrix();
         aModelBuchs.renderModel(0.0625f);}
        if (tileentity1.getBlockType() == ExtDecoMod.BuchsPotteryBlackBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/buchspotteryblack.png");
         GL11.glPushMatrix();
         aModelBuchs.renderModel(0.0625f);}
        
        //Cactus
        if (tileentity1.getBlockType() == ExtDecoMod.CactusPotteryWhiteBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/cactuspotterywhite.png");
         GL11.glPushMatrix();
         aModelCactus.renderModel(0.0625f);}
        if (tileentity1.getBlockType() == ExtDecoMod.CactusPotteryBlackBlock)
        {this.bindTextureByName("/ExtDecoMod/Potteries/cactuspotteryblack.png");
         GL11.glPushMatrix();
         aModelCactus.renderModel(0.0625f);}
        
        
        GL11.glPopMatrix();     
        GL11.glPopMatrix();
        }

        

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2,float f)
    {
        this.renderAModelAt((TileEntityPottery)tileentity, d, d1, d2, f);
    }	
}
