package midford.shotbow.entity;

import midford.shotbow.item.ModItems;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.projectile.EntityArrow;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;

public class SteelArrowEntity extends EntityArrow {
	public SteelArrowEntity(World world) {
		super(world);
	}

	public SteelArrowEntity(World world, int arrowType) {
		super(world, arrowType);
	}

	public SteelArrowEntity(World world, double d, double d1, double d2, int arrowType) {
		super(world, d, d1, d2, arrowType);
	}

	public SteelArrowEntity(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
		super(world, entityliving, doesArrowBelongToPlayer, arrowType);
	}
	@Override
	protected void inGroundAction()
	{
		if(world.isClientSide) {
			setGrounded(true);
			shake = 7;
			return;
		}
		world.playSoundAtEntity(null, this, "random.drr", 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
		for(int j = 0; j < 4; j++)
		{
			world.spawnParticle("item", x, y, z, 0.0, 0.0D, 0.0D, ModItems.ShotBow.id);
		}
		remove();
	}
}
