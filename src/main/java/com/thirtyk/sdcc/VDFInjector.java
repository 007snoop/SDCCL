package com.thirtyk.sdcc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class VDFInjector {

    private static final String STEAM_DECK_PATH = "C:\\Program Files (x86)\\Steam\\userdata\\YOUR_USER_ID\\config\\controller_configs\\";

    public static boolean injectVDF(File vdfFile, String gameId) {
        File destination = new File(STEAM_DECK_PATH + gameId + ".vdf");

        try {
            Files.copy(vdfFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
