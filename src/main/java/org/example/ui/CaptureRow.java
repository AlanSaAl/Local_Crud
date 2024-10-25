package org.example.ui;

import javax.swing.*;

public class CaptureRow extends JPanel {
    JLabel label;
    JTextField textField;
    JButton button;

    public CaptureRow(String description, String buttonLabel) {
        this.label = new JLabel(description);
        this.textField = new JTextField(10);
        this.button = new JButton(buttonLabel);

        add(label);
        add(textField);
        add(button);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }
}
