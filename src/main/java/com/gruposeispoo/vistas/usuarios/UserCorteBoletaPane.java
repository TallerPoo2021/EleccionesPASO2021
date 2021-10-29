package com.gruposeispoo.vistas.usuarios;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UserCorteBoletaPane extends javax.swing.JPanel {

    /**
     *
     * ATRIBUTOS
     *
     */
    private int numero = 0;

    private List<String> nombres;

    private UserVotoCatePane contenedor;
    private boolean flagDiputados;
    private boolean clicked = false;

    /**
     * CONSTRUCTOR
     *
     */
    public UserCorteBoletaPane() {
        initComponents();
        nombres = new ArrayList<>();
        contenedor = null;
        flagDiputados = false;
    }

    /**
     * CONSTRUCTOR
     *
     * @param contenedor
     * @param numero
     * @param nombres
     */
    public UserCorteBoletaPane(UserVotoCatePane contenedor, int numero, List<String> nombres, boolean flag) {
        this();
        escribirNumeroYNombres(numero, nombres);
        this.contenedor = contenedor;
        this.numero = numero;
        this.nombres = nombres;
        this.flagDiputados = flag;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
        
        if (clicked) {
            setCandidatoIcon(iconCandidato, "/com/gruposeispoo/vistas/images/personasceleste.png");
            candidatosTxt.setForeground(new Color(43, 179, 205));
            numeroListaTxt.setForeground(new Color(43, 179, 205));
            return;
        }
            setCandidatoIcon(iconCandidato, "/com/gruposeispoo/vistas/images/personasgris.png");
            candidatosTxt.setForeground(new Color(127,127,127));
            numeroListaTxt.setForeground(new Color(127,127,127));
    }

    public int getNumero() {
        return numero;
    }

    public boolean isFlagDiputados() {
        return flagDiputados;
    }

    private void escribirNumeroYNombres(int numero, List<String> nombres) {
        String numeroLista = "Lista " + numero;
        String candidato = "<html><p><center>";

        for (String nombre : nombres) {
            candidato += nombre + "<br>";
        }

        candidato += "</center></p></html>";
        numeroListaTxt.setText("");
        numeroListaTxt.setText(numeroLista);
        candidatosTxt.setText("");
        candidatosTxt.setText(candidato);
    }

    private void setCandidatoIcon(JLabel etiqueta, String rutaRelativaIcon) {
        etiqueta.setIcon(new ImageIcon(getClass().getResource(rutaRelativaIcon)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgContainer = new javax.swing.JPanel();
        iconCandidato = new javax.swing.JLabel();
        candidatosTxt = new javax.swing.JLabel();
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

        iconCandidato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/personasgris.png"))); // NOI18N

        candidatosTxt.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        candidatosTxt.setForeground(new java.awt.Color(127, 127, 127));
        candidatosTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        candidatosTxt.setText("<html><p><center>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido</center></p></html>  \n");
        candidatosTxt.setToolTipText("");
        candidatosTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        numeroListaTxt.setBackground(new java.awt.Color(255, 255, 255));
        numeroListaTxt.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        numeroListaTxt.setForeground(new java.awt.Color(127, 127, 127));
        numeroListaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroListaTxt.setText("Lista<NumeroLista>");

        javax.swing.GroupLayout bgContainerLayout = new javax.swing.GroupLayout(bgContainer);
        bgContainer.setLayout(bgContainerLayout);
        bgContainerLayout.setHorizontalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(iconCandidato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(candidatosTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numeroListaTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgContainerLayout.setVerticalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addComponent(numeroListaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(candidatosTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        contenedor.actualizarTodasLasBoletas(this);
    }//GEN-LAST:event_bgContainerMouseClicked

    private void bgContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseEntered
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseEntered

    private void bgContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseExited
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JLabel candidatosTxt;
    private javax.swing.JLabel iconCandidato;
    private javax.swing.JLabel numeroListaTxt;
    // End of variables declaration//GEN-END:variables
}
