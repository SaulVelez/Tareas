package puce.examenfinal.clases;
public class Estudiante {
    
    private String nombreEstudiante;
    private String cedulaEstudiante;
    private Curso curso;
    private Mesa mesaDelEstudiante;
    private Candidato candidatoVotado; // Nuevo atributo para almacenar el candidato por el que votó

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Mesa getMesaDelEstudiante() {
        return mesaDelEstudiante;
    }

    public void setMesaDelEstudiante(Mesa mesaDelEstudiante) {
        this.mesaDelEstudiante = mesaDelEstudiante;
    }

    public Candidato getCandidatoVotado() {
        return candidatoVotado;
    }

    public void setCandidatoVotado(Candidato candidatoVotado) {
        this.candidatoVotado = candidatoVotado;
    }
}
