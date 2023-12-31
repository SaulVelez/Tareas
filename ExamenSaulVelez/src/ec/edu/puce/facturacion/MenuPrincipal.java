package ec.edu.puce.facturacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FrmCliente frmCliente;
	private FrmProducto frmProducto;
	private FrmFacturar frmFacturar;
	private JDesktopPane desktopPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		setTitle("Sistema de facturación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 454);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(253, 250, 189));
		menuBar.setForeground(new Color(250, 255, 198));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem btnSalir = new JMenuItem("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		mnArchivo.add(btnSalir);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem btnNuevoCliente = new JMenuItem("Nuevo Cliente");
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFrmClientes();
			}
		});
		mnClientes.add(btnNuevoCliente);
		
		JMenu mnProductos = new JMenu("Productos");
		menuBar.add(mnProductos);
		
		JMenuItem btnNuevoProducto = new JMenuItem("Nuevo Producto");
		btnNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFrmProducto();
			}
		});
		mnProductos.add(btnNuevoProducto);
		
		JMenu mnFacturas = new JMenu("Facturas");
		menuBar.add(mnFacturas);
		
		JMenuItem btnFacturar = new JMenuItem("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFrmFacturar();
			}
		});
		mnFacturas.add(btnFacturar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_335641104678300");
	}
	
	private void cerrarVentana() {
		this.dispose();
	}
	
	private void abrirFrmClientes() {
		if (this.frmCliente == null) {
			this.frmCliente = new FrmCliente();
			this.desktopPane.add(frmCliente);
			this.frmCliente.setVisible(true);
		} else if (!this.frmCliente.isVisible()){
			this.frmCliente.setVisible(true);
		} else {
			this.frmCliente.toFront();
		}
	}
	
	private void abrirFrmProducto() {
		if (this.frmProducto == null) {
			this.frmProducto = new FrmProducto();
			this.desktopPane.add(frmProducto);
			this.frmProducto.setVisible(true);
		} else if (!this.frmProducto.isVisible()){
			this.frmProducto.setVisible(true);
		} else {
			this.frmProducto.toFront();
		}
	}
	
	private void abrirFrmFacturar() {
		if (this.frmFacturar == null || this.frmFacturar.isClosed()) {
			this.frmFacturar = new FrmFacturar();
			this.desktopPane.add(frmFacturar);
			this.frmFacturar.setVisible(true);
		}  else {
			this.frmFacturar.toFront();
		}
	}
	
}
