package me.restonic4.ssna.client;

import net.fabricmc.api.ClientModInitializer;

import static me.restonic4.ssna.SuperSimpleNormalAPI.CONSOLE;
import static me.restonic4.ssna.SuperSimpleNormalAPI.MOD_NAME;

public class SuperSimpleNormalAPIClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CONSOLE.info("Loading " + MOD_NAME + " client part");
    }
}
