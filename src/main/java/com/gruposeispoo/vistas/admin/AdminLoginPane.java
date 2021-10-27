package com.gruposeispoo.vistas.admin;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.vistas.Index;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AdminLoginPane extends javax.swing.JPanel {
    /*
        COMENTADO: NO ELIMINAR EL ATRIBUTO DE ABAJO (SE ESTA TRABAJANDO EN LA CLASE adminGraficoPrueba
    */
    private AdminGraficoPrueba adminGraficoPrueba = new AdminGraficoPrueba();
    
    private Index contenedor;
    /**
     * Usuario comienza vacio. No nulo, no con espacios.
     */
    private String usuario = "";
    /**
     * Contrasenia comienza vacia. No nula, no con espacios.
     */
    private String contrasenia = "";

    /**
     * CONSTRUCTOR
     *
     * @param contenedor
     */
    public AdminLoginPane(Index contenedor) {
        initComponents();
        this.contenedor = contenedor;
        setIngresoSistemaAuditor(false);
    }

    /**
     * Activa (activado == true) o desactiva (activado == false) el acceso al
     * sistema auditor
     *
     * @param activado
     */
    private void setIngresoSistemaAuditor(boolean activado) {
        btnIngresarTxt.setVisible(activado);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentContainer = new javax.swing.JPanel();
        iniciarSesionTxt = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JLabel();
        inputUsuario = new javax.swing.JTextField();
        inputUsuarioStatus = new javax.swing.JSeparator();
        contraseniaTxt = new javax.swing.JLabel();
        inputContraseniaStatus = new javax.swing.JSeparator();
        inputContrasenia = new javax.swing.JPasswordField();
        adminCardContainer = new javax.swing.JPanel();
        adminIcon = new javax.swing.JLabel();
        btnIngresarContainer = new javax.swing.JPanel();
        btnIngresarTxt = new javax.swing.JLabel();
        InputUsuarioCheckerContainer = new javax.swing.JPanel();
        InputUsuarioCheckerIcon = new javax.swing.JLabel();
        InputContraseniaCheckerContainer = new javax.swing.JPanel();
        InputContraseniaCheckerIcon = new javax.swing.JLabel();
        headerContainer = new javax.swing.JPanel();
        headerTitleTxt = new javax.swing.JLabel();
        headerBarContainer = new javax.swing.JPanel();
        btnExitContainer = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(700, 590));
        setPreferredSize(new java.awt.Dimension(700, 590));

        contentContainer.setBackground(new java.awt.Color(245, 244, 246));
        contentContainer.setMinimumSize(new java.awt.Dimension(700, 540));
        contentContainer.setPreferredSize(new java.awt.Dimension(700, 540));
        contentContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciarSesionTxt.setBackground(new java.awt.Color(245, 244, 246));
        iniciarSesionTxt.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        iniciarSesionTxt.setForeground(new java.awt.Color(43, 179, 205));
        iniciarSesionTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iniciarSesionTxt.setText("INICIAR SESIÓN");
        iniciarSesionTxt.setToolTipText("");
        iniciarSesionTxt.setOpaque(true);
        contentContainer.add(iniciarSesionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 300, 50));

        usuarioTxt.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        usuarioTxt.setForeground(new java.awt.Color(43, 179, 205));
        usuarioTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarioTxt.setText("USUARIO");
        contentContainer.add(usuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, 30));

        inputUsuario.setBackground(new java.awt.Color(245, 244, 246));
        inputUsuario.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        inputUsuario.setForeground(new java.awt.Color(153, 153, 153));
        inputUsuario.setText("Ingrese su nombre de usuario");
        inputUsuario.setToolTipText("");
        inputUsuario.setBorder(null);
        inputUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputUsuarioFocusLost(evt);
            }
        });
        inputUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputUsuarioMousePressed(evt);
            }
        });
        inputUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsuarioActionPerformed(evt);
            }
        });
        inputUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputUsuarioKeyReleased(evt);
            }
        });
        contentContainer.add(inputUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 280, 50));

        inputUsuarioStatus.setBackground(new java.awt.Color(0, 0, 0));
        inputUsuarioStatus.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        contentContainer.add(inputUsuarioStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 280, 10));

        contraseniaTxt.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        contraseniaTxt.setForeground(new java.awt.Color(43, 179, 205));
        contraseniaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contraseniaTxt.setText("CONTRASEÑA");
        contentContainer.add(contraseniaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 130, 30));

        inputContraseniaStatus.setBackground(new java.awt.Color(0, 0, 0));
        inputContraseniaStatus.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        contentContainer.add(inputContraseniaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 280, 10));

        inputContrasenia.setBackground(new java.awt.Color(245, 244, 246));
        inputContrasenia.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        inputContrasenia.setForeground(new java.awt.Color(153, 153, 153));
        inputContrasenia.setText("********");
        inputContrasenia.setToolTipText("");
        inputContrasenia.setBorder(null);
        inputContrasenia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputContraseniaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputContraseniaFocusLost(evt);
            }
        });
        inputContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputContraseniaMousePressed(evt);
            }
        });
        inputContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputContraseniaActionPerformed(evt);
            }
        });
        inputContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputContraseniaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputContraseniaKeyReleased(evt);
            }
        });
        contentContainer.add(inputContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 280, 50));

        adminCardContainer.setBackground(new java.awt.Color(245, 244, 246));

        adminIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/admin.png"))); // NOI18N

        javax.swing.GroupLayout adminCardContainerLayout = new javax.swing.GroupLayout(adminCardContainer);
        adminCardContainer.setLayout(adminCardContainerLayout);
        adminCardContainerLayout.setHorizontalGroup(
            adminCardContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 240, Short.MAX_VALUE)
        );
        adminCardContainerLayout.setVerticalGroup(
            adminCardContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
        );

        contentContainer.add(adminCardContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 240, 200));

        btnIngresarContainer.setBackground(new java.awt.Color(245, 244, 246));
        btnIngresarContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresarTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnIngresarTxt.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnIngresarTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIngresarTxt.setText("INGRESAR");
        btnIngresarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresarTxt.setOpaque(true);
        btnIngresarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarTxtMouseExited(evt);
            }
        });
        btnIngresarContainer.add(btnIngresarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        contentContainer.add(btnIngresarContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 180, 40));

        InputUsuarioCheckerContainer.setBackground(new java.awt.Color(245, 244, 246));

        InputUsuarioCheckerIcon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InputUsuarioCheckerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputUsuarioCheckerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/neutral.png"))); // NOI18N

        javax.swing.GroupLayout InputUsuarioCheckerContainerLayout = new javax.swing.GroupLayout(InputUsuarioCheckerContainer);
        InputUsuarioCheckerContainer.setLayout(InputUsuarioCheckerContainerLayout);
        InputUsuarioCheckerContainerLayout.setHorizontalGroup(
            InputUsuarioCheckerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputUsuarioCheckerContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InputUsuarioCheckerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InputUsuarioCheckerContainerLayout.setVerticalGroup(
            InputUsuarioCheckerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputUsuarioCheckerContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InputUsuarioCheckerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentContainer.add(InputUsuarioCheckerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 40, 40));

        InputContraseniaCheckerContainer.setBackground(new java.awt.Color(245, 244, 246));

        InputContraseniaCheckerIcon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InputContraseniaCheckerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputContraseniaCheckerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/neutral.png"))); // NOI18N

        javax.swing.GroupLayout InputContraseniaCheckerContainerLayout = new javax.swing.GroupLayout(InputContraseniaCheckerContainer);
        InputContraseniaCheckerContainer.setLayout(InputContraseniaCheckerContainerLayout);
        InputContraseniaCheckerContainerLayout.setHorizontalGroup(
            InputContraseniaCheckerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputContraseniaCheckerContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InputContraseniaCheckerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InputContraseniaCheckerContainerLayout.setVerticalGroup(
            InputContraseniaCheckerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputContraseniaCheckerContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InputContraseniaCheckerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentContainer.add(InputContraseniaCheckerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 40, 40));

        headerContainer.setBackground(new java.awt.Color(245, 244, 246));

        headerTitleTxt.setBackground(new java.awt.Color(245, 244, 246));
        headerTitleTxt.setFont(new java.awt.Font("Roboto Black", 1, 40)); // NOI18N
        headerTitleTxt.setForeground(new java.awt.Color(43, 179, 205));
        headerTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleTxt.setText("Sistema auditor de votos");

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

        javax.swing.GroupLayout headerBarContainerLayout = new javax.swing.GroupLayout(headerBarContainer);
        headerBarContainer.setLayout(headerBarContainerLayout);
        headerBarContainerLayout.setHorizontalGroup(
            headerBarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerBarContainerLayout.setVerticalGroup(
            headerBarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

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
            .addComponent(btnExitTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerContainerLayout = new javax.swing.GroupLayout(headerContainer);
        headerContainer.setLayout(headerContainerLayout);
        headerContainerLayout.setHorizontalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerContainerLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(headerTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(headerContainerLayout.createSequentialGroup()
                .addComponent(headerBarContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(btnExitContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerContainerLayout.setVerticalGroup(
            headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerContainerLayout.createSequentialGroup()
                .addGroup(headerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerBarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentContainer.add(headerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * El input de usuario gana el foco, se vacia y cambia su color de letra
     *
     * @param evt
     */
    private void inputUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputUsuarioFocusGained
        if (inputUsuario.getText().isEmpty()) {
            inputUsuario.setText("");
            inputUsuario.setForeground(new Color(57, 77, 93));
        }
    }//GEN-LAST:event_inputUsuarioFocusGained
    /**
     * El input de usuario pierde el foco, si esta vacio o con espacios, se
     * cambia el color de letra y se le establece el text por defecto
     *
     * @param evt
     */
    private void inputUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputUsuarioFocusLost
        if (inputUsuario.getText().isEmpty() || inputUsuario.getText().isBlank()) {
            inputUsuario.setForeground(new Color(153, 153, 153));
            inputUsuario.setText("Ingrese su nombre de usuario");
        }
    }//GEN-LAST:event_inputUsuarioFocusLost
    /**
     * El input de usuario tiene el mouse presionado sobre el mismo. Si el input
     * tiene el texto por defecto lo vaciamos y le cambiamos el color de la
     * letra
     *
     * @param evt
     */
    private void inputUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputUsuarioMousePressed
        if (inputUsuario.getText().equals("Ingrese su nombre de usuario")) {
            inputUsuario.setText("");
            inputUsuario.setForeground(new Color(57, 77, 93));
        }
    }//GEN-LAST:event_inputUsuarioMousePressed

    private void inputUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUsuarioActionPerformed
    /**
     * El input de usuario tiene una tecla presionada. Si el input tiene el
     * texto por defecto lo vaciamos y le cambiamos el color de la letra
     *
     *
     * @param evt
     */
    private void inputUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputUsuarioKeyPressed
        if (inputUsuario.getText().equals("Ingrese su nombre de usuario")) {
            inputUsuario.setText("");
            inputUsuario.setForeground(new Color(57, 77, 93));
        }
    }//GEN-LAST:event_inputUsuarioKeyPressed
    /**
     * El input del usuario tiene una tecla levantada. Verificamos si el texto
     * ingresado corresponde a un nombre de usuario
     *
     * @param evt
     */
    private void inputUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputUsuarioKeyReleased
        if (Controlador.existeUsuario(inputUsuario.getText())) {
            usuario = inputUsuario.getText();
            setButtonIcon(InputUsuarioCheckerIcon, //Etiqueta
                    "/com/gruposeispoo/vistas/images/check.png");    //RutaRelativaIcon
        } else {
            usuario = "";
            inputContraseniaKeyReleased(evt);
            inputContrasenia.setText("");
            if (!inputUsuario.getText().isEmpty()) {
                setButtonIcon(InputUsuarioCheckerIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/error.png");    //RutaRelativaIcon
            } else {
                setButtonIcon(InputUsuarioCheckerIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/neutral.png");    //RutaRelativaIcon
            }
        }
    }//GEN-LAST:event_inputUsuarioKeyReleased
    /**
     * El input de contrasenia gana el foco, se vacia y cambia su color de letra
     *
     * @param evt
     */
    private void inputContraseniaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputContraseniaFocusGained
        String contra = String.valueOf(inputContrasenia.getPassword());

        if (contra.isEmpty()) {
            inputContrasenia.setText("");
            inputContrasenia.setForeground(new Color(57, 77, 93));
        }
    }//GEN-LAST:event_inputContraseniaFocusGained

    /**
     * El input de contrasenia pierde el foco, si esta vacio o con espacios, se
     * cambia el color de letra y se le establece el text por defecto
     *
     * @param evt
     */
    private void inputContraseniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputContraseniaFocusLost
        String contra = String.valueOf(inputContrasenia.getPassword());

        if (contra.isEmpty() || contra.isBlank()) {
            inputContrasenia.setForeground(new Color(153, 153, 153));
            inputContrasenia.setText("********");
        }
    }//GEN-LAST:event_inputContraseniaFocusLost
    /**
     * El input de contrasenia tiene el mouse presionado sobre el mismo. Si el
     * input tiene el texto por defecto lo vaciamos y le cambiamos el color de
     * la letra
     *
     * @param evt
     */
    private void inputContraseniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputContraseniaMousePressed
        String contra = String.valueOf(inputContrasenia.getPassword());

        if (contra.equals("********")) {
            inputContrasenia.setText("");
            inputContrasenia.setForeground(new Color(57, 77, 93));
        }
    }//GEN-LAST:event_inputContraseniaMousePressed

    private void inputContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputContraseniaActionPerformed
    /**
     * El input de contrasenia tiene una tecla presionada. Si el input tiene el
     * texto por defecto lo vaciamos y le cambiamos el color de la letra
     *
     *
     * @param evt
     */
    private void inputContraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputContraseniaKeyPressed
        String contra = String.valueOf(inputContrasenia.getPassword());

        if (contra.equals("********")) {
            inputContrasenia.setText("");
            inputContrasenia.setForeground(new Color(57, 77, 93));
        }
    }//GEN-LAST:event_inputContraseniaKeyPressed
    /**
     * El input del contrasenia tiene una tecla levantada. Verificamos si el
     * texto ingresado corresponde a un nombre de usuario
     *
     * @param evt
     */
    private void inputContraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputContraseniaKeyReleased
        String contra = String.valueOf(inputContrasenia.getPassword());

        if (!usuario.isEmpty()) {
            contrasenia = contra;
            if (Controlador.verificadorDeUsuario(usuario, contrasenia)) {
                setButtonIcon(InputContraseniaCheckerIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/check.png");    //RutaRelativaIcon
                setIngresoSistemaAuditor(true);
            } else {
                setIngresoSistemaAuditor(false);
                setButtonIcon(InputContraseniaCheckerIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/error.png");    //RutaRelativaIcon
            }
        } else {
            setIngresoSistemaAuditor(false);
            contrasenia = "";
            if (!contra.isEmpty()) {
                setButtonIcon(InputContraseniaCheckerIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/error.png");    //RutaRelativaIcon
            } else {
                setButtonIcon(InputContraseniaCheckerIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/neutral.png");    //RutaRelativaIcon
            }
        }
    }//GEN-LAST:event_inputContraseniaKeyReleased

    private void btnIngresarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarTxtMouseEntered
        btnIngresarTxt.setBackground(new Color(58, 77, 92));
    }//GEN-LAST:event_btnIngresarTxtMouseEntered

    private void btnIngresarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarTxtMouseExited
        btnIngresarTxt.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_btnIngresarTxtMouseExited

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

    private void btnIngresarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarTxtMouseClicked
        //NO ELIMINAR LA LINEA DE ABAJO:SE ESTÁTRABAJANDO EN adminGraficoPrueba
        contenedor.actualizarContentPane(adminGraficoPrueba);
    }//GEN-LAST:event_btnIngresarTxtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InputContraseniaCheckerContainer;
    private javax.swing.JLabel InputContraseniaCheckerIcon;
    private javax.swing.JPanel InputUsuarioCheckerContainer;
    private javax.swing.JLabel InputUsuarioCheckerIcon;
    private javax.swing.JPanel adminCardContainer;
    private javax.swing.JLabel adminIcon;
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel btnIngresarContainer;
    private javax.swing.JLabel btnIngresarTxt;
    private javax.swing.JPanel contentContainer;
    private javax.swing.JLabel contraseniaTxt;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JLabel iniciarSesionTxt;
    private javax.swing.JPasswordField inputContrasenia;
    private javax.swing.JSeparator inputContraseniaStatus;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JSeparator inputUsuarioStatus;
    private javax.swing.JLabel usuarioTxt;
    // End of variables declaration//GEN-END:variables
}
