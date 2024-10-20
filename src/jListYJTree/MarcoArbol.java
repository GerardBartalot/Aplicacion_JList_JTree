package jListYJTree;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

public class MarcoArbol {

    // Mapa que asocia los países por su código ISO a los continentes
    private static final Map<String, String> paisesPorContinente = new HashMap<>();
    
    static {
        // América
        String[] america = {"AG", "AR", "AW", "BB", "BO", "BR", "BS", "BZ", "CA", "CL", "CO", "CR", "CU", "DM", "DO", "EC", "SV", "GD", "GT", "GY", "HN", "HT", "JM", "MX", "NI", "PA", "PY", "PE", "KN", "LC", "VC", "SR", "TT", "US", "UY", "VE"};
        // Europa
        String[] europa = {"AL", "AD", "AM", "AT", "AZ", "BE", "BG", "BY", "CH", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GE", "GR", "HR", "HU", "IE", "IS", "IT", "KZ", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MK", "MT", "NL", "NO", "PL", "PT", "RO", "RU", "SE", "SI", "SK", "SM", "UA", "VA", "GB"};
        // Asia
        String[] asia = {"AF", "AE", "AM", "AZ", "BD", "BH", "BN", "BT", "CN", "CY", "GE", "IN", "ID", "IL", "IQ", "IR", "JO", "JP", "KG", "KH", "KP", "KR", "KW", "KZ", "LA", "LB", "LK", "MM", "MN", "MY", "MV", "NP", "OM", "PH", "PK", "QA", "SA", "SG", "SY", "TH", "TJ", "TL", "TM", "TR", "UZ", "VN", "YE"};
        // África
        String[] africa = {"DZ", "AO", "BJ", "BW", "BF", "BI", "CV", "CM", "CF", "TD", "KM", "CG", "CD", "CI", "DJ", "EG", "GQ", "ER", "SZ", "ET", "GA", "GM", "GH", "GN", "GW", "KE", "LS", "LR", "LY", "MG", "MW", "ML", "MR", "MU", "MA", "MZ", "NA", "NE", "NG", "RW", "ST", "SN", "SC", "SL", "SO", "ZA", "SS", "SD", "TZ", "TG", "TN", "UG", "ZM", "ZW"};
        // Oceanía
        String[] oceania = {"AU", "FJ", "KI", "MH", "FM", "NR", "NZ", "PW", "PG", "WS", "SB", "TO", "TV", "VU"};

        // Asociar países con continentes
        for (String codigo : america) {
            paisesPorContinente.put(codigo, "América");
        }
        for (String codigo : europa) {
            paisesPorContinente.put(codigo, "Europa");
        }
        for (String codigo : asia) {
            paisesPorContinente.put(codigo, "Asia");
        }
        for (String codigo : africa) {
            paisesPorContinente.put(codigo, "África");
        }
        for (String codigo : oceania) {
            paisesPorContinente.put(codigo, "Oceanía");
        }
    }

    public static void crearYMostrarArbol() {
        JFrame marcoArbol = new JFrame("Árbol de Países");
        marcoArbol.setBounds(400, 300, 300, 500);
        
        // Nodo raíz "Mundo"
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo");
        
        // Añadir continentes
        DefaultMutableTreeNode americaNode = new DefaultMutableTreeNode("América");
        DefaultMutableTreeNode europaNode = new DefaultMutableTreeNode("Europa");
        DefaultMutableTreeNode asiaNode = new DefaultMutableTreeNode("Asia");
        DefaultMutableTreeNode africaNode = new DefaultMutableTreeNode("África");
        DefaultMutableTreeNode oceaniaNode = new DefaultMutableTreeNode("Oceanía");
        
        raiz.add(americaNode);
        raiz.add(europaNode);
        raiz.add(asiaNode);
        raiz.add(africaNode);
        raiz.add(oceaniaNode);
        
        // Llenar los nodos con países según el continente
        llenarArbolConPaises(americaNode, "América");
        llenarArbolConPaises(europaNode, "Europa");
        llenarArbolConPaises(asiaNode, "Asia");
        llenarArbolConPaises(africaNode, "África");
        llenarArbolConPaises(oceaniaNode, "Oceanía");

        // Crear el árbol basado en la estructura
        JTree arbol = new JTree(raiz);
        JScrollPane panelArbol = new JScrollPane(arbol);
        
        marcoArbol.add(panelArbol);
        marcoArbol.setVisible(true);
    }

    // Método para llenar el árbol con países asignados a cada continente
    private static void llenarArbolConPaises(DefaultMutableTreeNode nodoContinente, String continente) {
        String[] codigosDePaises = Locale.getISOCountries();
        
        for (String codigoPais : codigosDePaises) {
            Locale locale = new Locale("", codigoPais);
            String nombrePais = locale.getDisplayCountry();
            
            // Verificar si el país pertenece al continente correcto
            if (paisesPorContinente.getOrDefault(codigoPais, "").equals(continente)) {
                nodoContinente.add(new DefaultMutableTreeNode(nombrePais)); // Agregar el nombre completo del país
            }
        }
    }
}
