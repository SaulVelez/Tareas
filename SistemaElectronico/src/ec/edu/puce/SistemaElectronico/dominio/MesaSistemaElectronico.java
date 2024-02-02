package ec.edu.puce.SistemaElectronico.dominio;

import java.util.List;

public class MesaSistemaElectronico {
    private int numero;
    private List<EstudianteSistemaElectronico> estudiantes;
    private int escritorio;

    // Constructor
    public MesaSistemaElectronico(int numero, List<EstudianteSistemaElectronico> estudiantes) {
        this.numero = numero;
        this.estudiantes = estudiantes;
        this.escritorio = escritorio;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<EstudianteSistemaElectronico> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteSistemaElectronico> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    public int getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(int escritorio) {
        this.escritorio = escritorio;
    }
    
}
