package com.supermariobros.states;

import com.supermariobros.framework.GameApplication;
import com.supermariobros.framework.IGameState;
import com.supermariobros.framework.ui.TextView;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

public class SettingState implements IGameState {
    private final String TAG = SettingState.class.getSimpleName();
    private TextView textView;

    public SettingState() {
        this.textView = new TextView("\t\t\tSetting");
    }

    @Override
    public void processInput(GameApplication app, Event event) {
        switch (event.type) {
            case KEY_PRESSED:
                if (event.asKeyEvent().key == Keyboard.Key.RIGHT) {
                    app.changeState(StateType.MENU_STATE);
                }
            default:
                break;
        }
//        System.out.println(this.TAG + ": processInput");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(RenderTarget renderTarget) {
//        System.out.println(this.TAG + ": render");
        renderTarget.draw(this.textView);
    }

}
