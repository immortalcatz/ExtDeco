package neo.extdeco.blocks;

import java.util.List;
import java.util.Random;

import neo.extdeco.init.ExtDeco;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOtherStuff extends BlockSlab {
	public static final String[] otherStuffType = { "otherStuffBrickIce", "otherStuffIceSmooth", "otherStuffBrickSnow"};
	@SideOnly(Side.CLIENT)
    private IIcon[] otherStuffTextures;
	protected IIcon blockIcon;
	private boolean field_149996_a;

	public BlockOtherStuff(boolean isDouble, Material material) {
		super(isDouble, material);
		this.field_149996_a = true;
		useNeighborBrightness = true;
		if (isDouble) {
			this.setCreativeTab(null);
		} else {
			this.setCreativeTab(ExtDeco.tabExtDeco);
		}
	}

	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
        Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);

        if (this == BlocksExtDeco.otherStuffSlabSingle || this == BlocksExtDeco.otherStuffSlabDouble) {
            if (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.getBlockMetadata(p_149646_2_ - Facing.offsetsXForSide[p_149646_5_], p_149646_3_ - Facing.offsetsYForSide[p_149646_5_], p_149646_4_ - Facing.offsetsZForSide[p_149646_5_])) {
                return true;
            }

            if (block == this) {
                return false;
            }
        }

        return !this.field_149996_a && block == this ? false : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.otherStuffTextures = new IIcon[otherStuffType.length];

        for (int i = 0; i < this.otherStuffTextures.length; ++i) {
            this.otherStuffTextures[i] = iconRegister.registerIcon(getName(i));
        }
    }

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int meta) {
		return this.otherStuffTextures[meta];
	}

	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
		return Item.getItemFromBlock(BlocksExtDeco.otherStuffSlabSingle);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving) {
		if (par1World.getBlock(par2, par3 - 1, par4) == BlocksExtDeco.otherStuffSlabSingle) {
			par1World.setBlock(par2, par3 - 1, par4,
					BlocksExtDeco.otherStuffSlabDouble);
		}
		if (par1World.getBlock(par2, par3 + 1, par4) == BlocksExtDeco.otherStuffSlabSingle) {
			par1World.setBlock(par2, par3 + 1, par4,
					BlocksExtDeco.otherStuffSlabDouble);
		}
	}
	
	/**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(BlocksExtDeco.otherStuffSlabSingle, 2, par1 & 7);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < 3; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	public String getFullSlabName(int par1) {
		if ((par1 < 0) || (par1 >= otherStuffType.length)) {
			par1 = 0;
		}

		return ExtDeco.MODID + ":" + otherStuffType[par1];
	}

	@Override
	public String func_150002_b(int par1) {
		return getFullSlabName(par1);
	}
	
	private String getName(int par1) {
	    return func_150002_b(par1);
	}
}