package midford.shotbow.entity;

import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;

import static midford.shotbow.ShotBow.MOD_ID;


public class ModEntities {
	private ModEntities() {
	}

	public static void init() {
		EntityHelper.createEntity(SteelArrowEntity.class, NamespaceID.getPermanent(MOD_ID, "steel_arrow_entity"), null);
	}
}
