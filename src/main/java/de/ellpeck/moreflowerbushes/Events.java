package de.ellpeck.moreflowerbushes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class Events {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.FOREST)
            event.getGeneration().func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, MoreFlowerBushes.flowerFeature);
    }
}
