package net.redchujelly.cluttered;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.redchujelly.cluttered.platform.BusGroup;
import net.redchujelly.cluttered.setup.BlockRegistration;
import net.redchujelly.cluttered.setup.CreativeTabRegistration;
import net.redchujelly.cluttered.setup.EntityTypeRegistration;
import net.redchujelly.cluttered.setup.FoliagePlacerTypeRegistration;
import net.redchujelly.cluttered.setup.ItemRegistration;
import net.redchujelly.cluttered.setup.SoundRegistration;
import net.redchujelly.cluttered.setup.TileEntityRegistration;
import net.redchujelly.cluttered.setup.TreeDecoratorTypeRegistration;
import net.redchujelly.cluttered.setup.TrunkPlacerTypeRegistration;
import org.slf4j.Logger;

public class Cluttered implements ModInitializer {
    public static final String MODID = "cluttered";

    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        BusGroup eventBus = BusGroup.INSTANCE;

        SoundRegistration.register(eventBus);
        ItemRegistration.register(eventBus);
        BlockRegistration.register(eventBus);
        TileEntityRegistration.register(eventBus);
        EntityTypeRegistration.register(eventBus);
        TrunkPlacerTypeRegistration.register(eventBus);
        FoliagePlacerTypeRegistration.register(eventBus);
        TreeDecoratorTypeRegistration.register(eventBus);
        CreativeTabRegistration.register(eventBus);

        ItemRegistration.registerFabricContent();
        BlockRegistration.registerFabricContent();
        LOGGER.info("Loaded Cluttered Fabric port");
    }
}
