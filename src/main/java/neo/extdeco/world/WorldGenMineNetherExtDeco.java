package neo.extdeco.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMineNetherExtDeco extends WorldGenerator
{
	/** The Block what are Generating*/
    private Block oreBlock;
    /** The number of blocks to generate.*/
    private int numberOfBlocks;
    /**Meta of the Block*/
    private int mineableBlockMeta;
    
    private static final String __OBFID = "CL_00000405";

    /**
     * 
     * @param block
     * @param value of blocks
     * @param meta
     */
    public WorldGenMineNetherExtDeco(Block block, int value, int meta)
    {
        this.oreBlock = block;
        this.mineableBlockMeta = meta;
        this.numberOfBlocks = value;
    }
    
    public boolean generate(World world, Random p_76484_2_, int x, int y, int z)
    {
        if (!world.isAirBlock(x, y, z))
        {
            return false;
        }
        else if (world.getBlock(x, y + 1, z) != Blocks.netherrack)
        {
            return false;
        }
        else
        {
        	world.setBlock(x, y, z, oreBlock, mineableBlockMeta, 2);

            for (int l = 0; l < numberOfBlocks; ++l)
            {
                int i1 = x + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
                int j1 = y - p_76484_2_.nextInt(12);
                int k1 = z + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);

                if (world.getBlock(i1, j1, k1).getMaterial() == Material.air)
                {
                    int l1 = 0;

                    for (int i2 = 0; i2 < 6; ++i2)
                    {
                        Block block = null;

                        if (i2 == 0)
                        {
                            block = world.getBlock(i1 - 1, j1, k1);
                        }

                        if (i2 == 1)
                        {
                            block = world.getBlock(i1 + 1, j1, k1);
                        }

                        if (i2 == 2)
                        {
                            block = world.getBlock(i1, j1 - 1, k1);
                        }

                        if (i2 == 3)
                        {
                            block = world.getBlock(i1, j1 + 1, k1);
                        }

                        if (i2 == 4)
                        {
                            block = world.getBlock(i1, j1, k1 - 1);
                        }

                        if (i2 == 5)
                        {
                            block = world.getBlock(i1, j1, k1 + 1);
                        }

                        if (block == oreBlock)
                        {
                            ++l1;
                        }
                    }

                    if (l1 == 1)
                    {
                        world.setBlock(i1, j1, k1, oreBlock, mineableBlockMeta, 2);
                    }
                }
            }

            return true;
        }
    }
}