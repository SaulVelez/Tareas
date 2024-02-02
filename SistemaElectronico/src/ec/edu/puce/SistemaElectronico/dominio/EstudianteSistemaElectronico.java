package ec.edu.puce.SistemaElectronico.dominio;

public class EstudianteSistemaElectronico {
    private int id;
    private String nombre;
    private String curso;

    // Constructor
    public EstudianteSistemaElectronico(int id, String nombre, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
