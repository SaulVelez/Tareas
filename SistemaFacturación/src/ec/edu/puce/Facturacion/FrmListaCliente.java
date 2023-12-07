package ec.edu.puce.Facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class FrmListaCliente extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    // Agrega un constructor que acepta un DefaultTableModel
    public FrmListaCliente(DefaultTableModel modeloTabla) {
        setBounds(100, 100, 519, 617);

        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setModel(modeloTabla); // Utiliza el modelo de tabla proporcionado
        scrollPane.setViewportView(table);
    }

}


