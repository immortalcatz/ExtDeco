package neo.extdeco.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import neo.extdeco.init.ExtDeco;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMarbleSlabs extends BlockSlab {

	private boolean isDoubleSlab;
	private int numSubBlocks;
	private Block singleSlab;
	private Block textureBlock;
	private int textureStartCounter;
	private boolean field_149996_a;

	/**
	 * Creates a new custom slab
	 * 
	 * @param _isDoubleSlab
	 *            determines if the slab represents the half block or the full
	 *            block
	 * @param material
	 *            is the material of the slabs
	 * @param _numSubBlocks
	 *            is the number of metadata sub blocks (can't be more than 8)
	 * @param _singleSlab
	 *            the block representing the half slab and also the block to
	 *            drop when harvesting a full slab block
	 * @param _textureBlock
	 *            the block from which to retrieve the texture
	 * @param _textureStartCounter
	 *            the starting index from which to retrieve a texture from a
	 *            metadata block
	 */
	public BlockMarbleSlabs(boolean _isDoubleSlab, Material material, int _numSubBlocks, Block _singleSlab, Block _textureBlock, int _textureStartCounter) {
		super(_isDoubleSlab, material);
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(Block.soundTypeStone);
		useNeighborBrightness = true;
		if (_isDoubleSlab)
			setCreativeTab(null); // Set the creative tab to null so that the
									// double slab blocks will not appear in the
									// creative tabs
		else
			setCreativeTab(ExtDeco.tabExtDeco); // Set your creative tab, for
												// example:
		isDoubleSlab = _isDoubleSlab;
		numSubBlocks = _numSubBlocks;
		singleSlab = _singleSlab;
		textureBlock = _textureBlock;
		textureStartCounter = _textureStartCounter;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < numSubBlocks; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return textureBlock.getIcon(side, (meta % 8) + textureStartCounter);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        Block block = blockAccess.getBlock(x, y, z);

        if (this == BlocksExtDeco.marbleBrickSlabDouble)
        {
            if (blockAccess.getBlockMetadata(x, y, z) != blockAccess.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }
        return !this.field_149996_a && block == this ? false : super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }
	
	@Override
	public boolean isOpaqueCube() {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
	
	@SideOnly(Side.CLIENT)
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public Item getItemDropped(int par1, Random rand, int par3) {
		return (isDoubleSlab ? Item.getItemFromBlock(singleSlab) : Item
				.getItemFromBlock(this));
	}

	@Override
	public int quantityDropped(Random rand) {
		return (isDoubleSlab ? 2 : 1);
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata % 8;
	}

	@Override
	protected ItemStack createStackedBlock(int meta) {
		return new ItemStack(singleSlab, 2, meta % 7);
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z) {
        return super.getDamageValue(world, x, y, z) & 7;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {	
		Block block = world.getBlock(x, y, z);
		
		if (block == BlocksExtDeco.marbleSlabSingle) {
			if (!isDoubleSlab)
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleSlabSingle); } 
			else 
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleSlabDouble); }
		}
		else if (block == BlocksExtDeco.marbleSlabDouble) {
			if (!isDoubleSlab)
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleSlabSingle); } 
			else 
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleSlabDouble); }		  
		}
		
		
		if (block == BlocksExtDeco.marbleBrickSlabSingle) {
			if (!isDoubleSlab)
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleBrickSlabSingle); } 
			else 
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleBrickSlabDouble); }
		}
		else if (block == BlocksExtDeco.marbleBrickSlabDouble) {
			if (!isDoubleSlab)
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleBrickSlabSingle); } 
			else 
			{ return Item.getItemFromBlock(BlocksExtDeco.marbleBrickSlabDouble); }		  
		}
		return Item.getItemFromBlock(BlocksExtDeco.marbleSlabDouble);		
    }

	@Override
	// In Forge 1.6.4 it was "getFullSlabName"
	public String func_150002_b(int par1) {
		if ((par1 < 0) || (par1 >= numSubBlocks)) {
			par1 = 0;
		}
		return super.getUnlocalizedName() + "." + (par1 + 1);
	}
}