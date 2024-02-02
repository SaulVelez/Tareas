package ec.edu.puce.SistemaElectronico.formulario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormularioCrearMesa extends JInternalFrame implements ActionListener {
    private JTextField txtNombre;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private DefaultTableModel model;
    private JTable table;
    private int numeroMesa = 1;  // Variable para asignar números de mesa

    public FormularioCrearMesa() {
        getContentPane().setBackground(new Color(245, 243, 148));
        setClosable(true);
        setTitle("CREAR MESA");
        setBounds(100, 100, 443, 385);
        getContentPane().setLayout(null);

        // Campo de texto para el nombre de la mesa
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        txtNombre.addActionListener(this);
        txtNombre.setBounds(177, 37, 231, 19);
        getContentPane().add(txtNombre);

        // Botones para Nuevo, Agregar Mesa y Cancelar
        btnGuardar = new JButton("Agregar Mesa");
        btnGuardar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnGuardar.setBackground(new Color(85, 219, 95));
        btnGuardar.addActionListener(this);
        btnGuardar.setBounds(157, 99, 117, 25);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnCancelar.setBackground(new Color(85, 219, 95));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(291, 99, 117, 25);
        getContentPane().add(btnCancelar);

        // Tabla para mostrar las mesas
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 148, 416, 163);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica al hacer clic en la tabla
            }
        });

        // Encabezados de la tabla
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Nombre de la Mesa", "Número de Mesa"});
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JButton btnNuvamesa = new JButton("Nueva Mesa");
        btnNuvamesa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNuvamesa.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnNuvamesa.setBackground(new Color(85, 219, 95));
        btnNuvamesa.setBounds(12, 100, 117, 25);
        getContentPane().add(btnNuvamesa);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == txtNombre || e.getSource() == btnGuardar) {
            agregarFila();
        } else if (e.getSource() == btnCancelar) {
            // Lógica para cancelar
        }
    }

    private void agregarFila() {
        // Lógica para agregar una fila a la tabla
        String nombreMesa = txtNombre.getText();
        model.addRow(new Object[]{nombreMesa, numeroMesa});
        txtNombre.setText("");
        numeroMesa++;  // Incrementar el número de mesa para la siguiente
    }
}
