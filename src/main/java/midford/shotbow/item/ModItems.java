package midford.shotbow.item;

import midford.shotbow.entity.SteelArrowEntity;
import midford.shotbow.entity.SteelArrowRenderer;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static midford.shotbow.ShotBow.MOD_ID;
import static midford.shotbow.ShotBow.itemId;

 public class ModItems implements ModelEntrypoint {
	public ModItems() {} // Makes it impossible to accidentally call 'new ModItems()'
	public static Item ShotBow;
	public static Item SteelArrow;

	public static void init() {

		ShotBow = new ItemBuilder(midford.shotbow.ShotBow.MOD_ID)
			.setStackSize(1)
			.build(new ShotBowItem("shotbow", "shotbow:item/shotbow", itemId++));

		SteelArrow = new ItemBuilder(midford.shotbow.ShotBow.MOD_ID)
			.setStackSize(64)
			.build(new Item("steel_arrow", "shotbow:item/steel_arrow",itemId++));

	}


	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {
		itemModelDispatcher.addDispatch(new ItemModelStandard(ShotBow, null).setIcon("shotbow:item/shotbow").setFull3D());
		itemModelDispatcher.addDispatch(new ItemModelStandard(SteelArrow, null).setIcon("shotbow:item/steel_arrow"));
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {
		ModelHelper.setEntityModel(SteelArrowEntity.class, () -> new SteelArrowRenderer());
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
