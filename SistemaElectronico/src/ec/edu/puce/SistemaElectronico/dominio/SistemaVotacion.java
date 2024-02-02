package ec.edu.puce.SistemaElectronico.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;

public class SistemaVotacion {
    private List<EstudianteSistemaElectronico> estudiantes;
    private List<CandidatoSistemaElectronico> candidatos;
    private List<MesaSistemaElectronico> mesas;
    private JDesktopPane escritorio;  // Cambiado a JDesktopPane

    // Constructor
    public SistemaVotacion() {
        this.estudiantes = new ArrayList<>();
        this.candidatos = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.escritorio = new JDesktopPane();  // Instancia del escritorio
    }

    // Métodos para agregar estudiantes, candidatos, mesas, etc.
    public void agregarEstudiante(EstudianteSistemaElectronico estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarCandidato(CandidatoSistemaElectronico candidato) {
        candidatos.add(candidato);
    }

    public void agregarMesa(MesaSistemaElectronico mesa) {
        mesas.add(mesa);
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    // Otros métodos según sea necesario...

    // Método para imprimir el padrón electoral
    public void imprimirPadronElectoral() {
        System.out.println("Padrón Electoral:");
        for (EstudianteSistemaElectronico estudiante : estudiantes) {
            System.out.println("ID: " + estudiante.getId() + " - Nombre: " + estudiante.getNombre());
        }
    }
}
