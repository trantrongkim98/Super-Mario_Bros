package com.supermariobros.framework;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;

public abstract class GameApplication {
    protected RenderWindow mainWindow;
    private IGameState state;

    protected void onCreate() {
        ContextSettings contextSettings = new ContextSettings();
        this.mainWindow = new RenderWindow(new VideoMode(800, 600), "Application", WindowStyle.DEFAULT, contextSettings);

    }

    final void onRunning() {
        while (this.mainWindow.isOpen()) {
            this.mainWindow.pollEvents().forEach(event -> {
                Event.Type e = event.type;
                if (e == Event.Type.CLOSED) {
                    this.onExit();
                } else {
                    if (this.state != null) {
                        this.state.processInput(this, event);
                    }
                }
            });

            if (this.state != null) {
                this.state.update();
            }

            this.mainWindow.clear(Color.WHITE);
            if (this.state != null) {
                this.state.render(this.mainWindow);
            }
            this.mainWindow.display();
        }
    }

    protected void onExit() {
        this.mainWindow.close();
    }

    abstract public void changeState(Object stateType);

    public static <T extends GameApplication> void run(Class<T> application) {
        try {
            T app = application.newInstance();
            app.onCreate();
            app.onRunning();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public RenderWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(RenderWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public IGameState getState() {
        return state;
    }

    public void setState(IGameState state) {
        this.state = state;
    }
}
