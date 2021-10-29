package com.gruposeispoo.vistas;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.vistas.admin.AdminLoginPane;
import com.gruposeispoo.vistas.usuarios.UserLoginPane;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class Index extends javax.swing.JFrame {

    private IndexPane indexPane;
    private AdminLoginPane adminLoginPane;
    private UserLoginPane userLoginPane;
    private Controlador controlador;

    /**
     *
     * CONSTRUCTOR
     *
     */
    public Index() {
        initComponents();
        indexPane = new IndexPane(this);
        adminLoginPane = new AdminLoginPane(this);
        userLoginPane = new UserLoginPane(this);
        controlador = Controlador.getInstancia();
        init();
    }

    /**
     * Genera una nueva instancia de votación. Esto significa un nuevo elector
     * realizando el voto.
     *
     * @param userLoginPane
     */
    public void generarNuevaInstanciaDeAuditoria() {
        this.userLoginPane = new UserLoginPane(this);
        actualizarContentPane(this.userLoginPane);
    }

    /**
     * Genera una nueva instancia de votación. Esto significa un nuevo elector
     * realizando el voto.
     *
     * @param userLoginPane
     */
    public void generarNuevaInstanciaDeVotacion() {
        this.adminLoginPane = new AdminLoginPane(this);
        actualizarContentPane(this.adminLoginPane);
    }

    /**
     *
     * @param nuevoContenedor
     */
    public void actualizarContentPane(JPanel nuevoContenedor) {
        actualizarContentPane(contentContainer, nuevoContenedor);
    }

    /**
     * Activa o desactiva los botones del lateral izquierdo del frame
     *
     * @param visibilidad
     */
    public void setBotoneraEnabled(boolean visibilidad) {

        setVisible(btnUnoContainer, visibilidad);
        setVisible(btnSistemaGestorTxt, visibilidad);

        btnSistemaGestorTxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setVisible(btnDosContainer, visibilidad);
        setVisible(btnSistemaVotacionTxt, visibilidad);
        btnSistemaVotacionTxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setVisible(btnTresContainer, visibilidad);
        setVisible(btnOtroSistemaTxt, visibilidad);
        btnOtroSistemaTxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    /**
     * Configuraciones iniciales del Frame
     */
    private void init() {
        actualizarContentPane(contentContainer, indexPane);
        setBotoneraEnabled(false);
    }

    /**
     * Establece el icono de un boton
     *
     * @param etiqueta
     * @param rutaRelativaIcon
     */
    private void setButtonIcon(JLabel etiqueta, String rutaRelativaIcon) {
        etiqueta.setIcon(new ImageIcon(getClass().getResource(rutaRelativaIcon)));
    }

    /**
     *
     * @param segundos
     */
    private void espera(int segundos) {
        //Argumento illegal
        if (segundos > 3) {
            throw new IllegalArgumentException("Espera demasiado larga: " + segundos + " segundos");
        }

        try {
            segundos = segundos * 1000;
            Thread.sleep(segundos);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Activa un botón
     *
     * @param etiquetaBoton
     */
    private void activarBoton(JLabel etiquetaBoton) {
        desHabilitarBoton(etiquetaBoton, true, true);
    }

    /**
     * Desactiva un botón, el mismo dejará de ser clickable
     *
     * @param etiquetaBoton
     */
    private void desactivarBoton(JLabel etiquetaBoton) {
        desHabilitarBoton(etiquetaBoton, false, false);
    }

    /**
     * Deshabilita un boton
     *
     * @param etiquetaBoton
     * @param activado
     * @param visible
     */
    private void desHabilitarBoton(JLabel etiquetaBoton, boolean activado, boolean visible) {
        etiquetaBoton.setEnabled(activado);
        etiquetaBoton.setVisible(visible);
    }

    public void setVisible(JComponent comp, boolean visibilidad) {
        comp.setVisible(visibilidad);
    }

    /**
     * Pinta el borde y el fondo de una etiqueta
     *
     * @param container
     * @param colorBorde
     * @param colorFondo
     */
    private void setLabelColor(JLabel etiqueta, Color colorBorde, Color colorFondo, Color colorLetra) {
        if (colorBorde == null) {
            etiqueta.setBorder(null);
        } else {
            etiqueta.setBorder(new javax.swing.border.LineBorder(colorBorde, 2, true));
        }
        etiqueta.setBackground(colorFondo);
        etiqueta.setForeground(colorLetra);

        if (!etiqueta.isVisible()) {
            etiqueta.setVisible(true);
        }
    }

    /**
     * Actualiza el contenido principal de la ventana
     *
     * @param actualContenedor
     * @param nuevoContenedor
     */
    public void actualizarContentPane(JPanel actualContenedor, JPanel nuevoContenedor) {

        nuevoContenedor.setSize(700, 590);

        actualContenedor.removeAll();
        actualContenedor.add(nuevoContenedor, new AbsoluteConstraints(0, 0, -1, -1));
        actualContenedor.revalidate();
        actualContenedor.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        bgContainer = new javax.swing.JPanel();
        leftSideContainer = new javax.swing.JPanel();
        logoIcon = new javax.swing.JLabel();
        bottomPanelContainer = new javax.swing.JPanel();
        copyrightsTxt = new javax.swing.JLabel();
        buttonsPanelContainer = new javax.swing.JPanel();
        btnUnoContainer = new javax.swing.JPanel();
        btnSistemaGestorTxt = new javax.swing.JLabel();
        btnDosContainer = new javax.swing.JPanel();
        btnSistemaVotacionTxt = new javax.swing.JLabel();
        btnTresContainer = new javax.swing.JPanel();
        btnOtroSistemaTxt = new javax.swing.JLabel();
        contentContainer = new javax.swing.JPanel();
        headerContainer = new javax.swing.JPanel();
        headerBarContainer = new javax.swing.JPanel();
        btnExitContainer = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();

        jLabel6.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgContainer.setBackground(new java.awt.Color(245, 244, 246));
        bgContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftSideContainer.setBackground(new java.awt.Color(43, 179, 205));

        logoIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/logo.png"))); // NOI18N

        bottomPanelContainer.setBackground(new java.awt.Color(43, 179, 205));

        copyrightsTxt.setBackground(new java.awt.Color(0, 140, 147));
        copyrightsTxt.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        copyrightsTxt.setForeground(new java.awt.Color(245, 246, 232));
        copyrightsTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrightsTxt.setText("© 2021");
        copyrightsTxt.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout bottomPanelContainerLayout = new javax.swing.GroupLayout(bottomPanelContainer);
        bottomPanelContainer.setLayout(bottomPanelContainerLayout);
        bottomPanelContainerLayout.setHorizontalGroup(
            bottomPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(copyrightsTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bottomPanelContainerLayout.setVerticalGroup(
            bottomPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(copyrightsTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        buttonsPanelContainer.setBackground(new java.awt.Color(43, 179, 205));
        buttonsPanelContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUnoContainer.setBackground(new java.awt.Color(35, 147, 168));
        btnUnoContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUnoContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUnoContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUnoContainerMouseExited(evt);
            }
        });
        btnUnoContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSistemaGestorTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnSistemaGestorTxt.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        btnSistemaGestorTxt.setForeground(new java.awt.Color(245, 246, 232));
        btnSistemaGestorTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSistemaGestorTxt.setText("GESTORIA");
        btnSistemaGestorTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSistemaGestorTxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSistemaGestorTxt.setOpaque(true);
        btnSistemaGestorTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSistemaGestorTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSistemaGestorTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSistemaGestorTxtMouseExited(evt);
            }
        });
        btnUnoContainer.add(btnSistemaGestorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        buttonsPanelContainer.add(btnUnoContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, -1));

        btnDosContainer.setBackground(new java.awt.Color(35, 147, 168));
        btnDosContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDosContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDosContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDosContainerMouseExited(evt);
            }
        });
        btnDosContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSistemaVotacionTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnSistemaVotacionTxt.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        btnSistemaVotacionTxt.setForeground(new java.awt.Color(245, 246, 232));
        btnSistemaVotacionTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSistemaVotacionTxt.setText("VOTACION");
        btnSistemaVotacionTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSistemaVotacionTxt.setOpaque(true);
        btnSistemaVotacionTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSistemaVotacionTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSistemaVotacionTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSistemaVotacionTxtMouseExited(evt);
            }
        });
        btnDosContainer.add(btnSistemaVotacionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        buttonsPanelContainer.add(btnDosContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 260, -1));

        btnTresContainer.setBackground(new java.awt.Color(35, 147, 168));
        btnTresContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTresContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTresContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTresContainerMouseExited(evt);
            }
        });
        btnTresContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOtroSistemaTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnOtroSistemaTxt.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        btnOtroSistemaTxt.setForeground(new java.awt.Color(245, 246, 232));
        btnOtroSistemaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOtroSistemaTxt.setText("<html>\n<p>\n<a href=\"www.facebook.com\"  style=\"text-decoration: none;color: rgb(245,246,232);\">\nOTRO\n</a>\n</p>\n</html>\n");
        btnOtroSistemaTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOtroSistemaTxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOtroSistemaTxt.setOpaque(true);
        btnOtroSistemaTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOtroSistemaTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOtroSistemaTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOtroSistemaTxtMouseExited(evt);
            }
        });
        btnTresContainer.add(btnOtroSistemaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 47));

        buttonsPanelContainer.add(btnTresContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 253, 260, -1));

        javax.swing.GroupLayout leftSideContainerLayout = new javax.swing.GroupLayout(leftSideContainer);
        leftSideContainer.setLayout(leftSideContainerLayout);
        leftSideContainerLayout.setHorizontalGroup(
            leftSideContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonsPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftSideContainerLayout.createSequentialGroup()
                .addComponent(logoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        leftSideContainerLayout.setVerticalGroup(
            leftSideContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSideContainerLayout.createSequentialGroup()
                .addComponent(logoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bgContainer.add(leftSideContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 600));

        contentContainer.setBackground(new java.awt.Color(245, 244, 246));
        contentContainer.setForeground(new java.awt.Color(245, 244, 246));
        contentContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contentContainer.setMinimumSize(new java.awt.Dimension(700, 590));
        contentContainer.setPreferredSize(new java.awt.Dimension(700, 590));
        contentContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerContainer.setBackground(new java.awt.Color(245, 244, 246));
        headerContainer.setForeground(new java.awt.Color(245, 244, 246));

        headerBarContainer.setBackground(new java.awt.Color(245, 244, 246));
        headerBarContainer.setForeground(new java.awt.Color(245, 244, 246));
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

        javax.swing.GroupLayout headerContainerLayout = new javax.swing.GroupLayout(headerContainer);
        headerContainer.setLayout(headerContainerLayout);
        headerContainerLayout.setHorizontalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerBarContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerContainerLayout.setVerticalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerContainerLayout.createSequentialGroup()
                .addComponent(headerBarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        contentContainer.add(headerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 100));

        bgContainer.add(contentContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 700, 600));

        getContentPane().add(bgContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headerBarContainerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarContainerMousePressed

    }//GEN-LAST:event_headerBarContainerMousePressed

    private void headerBarContainerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarContainerMouseDragged

    }//GEN-LAST:event_headerBarContainerMouseDragged

    private void btnExitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseExited
        this.btnExitTxt.setBackground(new Color(199, 80, 80));
    }//GEN-LAST:event_btnExitTxtMouseExited

    private void btnExitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseEntered
        this.btnExitTxt.setBackground(Color.red);
    }//GEN-LAST:event_btnExitTxtMouseEntered

    private void btnExitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitTxtMouseClicked

    private void btnUnoContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnoContainerMouseEntered
        btnUnoContainer.setBackground(new Color(11, 205, 214));
    }//GEN-LAST:event_btnUnoContainerMouseEntered

    private void btnUnoContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnoContainerMouseExited
        btnUnoContainer.setBackground(new Color(0, 140, 147));
    }//GEN-LAST:event_btnUnoContainerMouseExited

    private void btnSistemaGestorTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSistemaGestorTxtMouseClicked
        actualizarContentPane(contentContainer, adminLoginPane);
    }//GEN-LAST:event_btnSistemaGestorTxtMouseClicked

    private void btnDosContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDosContainerMouseEntered
        btnDosContainer.setBackground(new Color(11, 205, 214));
    }//GEN-LAST:event_btnDosContainerMouseEntered

    private void btnDosContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDosContainerMouseExited
        btnDosContainer.setBackground(new Color(0, 140, 147));
    }//GEN-LAST:event_btnDosContainerMouseExited

    private void btnSistemaVotacionTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSistemaVotacionTxtMouseClicked
        actualizarContentPane(contentContainer, userLoginPane);
    }//GEN-LAST:event_btnSistemaVotacionTxtMouseClicked

    private void btnTresContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTresContainerMouseEntered
        btnTresContainer.setBackground(new Color(11, 205, 214));
    }//GEN-LAST:event_btnTresContainerMouseEntered

    private void btnTresContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTresContainerMouseExited
        btnTresContainer.setBackground(new Color(0, 140, 147));
    }//GEN-LAST:event_btnTresContainerMouseExited

    private void btnOtroSistemaTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOtroSistemaTxtMouseClicked
        //CLICK EN EL NOMBRE 
    }//GEN-LAST:event_btnOtroSistemaTxtMouseClicked

    private void btnSistemaGestorTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSistemaGestorTxtMouseEntered
        btnSistemaGestorTxt.setBackground(new Color(58, 77, 92));
    }//GEN-LAST:event_btnSistemaGestorTxtMouseEntered

    private void btnSistemaGestorTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSistemaGestorTxtMouseExited
        btnSistemaGestorTxt.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_btnSistemaGestorTxtMouseExited

    private void btnSistemaVotacionTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSistemaVotacionTxtMouseEntered
        btnSistemaVotacionTxt.setBackground(new Color(58, 77, 92));

    }//GEN-LAST:event_btnSistemaVotacionTxtMouseEntered

    private void btnSistemaVotacionTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSistemaVotacionTxtMouseExited
        btnSistemaVotacionTxt.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_btnSistemaVotacionTxtMouseExited

    private void btnOtroSistemaTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOtroSistemaTxtMouseEntered
        btnOtroSistemaTxt.setBackground(new Color(58, 77, 92));

    }//GEN-LAST:event_btnOtroSistemaTxtMouseEntered

    private void btnOtroSistemaTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOtroSistemaTxtMouseExited
        btnOtroSistemaTxt.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_btnOtroSistemaTxtMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JPanel bottomPanelContainer;
    private javax.swing.JPanel btnDosContainer;
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JLabel btnOtroSistemaTxt;
    private javax.swing.JLabel btnSistemaGestorTxt;
    private javax.swing.JLabel btnSistemaVotacionTxt;
    private javax.swing.JPanel btnTresContainer;
    private javax.swing.JPanel btnUnoContainer;
    private javax.swing.JPanel buttonsPanelContainer;
    private javax.swing.JPanel contentContainer;
    private javax.swing.JLabel copyrightsTxt;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel leftSideContainer;
    private javax.swing.JLabel logoIcon;
    // End of variables declaration//GEN-END:variables
}
