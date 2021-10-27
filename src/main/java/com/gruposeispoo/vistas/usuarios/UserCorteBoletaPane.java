package com.gruposeispoo.vistas.usuarios;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class UserCorteBoletaPane extends javax.swing.JPanel {

    private UserVotoCatePane contenedor;
    private boolean clicked = false;

    /**
     * Constructor
     *
     * @param contenedor
     */
    public UserCorteBoletaPane(UserVotoCatePane contenedor) {
        this.contenedor = contenedor;
        initComponents();
    }

    private void setCandidatoIcon(JLabel etiqueta, String rutaRelativaIcon) {
        etiqueta.setIcon(new ImageIcon(getClass().getResource(rutaRelativaIcon)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgContainer = new javax.swing.JPanel();
        iconCandidato = new javax.swing.JLabel();
        nombreCandidatoTxt = new javax.swing.JLabel();
        tipoCandidatoTxt = new javax.swing.JLabel();

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

        nombreCandidatoTxt.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        nombreCandidatoTxt.setForeground(new java.awt.Color(127, 127, 127));
        nombreCandidatoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCandidatoTxt.setText("<html><p><center>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido<br>Nombre Apellido</center></p></html>  \n");
        nombreCandidatoTxt.setToolTipText("");
        nombreCandidatoTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tipoCandidatoTxt.setBackground(new java.awt.Color(255, 255, 255));
        tipoCandidatoTxt.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        tipoCandidatoTxt.setForeground(new java.awt.Color(127, 127, 127));
        tipoCandidatoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoCandidatoTxt.setText("Lista<NumeroLista>");

        javax.swing.GroupLayout bgContainerLayout = new javax.swing.GroupLayout(bgContainer);
        bgContainer.setLayout(bgContainerLayout);
        bgContainerLayout.setHorizontalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(iconCandidato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(nombreCandidatoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipoCandidatoTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgContainerLayout.setVerticalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addComponent(tipoCandidatoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreCandidatoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
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
        setCandidatoIcon(iconCandidato, "/com/gruposeispoo/vistas/images/personasceleste.png");
        nombreCandidatoTxt.setForeground(new Color(43,179,205));
        tipoCandidatoTxt.setForeground(new Color(43,179,205));
    }//GEN-LAST:event_bgContainerMouseClicked

    private void bgContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseEntered
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseEntered

    private void bgContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseExited
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JLabel iconCandidato;
    private javax.swing.JLabel nombreCandidatoTxt;
    private javax.swing.JLabel tipoCandidatoTxt;
    // End of variables declaration//GEN-END:variables
}
