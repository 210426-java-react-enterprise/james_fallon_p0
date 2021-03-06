package com.bank.util;
import com.bank.screens.Screen;

public class ScreenRouter {

    private LinkedList<Screen> screens= new LinkedList<>();

    public ScreenRouter addScreen(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route){
        for(int i = 0; i < screens.size(); i++){
            Screen screen = screens.get(i);
            if(screen.getRoute().equals(route)){
                screen.render();
            }
        }
    }
}
