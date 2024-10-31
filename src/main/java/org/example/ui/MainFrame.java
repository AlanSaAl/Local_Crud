package org.example.ui;

import org.example.service.BdOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    public static void createAndShowGUI() {
        BdOperations bdUtilities = new BdOperations();

        JTextArea dataResultTextArea = new JTextArea(1, 10); // por que se hace primero el textArea y luego se le pasa al scrollPane?
        JScrollPane scrollPane = new JScrollPane(dataResultTextArea);

        //Create and set up the window.
        JFrame frame = new JFrame("Crud Local");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        frame.setLayout(new FlowLayout()); // Establecer gestor de diseño

        CaptureRow getRow = new CaptureRow("Ingrese el id que desea consultar: ", "Consultar");
        CaptureRow insertRow = new CaptureRow("Escriba los datos que desea registrar:", "Insertar");
        CaptureRow deleteRow = new CaptureRow("Ingrese el id que desea eliminar: ", "Eliminar");
        CaptureRow updateRow = new CaptureRow("Ingrese el registro que se va a actualizar: ", "Actualizar");

        getRow.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = getRow.getTextField().getText();
                dataResultTextArea.append(bdUtilities.obtenerRegistro(Integer.parseInt(id)));
            }
        });

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

        frame.getContentPane().add(getRow);
        frame.getContentPane().add(insertRow);
        frame.getContentPane().add(deleteRow);
        frame.getContentPane().add(updateRow);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        //Display the window.
        frame.setVisible(true);
    }
}
