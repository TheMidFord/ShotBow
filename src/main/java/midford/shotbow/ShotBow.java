package midford.shotbow;

import midford.shotbow.entity.ModEntities;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import midford.shotbow.item.ModItems;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class ShotBow implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "shotbow";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static int blockId;
	public static int itemId;
	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","8300");
		prop.setProperty("starting_item_id","25700");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		blockId = config.getInt("starting_block_id");
		itemId = config.getInt("starting_item_id");

		config.updateConfig();
	}
    @Override
    public void onInitialize() {
        LOGGER.info("ShotBow initialized.");
		ModItems.init();
		ModEntities.init();

    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}
}
