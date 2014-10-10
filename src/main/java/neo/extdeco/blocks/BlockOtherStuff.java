package neo.extdeco.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import neo.extdeco.init.ExtDeco;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOtherStuff extends Block {
	
    public static final String[] marbleNames = new String[] {"BrickIce", "IceSmooth"};
    
    @SideOnly(Side.CLIENT)
    private IIcon[] marbleTextures;
    private int metaNumber = 2;
    private static final String __OBFID = "CL_00000335";

    public BlockOtherStuff() {
        super(Material.rock);
        this.setCreativeTab(ExtDeco.tabExtDeco);
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

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta >= this.marbleTextures.length) {
        	meta = 0;
        }

        return this.marbleTextures[meta];
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int meta) {
        return meta;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < metaNumber; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.marbleTextures = new IIcon[marbleNames.length];

        for (int i = 0; i < this.marbleTextures.length; ++i)
        {
            this.marbleTextures[i] = iconRegister.registerIcon(this.getTextureName() + marbleNames[i]);
        }
    }
}