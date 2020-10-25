package com.supermariobros.states;

public enum StateType {
    MENU_STATE("MenuState"),
    SETTING_STATE("SettingState");

    private String stateType;

    public String getStateType() {
        return stateType;
    }

    StateType(String stateType) {
        this.stateType = stateType;
    }
}