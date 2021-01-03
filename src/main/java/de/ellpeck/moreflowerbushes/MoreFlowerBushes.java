package de.ellpeck.moreflowerbushes;

import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(MoreFlowerBushes.ID)
public class MoreFlowerBushes {

    public static final String ID = "moreflowerbushes";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ID);
    public static final RegistryObject<Block> LARKSPUR = BLOCKS.register("larkspur", FlowerBlock::new);
    public static final RegistryObject<Block> BLUE_HORTENSIA = BLOCKS.register("blue_hortensia", FlowerBlock::new);
    public static final RegistryObject<Block> GOLDEN_SHOWER = BLOCKS.register("golden_shower", FlowerBlock::new);
    public static final RegistryObject<Block> FUCHSIA = BLOCKS.register("fuchsia", FlowerBlock::new);
    public static final RegistryObject<Block> MOUNTAIN_LAUREL = BLOCKS.register("mountain_laurel", FlowerBlock::new);
    public static final RegistryObject<Block> BUTTERFLY_WEED = BLOCKS.register("butterfly_weed", FlowerBlock::new);
    public static final RegistryObject<Block> BLUE_SAGE = BLOCKS.register("blue_sage", FlowerBlock::new);
    public static final RegistryObject<Block> PURPLE_HIBISCUS = BLOCKS.register("purple_hibiscus", FlowerBlock::new);

    public MoreFlowerBushes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        BLOCKS.register(bus);
    }

    private void setup(FMLCommonSetupEvent event) {
        for (RegistryObject<Block> block : BLOCKS.getEntries()) {
            // spawning
            ConfiguredFeature<BlockClusterFeatureConfig, ?> feature = Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build());
            Registry.register(WorldGenRegistries.field_243653_e, block.getId(), feature);

            // composting
            ComposterBlock.CHANCES.put(block.get(), 0.65F);
        }

    }
}
