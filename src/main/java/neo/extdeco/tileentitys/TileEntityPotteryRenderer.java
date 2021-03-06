package neo.extdeco.tileentitys;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.init.ExtDeco;
import neo.extdeco.models.ModelBuchsPottery;
import neo.extdeco.models.ModelCactusPottery;
import neo.extdeco.models.ModelFlowerPottery;
import neo.extdeco.models.ModelFlowerPottery2;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TileEntityPotteryRenderer extends TileEntitySpecialRenderer {
	

	private ModelFlowerPottery redYellowModel;
	private ModelFlowerPottery2 orangeModel;
	private ModelCactusPottery aCactusModel;
	private ModelBuchsPottery aBuchsModel;
	
	private int ID;
	
	public TileEntityPotteryRenderer() {
		
		redYellowModel = new ModelFlowerPottery();
		orangeModel = new ModelFlowerPottery2();
		aCactusModel = new ModelCactusPottery();
		aBuchsModel = new ModelBuchsPottery();
	}

	public void renderAPotteryAt(TileEntityPottery tileEntityPottery, double d, double d1, double d2, float f) {
		GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1 - 0.5F, (float)d2 + 0.5F);
        
        /** Flower Models */		
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.yellowFlowerPotteryWhite) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/yellowFlowerPotteryWhite.png"));
            GL11.glPushMatrix();
            redYellowModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.yellowFlowerPotteryBlack) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/yellowFlowerPotteryBlack.png"));
            GL11.glPushMatrix();
            redYellowModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.orangeFlowerPotteryWhite) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/orangeFlowerPotteryWhite.png"));
            GL11.glPushMatrix();
            orangeModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.orangeFlowerPotteryBlack) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/orangeFlowerPotteryBlack.png"));
            GL11.glPushMatrix();
            orangeModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.redFlowerPotteryWhite) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/redFlowerPotteryWhite.png"));
            GL11.glPushMatrix();
            redYellowModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.redFlowerPotteryBlack) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/redFlowerPotteryBlack.png"));
            GL11.glPushMatrix();
            redYellowModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.whiteFlowerPotteryWhite) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/whiteFlowerPotteryWhite.png"));
            GL11.glPushMatrix();
            orangeModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.whiteFlowerPotteryBlack) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/whiteFlowerPotteryBlack.png"));
            GL11.glPushMatrix();
            orangeModel.renderModel(0.0625f);
        }
		
		/**Cactus Models */
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.cactusPotteryWhite) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/cactusPotteryWhite.png"));
            GL11.glPushMatrix();
            aCactusModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.cactusPotteryBlack) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/cactusPotteryBlack.png"));
            GL11.glPushMatrix();
            aCactusModel.renderModel(0.0625f);
        }
		
		/** Buchs Models */
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.buchsPotteryWhite) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/buchsPotteryWhite.png"));
            GL11.glPushMatrix();
            aBuchsModel.renderModel(0.0625f);
        }
		if (tileEntityPottery.getBlockType() == BlocksExtDeco.buchsPotteryBlack) {
			this.bindTexture(new ResourceLocation(ExtDeco.MODID + ":" + "textures/models/buchsPotteryBlack.png"));
            GL11.glPushMatrix();
            aBuchsModel.renderModel(0.0625f);
        }
		
		GL11.glPopMatrix();     
        GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		this.renderAPotteryAt((TileEntityPottery) tileentity, d, d1, d2, f);
	}
}
