package ec.edu.puce.SistemaElectronico.dominio;

public class CandidatoSistemaElectronico {
    private int id;
    private String nombre;
    private String partido;

    // Constructor
    public CandidatoSistemaElectronico(int id, String nombre, String partido) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
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

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
}
