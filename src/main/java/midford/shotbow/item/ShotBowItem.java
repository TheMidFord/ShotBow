package midford.shotbow.item;

import midford.shotbow.entity.SteelArrowEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.entity.projectile.EntityArrow;
import net.minecraft.core.entity.projectile.EntityArrowGolden;
import net.minecraft.core.entity.projectile.EntityArrowPurple;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;

public class ShotBowItem extends Item {
	public ShotBowItem(String name, int id) {
		super(name, id);
		this.maxStackSize = 1;
		this.setMaxDamage(4608);
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (entityplayer.inventory.consumeInventoryItem(ModItems.SteelArrow.id)) {
			itemstack.damageItem(1, entityplayer);
			world.playSoundAtEntity(entityplayer, entityplayer, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				final float spread = 16f;
				final int shotsToFire = 5;
				for (int i = 0; i < shotsToFire; i++) {
					EntityArrow arrow = new SteelArrowEntity(world, entityplayer, true, 0);
					float hOff = (itemRand.nextFloat() - 0.5f) * 0.4f;
					float vOff = (itemRand.nextFloat() - 0.5f) * 0.2f;
					setHeadingDirect(entityplayer, arrow, arrow.xd, arrow.yd, arrow.zd, 1.5f, hOff, vOff);
					world.entityJoinedWorld(arrow);
				}
			}


		}
		return itemstack;
	}


	public void setHeadingDirect(EntityPlayer player, EntityArrow arrow, double newMotionX, double newMotionY, double newMotionZ, float speed, float hOff, float vOff) {
		float velocity = MathHelper.sqrt_double(newMotionX * newMotionX + newMotionY * newMotionY + newMotionZ * newMotionZ);

		float sinYaw = MathHelper.sin(player.yRot * 3.141593F / 180.0F);
		float cosYaw = MathHelper.cos(player.yRot * 3.141593F / 180.0F);

		newMotionX = (newMotionX / velocity) * speed;
		newMotionY = (newMotionY / velocity) * speed;
		newMotionZ = (newMotionZ / velocity) * speed;
		arrow.xd = newMotionX + (double)(hOff * cosYaw);
		arrow.yd = newMotionY + vOff;
		arrow.zd = newMotionZ + (double)(hOff * sinYaw);


		float f3 = MathHelper.sqrt_double(newMotionX * newMotionX + newMotionZ * newMotionZ);
		arrow.yRotO = arrow.yRot = (float)(Math.atan2(newMotionX, newMotionZ) * 180.0 / Math.PI);
		arrow.xRotO = arrow.xRot = (float)(Math.atan2(newMotionY, f3) * 180.0 / Math.PI);
	}
}
