package ec.edu.puce.Facturacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FrmCliente frmCliente;
	private JDesktopPane desktopPane;
	private List<Cliente> clientes;
	
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
		setTitle("Sistema de Facturación.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 614);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(222, 228, 197));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(getDefaultCloseOperation());;
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear Clientes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (frmCliente == null || frmCliente.isClosed()) {
		            frmCliente = new FrmCliente();
		            desktopPane.add(frmCliente);
		            frmCliente.setVisible(true);
		        } else {
		            frmCliente.toFront();
		        }
		    }
		});
		
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Lista de Clientes");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        mostrarListaClientes();
		    }
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Productos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Crear Producto");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lista Productos");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Redes Sociales");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Facebook");
		mntmNewMenuItem_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ec/edu/puce/Facturacion/imagenes/Facebook.png")));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_64221350094100");
		desktopPane.setLayout(null);
	}
	private void mostrarListaClientes() {
	    FrmListaCliente frmListaCliente = new FrmListaCliente(clientes);
	    desktopPane.add(frmListaCliente);
	    frmListaCliente.setVisible(true);
	}
}
