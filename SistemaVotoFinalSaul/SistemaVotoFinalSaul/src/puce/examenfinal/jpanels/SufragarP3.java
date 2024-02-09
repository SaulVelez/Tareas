package puce.examenfinal.jpanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class SufragarP3 extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
    public SufragarP3() {
		getContentPane().setBackground(new Color(25, 196, 196));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		
		JButton btnSALIR = new JButton("SALIR");
		btnSALIR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSALIR.setBounds(0, 241, 434, 29);
		btnSALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnSALIR);
		
		JLabel lblGracias = new JLabel("¡Gracias por votar!");
		lblGracias.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGracias.setBounds(131, 76, 249, 70);
		getContentPane().add(lblGracias);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
