package com.supermariobros.framework;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.window.event.Event;

public interface IGameState {
    void processInput(GameApplication app, Event event);

    void update();

    void render(RenderTarget renderTarget);

}
