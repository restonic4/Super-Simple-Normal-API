package me.restonic4.ssna;

import me.restonic4.ssna.testing.TestingLoader;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperSimpleNormalAPI implements ModInitializer {
    public static final String MOD_ID = "ssna";
    public static final String MOD_NAME = "Super Simple Normal API";
    public static final Logger CONSOLE = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        CONSOLE.info("Loading " + MOD_NAME + " common part");

        TestingLoader.load();
    }
}