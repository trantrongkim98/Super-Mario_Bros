package com.supermariobros.app;

import com.supermariobros.framework.GameApplication;
import com.supermariobros.framework.IGameState;
import com.supermariobros.states.MenuState;
import com.supermariobros.states.SettingState;
import com.supermariobros.states.StateType;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;

import java.util.Hashtable;

public final class SuperMarioBrosApp extends GameApplication {
    private final String TAG = SuperMarioBrosApp.class.getSimpleName();
    private final String title = "Super Mario Bros";
    private Hashtable<StateType, IGameState> gameStates;

    @Override
    protected void onCreate() {
        super.onCreate();
        System.out.println(this.TAG + " onCreate");
        this.gameStates = new Hashtable<>();
        this.gameStates.put(StateType.MENU_STATE, new MenuState());
        this.gameStates.put(StateType.SETTING_STATE, new SettingState());
        // init game state
        this.setState(this.gameStates.get(StateType.MENU_STATE));

        // customize main window
        ContextSettings contextSettings = new ContextSettings();
        this.mainWindow.create(new VideoMode(800, 600), title, WindowStyle.DEFAULT, contextSettings);
    }

    @Override
    public void changeState(Object stateType) {
        if (stateType instanceof StateType) {
            this.setState(this.gameStates.get(stateType));
        }
        // throw invalid state type exception
    }

    @Override
    protected void onExit() {
        System.out.println(this.TAG + " onExit");
        super.onExit();
    }
}
