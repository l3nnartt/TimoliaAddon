package com.github.l3nnartt.timolia.core.listener;

import com.google.inject.Inject;
import net.labymod.api.event.Phase;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import com.github.l3nnartt.timolia.core.TimoliaAddon;

public class ExampleGameTickListener {

  private final TimoliaAddon addon;

  @Inject
  private ExampleGameTickListener(TimoliaAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(GameTickEvent event) {
    if (event.phase() != Phase.PRE) {
      return;
    }

    this.addon.logger().info(this.addon.configuration().enabled().get() ? "enabled" : "disabled");
  }
}
