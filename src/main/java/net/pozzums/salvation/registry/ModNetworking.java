package net.pozzums.salvation.registry;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.pozzums.salvation.screen.ContractScreenHandler;
import net.pozzums.salvation.util.SalvationIds;

import java.util.List;
import java.util.UUID;

public class ModNetworking {

    public static final var CYCLE_TARGET = SalvationIds.id("cycle_target");
    public static final var CYCLE_TYPE = SalvationIds.id("cycle_type");

    public static void register() {

        ServerPlayNetworking.registerGlobalReceiver(CYCLE_TYPE,
                (server, player, handler, buf, sender) -> server.execute(() -> {
                    if (player.currentScreenHandler instanceof ContractScreenHandler screen) {
                        screen.getDraft().cycleType();
                    }
                })
        );

        ServerPlayNetworking.registerGlobalReceiver(CYCLE_TARGET,
                (server, player, handler, buf, sender) -> server.execute(() -> {
                    if (player.currentScreenHandler instanceof ContractScreenHandler screen) {

                        List<ServerPlayerEntity> players =
                                server.getPlayerManager().getPlayerList();

                        UUID current = screen.getDraft().getTarget();
                        int index = 0;

                        if (current != null) {
                            for (int i = 0; i < players.size(); i++) {
                                if (players.get(i).getUuid().equals(current)) {
                                    index = i + 1;
                                    break;
                                }
                            }
                        }

                        screen.getDraft().setTarget(
                                players.get(index % players.size()).getUuid()
                        );
                    }
                })
        );
    }

    // client helpers
    public static void sendCycleType() {
        net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.send(CYCLE_TYPE, net.minecraft.network.PacketByteBufs.empty());
    }

    public static void sendCycleTarget() {
        net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.send(CYCLE_TARGET, net.minecraft.network.PacketByteBufs.empty());
    }
}
