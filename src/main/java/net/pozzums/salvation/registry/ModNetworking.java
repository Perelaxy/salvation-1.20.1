package net.pozzums.salvation.registry;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs; // FIXED
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.pozzums.salvation.screen.ContractScreenHandler;
import net.pozzums.salvation.util.SalvationIds;

import java.util.List;
import java.util.UUID;


public class ModNetworking {

    public static final Identifier CYCLE_TARGET = SalvationIds.id("cycle_target");
    public static final Identifier CYCLE_TYPE   = SalvationIds.id("cycle_type");

    public static void register() {

        // Cycle judgment type
        ServerPlayNetworking.registerGlobalReceiver(CYCLE_TYPE, (server, player, handler, buf, sender) -> {
            server.execute(() -> {
                if (player.currentScreenHandler instanceof ContractScreenHandler screen) {
                    screen.getDraft().cycleType();
                }
            });
        });

        // Cycle target player
        ServerPlayNetworking.registerGlobalReceiver(CYCLE_TARGET, (server, player, handler, buf, sender) -> {
            server.execute(() -> {
                if (player.currentScreenHandler instanceof ContractScreenHandler screen) {

                    List<ServerPlayerEntity> players = server.getPlayerManager().getPlayerList();
                    UUID current = screen.getDraft().getTarget();
                    int idx = 0;

                    if (current != null) {
                        for (int i = 0; i < players.size(); i++) {
                            if (players.get(i).getUuid().equals(current)) {
                                idx = (i + 1) % players.size(); // next player
                                break;
                            }
                        }
                    }

                    screen.getDraft().setTarget(players.get(idx).getUuid());
                }
            });
        });
    }

    // Client helpers
    public static void sendCycleType() {
        ClientPlayNetworking.send(CYCLE_TYPE, PacketByteBufs.empty());
    }

    public static void sendCycleTarget() {
        ClientPlayNetworking.send(CYCLE_TARGET, PacketByteBufs.empty());
    }
}
