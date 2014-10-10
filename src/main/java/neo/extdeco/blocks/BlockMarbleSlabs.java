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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMarbleSlabs extends BlockSlab {
	
	public static final String[] marbleType = { "marbleWhite", "marbleBlack", "marbleYellow", "marbleBrickWhite", "marbleBrickBlack", "marbleBrickYellow", "marbleBrickSnow"};
	
	@SideOnly(Side.CLIENT)
    private IIcon[] marbleTextures;
	protected IIcon blockIcon;
	private int metaNumber = 7;

	public BlockMarbleSlabs(boolean isDouble, Material material) {
		super(isDouble, material);
		useNeighborBrightness = true;
		if (isDouble) {
			this.setHardness(2.5F);
			this.setResistance(3.5F);
			this.setCreativeTab(null);
		} else {
			this.setHardness(1.25F);
			this.setResistance(1.75F);
			this.setCreativeTab(ExtDeco.tabExtDeco);
		}
	}

	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.marbleTextures = new IIcon[marbleType.length];

        for (int i = 0; i < this.marbleTextures.length; ++i) {
            this.marbleTextures[i] = iconRegister.registerIcon(getName(i));
        }
    }

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int meta) {
		return this.marbleTextures[meta];
	}

	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
		return Item.getItemFromBlock(BlocksExtDeco.marbleSlabSingle);
	}

	public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
        return this.field_150004_a ? p_149660_9_ : (p_149660_5_ != 0 && (p_149660_5_ == 1 || (double)p_149660_7_ <= 0.5D) ? p_149660_9_ : p_149660_9_ | 8);
    }

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving) {
		if (par1World.getBlock(par2, par3 - 1, par4) == BlocksExtDeco.marbleSlabSingle) {
			par1World.setBlock(par2, par3 - 1, par4,
					BlocksExtDeco.marbleSlabDouble);
		}
		if (par1World.getBlock(par2, par3 + 1, par4) == BlocksExtDeco.marbleSlabSingle) {
			par1World.setBlock(par2, par3 + 1, par4,
					BlocksExtDeco.marbleSlabDouble);
		}
	}

	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(BlocksExtDeco.marbleSlabSingle, 2, par1 & 7);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < metaNumber; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	public String getFullSlabName(int par1) {
		if ((par1 < 0) || (par1 >= marbleType.length)) {
			par1 = 0;
		}

		return ExtDeco.MODID + ":" + marbleType[par1];
	}

	@Override
	public String func_150002_b(int par1) {
		return getFullSlabName(par1);
	}
	
	private String getName(int par1) {
	    return func_150002_b(par1);
	}
}