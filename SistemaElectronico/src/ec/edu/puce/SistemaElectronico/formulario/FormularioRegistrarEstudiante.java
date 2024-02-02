package ec.edu.puce.SistemaElectronico.formulario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormularioRegistrarEstudiante extends JInternalFrame implements ActionListener {
    private JTextField txtNombre;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private DefaultTableModel model;
    private JTable table;
    private int numeroMesa = 1;  // Variable para asignar números de mesa
    private JTextField textField;
    private JTextField textField_1;

    public FormularioRegistrarEstudiante() {
        getContentPane().setBackground(new Color(245, 243, 148));
        setTitle("CREAR ESTUDIANTE");
        setClosable(true);
        setBounds(100, 100, 443, 385);
        getContentPane().setLayout(null);

        // Campo de texto para el nombre de la mesa
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        txtNombre.addActionListener(this);
        txtNombre.setBounds(139, 18, 231, 19);
        getContentPane().add(txtNombre);

        // Botones para Nuevo, Agregar Mesa y Cancelar
        btnGuardar = new JButton("Agregar Estudiante");
        btnGuardar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnGuardar.setBackground(new Color(85, 219, 95));
        btnGuardar.addActionListener(this);
        btnGuardar.setBounds(150, 122, 117, 25);
        getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnCancelar.setBackground(new Color(85, 219, 95));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(289, 122, 117, 25);
        getContentPane().add(btnCancelar);

        // Tabla para mostrar las mesas
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 170, 416, 163);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica al hacer clic en la tabla
            }
        });

        // Encabezados de la tabla
        model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nombre","Curso"});
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JButton btnNuvamesa = new JButton("Nuevo Estudiante");
        btnNuvamesa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNuvamesa.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnNuvamesa.setBackground(new Color(85, 219, 95));
        btnNuvamesa.setBounds(10, 122, 117, 25);
        getContentPane().add(btnNuvamesa);
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(42, 21, 49, 14);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(42, 51, 49, 14);
        getContentPane().add(lblNombre);
        
        textField = new JTextField();
        textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        textField.setBounds(139, 48, 231, 19);
        getContentPane().add(textField);
        
        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(42, 81, 49, 14);
        getContentPane().add(lblCurso);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        textField_1.setBounds(139, 78, 231, 19);
        getContentPane().add(textField_1);
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
    	    // Obtener valores de los campos
    	    String id = textField.getText();
    	    String nombre = txtNombre.getText();
    	    String curso = textField_1.getText();

    	    // Validar que los campos no estén vacíos
    	    if (id.isEmpty() || nombre.isEmpty() || curso.isEmpty()) {
    	        JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
    	        return;
    	    }

    	    // Lógica para agregar una fila a la tabla
    	    Object[] rowData = {nombre, id, curso};  // Intercambio de id y nombre
    	    model.addRow(rowData);

    	    // Limpiar campos después de agregar la fila
    	    txtNombre.setText("");
    	    textField.setText("");
    	    textField_1.setText("");
    	}
}
