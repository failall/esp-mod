package com.failall.esp.event;

import com.failall.esp.Esp;
import com.failall.esp.registry.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

@Mod.EventBusSubscriber(modid = Esp.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TeleportElevatorEvent {
    @SubscribeEvent
    public static void onSneakEvent(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level level = event.player.level();
        if (player.isShiftKeyDown()) {
            BlockPos posBelow = player.getOnPos();
            BlockState blockState = level.getBlockState(posBelow);
            if (blockState.getBlock() != Registry.ELEVATOR_BLOCK.get()) {
                return;
            }
            BlockPos current_pos = posBelow;
            while(current_pos.getY() > -64)
            {
                current_pos = current_pos.below();
                if (level.getBlockState(current_pos).getBlock() == Registry.ELEVATOR_BLOCK.get())
                {
                    //player.sendSystemMessage(Component.literal("Current Pos: " + current_pos));
                    player.teleportRelative(0, -(player.getY() - current_pos.getY() - 1), 0);
                    //player.setPos(current_pos.getCenter());
                    return;
                }
            }
        }
    }
}
