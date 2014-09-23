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
import net.minecraft.util.IIcon;

public class BlockMarble extends Block
{
    public static final String[] marbleNames = new String[] {"White", "Black", "Yellow"};
    @SideOnly(Side.CLIENT)
    private IIcon[] marbleTextures;
    private static final String __OBFID = "CL_00000335";

    public BlockMarble()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 0 || meta >= this.marbleTextures.length)
        {
        	meta = 0;
        }

        return this.marbleTextures[meta];
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int meta)
    {
        return meta;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    	list.add(new ItemStack(item, 1, 2));
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