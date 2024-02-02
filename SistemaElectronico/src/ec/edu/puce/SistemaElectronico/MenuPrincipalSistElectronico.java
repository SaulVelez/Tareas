package ec.edu.puce.SistemaElectronico;

import javax.swing.*;
import ec.edu.puce.SistemaElectronico.dominio.SistemaVotacion;
import ec.edu.puce.SistemaElectronico.formulario.FormularioCrearMesa;
import ec.edu.puce.SistemaElectronico.formulario.FormularioRegistrarCandidato;
import ec.edu.puce.SistemaElectronico.formulario.FormularioRegistrarEstudiante;
import ec.edu.puce.SistemaElectronico.formulario.FormularioSeleccionCurso;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipalSistElectronico extends JFrame implements ActionListener {
    private JMenuItem mntmSalir;
    private JMenuItem mntmMesas;
    private JMenuItem mntmCursos;
    private JMenuItem mntmEstudiantes;
    private JMenuItem mntmCandidatos;
    private JMenuItem mntmPadronElectoral;
    private JDesktopPane desktopPane;
    private SistemaVotacion sistemaVotacion;
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipalSistElectronico frame = new MenuPrincipalSistElectronico();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuPrincipalSistElectronico() {
        setTitle("SISTEMA VOTO ELECTRÓNICO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        mnArchivo.setBackground(new Color(237, 180, 230));
        mnArchivo.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\adjunto-archivo.png"));
        mnArchivo.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        menuBar.add(mnArchivo);

        mntmSalir = new JMenuItem("Salir");
        mntmSalir.setBackground(new Color(237, 180, 230));
        mntmSalir.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cerrar-sesion (1).png"));
        mntmSalir.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
        mnArchivo.add(mntmSalir);

        JMenu mnAdministracion = new JMenu("Administración");
        mnAdministracion.setBackground(new Color(237, 180, 230));
        mnAdministracion.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\trabajo-en-equipo.png"));
        mnAdministracion.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        menuBar.add(mnAdministracion);

        mntmMesas = new JMenuItem("Mesas");
        mntmMesas.setBackground(new Color(237, 180, 230));
        mntmMesas.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\mesa-circular.png"));
        mntmMesas.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
        mnAdministracion.add(mntmMesas);

        mntmCursos = new JMenuItem("Cursos");
        mntmCursos.setBackground(new Color(237, 180, 230));
        mntmCursos.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\aula.png"));
        mntmCursos.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
        mnAdministracion.add(mntmCursos);

        mntmEstudiantes = new JMenuItem("Estudiantes");
        mntmEstudiantes.setBackground(new Color(237, 180, 230));
        mntmEstudiantes.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\estudiantes.png"));
        mntmEstudiantes.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
        mnAdministracion.add(mntmEstudiantes);

        mntmCandidatos = new JMenuItem("Candidatos");
        mntmCandidatos.setBackground(new Color(0, 255, 255));
        mntmCandidatos.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\candidato.png"));
        mntmCandidatos.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
        mnAdministracion.add(mntmCandidatos);

        JMenu mnReportes = new JMenu("Reportes");
        mnReportes.setBackground(new Color(237, 180, 230));
        mnReportes.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\reporte.png"));
        mnReportes.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        menuBar.add(mnReportes);

        mntmPadronElectoral = new JMenuItem("Padrón Electoral");
        mntmPadronElectoral.setBackground(new Color(237, 180, 230));
        mntmPadronElectoral.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\urna-electoral (2).png"));
        mntmPadronElectoral.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
        mnReportes.add(mntmPadronElectoral);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(169, 234, 243));
        setContentPane(desktopPane);

        sistemaVotacion = new SistemaVotacion();

        mntmSalir.addActionListener(this);
        mntmMesas.addActionListener(this);
        mntmCursos.addActionListener(this);
        mntmEstudiantes.addActionListener(this);
        mntmCandidatos.addActionListener(this);
        mntmPadronElectoral.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mntmSalir) {
            dispose();
        } else if (e.getSource() == mntmMesas) {
            abrirFormularioCrearMesa();
        } else if (e.getSource() == mntmCursos) {
            abrirFormularioSeleccionCurso();
        } else if (e.getSource() == mntmEstudiantes) {
        	abrirFormularioRegistrarEstudiante();
        } else if (e.getSource() == mntmCandidatos) {
            abrirFormularioRegistrarCandidato();
        } else if (e.getSource() == mntmPadronElectoral) {
            sistemaVotacion.imprimirPadronElectoral();
        }
    }

    private void abrirFormularioSeleccionCurso() {
        FormularioSeleccionCurso formularioCurso = new FormularioSeleccionCurso();
        desktopPane.add(formularioCurso);
        formularioCurso.setVisible(true);
    }

    private void abrirFormularioCrearMesa() {
        FormularioCrearMesa formulario = new FormularioCrearMesa();
        desktopPane.add(formulario);
        formulario.setVisible(true);
    }
    
    private void abrirFormularioRegistrarEstudiante() {
        FormularioRegistrarEstudiante formulario = new FormularioRegistrarEstudiante();
        desktopPane.add(formulario);
        formulario.setVisible(true);
    }
    
    private void abrirFormularioRegistrarCandidato() {
    	FormularioRegistrarCandidato formulario = new FormularioRegistrarCandidato();
    	desktopPane.add(formulario);
    	formulario.setVisible(true);
    }
}

