package com.gruposeispoo.vistas.usuarios;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.clases.Elector;
import com.gruposeispoo.vistas.Index;
import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;

public class UserLoginPane extends javax.swing.JPanel {

    private final UserVotoPane userVotoPane;
    private final Controlador controlador;
    private final Timer timer;
    private final Index contenedor;
    private String electorNombre;
    private boolean votoActivado;
    private final int rangoElectores;


    /**
     * CONSTRUCTOR
     *
     * @param contenedor
     */
    public UserLoginPane(Index contenedor) {
        initComponents();
        this.contenedor = contenedor;
        this.controlador = Controlador.getInstancia();
        this.userVotoPane = new UserVotoPane(this.contenedor);
        this.timer = new Timer();
        this.votoActivado = true;
        this.rangoElectores = controlador.getCantidadVotosRestantes();
        this.votosRestantesCantidadTxt.setVisible(false);
    }

    /**
     * Genere un ID elector valido. Este nunca podrá repetirse.
     * 
     * @return 
     */
    private int generarIdElectorValido() {
        Random electorIdRandom = new Random();
        Integer enteroRand = 0;

        while (true) {
            enteroRand = electorIdRandom.nextInt(rangoElectores);
            enteroRand += 1;
            if (!controlador.electoresConocidos().contains(enteroRand)) {
                controlador.agregarElectorConocido(enteroRand);
                break;
            }
        }
        
        return enteroRand;
    }

    /**
     * Establece el icono de un componente de feedback de input
     *
     * @param etiqueta
     * @param rutaRelativaIcon
     */
    private void setInputFeedbackIcon(JLabel etiqueta, String rutaRelativaIcon) {
        etiqueta.setIcon(new ImageIcon(getClass().getResource(rutaRelativaIcon)));
    }

    /**
     * Establece el estado de un componente de feedback de input
     *
     * @param etiqueta
     * @param colorBorde
     * @param colorFondo
     * @param colorLetra
     * @param mensaje
     */
    private void setInputFeedback(JLabel etiqueta, Color colorBorde, Color colorFondo, Color colorLetra, String mensaje) {
        etiqueta.setBorder(new javax.swing.border.LineBorder(colorBorde, 1, true));
        etiqueta.setBackground(colorFondo);
        etiqueta.setForeground(colorLetra);
        etiqueta.setText(mensaje);

        if (!etiqueta.isVisible()) {
            etiqueta.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InputFingerprintFeedbackContainer1 = new javax.swing.JPanel();
        InputFingerprintFeedbackTxt1 = new javax.swing.JLabel();
        contentContainer = new javax.swing.JPanel();
        fingerprintTxt = new javax.swing.JLabel();
        fingerprintIconContainer = new javax.swing.JPanel();
        fingerprintIcon = new javax.swing.JLabel();
        InputFingerprintFeedbackContainer = new javax.swing.JPanel();
        InputFingerprintFeedbackTxt = new javax.swing.JLabel();
        InputFingerprintCheckerContainer = new javax.swing.JPanel();
        InputFingerprintChecker = new javax.swing.JLabel();
        inputStepOneContainer = new javax.swing.JPanel();
        inputStepOneIcon = new javax.swing.JLabel();
        ingreseDocumentoTxt = new javax.swing.JLabel();
        headerContainer = new javax.swing.JPanel();
        headerTitleTxt = new javax.swing.JLabel();
        headerBarContainer = new javax.swing.JPanel();
        btnExitContainer = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        restantesTxt = new javax.swing.JLabel();
        votosRestantesCantidadTxt = new javax.swing.JLabel();

        InputFingerprintFeedbackContainer1.setBackground(new java.awt.Color(245, 244, 246));

        InputFingerprintFeedbackTxt1.setBackground(new java.awt.Color(245, 244, 246));
        InputFingerprintFeedbackTxt1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        InputFingerprintFeedbackTxt1.setForeground(new java.awt.Color(245, 244, 246));
        InputFingerprintFeedbackTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputFingerprintFeedbackTxt1.setText("Documento no encontrado");
        InputFingerprintFeedbackTxt1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(245, 244, 246), 1, true));
        InputFingerprintFeedbackTxt1.setOpaque(true);

