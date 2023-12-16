package ec.edu.puce.Facturacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class FrmCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private JButton btnGuardar;
	private JTable table;
	private int indiceSeleccionado = -1;
	private DefaultTableModel model;
	private boolean AgregarButton=true;
	private JButton btnEliminar;
	

	
	public FrmCliente() {
		setTitle("Agregar Clientes");
		setBounds(100, 100, 584, 500);
		getContentPane().setLayout(null);
		
		JLabel lblCedula = new JLabel("Cédula");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCedula.setBounds(39, 26, 118, 14);
		getContentPane().add(lblCedula);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombres.setBounds(39, 65, 88, 14);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellidos.setBounds(39, 104, 88, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Télefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(39, 143, 88, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(39, 182, 88, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(39, 221, 103, 14);
		getContentPane().add(lblDireccion);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(119, 25, 260, 20);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(119, 64, 260, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(119, 103, 260, 20);
		getContentPane().add(txtApellidos);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(119, 142, 260, 20);
		getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(119, 181, 260, 20);
		getContentPane().add(txtEmail);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(119, 220, 260, 20);
		getContentPane().add(txtDireccion);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNuevo.setBounds(45, 274, 90, 23);
		getContentPane().add(btnNuevo);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
				limpiarCampos();
			}
		});
		btnGuardar.setBounds(180, 274, 90, 23);
		getContentPane().add(btnGuardar);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		btnCancelar.setBounds(446, 274, 89, 23);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 308, 490, 140);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
            	try {
            		if (!event.getValueIsAdjusting()) {
                       	int selectedRow = table.getSelectedRow();
                            cargarDatos();
                            System.out.println("Selected Row: " + selectedRow);	
            		}
            	} catch(IndexOutOfBoundsException e) {
            		limpiarCampos();
            	}
                
            }
        });
		table.setBackground(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00E9dula", "Nombres", "Apellidos", "Tel\u00E9fono", "Email", "Direcci\u00F3n"
			}
		));
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
			}
		});
		btnEliminar.setBounds(315, 274, 89, 23);
		getContentPane().add(btnEliminar);
		model = (DefaultTableModel) table.getModel();

	}
	
	private void limpiarCampos() {
		this.txtCedula.setText("");
		this.txtNombres.setText("");
		this.txtApellidos.setText("");
		this.txtTelefono.setText("");
		this.txtEmail.setText("");
		this.txtDireccion.setText("");
		this.AgregarButton = true;
		intercambiarBotones();
	}
	
	private void cerrarVentana() {
		this.setVisible(false);
		table.clearSelection();
	}
	
	private void crearCliente() {
		Cliente cliente = new Cliente(
				);
		clientes.add(cliente);
		agregarFila(cliente);
	}
	
	private void agregarFila(Cliente cliente) {
		Object[] fila=new Object[6];
		fila[0]= cliente.getCedula();
		fila[1]= cliente.getNombre();
		fila[2]= cliente.getApellido();
		fila[3]= cliente.getTelefono();
		fila[4]= cliente.getEmail();
		fila[5]= cliente.getDireccion();
		this.model.addRow(fila);
	}
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	private void elegirIndice(int indice) {
		setIndiceSeleccionado(indice);
	}
	private void cargarDatos() {
		elegirIndice(table.getSelectedRow());
		this.txtCedula.setText(clientes.get(this.indiceSeleccionado).getCedula());
		this.txtNombres.setText(clientes.get(this.indiceSeleccionado).getNombre());
		this.txtApellidos.setText(clientes.get(this.indiceSeleccionado).getApellido());
		this.txtTelefono.setText(clientes.get(this.indiceSeleccionado).getTelefono());
		this.txtEmail.setText(clientes.get(this.indiceSeleccionado).getEmail());
		this.txtDireccion.setText(clientes.get(this.indiceSeleccionado).getDireccion());
		this.AgregarButton = false;
		intercambiarBotones();
		this.btnEliminar.setEnabled(true);
	}
	
	private void editarDatos() {
		elegirIndice(table.getSelectedRow());
		clientes.get(indiceSeleccionado).setCedula(this.txtCedula.getText());
		clientes.get(indiceSeleccionado).setNombre(this.txtNombres.getText());
		clientes.get(indiceSeleccionado).setApellido(this.txtApellidos.getText());
		clientes.get(indiceSeleccionado).setTelefono(this.txtTelefono.getText());
		clientes.get(indiceSeleccionado).setEmail(this.txtEmail.getText());
		clientes.get(indiceSeleccionado).setDireccion(this.txtDireccion.getText());
		int guardarIndice = indiceSeleccionado;
		Object[] fila=new Object[6];
		fila[0]= clientes.get(indiceSeleccionado).getCedula();
		fila[1]= clientes.get(indiceSeleccionado).getNombre();
		fila[2]= clientes.get(indiceSeleccionado).getApellido();
		fila[3]= clientes.get(indiceSeleccionado).getTelefono();
		fila[4]= clientes.get(indiceSeleccionado).getEmail();
		fila[5]= clientes.get(indiceSeleccionado).getDireccion();
		this.model.removeRow(guardarIndice);
		this.model.addRow(fila);
		this.btnEliminar.setEnabled(false);
	}
	
	private void eliminarCliente() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este cliente?", "Confirme", JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION) {
			elegirIndice(table.getSelectedRow());
			System.out.println(table.getSelectedRow());
			System.out.println(table.getRowCount());
			System.out.println(clientes.size());
			
	        if (this.indiceSeleccionado != -1) {
	            
	            clientes.remove(this.indiceSeleccionado);
	            
	            model.removeRow(this.indiceSeleccionado);
	        }
	        this.btnEliminar.setEnabled(false);
		}
        
    }


	public int getIndiceSeleccionado() {
		return indiceSeleccionado;
	}

	public void setIndiceSeleccionado(int i) {
		this.indiceSeleccionado = i;
	}
	
	private void intercambiarBotones() {
		
		if (AgregarButton) {
			btnGuardar.setText("Guardar");
			for (ActionListener listener : btnGuardar.getActionListeners()) {
				btnGuardar.removeActionListener(listener);
			}
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearCliente();
					limpiarCampos();
				}
			});
			
		} else {
			btnGuardar.setText("Actualizar");
			for (ActionListener listener : btnGuardar.getActionListeners()) {
				btnGuardar.removeActionListener(listener);
			}
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editarDatos();
					limpiarCampos();
				}
			});
		}
	}
	
}