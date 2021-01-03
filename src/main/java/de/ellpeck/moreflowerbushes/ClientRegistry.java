package de.ellpeck.moreflowerbushes;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD)
public final class ClientRegistry {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        for (RegistryObject<Block> block : MoreFlowerBushes.BLOCKS.getEntries())
            RenderTypeLookup.setRenderLayer(block.get(), RenderType.getCutout());
    }

}
