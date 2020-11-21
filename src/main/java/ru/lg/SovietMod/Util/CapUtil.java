package ru.lg.SovietMod.Util;

import javax.annotation.Nullable;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class CapUtil {
	/**
	 * Get a capability handler from an {@link ICapabilityProvider} if it exists.
	 *
	 * @param provider   The provider
	 * @param capability The capability
	 * @param facing     The facing
	 * @param <T>        The handler type
	 * @return The handler, if any.
	 */
	@Nullable
	public static <T> T getCapability(@Nullable final ICapabilityProvider provider, final Capability<T> capability, @Nullable final EnumFacing facing) {
		return provider != null && provider.hasCapability(capability, facing) ? provider.getCapability(capability, facing) : null;
	}
}