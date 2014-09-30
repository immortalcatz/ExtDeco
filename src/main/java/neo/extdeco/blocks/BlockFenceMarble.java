package net.neocromicon.src.ExtDecoStuff;

import neo.extdeco.init.ExtDeco;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.neocromicon.src.ExtDecoBase.ExtDecoMod;

public class BlockMarbleFence extends BlockFence
{
	
	public BlockMarbleFence(String fenceTexture_, String name, Material material)
    {
        super(fenceTexture, material);
        this.fenceTexture = fenceTexture_;
        this.setCreativeTab(ExtDeco.tabExtDeco);
        this.setBlockName(ExtDeco.MODID + ":" + name);
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return super.canPlaceBlockAt(world, i, j, k);
    }

    public int getRenderBlockPass()
    {
        return 1;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        boolean flag = canConnectFenceTo(par1World, par2, par3, par4 - 1);
        boolean flag1 = canConnectFenceTo(par1World, par2, par3, par4 + 1);
        boolean flag2 = canConnectFenceTo(par1World, par2 - 1, par3, par4);
        boolean flag3 = canConnectFenceTo(par1World, par2 + 1, par3, par4);
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

        return AxisAlignedBB.getBoundingBox((float)par2 + f, par3, (float)par4 + f2, (float)par2 + f1, (float)par3 + 1.5F, (float)par4 + f3);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        boolean flag = canConnectFenceTo(par1IBlockAccess, par2, par3, par4 - 1);
        boolean flag1 = canConnectFenceTo(par1IBlockAccess, par2, par3, par4 + 1);
        boolean flag2 = canConnectFenceTo(par1IBlockAccess, par2 - 1, par3, par4);
        boolean flag3 = canConnectFenceTo(par1IBlockAccess, par2 + 1, par3, par4);
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

        setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

	public int getRenderType() {
		return 11;
	}

	public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4) {
		int i = par1IBlockAccess.getBlockId(par2, par3, par4);

		if (i == blockID || i == Block.fence.blockID
				|| i == ExtDecoMod.MarbleFenceBlack.blockID
				|| i == ExtDecoMod.MarbleFenceWhite.blockID
				|| i == ExtDecoMod.MarbleFenceYellow.blockID
				|| i == ExtDecoMod.SnowFence.blockID
				|| i == ExtDecoMod.IceFence.blockID
				|| i == ExtDecoMod.MarbleBrickFenceWhite.blockID
				|| i == ExtDecoMod.MarbleBrickFenceBlack.blockID
				|| i == ExtDecoMod.MarbleBrickFenceYellow.blockID
				|| i == ExtDecoMod.SnowBrickFence.blockID
				|| i == ExtDecoMod.IceBrickFence.blockID
			    || i == Block.fenceGate.blockID) {
			return true;
		}

		Block block = Block.blocksList[i];

		if (block != null && block.blockMaterial.isOpaque()
				&& block.renderAsNormalBlock()) {
			return block.blockMaterial != Material.pumpkin;
		} else {
			return false;
		}
	}
	
	public static boolean isIdAFence(int par0) {
		return par0 == Block.fence.blockID || par0 == Block.netherFence.blockID
				|| par0 == ExtDecoMod.MarbleFenceBlack.blockID
				|| par0 == ExtDecoMod.MarbleFenceWhite.blockID
				|| par0 == ExtDecoMod.MarbleFenceYellow.blockID
				|| par0 == ExtDecoMod.MarbleBrickFenceWhite.blockID
				|| par0 == ExtDecoMod.MarbleBrickFenceBlack.blockID
				|| par0 == ExtDecoMod.MarbleBrickFenceYellow.blockID;
	}

}