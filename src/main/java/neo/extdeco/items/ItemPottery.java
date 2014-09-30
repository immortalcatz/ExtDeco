package neo.extdeco.items;

import cpw.mods.fml.common.registry.GameData;
import neo.extdeco.init.ExtDeco;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPottery extends Item {
	
	private boolean isEmptyPottery;
	/** The ID of the block the reed will spawn when used from inventory bar. */
    private Block potterySpawnID;
	
	/**
	 * 
	 * @param isEmptyPottery
	 * @param name
	 * @param itemColor
	 * @param pottery : Block Spawn
	 */
	public ItemPottery(boolean isEmptyPottery, String name, String itemColor, Block pottery) {
		super();
		
		String potteryName = name + itemColor;
		
		potterySpawnID = pottery;
		setUnlocalizedName(ExtDeco.MODID + ":" + potteryName);
        setTextureName(ExtDeco.MODID + ":" + potteryName);
        setCreativeTab(ExtDeco.tabExtDeco);
		this.isEmptyPottery = isEmptyPottery;
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        
		if (isEmptyPottery) {
			System.out.println("Is Empty Pottery: " + isEmptyPottery);
			return false;			
		} else {
			
			Block block = world.getBlock(x, y, z);

	        if (block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 7) < 1)
	        {
	            p_77648_7_ = 1;
	        }
	        else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush)
	        {
	            if (p_77648_7_ == 0)
	            {
	                --y;
	            }

	            if (p_77648_7_ == 1)
	            {
	                ++y;
	            }

	            if (p_77648_7_ == 2)
	            {
	                --z;
	            }

	            if (p_77648_7_ == 3)
	            {
	                ++z;
	            }

	            if (p_77648_7_ == 4)
	            {
	                --x;
	            }

	            if (p_77648_7_ == 5)
	            {
	                ++x;
	            }
	        }

	        if (!entityPlayer.canPlayerEdit(x, y, z, p_77648_7_, itemStack))
	        {
	            return false;
	        }
	        else if (itemStack.stackSize == 0)
	        {
	            return false;
	        }
	        else
	        {
	            if (world.canPlaceEntityOnSide(this.potterySpawnID, x, y, z, false, p_77648_7_, (Entity)null, itemStack))
	            {
	                int i1 = this.potterySpawnID.onBlockPlaced(world, x, y, z, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);

	                if (world.setBlock(x, y, z, this.potterySpawnID, i1, 3))
	                {
	                    if (world.getBlock(x, y, z) == this.potterySpawnID)
	                    {
	                        this.potterySpawnID.onBlockPlacedBy(world, x, y, z, entityPlayer, itemStack);
	                        this.potterySpawnID.onPostBlockPlaced(world, x, y, z, i1);
	                    }

	                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.potterySpawnID.stepSound.func_150496_b(), (this.potterySpawnID.stepSound.getVolume() + 1.0F) / 2.0F, this.potterySpawnID.stepSound.getPitch() * 0.8F);
	                    --itemStack.stackSize;
	                }
	            }

	            return true;
	        }
		}
		
    }
}
