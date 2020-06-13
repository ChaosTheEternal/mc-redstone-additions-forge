package com.github.chaostheeternal.redstone_additions;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class RedstoneAdditionsModClient {
	private static final Logger LOGGER = LogManager.getLogger();

	private Minecraft _minecraft;

	public RedstoneAdditionsModClient(Supplier<Minecraft> minecraftSupplier) {
		LOGGER.debug( "{}::ctor", getClass().getName() );
		assert(FMLEnvironment.dist == Dist.CLIENT);
		_minecraft = minecraftSupplier.get();
		assert( _minecraft != null);
	}

	public void run() {
		LOGGER.debug( "{}::run", getClass().getName() );
	}

	@Mod.EventBusSubscriber(modid = RedstoneAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
	@OnlyIn(Dist.CLIENT)
	public static class Registration {
		@SubscribeEvent
		public static void registerClientSetup(FMLClientSetupEvent e) {
			LOGGER.debug( "{}::registerClientSetup", Registration.class.getName() );
		}
	}
}
