package br.com.wfcreations.craftduino.configuration;

import java.io.File;

import br.com.wfcreations.craftduino.block.BlocksInfo;
import net.minecraftforge.common.Configuration;

public class BlockConfiguration {

	public static void init(Configuration config) {
		BlocksInfo.ARDUINO_CONNECTOR_ID = config.getBlock(BlocksInfo.ARDUINO_CONNECTOR_KEY, BlocksInfo.ARDUINO_CONNECTOR_DEFAULT).getInt();
	}
	
}
