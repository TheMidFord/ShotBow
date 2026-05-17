package midford.shotbow;

import midford.shotbow.entity.SteelArrowEntity;
import midford.shotbow.entity.SteelArrowRenderer;
import midford.shotbow.item.ModItems;

import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import org.useless.dragonfly.DisplayPos;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

public class ShotBowModels implements ModelEntrypoint {

	 static final DisplayPos HANDHELD_FIRST_PERSON_RIGHT_HAND = new DisplayPos(0.070625F, 0.2F, 0.070625F, 0.0F, -90.0F, 25.0F, 0.68F, 0.68F, 0.68F);
	 static final DisplayPos HANDHELD_FIRST_PERSON_LEFT_HAND = new DisplayPos(0.070625F, 0.2F, 0.070625F, 0.0F, 90.0F, -25.0F, 0.68F, 0.68F, 0.68F);
	 static final DisplayPos HANDHELD_THIRD_PERSON_RIGHT_HAND = new DisplayPos(0.0F, 0.25F, 0.03125F, 0.0F, -90.0F, 55.0F, 0.85F, 0.85F, 0.85F);
	 static final DisplayPos HANDHELD_THIRD_PERSON_LEFT_HAND = new DisplayPos(0.0F, 0.25F, 0.03125F, 0.0F, 90.0F, -55.0F, 0.85F, 0.85F, 0.85F);
	 static final DisplayPos HANDHELD_ROD_FIRST_PERSON_RIGHT_HAND = new DisplayPos(0.0F, 0.1F, 0.05F, 0.0F, 90.0F, 25.0F, 0.68F, 0.68F, 0.68F);
	 static final DisplayPos HANDHELD_ROD_FIRST_PERSON_LEFT_HAND = new DisplayPos(0.0F, 0.1F, 0.05F, 0.0F, -90.0F, -25.0F, 0.68F, 0.68F, 0.68F);
	 static final DisplayPos HANDHELD_ROD_THIRD_PERSON_RIGHT_HAND = new DisplayPos(0.0F, 0.25F, 0.15625F, 0.0F, 90.0F, 55.0F, 0.85F, 0.85F, 0.85F);
	 static final DisplayPos HANDHELD_ROD_THIRD_PERSON_LEFT_HAND = new DisplayPos(0.0F, 0.25F, 0.15625F, 0.0F, -90.0F, -55.0F, 0.85F, 0.85F, 0.85F);


	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {
		itemModelDispatcher.addDispatch(new ItemModelStandard(ModItems.ShotBow, null).setIcon("shotbow:item/shotbow").setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		itemModelDispatcher.addDispatch(new ItemModelStandard(ModItems.SteelArrow, null).setIcon("shotbow:item/steel_arrow"));
	}

	@Override
	public void initEntityModels(EntityRendererDispatcher entityRenderDispatcher) {
		entityRenderDispatcher.assignRenderer(SteelArrowEntity.class, new SteelArrowRenderer());
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
