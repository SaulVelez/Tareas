package ec.edu.puce.Facturacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenido;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTable table;
	private Cliente cliente = new Cliente();
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setBounds(100, 100, 425, 583);
		getContentPane().setLayout(null);
		
		JPanel panelContenido = new JPanel();
		panelContenido.setLayout(null);
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelContenido.setBounds(0, 0, 540, 684);
		getContentPane().add(panelContenido);
		
		JLabel lblNewLabel = new JLabel("Cédula");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 57, 29);
		panelContenido.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 51, 57, 29);
		panelContenido.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 91, 57, 14);
		panelContenido.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 116, 57, 29);
		panelContenido.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 156, 57, 29);
		panelContenido.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 196, 57, 29);
		panelContenido.add(lblNewLabel_5);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(103, 16, 121, 20);
		panelContenido.add(txtCedula);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(103, 56, 121, 20);
		panelContenido.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(103, 89, 121, 20);
		panelContenido.add(txtApellidos);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(103, 121, 121, 20);
		panelContenido.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(103, 161, 121, 20);
		panelContenido.add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 201, 121, 20);
		panelContenido.add(txtEmail);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCedula.setText(" ");
				txtNombres.setText(" ");
				txtApellidos.setText(" ");
				txtDireccion.setText(" ");
				txtTelefono.setText(" ");
				txtEmail.setText(" ");
			}
		});
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevo.setBounds(20, 236, 96, 23);
		panelContenido.add(btnNuevo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(308, 236, 96, 23);
		panelContenido.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(166, 236, 96, 23);
		panelContenido.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 284, 384, 257);
		panelContenido.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00E9dula", "Nombres", "Apellidos", "Direccion", "Telefono", "Email"
			}
		));
		scrollPane.setViewportView(table);
		model=(DefaultTableModel)table.getModel();

	}
	private void crearCliente() {
		cliente.setCedula(txtCedula.getText());
		cliente.setNombre(txtNombres.getText());
		cliente.setApellido(txtApellidos.getText());
		cliente.setDireccion(txtDireccion.getText());
		cliente.setTelefono(txtTelefono.getText());
		cliente.setEmail(txtEmail.getText());
		agregarFila();
			
	}

	private void agregarFila() {
		Object[] fila=new Object[6];
		fila[0]=cliente.getCedula();
		fila[1]=cliente.getNombre();
		fila[2]=cliente.getApellido();
		fila[3]=cliente.getDireccion();
		fila[4]=cliente.getTelefono();
		fila[5]=cliente.getEmail();
		model.addRow(fila);
	}
	public void cerrarVentana() {
		this.dispose();
	}
	public DefaultTableModel getModeloTabla() {
	    return model;
	}
}
