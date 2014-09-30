package neo.extdeco.tileentitys;

import neo.extdeco.blocks.BlocksExtDeco;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityPottery extends TileEntity {
	
	public String potteryTextureAndName;
	
    public TileEntityPottery(World var1, String potteryTextureAndName) {    	
    	this.potteryTextureAndName = potteryTextureAndName;
    }
}