package com.gruposeispoo.vistas.usuarios;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class UserBoletaPane extends javax.swing.JPanel {

    /**
     *
     * ATRIBUTOS
     *
     */
    private int numero;
    private String nombre;
    private UserVotoListaPane contenedor;
    private boolean clicked = false;
    /**
     *
     * CONSTANTES
     *
     */
    public static final Color COLOR_NARANJA = new Color(255, 127, 0);
    public static final Color COLOR_AMARILLO = new Color(234, 219, 58);
    public static final Color COLOR_VERDE = new Color(0, 127, 0);
    public static final Color COLOR_AZUL = new Color(0, 0, 255);
    public static final Color COLOR_CELESTE = new Color(0, 191, 191);
    public static final Color COLOR_GRIS = new Color(127, 127, 127);
    public static final Color COLOR_MARRON = new Color(127, 63, 0);
    public static final Color COLOR_NEGRO = new Color(0, 0, 0);
    public static final Color COLOR_ROJO = new Color(255, 0, 0);
    public static final Color COLOR_VIOLETA = new Color(142, 15, 142);

    /**
     * Constructor
     *
     * @param contenedor
     * @param numero
     * @param nombre
     */
    public UserBoletaPane(UserVotoListaPane contenedor, int numero, String nombre) {
        initComponents();
        this.contenedor = contenedor;
        this.numero = numero;
        this.nombre = nombre;
    }

    /**
     * CONSTRUCTOR
     *
     * @param contenedor
     * @param numero
     * @param nombre
     * @param color
     */
    public UserBoletaPane(UserVotoListaPane contenedor, int numero, String nombre, Color color) {
        this(contenedor, numero, nombre);
        escribirNumeroYNombre(numero, nombre);

        if (color.equals(COLOR_AZUL)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasazul.png");
            return;
        }
        if (color.equals(COLOR_AMARILLO)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasamarillo.png");
            return;
        }
        if (color.equals(COLOR_VERDE)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasverde.png");
            return;
        }
        if (color.equals(COLOR_ROJO)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasrojo.png");
            return;
        }
        if (color.equals(COLOR_NEGRO)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasnegro.png");
            return;
        }
        if (color.equals(COLOR_NARANJA)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasnaranja.png");
            return;
        }
        if (color.equals(COLOR_CELESTE)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasceleste.png");
            return;
        }
        if (color.equals(COLOR_GRIS)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasgris.png");
            return;
        }
        if (color.equals(COLOR_MARRON)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasmarron.png");
            return;
        }
        if (color.equals(COLOR_VIOLETA)) {
            setBackgroundColorBorder(color);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasvioleta.png");
            return;
        }

        if (color == null) {
            setBackgroundColorBorder(this.COLOR_GRIS);
            setBoletaIcon(iconLista, "/com/gruposeispoo/vistas/images/personasgris.png");
        }

    }

    /**
     * Escribe correctamente el nombre y numero de la lista en su representación
     * grafica como boleta
     *
     */
    private void escribirNumeroYNombre(int numero, String nombre) {
        String numeroLista = "Lista " + numero;
        String boletaNombre = "<html><p><center>";
        String[] palabras = nombre.split(" ");

        for (String palabra : palabras) {
            if (palabra.length() < 5) {
                boletaNombre += palabra + " ";
            } else {
                boletaNombre += palabra + "<br>";
            }
        }

        boletaNombre += "</center></p></html>";
        numeroListaTxt.setText("");
        numeroListaTxt.setText(numeroLista);
        nombreListaTxt.setText("");
        nombreListaTxt.setText(boletaNombre);
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setBackgroundColorBorder(Color colorBG) {
        bgContainer.setBorder(new LineBorder(colorBG, 2, true));
    }

    private void setBoletaIcon(JLabel etiqueta, String rutaRelativaIcon) {
        etiqueta.setIcon(new ImageIcon(getClass().getResource(rutaRelativaIcon)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgContainer = new javax.swing.JPanel();
        nombreListaTxt = new javax.swing.JLabel();
        iconLista = new javax.swing.JLabel();
        numeroListaTxt = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        bgContainer.setBackground(new java.awt.Color(255, 255, 255));
        bgContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 179, 205), 2));
        bgContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bgContainerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bgContainerMouseExited(evt);
            }
        });

        nombreListaTxt.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        nombreListaTxt.setForeground(new java.awt.Color(43, 179, 205));
        nombreListaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreListaTxt.setText("<html><p><center>Nombre<br> de la, <br> lista</center></p></html>\n\n");
        nombreListaTxt.setToolTipText("");
        nombreListaTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        iconLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/personasgris.png"))); // NOI18N

        numeroListaTxt.setBackground(new java.awt.Color(255, 255, 255));
        numeroListaTxt.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        numeroListaTxt.setForeground(new java.awt.Color(43, 179, 205));
        numeroListaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroListaTxt.setText("Lista <NumeroLista>");

        javax.swing.GroupLayout bgContainerLayout = new javax.swing.GroupLayout(bgContainer);
        bgContainer.setLayout(bgContainerLayout);
        bgContainerLayout.setHorizontalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(iconLista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(nombreListaTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numeroListaTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgContainerLayout.setVerticalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addComponent(numeroListaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreListaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconLista, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bgContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseClicked
        contenedor.selectedListaPanel(this);
    }//GEN-LAST:event_bgContainerMouseClicked

    private void bgContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseEntered
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseEntered

    private void bgContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseExited
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JLabel iconLista;
    private javax.swing.JLabel nombreListaTxt;
    private javax.swing.JLabel numeroListaTxt;
    // End of variables declaration//GEN-END:variables
}
