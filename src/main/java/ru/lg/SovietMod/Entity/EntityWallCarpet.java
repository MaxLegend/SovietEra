package ru.lg.SovietMod.Entity;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegItems;

public class EntityWallCarpet extends EntityHanging implements IEntityAdditionalSpawnData {


	public EntityWallCarpet(World world) {
		super(world);
	}

	public EntityWallCarpet(World world, BlockPos pos, EnumFacing facing) {
		super(world, pos);
		updateFacingWithBoundingBox(facing);
	}
	@Override
	public void onUpdate()
	{

		return;
	}
	@Override
	public int getWidthPixels() {return 16;}

	@Override
	public int getHeightPixels() {return 16;}

	@Override
	public void onBroken(@Nullable Entity brokenEntity) {
		if (world.getGameRules().getBoolean("doEntityDrops")) {

			if (brokenEntity instanceof EntityPlayer)  {
				EntityPlayer player = (EntityPlayer)brokenEntity;
				if (player.capabilities.isCreativeMode) return;
			}

			entityDropItem(new ItemStack(RegItems.item_wall_carpet), 0.0F);
		}
	}
	@Override
	public EntityItem entityDropItem(ItemStack stack, float offsetY)
	{
		EntityItem entityitem = new EntityItem(this.world, this.posX + (double)((float)this.facingDirection.getFrontOffsetX() * 0.15F), this.posY + (double)offsetY, this.posZ + (double)((float)this.facingDirection.getFrontOffsetZ() * 0.15F), stack);
		this.getEntityWorld().spawnEntity(entityitem);
		return entityitem;
	}
	@Override
	public void playPlaceSound() {playSound(SoundEvents.ENTITY_PAINTING_PLACE, 1.0F, 1.0F);}

	@Override
	public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {setPosition(x, y, z);}

	@Override
	@SideOnly(Side.CLIENT)
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		BlockPos pos = hangingPosition.add(x - posX, y - posY, z - posZ);
		setPosition((double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		PacketBuffer pack = new PacketBuffer(buffer);
		pack.writeBlockPos(getHangingPosition());
		pack.writeEnumValue(this.getHorizontalFacing());
	}

	@Override
	public void readSpawnData(ByteBuf buffer) {
		PacketBuffer pack = new PacketBuffer(buffer);
		hangingPosition = pack.readBlockPos();
		updateFacingWithBoundingBox(pack.readEnumValue(EnumFacing.class));
	}
}
