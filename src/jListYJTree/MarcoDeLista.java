package jListYJTree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MarcoDeLista extends JFrame {

    public MarcoDeLista() {
        
    	setTitle("Lista de Países y Árbol");
        setBounds(400, 300, 500, 400);
        
        String[] paises = obtenerListaDePaises();
        
        listaDePaises = new JList<>(paises);
        listaDePaises.setVisibleRowCount(10);
        
        JScrollPane laminaDeDesplazamiento = new JScrollPane(listaDePaises);
        laminaDeDesplazamiento.setPreferredSize(new Dimension(250, 200));
        
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        laminaDeLista = new JPanel();
        laminaDeLista.add(laminaDeDesplazamiento);
        panelPrincipal.add(laminaDeLista, BorderLayout.NORTH);
        
        laminaDeTexto = new JPanel();
        rotulo = new JLabel("País seleccionado: ");
        laminaDeTexto.add(rotulo);
        panelPrincipal.add(laminaDeTexto, BorderLayout.CENTER);
        
        listaDePaises.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String valorSeleccionado = listaDePaises.getSelectedValue();
                rotulo.setText("País seleccionado: " + valorSeleccionado);
            }
        });

        botonArbol = new JButton("Mostrar Árbol");
        botonArbol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MarcoArbol.crearYMostrarArbol();
            }
        });
        panelPrincipal.add(botonArbol, BorderLayout.SOUTH);
        
        add(panelPrincipal);
        
    }

    private String[] obtenerListaDePaises() {
        
    	String[] codigosDePaises = Locale.getISOCountries();
        String[] nombresDePaises = new String[codigosDePaises.length];
        
        for (int i = 0; i < codigosDePaises.length; i++) {
            Locale locale = new Locale("", codigosDePaises[i]);
            nombresDePaises[i] = locale.getDisplayCountry(); // Obtener el nombre completo del país
        }
        
        return nombresDePaises;
        
    }

    private JList<String> listaDePaises;
    private JPanel laminaDeLista, laminaDeTexto;
    private JLabel rotulo;
    private JButton botonArbol;
    
}
