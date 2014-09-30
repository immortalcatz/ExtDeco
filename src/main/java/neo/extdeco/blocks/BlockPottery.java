package neo.extdeco.blocks;

import java.util.Random;

import cpw.mods.fml.common.FMLLog;
import neo.extdeco.init.ExtDeco;
import neo.extdeco.items.ItemsExtDeco;
import neo.extdeco.tileentitys.TileEntityPottery;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPottery extends BlockContainer {
	
	public static String potteryTextureAndName;
	private String getPotteryColor;
	
	/**
	 * @param potteryTextureAndName
	 */
    public BlockPottery(String potteryTextureAndName, String getPotteryColor) {   	
        super(Material.rock);
        this.potteryTextureAndName = potteryTextureAndName;
        this.getPotteryColor = getPotteryColor;
        this.setBlockTextureName(ExtDeco.MODID + ":" + this.getPotteryColor+"Pottery");
        this.setCreativeTab(null);
    }           
    
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
		if (getPotteryColor == "white") {
			return ItemsExtDeco.emptyPotteryWhite;
		} else if (getPotteryColor == "black") {
			return ItemsExtDeco.emptyPotteryBlack;
		} else {
			FMLLog.info("[Ext Deco] Unknown Pottery color");
		}
		return Items.stick;
	}

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }   

    public int getRenderType() {
        return -1;
    }
    
	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k) {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
		return super.getCollisionBoundingBoxFromPool(world, i, j, k);
	}

	public TileEntityPottery createNewTileEntity(World world, int p_149915_2_) {
		return new TileEntityPottery(world, this.potteryTextureAndName);
	}
	
	/*public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
		
		
		if (this.blockID == ExtDecoMod.CactusPotteryWhiteBlock.blockID)
		{
			PacketDispatcher.sendPacketToServer(PacketHandler.getPortPacket(1));
		}	
		if (this.blockID == ExtDecoMod.CactusPotteryBlackBlock.blockID)
		{			
			PacketDispatcher.sendPacketToServer(PacketHandler.getPortPacket(1));			
		}
		
    }*/ 
}