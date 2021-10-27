package com.gruposeispoo.vistas;

import java.awt.Color;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class IndexPane extends javax.swing.JPanel {

    // private UserLoginPane userLoginPane = new UserLoginPane();
    private Index contenedor;
    
    public IndexPane(Index contenedor) {
        initComponents();
        this.contenedor = contenedor;
    }

    /**
     * Actualiza el contenido principal de la ventana
     *
     * @param actualContenedor
     * @param nuevoContenedor
     */
    private void actualizarContentPane(JPanel actualContenedor, JPanel nuevoContenedor) {
        nuevoContenedor.setSize(700, 590);

        actualContenedor.removeAll();
        actualContenedor.add(nuevoContenedor, new AbsoluteConstraints(0, 0, -1, -1));
        actualContenedor.revalidate();
        actualContenedor.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentContainer = new javax.swing.JPanel();
        headerContainer = new javax.swing.JPanel();
        headerBarContainer = new javax.swing.JPanel();
        btnExitContainer = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        headerTitleTxt = new javax.swing.JLabel();
        infoContainer = new javax.swing.JPanel();
        infoTxtArea = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnLoTengoContainer = new javax.swing.JPanel();
        btnLoTengoTxt = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(700, 590));

        contentContainer.setBackground(new java.awt.Color(245, 244, 246));
        contentContainer.setForeground(new java.awt.Color(245, 244, 246));
        contentContainer.setMinimumSize(new java.awt.Dimension(700, 590));
        contentContainer.setPreferredSize(new java.awt.Dimension(700, 590));
        contentContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerContainer.setBackground(new java.awt.Color(245, 244, 246));
        headerContainer.setForeground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout headerBarContainerLayout = new javax.swing.GroupLayout(headerBarContainer);
        headerBarContainer.setLayout(headerBarContainerLayout);
        headerBarContainerLayout.setHorizontalGroup(
            headerBarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerBarContainerLayout.createSequentialGroup()
                .addGap(0, 642, Short.MAX_VALUE)
                .addComponent(btnExitContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerBarContainerLayout.setVerticalGroup(
            headerBarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerBarContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExitContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        headerTitleTxt.setBackground(new java.awt.Color(245, 244, 246));
        headerTitleTxt.setFont(new java.awt.Font("Roboto Black", 1, 40)); // NOI18N
        headerTitleTxt.setForeground(new java.awt.Color(43, 179, 205));
        headerTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleTxt.setText("Bienvenido");

        javax.swing.GroupLayout headerContainerLayout = new javax.swing.GroupLayout(headerContainer);
        headerContainer.setLayout(headerContainerLayout);
        headerContainerLayout.setHorizontalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerBarContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(headerContainerLayout.createSequentialGroup()
                .addComponent(headerTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerContainerLayout.setVerticalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerContainerLayout.createSequentialGroup()
                .addComponent(headerBarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentContainer.add(headerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 100));

        infoContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(58, 77, 92));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(43, 179, 205));
        jTextArea1.setRows(5);
        jTextArea1.setText("> \t\t\tACUERDO\n> \n> \t                     Bienvenido al sistema de voto electrónico VOTAR. \n>\n> \tEste sistema tiene el objetivo de facilitar el  acceso al voto a los ciudadanos \n>\t\te integrar a los diferentes actores participantes.\n> \n> \t                     Ventajas de usar un sistema de voto electrónico:\n>\n> \t\t                      - Más seguridad.\n> \t\t                      - Más transparencia.\n> \t\t                      - Más agilidad.\n> \t\t\t\n>\t\t        ¿Cómo se procede a realizar el voto?\n>\n>   \t   Dentro de el Sistema de Votación el votante deberá verificar su identidad \n>\tmediante datos biométricos. Luego de verificar su identidad deberá elegir su\n>\t\t\t método de voto.\n> \n>                                  Los datos ingresados son utilizados únicamente con fines estadisticos. \n> \n>\n>\n>\n>\n>\n>                                Todos los derechos reservados 2021 Programación Orientada a Objetos.\n>");
        jTextArea1.setDisabledTextColor(new java.awt.Color(10, 250, 153));
        jTextArea1.setEnabled(false);
        jTextArea1.setFocusable(false);
        jTextArea1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jTextArea1.setName(""); // NOI18N
        infoTxtArea.setViewportView(jTextArea1);

        infoContainer.add(infoTxtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 350));

        contentContainer.add(infoContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 640, 350));

        btnLoTengoTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnLoTengoTxt.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnLoTengoTxt.setForeground(new java.awt.Color(245, 246, 232));
        btnLoTengoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLoTengoTxt.setText("ACEPTAR");
        btnLoTengoTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoTengoTxt.setOpaque(true);
        btnLoTengoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoTengoTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoTengoTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoTengoTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLoTengoContainerLayout = new javax.swing.GroupLayout(btnLoTengoContainer);
        btnLoTengoContainer.setLayout(btnLoTengoContainerLayout);
        btnLoTengoContainerLayout.setHorizontalGroup(
            btnLoTengoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLoTengoContainerLayout.createSequentialGroup()
                .addComponent(btnLoTengoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnLoTengoContainerLayout.setVerticalGroup(
            btnLoTengoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLoTengoContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLoTengoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentContainer.add(btnLoTengoContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(contentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(contentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
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

    private void btnLoTengoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoTengoTxtMouseClicked
        contenedor.setBotoneraEnabled(true);
        btnLoTengoTxt.setVisible(false);
    }//GEN-LAST:event_btnLoTengoTxtMouseClicked

    private void btnLoTengoTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoTengoTxtMouseEntered
        btnLoTengoTxt.setBackground(new Color(58,77,92));
    }//GEN-LAST:event_btnLoTengoTxtMouseEntered

    private void btnLoTengoTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoTengoTxtMouseExited
        btnLoTengoTxt.setBackground(new Color(43,179,205));
    }//GEN-LAST:event_btnLoTengoTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel btnLoTengoContainer;
    private javax.swing.JLabel btnLoTengoTxt;
    private javax.swing.JPanel contentContainer;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JPanel infoContainer;
    private javax.swing.JScrollPane infoTxtArea;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
