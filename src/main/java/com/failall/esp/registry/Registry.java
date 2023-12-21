package com.failall.esp.registry;

import com.failall.esp.Esp;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Registry {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Esp.MODID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Esp.MODID);

    public static final DeferredBlock<Block> ELEVATOR_BLOCK =
            BLOCKS.registerSimpleBlock("elevator_block", BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK));

    public static final DeferredItem<BlockItem> ELEVATOR_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem(ELEVATOR_BLOCK);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
