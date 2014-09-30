package net.neocromicon.src.ExtDecoPottery;

import java.util.Random;

import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.neocromicon.src.ExtDecoBase.ExtDecoMod;
import net.neocromicon.src.ExtDecoBase.PacketHandler;

public class BlockBlackPottery extends BlockContainer
{
	public Block block;
    public BlockBlackPottery(int i)
    {
        super(i, Material.rock);
        this.setCreativeTab(null);
    }           
    
    public int idDropped(int par1, Random par2Random, int par3)
    {   	
    		return ExtDecoMod.EmptyBlackPotteryItem.shiftedIndex;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }   
        
        public int getRenderType()
    {
        return -1;
    }
        
	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k) {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
		return super.getCollisionBoundingBoxFromPool(world, i, j, k);
	}
    
	public int distance(int var1)
    {
        return var1 <= 2 ? var1 : var1 - 3;
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

	@Override
	public TileEntityPottery createNewTileEntity(World var1) {
	    {
	       return new TileEntityPottery(var1);
	    }  
	}  
}