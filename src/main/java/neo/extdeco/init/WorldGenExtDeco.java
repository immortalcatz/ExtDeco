package neo.extdeco.init;

import java.util.Random;

import neo.extdeco.blocks.BlocksExtDeco;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenExtDeco implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId) {
		case -1:
			genNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case  0:
			//genSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case  1:
			genEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}	
	}

	private void genEnd(World world, Random random, int chunkX, int chunkZ) {	
	}

	private void genSurface(World world, Random random, int chunkX, int chunkZ) {
		
		for (int i = 0; i < 50; i++) {
			int blockX = chunkX + random.nextInt(16);
			int blockY = random.nextInt(64);
			int blockZ = chunkZ + random.nextInt(16);
			
			//(new WorldGenMinable(BlocksExtDeco.whiteMarbleBlock, 8)).generate(world, random, blockX, blockY, blockZ);			
		}
	}

	private void genNether(World world, Random random, int chunkX, int chunkZ) {
		
		for (int i = 0; i < 50; i++) {
			int blockX = chunkX + random.nextInt(16);
			int blockY = random.nextInt(64);
			int blockZ = chunkZ + random.nextInt(16);
			
			//(new WorldGenMinable(BlocksExtDeco.blackMarble, 6)).generate(world, random, blockX, blockY, blockZ);			
		}
		for (int i = 0; i < 50; i++) {
			int blockX = chunkX + random.nextInt(16);
			int blockY = random.nextInt(64);
			int blockZ = chunkZ + random.nextInt(16);
			
			//(new WorldGenMinable(BlocksExtDeco.yellowMarble, 6)).generate(world, random, blockX, blockY, blockZ);			
		}
	}
}