package de.ellpeck.moreflowerbushes;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class Events {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (RegistryObject<Block> block : MoreFlowerBushes.BLOCKS.getEntries()) {
            BlockItem item = new BlockItem(block.get(), new Item.Properties().group(ItemGroup.DECORATIONS));
            item.setRegistryName(block.getId());
            event.getRegistry().register(item);
        }
    }
}
