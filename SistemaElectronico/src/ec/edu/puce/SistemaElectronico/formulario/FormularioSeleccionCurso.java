package ec.edu.puce.SistemaElectronico.formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioSeleccionCurso extends JInternalFrame implements ActionListener {
    private JComboBox<String> comboBoxCursos;
    private JButton btnAceptar;

    public FormularioSeleccionCurso() {
        setTitle("Seleccionar Curso");
        setClosable(true); // Permitir cerrar la ventana interna
        setSize(300, 150);
        setLocation(50, 50);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel lblEspacio = new JLabel();
        panel.add(lblEspacio);

        JLabel lblTitulo = new JLabel("Seleccione un curso:");
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\colegio.png"));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitulo);

        String[] cursos = {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo", "Octavo", "Noveno", "Décimo", "Primero de Bachillerato", "Segundo de Bachillerato", "Tercero de Bachillerato"};
        comboBoxCursos = new JComboBox<>(cursos);
        comboBoxCursos.setModel(new DefaultComboBoxModel<>(cursos));
        panel.add(comboBoxCursos);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\aceptar.png"));
        btnAceptar.addActionListener(this);
        btnAceptar.setPreferredSize(new Dimension(100, 30));
        panel.add(btnAceptar);

        getContentPane().add(panel);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            String cursoSeleccionado = (String) comboBoxCursos.getSelectedItem();
            mostrarMensaje(cursoSeleccionado);
        }
    }

    private void mostrarMensaje(String curso) {
        JOptionPane.showMessageDialog(this, "Curso seleccionado: " + curso);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioSeleccionCurso());
    }
}
