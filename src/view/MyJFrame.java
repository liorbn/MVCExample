package view;

import controller.AppController;

import javax.swing.*;

/**
 * MyJFrame obj the extends JFrame for use in MVC gui
 * @version 1.0
 */
public class MyJFrame extends JFrame {

    /**
     * Reference to the application panel
     */
    private MyJPanel basePanel;

    /**
     * Create a sample frame object passing a reference to the AppController for use by the MyJFrame object
     * @param baseController
     */
    public MyJFrame(AppController baseController){

        basePanel = new MyJPanel(baseController);

        setupFrame();
    }

    /**
     * Set ths content pane, size and make the frame visible
     */
    private void setupFrame(){

        setContentPane(basePanel);
        setSize(500,500);
        setVisible(true);

    }

    public MyJPanel getBasePanel() {
        return basePanel;
    }
}
