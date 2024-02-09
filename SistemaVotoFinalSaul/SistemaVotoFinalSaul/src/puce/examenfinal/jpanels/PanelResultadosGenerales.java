package puce.examenfinal.jpanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import puce.examenfinal.clases.Candidato;

public class PanelResultadosGenerales extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;

    public PanelResultadosGenerales(List<Candidato> candidatos) {
    	getContentPane().setBackground(new Color(0, 255, 255));
    	setClosable(true);
        setTitle("RESULTADOS GENERALES");
        setBounds(100, 100, 547, 465);
        getContentPane().setLayout(null);

        JTable table = new JTable();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"CANDIDATO", "VOTOS TOTALES"});
        table.setModel(model);

        for (Candidato candidato : candidatos) {
            model.addRow(new Object[]{candidato.getNombreCandidato(), candidato.getVotos()});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 511, 405);
        getContentPane().add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



