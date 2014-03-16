package br.com.wfcreations.craftduino.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockContainerBase<T extends TileEntity> extends BlockContainer {

	public BlockContainerBase(int id, Material material) {
		super(id, material);
	}

	@Override
	public abstract T createNewTileEntity(World world);

}
