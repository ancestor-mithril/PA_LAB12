package org.example.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JTextField componentType;
    JTextField componentName;

    JButton createComponent;
    JLabel typeInfo;
    JLabel nameInfo;
    JLabel error;

    JButton button;
    JLabel label;
    JTextField textField;
    JTextArea textArea;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(1000, 100));
        componentType = new JTextField(30);
        componentName = new JTextField(30);
        createComponent = new JButton("Create");
        typeInfo = new JLabel("Class type");
        nameInfo = new JLabel("Class name");
        error = new JLabel("No error");
        add(typeInfo);
        add(componentType);
        add(nameInfo);
        add(componentName);
        add(createComponent);
        add(error);
        createComponent.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        String classType = this.componentType.getText();
        String className = this.componentName.getText();
        try {
            error.setText("No error");
            Class clazz = Class.forName(classType);
            Component component = (Component) clazz.newInstance();
            component.setPreferredSize(new Dimension(100, 50));
            if (component instanceof  JButton){
                button=(JButton) component;
                button.setText(className);
                this.frame.designPanel.add(button);
            } else if (component instanceof  JLabel){
                label=(JLabel) component;
                label.setText(className);
                this.frame.designPanel.add(label);
            } else if (component instanceof JTextField){
                textField = (JTextField) component;
                textField.setText(className);
                this.frame.designPanel.add(textField);
            }else if (component instanceof JTextArea){
                textArea = (JTextArea) component;
                textArea.setText(className);
                this.frame.designPanel.add(textArea);
            }
            else {
                component.setName(className);
                this.frame.designPanel.add(component);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            error.setText(String.valueOf(ex));
        }
        revalidate();
    }
}
