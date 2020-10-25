package com.supermariobros.framework;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public abstract class AbstractApplication extends RenderWindow{
    private String mTitle = "Application";
    private Clock mClock;

    public AbstractApplication() {
        this.mClock = new Clock();
    }

    public AbstractApplication(VideoMode videoMode, String s, int i, ContextSettings contextSettings) {
        super(videoMode, s, i, contextSettings);
        this.mClock = new Clock();
    }

    public AbstractApplication(VideoMode videoMode, String s, int i) {
        super(videoMode, s, i);
        this.mClock = new Clock();
    }

    public AbstractApplication(VideoMode videoMode, String s) {
        super(videoMode, s);
        this.mClock = new Clock();
    }

    public void run() {
        this.initialize();
        this.loadingContent();
        while (this.isOpen()) {
            this.mClock.restart();
            this.pollEvents().forEach(this::processInput);
            this.update(this.mClock.getElapsedTime());
            this.clear(Color.WHITE);
            this.render();
            this.display();
        }
    }

    protected void initialize() {

    }

    protected void loadingContent() {

    }

    protected void processInput(Event event) {
        if (event.type == Event.Type.CLOSED) {
            this.closing();
            this.close();
        }
    }

    protected void update(Time time) {

    }

    protected void render() {

    }

    protected void closing() {

    }

    public Clock getClock() {
        return mClock;
    }

    public void setClock(Clock clock) {
        this.mClock = clock;
    }
}
