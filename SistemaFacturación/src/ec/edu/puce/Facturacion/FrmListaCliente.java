package ec.edu.puce.Facturacion;

import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.util.List;

public class FrmListaCliente extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    // Agrega un constructor que acepta un DefaultTableModel
    public FrmListaCliente(List<Cliente> clientes) {
        setBounds(100, 100, 519, 617);

        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setModel((TableModel) clientes); // Utiliza el modelo de la tabla proporcionado
        scrollPane.setViewportView(table);
    }

}


