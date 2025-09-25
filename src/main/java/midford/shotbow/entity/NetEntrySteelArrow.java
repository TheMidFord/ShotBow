package midford.shotbow.entity;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.net.entity.EntityTracker;
import net.minecraft.core.net.entity.EntityTrackerEntry;
import net.minecraft.core.net.entity.ITrackedEntry;
import net.minecraft.core.net.entity.IVehicleEntry;
import net.minecraft.core.net.packet.PacketAddEntity;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NetEntrySteelArrow implements IVehicleEntry<SteelArrowEntity>, ITrackedEntry<SteelArrowEntity> {
	public @NotNull Class<SteelArrowEntity> getAppliedClass() {
		return SteelArrowEntity.class;
	}

	public int getTrackingDistance() {
		return 64;
	}

	public int getPacketDelay() {
		return 1;
	}

	public boolean sendMotionUpdates() {
		return false;
	}

	public void onEntityTracked(EntityTracker tracker, EntityTrackerEntry trackerEntry, SteelArrowEntity trackedObject) {
	}

	public Entity getEntity(World world, double x, double y, double z, int metadata, boolean hasVelocity, double xd, double yd, double zd, Entity owner, @Nullable CompoundTag tag) {
		return new SteelArrowEntity(world, x, y, z, metadata);
	}

	public PacketAddEntity getSpawnPacket(EntityTrackerEntry tracker, SteelArrowEntity trackedObject) {
		Mob entityliving = trackedObject.owner;
		return new PacketAddEntity(trackedObject, trackedObject.getArrowType(), entityliving == null ? -1 : entityliving.id, trackedObject.xd, trackedObject.yd, trackedObject.zd);
	}
}
