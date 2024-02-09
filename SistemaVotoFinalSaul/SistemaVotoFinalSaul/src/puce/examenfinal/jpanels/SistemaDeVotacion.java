package puce.examenfinal.jpanels;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import puce.examenfinal.clases.Candidato;
import puce.examenfinal.clases.Curso;
import puce.examenfinal.clases.Estudiante;
import puce.examenfinal.clases.Mesa;

public class SistemaDeVotacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List <Candidato> candidatos;
	private List <Curso> cursos;
	private List <Estudiante> estudiantes;
	private List<Estudiante> estudiantesMesa;
	private List <Mesa> mesas;
	
    private Map<Estudiante, Mesa> asignacionesDeMesa;
    private Map<String, Candidato> votosPorEstudiante;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaDeVotacion frame = new SistemaDeVotacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SistemaDeVotacion() {
		setBackground(new Color(0, 255, 255));
		
		candidatos = new ArrayList<>(); 
		cursos = new ArrayList<>(); 
		estudiantes = new ArrayList<>();
		mesas = new ArrayList<>(); 
		estudiantesMesa = new ArrayList<>();
        asignacionesDeMesa = new HashMap<>();

        this.votosPorEstudiante = new HashMap<>();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 697);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(25, 196, 196));
		menuBar.setForeground(new Color(25, 196, 196));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		mnArchivo.setBackground(new Color(0, 255, 255));
		mnArchivo.setForeground(new Color(0, 0, 0));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setBackground(new Color(0, 255, 255));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAdministracion = new JMenu("ADMINISTRACIÓN");
		mnAdministracion.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmMesas = new JMenuItem("Mesas");
		mntmMesas.setBackground(new Color(0, 255, 255));
		mntmMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PanelEleccionMesas panelEleccionMesas = new PanelEleccionMesas(mesas, estudiantes);
		        contentPane.add(panelEleccionMesas);
		        panelEleccionMesas.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmMesas);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setBackground(new Color(0, 255, 255));
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PanelCurso panelCurso = new PanelCurso(cursos);
			        contentPane.add(panelCurso);
			        panelCurso.setVisible(true);
			}
		});
		mnAdministracion.add(mntmCursos);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Estudiantes");
		mntmEstudiantes.setBackground(new Color(0, 255, 255));
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  PanelEstudiantes panelEstudiantes = new PanelEstudiantes(cursos , estudiantes);
			        contentPane.add(panelEstudiantes);
			        panelEstudiantes.setVisible(true);
				
			}
		});
		mnAdministracion.add(mntmEstudiantes);
		
		JMenuItem mntmCandidatos = new JMenuItem("Candidatos");
		mntmCandidatos.setBackground(new Color(0, 255, 255));
		mntmCandidatos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PanelCandidatos panelCandidatos = new PanelCandidatos(candidatos);
		        contentPane.add(panelCandidatos);
		        panelCandidatos.setVisible(true);
		    }
		});
		

		mnAdministracion.add(mntmCandidatos);
		
		
		mnAdministracion.add(mntmCandidatos);
		
		JMenu mnProceso = new JMenu("PROCESO");
		mnProceso.setForeground(new Color(0, 0, 0));
		menuBar.add(mnProceso);
		
		JMenuItem mntmSufragar = new JMenuItem("Sufragar");
		mntmSufragar.setBackground(new Color(0, 255, 255));
		mntmSufragar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Sufragar sufragar = new Sufragar(SistemaDeVotacion.this);
		        contentPane.add(sufragar);
		        sufragar.setVisible(true);
				
			}
		});
		mnProceso.add(mntmSufragar);
		
				
		JMenu mnReportes = new JMenu("REPORTES");
		mnReportes.setForeground(new Color(0, 0, 0));
		menuBar.add(mnReportes);
		
		JMenuItem mntmPadron = new JMenuItem("Padrón Electoral");
		mntmPadron.setBackground(new Color(0, 255, 255));
		mntmPadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPadronElectoral panelPadronElectoral = new PanelPadronElectoral(
						mesas,
						estudiantes,
						estudiantesMesa);
				contentPane.add(panelPadronElectoral);
				panelPadronElectoral.setVisible(true);
			}
		});
		mnReportes.add(mntmPadron);
		
		JMenuItem mntmResultadosGenerales = new JMenuItem("Resultados Generales");
		mntmResultadosGenerales.setBackground(new Color(0, 255, 255));
		mntmResultadosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelResultadosGenerales resultadosGenerales = new PanelResultadosGenerales(candidatos);
		        contentPane.add(resultadosGenerales);
		        resultadosGenerales.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosGenerales);
		
		JMenuItem mntmResultadosPorMesas = new JMenuItem("Resultados por Mesas");
		mntmResultadosPorMesas.setBackground(new Color(0, 255, 255));
		mntmResultadosPorMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelResultadosPorMesa resultadosMesas = new PanelResultadosPorMesa(candidatos, mesas);
		        contentPane.add(resultadosMesas);
		        resultadosMesas.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosPorMesas);
		
		JMenuItem mntmResultadosEnGrfico = new JMenuItem("Resultados en Gráfico");
		mntmResultadosEnGrfico.setBackground(new Color(0, 255, 255));
		mntmResultadosEnGrfico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelGraficos panelGraficos = new PanelGraficos(candidatos);
		        contentPane.add(panelGraficos);
		        panelGraficos.setVisible(true);
			}
		});
		mnReportes.add(mntmResultadosEnGrfico);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}

	
	void abrirSufragar2(String cedulaEstudiante) {
	    SufragarP2 sufragarP2 = new SufragarP2(this, cedulaEstudiante);
	    sufragarP2.setLocation(100, 100);
	    contentPane.add(sufragarP2);
	    sufragarP2.setVisible(true);
	}


void abrirSufragar3() {
    
    SufragarP3 sufragarP3 = new SufragarP3();

    sufragarP3.setLocation(100, 100);

    contentPane.add(sufragarP3);
    sufragarP3.setVisible(true);
}

public List<Estudiante> getEstudiantes() {
    return estudiantes;
}

public Mesa getMesaDeEstudiante(Estudiante estudiante) {
    return asignacionesDeMesa.get(estudiante);
}

public Mesa getMesaPorNombre(String nombreMesa) {
    for (Mesa mesa : mesas) {
        if (mesa.getnombreMesa().equals(nombreMesa)) {
            return mesa;
        }
    }
    return null; 
}

public void asignarMesaAEstudiante(Estudiante estudiante, Mesa mesa) {
    asignacionesDeMesa.put(estudiante, mesa);
}


public List<Candidato> getCandidatos() {
    return candidatos;
}

public void registrarVoto(String cedulaEstudiante, Candidato candidato) {
    votosPorEstudiante.put(cedulaEstudiante, candidato);
}

public boolean estudianteYaVoto(String cedulaEstudiante) {
    return votosPorEstudiante.containsKey(cedulaEstudiante);
}

public Candidato getCandidatoVotadoPorEstudiante(String cedulaEstudiante) {
    return votosPorEstudiante.get(cedulaEstudiante);
}

}

