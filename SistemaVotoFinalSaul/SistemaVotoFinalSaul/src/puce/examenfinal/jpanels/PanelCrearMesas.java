package puce.examenfinal.jpanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import puce.examenfinal.clases.Mesa;

public class PanelCrearMesas extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombreMesa;
    private JTable table;
    private DefaultTableModel model;
    private List<Mesa> mesas;

    public PanelCrearMesas(List<Mesa> mesas) {
    	getContentPane().setBackground(new Color(25, 196, 196));
    	setClosable(true);
        this.mesas = mesas;
        initComponents();
    }

    private void initComponents() {
        setTitle("CREAR MESAS");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(null);

        JLabel lblNombreMesa = new JLabel("Nombre de la Mesa:");
        lblNombreMesa.setBounds(29, 36, 150, 20);
        getContentPane().add(lblNombreMesa);

        txtNombreMesa = new JTextField();
        txtNombreMesa.setBounds(147, 36, 150, 20);
        getContentPane().add(txtNombreMesa);
        txtNombreMesa.setColumns(10);

        JButton btnAgregarMesa = new JButton("Agregar Mesa");
        btnAgregarMesa.setBounds(307, 35, 150, 23);
        btnAgregarMesa.addActionListener(this);
        getContentPane().add(btnAgregarMesa);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 83, 500, 267);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Mesa"});
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("Limpiar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				limpiarCampos();

        	}
        });
        btnNewButton.setBounds(474, 35, 89, 23);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("CREAR MESAS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(239, 11, 97, 14);
        getContentPane().add(lblNewLabel);

        // Mostrar las mesas ya guardadas en la tabla al inicializar el panel
        mostrarMesas();
    }

    private void mostrarMesas() {
        for (Mesa mesa : mesas) {
            Object[] row = {mesa.getnombreMesa()};
            model.addRow(row);
        }
    }

    private void limpiarCampos() {
		txtNombreMesa.setText("");
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar Mesa")) {
            String nombreMesa = txtNombreMesa.getText();
            Mesa nuevaMesa = new Mesa();
            nuevaMesa.setnombreMesa(nombreMesa);
            mesas.add(nuevaMesa);
            Object[] row = {nombreMesa};
            model.addRow(row);
            txtNombreMesa.setText("");
        }
    }
}


