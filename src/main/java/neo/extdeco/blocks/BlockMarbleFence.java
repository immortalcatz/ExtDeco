package neo.extdeco.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import neo.extdeco.init.ExtDeco;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemLead;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMarbleFence extends BlockFence
{
	private static String fenceTexture;

    public BlockMarbleFence(String fenceTexture_, String name, Material material)
    {
        super(fenceTexture, material);
        this.fenceTexture = fenceTexture_;
        this.setCreativeTab(ExtDeco.tabExtDeco);
        this.setBlockName(ExtDeco.MODID + ":" + name);
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity)
    {
        boolean flag = this.canConnectFenceTo(world, x, y, z - 1);
        boolean flag1 = this.canConnectFenceTo(world, x, y, z + 1);
        boolean flag2 = this.canConnectFenceTo(world, x - 1, y, z);
        boolean flag3 = this.canConnectFenceTo(world, x + 1, y, z);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag || flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
        }

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
    {
        boolean flag = this.canConnectFenceTo(blockAccess, x, y, z - 1);
        boolean flag1 = this.canConnectFenceTo(blockAccess, x, y, z + 1);
        boolean flag2 = this.canConnectFenceTo(blockAccess, x - 1, y, z);
        boolean flag3 = this.canConnectFenceTo(blockAccess, x + 1, y, z);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_)
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 11;
    }

    
    public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		Block block = par1IBlockAccess.getBlock(par2, par3, par4);

		if (block == Blocks.fence || block == Blocks.nether_brick_fence || block == BlocksExtDeco.whiteMarbleFence
			    || block == Blocks.fence_gate) {
			return true;
		}
		return false;
    }
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon(ExtDeco.MODID + ":" + fenceTexture);
	}

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        return world.isRemote ? true : ItemLead.func_150909_a(player, world, x, y, z);
    }
}