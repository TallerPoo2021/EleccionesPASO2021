package com.gruposeispoo.vistas.usuarios;

import java.awt.Color;

public class UserBoletaEnBlancoPane extends javax.swing.JPanel {

    private final int numero = 0;
    private UserVotoListaPane contenedorLista;
    private UserVotoCatePane contenedorCategoria;
    private boolean flagDiputados;
    private boolean clicked = false;

    /**
     * CONSTRUCTOR
     *
     */
    public UserBoletaEnBlancoPane() {
        initComponents();
        contenedorLista = null;
        contenedorCategoria = null;
        flagDiputados = false;
    }

    /**
     * CONSTRUCTOR
     *
     * @param contenedor
     */
    public UserBoletaEnBlancoPane(UserVotoListaPane contenedor) {
        this();
        this.contenedorLista = contenedor;
    }

    /**
     * CONSTRUCTOR
     *
     * @param contenedor
     */
    public UserBoletaEnBlancoPane(UserVotoCatePane contenedor, boolean flag) {
        this();
        this.contenedorCategoria = contenedor;
        this.flagDiputados = flag;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isFlagDiputados() {
        return flagDiputados;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;

        if (clicked) {
            numeroListaTxt.setForeground(new Color(43, 179, 205));
            return;
        }
        numeroListaTxt.setForeground(new Color(127, 127, 127));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgContainer = new javax.swing.JPanel();
        numeroListaTxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        numeroListaTxt.setBackground(new java.awt.Color(255, 255, 255));
        numeroListaTxt.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        numeroListaTxt.setForeground(new java.awt.Color(127, 127, 127));
        numeroListaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroListaTxt.setText("LISTA VACIA");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/listavacia.png"))); // NOI18N

        javax.swing.GroupLayout bgContainerLayout = new javax.swing.GroupLayout(bgContainer);
        bgContainer.setLayout(bgContainerLayout);
        bgContainerLayout.setHorizontalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numeroListaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgContainerLayout.setVerticalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addComponent(numeroListaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
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
        clicked=true;
        
        if (contenedorCategoria == null) {
            contenedorLista.selectedListaPanel(this);
        } else {
            contenedorCategoria.actualizarTodasLasBoletas(this);
        }
    }//GEN-LAST:event_bgContainerMouseClicked

    private void bgContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseEntered
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseEntered

    private void bgContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgContainerMouseExited
        //ASDASDASDASDASDAS PROGRAME
    }//GEN-LAST:event_bgContainerMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel numeroListaTxt;
    // End of variables declaration//GEN-END:variables
}
