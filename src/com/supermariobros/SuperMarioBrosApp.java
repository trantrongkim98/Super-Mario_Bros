package com.supermariobros;


import com.supermariobros.framework.AbstractApplication;
import org.jsfml.system.Time;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public final class SuperMarioBrosApp extends AbstractApplication {
    public static void main(String[] args) {
        new SuperMarioBrosApp().run();
    }

    public SuperMarioBrosApp() {
       super(new VideoMode(800, 600), "Super Mario Bros");
    }

    @Override
    protected void initialize() {
        super.initialize();
//        System.out.println("initialize");
    }

    @Override
    protected void loadingContent() {
        super.loadingContent();
//        System.out.println("loadingContent");
    }

    @Override
    protected void processInput(Event event) {
        super.processInput(event);
//        System.out.println("processInput");
    }


    @Override
    protected void update(Time time) {
        super.update(time);
//        System.out.println("update");
    }

    @Override
    protected void render() {
        super.render();
//        System.out.println("render");
    }

    @Override
    protected void closing() {
        super.closing();
//        System.out.println("closing");
    }
}
