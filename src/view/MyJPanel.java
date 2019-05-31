package view;

import controller.AppController;
import model.Whatsit;
import model.Widget;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJPanel extends JPanel {

    private AppController baseController;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel weightLabel;
    private JLabel sizeLabel;
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField weightField;
    private JTextField sizeField;
    private JButton createWidgetButton;
    private JButton createWhatsitButton;
    private SpringLayout baseLayout;

    public MyJPanel(AppController baseController){

        this.baseController = baseController;

        createWidgetButton = new JButton("Make a Widget");
        createWhatsitButton = new JButton("Make a whatsit");

        nameLabel = new JLabel("Type the name of the widget");
        descriptionLabel = new JLabel("Describe the widget");
        weightLabel = new JLabel("Enter the weight of the Widget");
        sizeLabel = new JLabel("Enter the size of the Widget");

        nameField = new JTextField(20);
        descriptionField = new JTextField(20);
        weightField = new JTextField(10);
        sizeField = new JTextField(10);

        baseLayout = new SpringLayout();

        setupPanel();
        setupLayout();
        setupListeners();

    }


    private void setupLayout() {

    }

    private void setupPanel() {

        setSize(500, 500);
        //setLayout(baseLayout);
        add(createWhatsitButton);
        add(createWidgetButton);
        add(nameField);
        add(descriptionField);
        add(weightField);
        add(sizeField);
        add(nameLabel);
        add(descriptionLabel);
        add(weightLabel);
        add(sizeLabel);
    }

    private void setupListeners() {

        createWidgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String description = descriptionField.getText();
                double currentWeight = 0.0;
                if(checkDouble(sizeField.getText())){
                    currentWeight = Double.parseDouble(sizeField.getText());

                    if(baseController.getAppFactory().makeWidget(currentWeight, description)){
                        JOptionPane.showMessageDialog(baseController.getAppFrame(), "Success!");
                    }else{
                        JOptionPane.showMessageDialog(baseController.getAppFrame(), "Failed!");
                    }
                }


            }
        });

        createWhatsitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameField.getText();
                int size = 0;
                if(checkInteger(sizeField.getText())){
                    size = Integer.parseInt(sizeField.getText());

                    if(baseController.getAppFactory().makeWidget(size, name)){
                        JOptionPane.showMessageDialog(baseController.getAppFrame(), "Success!");
                    }else{
                        JOptionPane.showMessageDialog(baseController.getAppFrame(), "Failed");
                    }
                }
                //View -> Controller -> Model
                baseController.getAppFactory().getWhatsitList().add(new Whatsit(size, name));
            }
        });
    }

    private boolean checkInteger(String currentInput){
        //S - testing
        boolean isInteger = false;

        try{
            Integer.parseInt(currentInput);
            isInteger = true;
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Please enter a number only");
        }

        return isInteger;
    }

    private boolean checkDouble(String currentInput){

        boolean isDouble = false;

        try{
            Double.parseDouble(currentInput);
            isDouble = true;
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Please enter a number only");
        }

        return isDouble;
    }

    public void showMsg(String msg){

        JOptionPane.showMessageDialog(this, msg);
    }

}
