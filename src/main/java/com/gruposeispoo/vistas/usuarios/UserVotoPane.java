package com.gruposeispoo.vistas.usuarios;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.vistas.Index;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserVotoPane extends javax.swing.JPanel {

    private UserVotoListaPane userVotoListaPane;
    private UserVotoCatePane pruebaVotoCatePane;
    private Index contenedor;
    private Controlador controlador;

    /**
     * CONSTRUCTOR
     *
     * @param contenedor
     */
    public UserVotoPane(Index contenedor) {
        initComponents();
        this.contenedor = contenedor;
        userVotoListaPane = new UserVotoListaPane(this.contenedor);
        pruebaVotoCatePane = new UserVotoCatePane(this.contenedor);
        controlador = Controlador.getInstancia();
    }

    /**
     * Establece el icono de un componente
     *
     * @param etiqueta
     * @param rutaRelativaIcon
     */
    private void setUserIcon(JLabel etiqueta, String rutaRelativaIcon) {
        etiqueta.setIcon(new ImageIcon(getClass().getResource(rutaRelativaIcon)));
    }

    public String getNombreElectorTxt() {
        return nombreElectorTxt.getText();
    }

    public void setNombreElectorTxt(String nombre) {
        this.nombreElectorTxt.setText(nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerContainer = new javax.swing.JPanel();
        headerBarContainer = new javax.swing.JPanel();
        btnExitContainer = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        corteCardContainer = new javax.swing.JPanel();
        corteCardTitleTxt = new javax.swing.JLabel();
        corteCardIcon = new javax.swing.JLabel();
        listaCardContainer = new javax.swing.JPanel();
        listaCardTitleTxt = new javax.swing.JLabel();
        listaCardIcon = new javax.swing.JLabel();
        sombraCorteCard = new javax.swing.JSeparator();
        sombraListaCard = new javax.swing.JSeparator();
        nombreElectorTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 244, 246));
        setMinimumSize(new java.awt.Dimension(700, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerContainer.setBackground(new java.awt.Color(245, 244, 246));

        headerBarContainer.setBackground(new java.awt.Color(245, 244, 246));
        headerBarContainer.setForeground(new java.awt.Color(255, 255, 255));
        headerBarContainer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerBarContainerMouseDragged(evt);
            }
        });
        headerBarContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerBarContainerMousePressed(evt);
            }
        });

        btnExitContainer.setBackground(new java.awt.Color(255, 255, 255));
        btnExitContainer.setForeground(new java.awt.Color(255, 255, 255));

        btnExitTxt.setBackground(new java.awt.Color(199, 80, 80));
        btnExitTxt.setFont(new java.awt.Font("Roboto Black", 0, 25)); // NOI18N
        btnExitTxt.setForeground(new java.awt.Color(245, 244, 246));
        btnExitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExitTxt.setText("x");
        btnExitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExitTxt.setOpaque(true);
        btnExitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnExitContainerLayout = new javax.swing.GroupLayout(btnExitContainer);
        btnExitContainer.setLayout(btnExitContainerLayout);
        btnExitContainerLayout.setHorizontalGroup(
            btnExitContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnExitContainerLayout.setVerticalGroup(
            btnExitContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        userIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/personaceleste.png"))); // NOI18N
        userIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userIconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout headerBarContainerLayout = new javax.swing.GroupLayout(headerBarContainer);
        headerBarContainer.setLayout(headerBarContainerLayout);
        headerBarContainerLayout.setHorizontalGroup(
            headerBarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerBarContainerLayout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(userIcon)
                .addGap(279, 279, 279)
                .addComponent(btnExitContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerBarContainerLayout.setVerticalGroup(
            headerBarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerBarContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headerBarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnExitContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout headerContainerLayout = new javax.swing.GroupLayout(headerContainer);
        headerContainer.setLayout(headerContainerLayout);
        headerContainerLayout.setHorizontalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerBarContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerContainerLayout.setVerticalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerContainerLayout.createSequentialGroup()
                .addComponent(headerBarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(headerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 30));

        corteCardContainer.setBackground(new java.awt.Color(43, 179, 205));
        corteCardContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 179, 205), 2));
        corteCardContainer.setToolTipText("");
        corteCardContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        corteCardContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                corteCardContainerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                corteCardContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                corteCardContainerMouseExited(evt);
            }
        });
        corteCardContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        corteCardTitleTxt.setBackground(new java.awt.Color(255, 255, 255));
        corteCardTitleTxt.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        corteCardTitleTxt.setForeground(new java.awt.Color(255, 255, 255));
        corteCardTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        corteCardTitleTxt.setText("<html><p><center>Votar<br> por <br>Categoria</center></p></html>\n");
        corteCardTitleTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        corteCardContainer.add(corteCardTitleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 110));

        corteCardIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        corteCardIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/corteboleta.png"))); // NOI18N
        corteCardContainer.add(corteCardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, 220));

        add(corteCardContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 220, 330));

        listaCardContainer.setBackground(new java.awt.Color(43, 179, 205));
        listaCardContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 179, 205), 2));
        listaCardContainer.setToolTipText("");
        listaCardContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaCardContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCardContainerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listaCardContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listaCardContainerMouseExited(evt);
            }
        });
        listaCardContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaCardTitleTxt.setBackground(new java.awt.Color(245, 244, 246));
        listaCardTitleTxt.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        listaCardTitleTxt.setForeground(new java.awt.Color(255, 255, 255));
        listaCardTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listaCardTitleTxt.setText("<html><p><center>Votar<br> Lista <br>Completa</center></p></html>\n");
        listaCardTitleTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        listaCardContainer.add(listaCardTitleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 110));

        listaCardIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listaCardIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/listaCompleta.png"))); // NOI18N
        listaCardContainer.add(listaCardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, 170));

        add(listaCardContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 220, 330));

        sombraCorteCard.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(sombraCorteCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 20, 330));

        sombraListaCard.setOrientation(javax.swing.SwingConstants.VERTICAL);
        sombraListaCard.setRequestFocusEnabled(false);
        add(sombraListaCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 20, 330));

        nombreElectorTxt.setBackground(new java.awt.Color(245, 244, 246));
        nombreElectorTxt.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        nombreElectorTxt.setForeground(new java.awt.Color(43, 179, 205));
        nombreElectorTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreElectorTxt.setToolTipText("");
        nombreElectorTxt.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        nombreElectorTxt.setOpaque(true);
        nombreElectorTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nombreElectorTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nombreElectorTxtMouseExited(evt);
            }
        });
        add(nombreElectorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 430, 31));
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitTxtMouseClicked

    private void btnExitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseEntered
        this.btnExitTxt.setBackground(Color.red);
    }//GEN-LAST:event_btnExitTxtMouseEntered

    private void btnExitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseExited
        this.btnExitTxt.setBackground(new Color(199, 80, 80));
    }//GEN-LAST:event_btnExitTxtMouseExited

    private void headerBarContainerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarContainerMouseDragged

    }//GEN-LAST:event_headerBarContainerMouseDragged

    private void headerBarContainerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarContainerMousePressed

    }//GEN-LAST:event_headerBarContainerMousePressed

    private void corteCardContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_corteCardContainerMouseEntered
        corteCardContainer.setBackground(new Color(58, 77, 92));
    }//GEN-LAST:event_corteCardContainerMouseEntered

    private void corteCardContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_corteCardContainerMouseExited
        corteCardContainer.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_corteCardContainerMouseExited

    private void listaCardContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCardContainerMouseEntered
        listaCardContainer.setBackground(new Color(58, 77, 92));
    }//GEN-LAST:event_listaCardContainerMouseEntered

    private void listaCardContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCardContainerMouseExited
        listaCardContainer.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_listaCardContainerMouseExited

    private void listaCardContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCardContainerMouseClicked
        controlador.setVotoPorLista(true);
        contenedor.actualizarContentPane(userVotoListaPane);
    }//GEN-LAST:event_listaCardContainerMouseClicked

    private void corteCardContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_corteCardContainerMouseClicked
        controlador.setVotoPorLista(false);
        contenedor.actualizarContentPane(pruebaVotoCatePane);
    }//GEN-LAST:event_corteCardContainerMouseClicked

    private void nombreElectorTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreElectorTxtMouseEntered
        nombreElectorTxt.setForeground(new Color(58, 77, 92));
    }//GEN-LAST:event_nombreElectorTxtMouseEntered

    private void nombreElectorTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreElectorTxtMouseExited
        nombreElectorTxt.setForeground(new Color(43, 179, 205));
    }//GEN-LAST:event_nombreElectorTxtMouseExited

    private void userIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userIconMouseEntered
        setUserIcon(userIcon, "/com/gruposeispoo/vistas/images/personagris.png");
    }//GEN-LAST:event_userIconMouseEntered

    private void userIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userIconMouseExited
        setUserIcon(userIcon, "/com/gruposeispoo/vistas/images/personaceleste.png");
    }//GEN-LAST:event_userIconMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel corteCardContainer;
    private javax.swing.JLabel corteCardIcon;
    private javax.swing.JLabel corteCardTitleTxt;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JPanel listaCardContainer;
    private javax.swing.JLabel listaCardIcon;
    private javax.swing.JLabel listaCardTitleTxt;
    private javax.swing.JLabel nombreElectorTxt;
    private javax.swing.JSeparator sombraCorteCard;
    private javax.swing.JSeparator sombraListaCard;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
}
