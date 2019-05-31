package controller;

import model.MVCFactory;
import view.MyJFrame;

public class AppController {

    private MyJFrame appFrame;
    private MVCFactory appFactory;

    public AppController(){
        appFactory = new MVCFactory();
    }

    public MVCFactory getAppFactory() {
        return appFactory;
    }

    public MyJFrame getAppFrame() {
        return appFrame;
    }

    public void start(){

        appFrame = new MyJFrame(this);

        //Controller -> VIew
        appFrame.getBasePanel().showMsg("Testing!!!!");
    }
}
