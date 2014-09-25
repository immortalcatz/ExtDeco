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

public class BlockMarbleBrick extends Block
{
    public static final String[] marbleNames = new String[] {"White", "Black", "Yellow", "Ice", "IceSmooth", "Snow"};
    @SideOnly(Side.CLIENT)
    private IIcon[] marbleTextures;
    private boolean field_149996_a;
    private static final String __OBFID = "CL_00000335";

    public BlockMarbleBrick()
    {
        super(Material.ground);
        this.setCreativeTab(ExtDeco.tabExtDeco);
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
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        Block block = blockAccess.getBlock(x, y, z);

        if (this == BlocksExtDeco.marbleBrick)
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
    	list.add(new ItemStack(item, 1, 3));
    	list.add(new ItemStack(item, 1, 4));
    	list.add(new ItemStack(item, 1, 5));
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