        javax.swing.GroupLayout InputFingerprintFeedbackContainer1Layout = new javax.swing.GroupLayout(InputFingerprintFeedbackContainer1);
        InputFingerprintFeedbackContainer1.setLayout(InputFingerprintFeedbackContainer1Layout);
        InputFingerprintFeedbackContainer1Layout.setHorizontalGroup(
            InputFingerprintFeedbackContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputFingerprintFeedbackContainer1Layout.createSequentialGroup()
                .addComponent(InputFingerprintFeedbackTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        InputFingerprintFeedbackContainer1Layout.setVerticalGroup(
            InputFingerprintFeedbackContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputFingerprintFeedbackContainer1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InputFingerprintFeedbackTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setMinimumSize(new java.awt.Dimension(700, 590));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 590));

        contentContainer.setBackground(new java.awt.Color(245, 244, 246));
        contentContainer.setMinimumSize(new java.awt.Dimension(700, 590));
        contentContainer.setPreferredSize(new java.awt.Dimension(700, 590));
        contentContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fingerprintTxt.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        fingerprintTxt.setForeground(new java.awt.Color(43, 179, 205));
        fingerprintTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fingerprintTxt.setText("Sensor de huella digital dactilar");
        contentContainer.add(fingerprintTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 290, 20));

        fingerprintIconContainer.setBackground(new java.awt.Color(245, 244, 246));

        fingerprintIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fingerprintIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/fingerprintdisabled.png"))); // NOI18N
        fingerprintIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 244, 246), 2));
        fingerprintIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fingerprintIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fingerprintIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fingerprintIconContainerLayout = new javax.swing.GroupLayout(fingerprintIconContainer);
        fingerprintIconContainer.setLayout(fingerprintIconContainerLayout);
        fingerprintIconContainerLayout.setHorizontalGroup(
            fingerprintIconContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fingerprintIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        fingerprintIconContainerLayout.setVerticalGroup(
            fingerprintIconContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fingerprintIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );

        contentContainer.add(fingerprintIconContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 290, 220));

        InputFingerprintFeedbackContainer.setBackground(new java.awt.Color(245, 244, 246));

        InputFingerprintFeedbackTxt.setBackground(new java.awt.Color(203, 235, 251));
        InputFingerprintFeedbackTxt.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        InputFingerprintFeedbackTxt.setForeground(new java.awt.Color(43, 179, 205));
        InputFingerprintFeedbackTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputFingerprintFeedbackTxt.setText("Apoye el dedo pulgar ");
        InputFingerprintFeedbackTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 132, 171), 1, true));
        InputFingerprintFeedbackTxt.setOpaque(true);

        javax.swing.GroupLayout InputFingerprintFeedbackContainerLayout = new javax.swing.GroupLayout(InputFingerprintFeedbackContainer);
        InputFingerprintFeedbackContainer.setLayout(InputFingerprintFeedbackContainerLayout);
        InputFingerprintFeedbackContainerLayout.setHorizontalGroup(
            InputFingerprintFeedbackContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InputFingerprintFeedbackTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        InputFingerprintFeedbackContainerLayout.setVerticalGroup(
            InputFingerprintFeedbackContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InputFingerprintFeedbackTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        contentContainer.add(InputFingerprintFeedbackContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 290, 40));

        InputFingerprintCheckerContainer.setBackground(new java.awt.Color(245, 244, 246));

        InputFingerprintChecker.setBackground(new java.awt.Color(245, 244, 246));
        InputFingerprintChecker.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        InputFingerprintChecker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputFingerprintChecker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/info.png"))); // NOI18N

        javax.swing.GroupLayout InputFingerprintCheckerContainerLayout = new javax.swing.GroupLayout(InputFingerprintCheckerContainer);
        InputFingerprintCheckerContainer.setLayout(InputFingerprintCheckerContainerLayout);
        InputFingerprintCheckerContainerLayout.setHorizontalGroup(
            InputFingerprintCheckerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputFingerprintCheckerContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InputFingerprintChecker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        InputFingerprintCheckerContainerLayout.setVerticalGroup(
            InputFingerprintCheckerContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputFingerprintCheckerContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InputFingerprintChecker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentContainer.add(InputFingerprintCheckerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, -1, -1));

        inputStepOneContainer.setBackground(new java.awt.Color(245, 244, 246));

        inputStepOneIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inputStepOneIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gruposeispoo/vistas/images/stepone.png"))); // NOI18N
        inputStepOneIcon.setToolTipText("1 - Huella digital");

        javax.swing.GroupLayout inputStepOneContainerLayout = new javax.swing.GroupLayout(inputStepOneContainer);
        inputStepOneContainer.setLayout(inputStepOneContainerLayout);
        inputStepOneContainerLayout.setHorizontalGroup(
            inputStepOneContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputStepOneIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );
        inputStepOneContainerLayout.setVerticalGroup(
            inputStepOneContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputStepOneIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        contentContainer.add(inputStepOneContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        ingreseDocumentoTxt.setFont(new java.awt.Font("Roboto Black", 1, 28)); // NOI18N
        ingreseDocumentoTxt.setForeground(new java.awt.Color(43, 179, 205));
        ingreseDocumentoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingreseDocumentoTxt.setText("INGRESAR AL SISTEMA");
        ingreseDocumentoTxt.setToolTipText("");
        contentContainer.add(ingreseDocumentoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 490, 30));

        headerContainer.setBackground(new java.awt.Color(245, 244, 246));

        headerTitleTxt.setBackground(new java.awt.Color(245, 244, 246));
        headerTitleTxt.setFont(new java.awt.Font("Roboto Black", 1, 40)); // NOI18N
        headerTitleTxt.setForeground(new java.awt.Color(43, 179, 205));
        headerTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleTxt.setText("Sistema de voto electrónico");

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

        restantesTxt.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        restantesTxt.setForeground(new java.awt.Color(43, 179, 205));
        restantesTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restantesTxt.setText("Restantes:");
        contentContainer.add(restantesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 70, 30));

        votosRestantesCantidadTxt.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        votosRestantesCantidadTxt.setForeground(new java.awt.Color(43, 179, 205));
        votosRestantesCantidadTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentContainer.add(votosRestantesCantidadTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fingerprintIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fingerprintIconMouseClicked
        Integer enteroRand = generarIdElectorValido();
        Elector electorAuxiliar;

        if (InputFingerprintChecker.isVisible()) {
            InputFingerprintChecker.setVisible(false);
        }

        if (votoActivado) {
            if (controlador.existeElector(enteroRand) != null) {

                votoActivado = false;
                controlador.descontarVoto();
                votosRestantesCantidadTxt.setVisible(true);
                votosRestantesCantidadTxt.setText(String.valueOf(controlador.getCantidadVotosRestantes()));
                controlador.setIdVotante(enteroRand);
                electorAuxiliar = controlador.buscarElectorPorId(enteroRand);
                electorNombre = electorAuxiliar.getNombre() + " " + electorAuxiliar.getApellido();

                /*
            SETEO DEL INPUT CHECKER - PASO 1
                 */
                setInputFeedbackIcon(inputStepOneIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/steponeactived.png");    //RutaRelativaIcon
                /*
            SETEO DEL INPUT CHECKER - HUELLA DIGITAL (HUELLA DIGITAL VERDE)
                 */
                setInputFeedbackIcon(fingerprintIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/fingerprintvalid.png");    //RutaRelativaIcon
                /*
            SETEO DEL INPUT CHECKER - HUELLA DIGITAL (BORDE, FONDO Y LETRA)
                 */
                setInputFeedback(fingerprintIcon, //Etiqueta
                        new Color(35, 233, 35), //ColorBorde
                        new Color(245, 244, 246), //ColorFondo
                        new Color(245, 244, 246), //ColorLetra
                        null);  //Mensaje
                /*
            SETEO DEL INPUT FEEDBACK - MENSAJE DEBAJO DE LA HUELLA DIGITAL (BORDE, DONDO, LETRA Y MENSAJE)
                 */
                setInputFeedback(InputFingerprintFeedbackTxt, //Etiqueta
                        new Color(129, 203, 169), //ColorBorde
                        new Color(218, 241, 214), //ColorFondo
                        new Color(88, 184, 145), //ColorLetra
                        electorNombre);  //Mensaje

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        contenedor.setBotoneraEnabled(false);
                        userVotoPane.setNombreElectorTxt(electorNombre);
                        contenedor.actualizarContentPane(userVotoPane);
                    }
                }, 1500);

            } else {
                /*
            SETEO DEL INPUT CHECKER - PASO 1
                 */
                setInputFeedbackIcon(inputStepOneIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/stepone.png");    //RutaRelativaIcon
                /*
            SETEO DEL INPUT CHECKER - HUELLA DIGITAL (HUELLA DIGITAL ROJA)
                 */
                setInputFeedbackIcon(fingerprintIcon, //Etiqueta
                        "/com/gruposeispoo/vistas/images/fingerprintnovalid.png");    //RutaRelativaIcon

                /*
            SETEO DEL INPUT CHECKER - HUELLA DIGITAL
                 */
                setInputFeedback(fingerprintIcon, //Etiqueta
                        new Color(255, 22, 22), //ColorBorde
                        new Color(245, 244, 246), //ColorFondo
                        new Color(245, 244, 246), //ColorLetra
                        null);  //Mensaje

                setInputFeedback(InputFingerprintFeedbackTxt, //Etiqueta
                        new Color(220, 192, 196), //ColorBorde
                        new Color(254, 220, 224), //ColorFondo
                        new Color(132, 26, 33), //ColorLetra
                        "Intente nuevamente");  //Mensaje
            }
        }
    }//GEN-LAST:event_fingerprintIconMouseClicked

    private void headerBarContainerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarContainerMouseDragged

    }//GEN-LAST:event_headerBarContainerMouseDragged

    private void headerBarContainerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarContainerMousePressed

    }//GEN-LAST:event_headerBarContainerMousePressed

    private void btnExitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitTxtMouseClicked

    private void btnExitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseEntered
        this.btnExitTxt.setBackground(Color.red);
    }//GEN-LAST:event_btnExitTxtMouseEntered

    private void btnExitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTxtMouseExited
        this.btnExitTxt.setBackground(new Color(199, 80, 80));
    }//GEN-LAST:event_btnExitTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InputFingerprintChecker;
    private javax.swing.JPanel InputFingerprintCheckerContainer;
    private javax.swing.JPanel InputFingerprintFeedbackContainer;
    private javax.swing.JPanel InputFingerprintFeedbackContainer1;
    private javax.swing.JLabel InputFingerprintFeedbackTxt;
    private javax.swing.JLabel InputFingerprintFeedbackTxt1;
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel contentContainer;
    private javax.swing.JLabel fingerprintIcon;
    private javax.swing.JPanel fingerprintIconContainer;
    private javax.swing.JLabel fingerprintTxt;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JLabel ingreseDocumentoTxt;
    private javax.swing.JPanel inputStepOneContainer;
    private javax.swing.JLabel inputStepOneIcon;
    private javax.swing.JLabel restantesTxt;
    private javax.swing.JLabel votosRestantesCantidadTxt;
    // End of variables declaration//GEN-END:variables
}
