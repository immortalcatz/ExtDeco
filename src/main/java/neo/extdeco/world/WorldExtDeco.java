package neo.extdeco.world;

import java.util.Random;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.init.ExtDeco;
import neo.extdeco.items.ItemMarbleSlab;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldExtDeco implements IWorldGenerator{
	
	private ExtDeco config = ExtDeco.modInstance;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId) {
		case -1:
			genNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case  0:
			genSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case  1:
			genEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}	
	}

	private void genEnd(World world, Random random, int chunkX, int chunkZ) {	
	}

	private void genSurface(World world, Random random, int chunkX, int chunkZ) {
		if (config.genWhiteMarble){
			for (int i = 0; i < 50; i++) {
				
				int blockX = chunkX + random.nextInt(16);
				int blockY = random.nextInt(64);
				int blockZ = chunkZ + random.nextInt(16);
				
				(new WorldGenMineSurfaceExtDeco(BlocksExtDeco.marble, 8, 0, Blocks.stone)).generate(world, random, blockX, blockY, blockZ);	
			}
		}	
	}

	private void genNether(World world, Random random, int chunkX, int chunkZ) {
		
		if (config.genBlackMarble){
			
			for (int i = 0; i < 50; i++) {
				int blockX = chunkX + random.nextInt(16);
				int blockY = random.nextInt(64);
				int blockZ = chunkZ + random.nextInt(16);
				
				(new WorldGenMineNetherExtDeco(BlocksExtDeco.marble, 350, 1)).generate(world, random, blockX, blockY, blockZ);			
			}
		}
		
		if (config.genYellowMarble){
			
			for (int i = 0; i < 50; i++) {
				int blockX = chunkX + random.nextInt(16);
				int blockY = random.nextInt(64);
				int blockZ = chunkZ + random.nextInt(16);
				
				(new WorldGenMineNetherExtDeco(BlocksExtDeco.marble, 250, 2)).generate(world, random, blockX, blockY, blockZ);					
			}
		}
	}
}