import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class BocaUrna {

    private static List<String> candidatos = new ArrayList<>();
    private static JPanel panelCandidatosAdmin;
    private static JPanel panelCandidatosUsuario;
    private static JPanel panelEstadisticas;
    private static JTextField txtNombreCandidato;
    private static JTextField txtPartidoCandidato;
    private static String pinAdmin = "1234";

    private static Map<String, Map<String, Integer>> votosPorProvincia = new HashMap<>();

    private static Map<String, Color> coloresCandidatos = new HashMap<>();
    private static Map<String, Integer> votosPorCandidato = new HashMap<>();

    private static List<String> provincias = Arrays.asList(
            "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos",
            "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza",
            "Pichincha", "Santa Elena", "Santo Domingo", "Sucumbíos", "Tungurahua", "Zamora Chinchipe");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Boca de Urnas");

            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panelPrincipal = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JTabbedPane tabbedPane = new JTabbedPane();

            JPanel panelAdmin = crearPanelAdmin();
            JPanel panelUsuario = crearPanelUsuario();

            tabbedPane.addTab("Admin", null, panelAdmin, "Panel de Administradores");
            tabbedPane.addTab("Usuario", null, panelUsuario, "Panel de Usuarios");

            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            panelPrincipal.add(tabbedPane, gbc);

            ventana.getContentPane().add(panelPrincipal);

            ventana.setMinimumSize(new Dimension(400, 400));
            ventana.pack();

            ventana.setLocationRelativeTo(null);

            ventana.setVisible(true);
        });
    }

    private static JPanel crearPanelAdmin() {
        JPanel panelAdmin = new JPanel(new BorderLayout());

        JLabel labelTitulo = new JLabel("Agregar Candidatos");
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelAdmin.add(labelTitulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel();
        panelCandidatosAdmin = new JPanel();
        panelEstadisticas = new JPanel();

        txtNombreCandidato = new JTextField(15);
        txtPartidoCandidato = new JTextField(15);

        JButton btnAgregarCandidato = new JButton("Agregar Candidato");
        btnAgregarCandidato.addActionListener(e -> agregarCandidato());

        JButton btnVerResultados = new JButton("Ver Resultados");
        btnVerResultados.addActionListener(e -> mostrarResultados());

        panelFormulario.add(txtNombreCandidato);
        panelFormulario.add(txtPartidoCandidato);
        panelFormulario.add(btnAgregarCandidato);

        panelAdmin.add(panelFormulario, BorderLayout.CENTER);
        panelAdmin.add(panelCandidatosAdmin, BorderLayout.SOUTH);
        panelAdmin.add(panelEstadisticas, BorderLayout.EAST);

        return panelAdmin;
    }

    private static JPanel crearPanelUsuario() {
        JPanel panelUsuario = new JPanel(new BorderLayout());

        JLabel labelTitulo = new JLabel("Votar por Candidato");
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelUsuario.add(labelTitulo, BorderLayout.NORTH);

        JPanel panelVotacion = new JPanel();
        panelCandidatosUsuario = new JPanel();
        panelEstadisticas = new JPanel();

        JButton btnAccesoAdmin = new JButton("Acceder como Administrador");
        btnAccesoAdmin.addActionListener(e -> solicitarPIN());

        panelUsuario.add(btnAccesoAdmin, BorderLayout.CENTER);
        panelUsuario.add(panelVotacion, BorderLayout.CENTER);
        panelUsuario.add(panelCandidatosUsuario, BorderLayout.SOUTH);
        panelUsuario.add(panelEstadisticas, BorderLayout.EAST);

        return panelUsuario;
    }

    private static void solicitarPIN() {
        String ingresoPIN = JOptionPane.showInputDialog(null, "Ingrese el PIN de administrador:", "Acceso de Administrador", JOptionPane.PLAIN_MESSAGE);
        if (ingresoPIN != null && ingresoPIN.equals(pinAdmin)) {
            JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, panelCandidatosUsuario);
            tabbedPane.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "PIN incorrecto. Acceso denegado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void agregarCandidato() {
        String nombre = txtNombreCandidato.getText();
        String partido = txtPartidoCandidato.getText();

        if (!nombre.isEmpty() && !partido.isEmpty()) {
            String candidato = nombre + " (" + partido + ")";
            candidatos.add(candidato);
            coloresCandidatos.put(candidato, obtenerColorAleatorio());
            votosPorCandidato.put(candidato, 0);
            inicializarVotosPorProvincia(candidato);
            agregarCardCandidatoAdmin(candidato);
            agregarCardCandidatoUsuario(candidato);

            txtNombreCandidato.setText("");
            txtPartidoCandidato.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa el nombre y el partido del candidato.");
        }
    }

    private static void inicializarVotosPorProvincia(String candidato) {
        for (String provincia : provincias) {
            votosPorProvincia.computeIfAbsent(candidato, k -> new HashMap<>()).put(provincia, 0);
        }
    }

    private static void agregarCardCandidatoAdmin(String candidato) {
        JPanel cardCandidato = new JPanel();
        JButton btnCandidato = new JButton(candidato);
        btnCandidato.setBackground(coloresCandidatos.get(candidato));
        cardCandidato.add(btnCandidato);
        panelCandidatosAdmin.add(cardCandidato);
        panelCandidatosAdmin.revalidate();
    }

    private static void agregarCardCandidatoUsuario(String candidato) {
        JPanel cardCandidato = new JPanel();
        JButton btnVotar = new JButton("Votar");
        btnVotar.addActionListener(e -> votarCandidato(candidato));
        cardCandidato.add(new JLabel(candidato));
        cardCandidato.add(btnVotar);
        panelCandidatosUsuario.add(cardCandidato);
        panelCandidatosUsuario.revalidate();
    }

    private static void mostrarResultados() {
        actualizarEstadisticasAdmin();
        actualizarEstadisticasPorProvincia();
        mostrarLider();
        agregarBotonFinalizar();
    }

    private static void votarCandidato(String candidato) {
        String provincia = JOptionPane.showInputDialog(null, "Ingrese la provincia:", "Votar por Provincia", JOptionPane.PLAIN_MESSAGE);
        if (provincia != null && !provincia.isEmpty() && provincias.contains(provincia)) {
            votosPorCandidato.put(candidato, votosPorCandidato.get(candidato) + 1);
            votarCandidatoPorProvincia(candidato, provincia);
            JOptionPane.showMessageDialog(null, "Votaste por: " + candidato + " en la provincia de " + provincia);
            actualizarEstadisticasAdmin();
            actualizarEstadisticasPorProvincia();
            mostrarLider();
            agregarBotonFinalizar();
        } else {
            JOptionPane.showMessageDialog(null, "Provincia incorrecta. Introduce una provincia válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void votarCandidatoPorProvincia(String candidato, String provincia) {
        votosPorProvincia.get(candidato).put(provincia, votosPorProvincia.get(candidato).get(provincia) + 1);
    }

    private static void actualizarEstadisticasAdmin() {
        actualizarEstadisticas("Estadísticas Descriptivas", votosPorCandidato, panelEstadisticas);
    }

    private static void actualizarEstadisticasPorProvincia() {
        for (String provincia : provincias) {
            Map<String, Integer> datosProvincia = votosPorProvincia.get(provincia);

            if (datosProvincia != null) {
                actualizarEstadisticas("Estadísticas Descriptivas por Provincia (" + provincia + ")", datosProvincia, panelEstadisticas);
            } else {
                System.out.println("Data not found for province: " + provincia);
            }
        }
    }

    private static void actualizarEstadisticas(String titulo, Map<String, ?> datos, Container contenedor) {
        contenedor.removeAll();

        JLabel labelEstadisticas = new JLabel(titulo);
        JTextArea areaEstadisticas = new JTextArea();
        areaEstadisticas.setEditable(false);

        if (datos != null) {
            for (String clave : datos.keySet()) {
                int votos = (int) datos.get(clave);
                areaEstadisticas.append(clave + ": " + votos + " votos\n");
            }
        } else {
            System.out.println("Data is null for statistics: " + titulo);
        }

        contenedor.add(labelEstadisticas, BorderLayout.NORTH);
        contenedor.add(new JScrollPane(areaEstadisticas), BorderLayout.CENTER);

        contenedor.revalidate();
        contenedor.repaint();
    }

    private static void mostrarLider() {
        int maxVotos = 0;
        String lider = "";

        for (String candidato : candidatos) {
            int votos = votosPorCandidato.get(candidato);
            if (votos > maxVotos) {
                maxVotos = votos;
                lider = candidato;
            }
        }

        JLabel labelLider = new JLabel("Candidato Líder: " + lider + " con " + maxVotos + " votos");
        panelEstadisticas.add(labelLider, BorderLayout.SOUTH);

        panelEstadisticas.revalidate();
        panelEstadisticas.repaint();
    }

    private static void agregarBotonFinalizar() {
        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.addActionListener(e -> determinarGanador());
        panelEstadisticas.add(btnFinalizar, BorderLayout.SOUTH);

        panelEstadisticas.revalidate();
        panelEstadisticas.repaint();
    }

    private static void determinarGanador() {
        int maxVotos = 0;
        String ganador = "";

        for (String candidato : candidatos) {
            int votos = votosPorCandidato.get(candidato);
            if (votos > maxVotos) {
                maxVotos = votos;
                ganador = candidato;
            }
        }

        JOptionPane.showMessageDialog(null, "¡El candidato ganador es: " + ganador + " con " + maxVotos + " votos!");

        System.exit(0);
    }

    private static Color obtenerColorAleatorio() {
        return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }
}
