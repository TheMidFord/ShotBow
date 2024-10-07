package midford.shotbow.item;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

import static midford.shotbow.ShotBow.itemId;

public class ModItems {
	private ModItems() {} // Makes it impossible to accidentally call 'new ModItems()'
	public static Item ShotBow;
	public static Item SteelArrow;

	public static void init() {

		ShotBow = new ItemBuilder(midford.shotbow.ShotBow.MOD_ID)
			.setStackSize(1)
			.setIcon("shotbow:item/shotbow")
			.build(new ShotBowItem("shotbow",itemId++));

		SteelArrow = new ItemBuilder(midford.shotbow.ShotBow.MOD_ID)
			.setStackSize(64)
			.setIcon("shotbow:item/steel_arrow")
			.build(new Item("steel_arrow",itemId++));

	}



}
