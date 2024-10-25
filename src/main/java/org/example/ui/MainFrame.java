package org.example.ui;

import org.example.service.BdOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    public static void createAndShowGUI() {
        BdOperations bdUtilities = new BdOperations();

        JTextArea textArea = new JTextArea(1, 10);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Create and set up the window.
        JFrame frame = new JFrame("Crud Local");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        // Cuadro de dialogo para obtener el id
        JTextField textFieldConsulta = new JTextField(10);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Ingrese el id que desea consultar: ");

        frame.setLayout(new FlowLayout()); //para establecer un gestor de diseño

        CaptureRow insertRow = new CaptureRow("Escriba los datos que desea registrar:", "Insertar");
        CaptureRow deleteRow = new CaptureRow("Ingrese el id que desea eliminar: ", "Eliminar");
        CaptureRow updateRow = new CaptureRow("Ingrese el registro que se va a actualizar: ", "Actualizar");

        JButton b1 = new JButton("Consultar");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acciones a realizar cuando se hace clic en el botón
                String id = textFieldConsulta.getText();
                textArea.append(bdUtilities.obtenerRegistro(Integer.parseInt(id)));
                System.out.println(bdUtilities.obtenerRegistro(Integer.parseInt(id)));
            }
        });

        // Consultar
        frame.getContentPane().add(label);
        frame.getContentPane().add(textFieldConsulta);
        frame.getContentPane().add(b1);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        insertRow.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = insertRow.getTextField().getText().split(",");
                String id = data[0];
                String name = data[1];
                bdUtilities.insert(Integer.parseInt(id), name);
                JOptionPane.showMessageDialog(null, "El registro se insertó correctamente");
            }
        });

        deleteRow.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = deleteRow.getTextField().getText();
                bdUtilities.eliminarRegistro(Integer.parseInt(id));
                JOptionPane.showMessageDialog(null, "El registro con id:" + id + "se eliminó correctamente");
            }
        });

        updateRow.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = updateRow.getTextField().getText().split(",");
                String id = data[0];
                String name = data[1];
                bdUtilities.update(Integer.parseInt(id), name);
                JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente");
            }
        });

        frame.getContentPane().add(insertRow);
        frame.getContentPane().add(deleteRow);
        frame.getContentPane().add(updateRow);

        frame.setLocationRelativeTo(null);
        //Display the window.
        frame.setVisible(true);
    }
}
