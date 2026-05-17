package midford.shotbow.entity;

import net.minecraft.core.entity.EntityDispatcher;
import net.minecraft.core.util.collection.NamespaceID;

import static midford.shotbow.ShotBow.MOD_ID;


public class ModEntities {
	private ModEntities() {
	}

	public static void init() {
		EntityDispatcher.getInstance().addMapping(SteelArrowEntity.class,new NamespaceID(MOD_ID, "steel_arrow_entity"), SteelArrowEntity::new,null);
	}
}
