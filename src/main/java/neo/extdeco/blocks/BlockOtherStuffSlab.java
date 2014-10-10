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

public class BlockOtherStuffSlab extends BlockSlab {
	public static final String[] otherStuffType = { "otherStuffBrickIce", "otherStuffIceSmooth"};
	
	@SideOnly(Side.CLIENT)
    private IIcon[] otherStuffTextures;
	protected IIcon blockIcon;
	private int metaNumber = 2;

	public BlockOtherStuffSlab(boolean isDouble, Material material) {
		super(isDouble, material);
		useNeighborBrightness = true;
		if (isDouble) {
			this.setHardness(2F);
			this.setResistance(1.5F);
			this.setCreativeTab(null);
		} else {
			this.setHardness(1F);
			this.setResistance(0.75F);
			this.setCreativeTab(ExtDeco.tabExtDeco);
		}
	}
	
	/**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
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
		for (int i = 0; i < metaNumber; i++) {
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