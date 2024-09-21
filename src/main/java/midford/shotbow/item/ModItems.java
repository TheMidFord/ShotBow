package midford.shotbow.item;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

public class ModItems {
	private ModItems() {} // Makes it impossible to accidentally call 'new ModItems()'
	public static Item ShotBow;

	public static void init() {
		// TODO make numeric block ids configurable by the user
		// TODO actually use lang file to set name
		ShotBow = new ItemBuilder(midford.shotbow.ShotBow.MOD_ID)
			.setStackSize(1)
			.build(new ShotBowItem("shotbow", 20000));

	}
}
