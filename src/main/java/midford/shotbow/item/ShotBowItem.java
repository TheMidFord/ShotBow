package midford.shotbow.item;

import midford.shotbow.entity.SteelArrowEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.entity.projectile.EntityArrow;
import net.minecraft.core.entity.projectile.EntityArrowGolden;
import net.minecraft.core.entity.projectile.EntityArrowPurple;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ShotBowItem extends Item {
	public ShotBowItem(String name, int id) {
		super(name, id);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (entityplayer.inventory.consumeInventoryItem(Item.ammoArrow.id)) {
			itemstack.damageItem(1, entityplayer);
			world.playSoundAtEntity(entityplayer, entityplayer, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				final float spread = 6f;
				final int shotsToFire = 5;
				for (int i = 0; i < shotsToFire; i++) {
					EntityArrow arrow = new SteelArrowEntity(world, entityplayer, true, 0);
					arrow.setHeading(arrow.xd, arrow.yd, arrow.zd, 1.5f, spread);
					world.entityJoinedWorld(arrow);
				}
			}


		}
		return itemstack;
	}

}
