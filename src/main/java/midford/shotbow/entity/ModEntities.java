package midford.shotbow.entity;
import midford.shotbow.ShotBow;
import net.minecraft.client.render.entity.ArrowRenderer;
import net.minecraft.core.entity.Entity;
import turniplabs.halplibe.helper.EntityHelper;


public class ModEntities {
	private ModEntities() {}

	public static void init() {
		EntityHelper.createEntity(SteelArrowEntity.class, 200 /* replace with config derived value */, "steelArrow", () -> new SteelArrowRenderer());
	}
}
