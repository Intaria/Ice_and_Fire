package com.github.alexthe666.iceandfire.client.gui;

import com.github.alexthe666.iceandfire.inventory.IafContainerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;

public class IafGuiRegistry {

    public static void register() {
        MenuScreens.register(IafContainerRegistry.HIPPOGRYPH_CONTAINER.get(), GuiHippogryph::new);
        MenuScreens.register(IafContainerRegistry.HIPPOCAMPUS_CONTAINER.get(), GuiHippocampus::new);
    }
}
