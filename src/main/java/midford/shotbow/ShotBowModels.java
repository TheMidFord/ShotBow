package midford.shotbow;

import midford.shotbow.entity.SteelArrowEntity;
import midford.shotbow.entity.SteelArrowRenderer;
import midford.shotbow.item.ModItems;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

public class ShotBowModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {
		itemModelDispatcher.addDispatch(new ItemModelStandard(ModItems.ShotBow, null).setIcon("shotbow:item/shotbow").setFull3D());
		itemModelDispatcher.addDispatch(new ItemModelStandard(ModItems.SteelArrow, null).setIcon("shotbow:item/steel_arrow"));
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {
		ModelHelper.setEntityModel(SteelArrowEntity.class, SteelArrowRenderer::new);
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
