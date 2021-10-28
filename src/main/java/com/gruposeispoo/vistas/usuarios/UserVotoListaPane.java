package com.gruposeispoo.vistas.usuarios;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.clases.ListaPolitica;
import com.gruposeispoo.clases.Voto;
import com.gruposeispoo.vistas.Index;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Box;
import javax.swing.JPanel;

public class UserVotoListaPane extends javax.swing.JPanel {

    /**
     * ATRIBUTOS
     *
     */
    private JPanel listaSeleccionada = null;
    private List<UserBoletaPane> boletas = new ArrayList<>();
    private boolean selectedListaTieneUnaLista = false;
    private Index contenedor;

    /**
     * CONSTRUCTOR
     *
     */
    public UserVotoListaPane(Index contenedor) {
        initComponents();
        this.contenedor = contenedor;
        //separadorDeBoletaSuperior
        listasContainer.add(Box.createRigidArea(new Dimension(10, 10)));
        //BoletaEnBlancoParaVotoEnBlanco
        listasContainer.add(new UserBoletaEnBlancoPane(this));
        //MostrarBoletasEnPantalla
        mostrarBoletas();
        //Comienzo con botones invisibles
        btnConfirmarTxt.setVisible(false);
        btnVotarTxt.setVisible(false);
    }

    /**
     * Imprime todas las boletas en el contenedor
     *
     */
    private void mostrarBoletas() {
        setBoletas();
        agregarBoletas(boletas);
    }

    /**
     * LLena la lista de boletas con las correspondientes representaciones
     * gráficas de las listas politicas en listasPoliticas
     *
     */
    public void setBoletas() {
        List<ListaPolitica> listasPoliticas = Controlador.getListasPolticas();

        for (ListaPolitica listaPolitica : listasPoliticas) {
            UserBoletaPane nuevaBoleta = (UserBoletaPane) listaPoliticaABoletaPane(listaPolitica.getNumero(), listaPolitica.getNombre());
            boletas.add(nuevaBoleta);
        }
    }

    /**
     * Obtiene un color desde UserBoletaPane.
     *
     * @param numero, debe ser un entero entre 0 y 9
     * @return Color, el color correspondiente al numero
     */
    public Color getOneColor(int numero) {
        if (numero > 9) {
            throw new IllegalArgumentException("No existe el color " + numero);
        }

        switch (numero) {
            case 0: {
                return UserBoletaPane.COLOR_AMARILLO;
            }
            case 1: {
                return UserBoletaPane.COLOR_AZUL;
            }
            case 2: {
                return UserBoletaPane.COLOR_CELESTE;
            }
            case 3: {
                return UserBoletaPane.COLOR_GRIS;
            }
            case 4: {
                return UserBoletaPane.COLOR_MARRON;
            }
            case 5: {
                return UserBoletaPane.COLOR_NARANJA;
            }
            case 6: {
                return UserBoletaPane.COLOR_NEGRO;
            }
            case 7: {
                return UserBoletaPane.COLOR_VERDE;
            }
            case 8: {
                return UserBoletaPane.COLOR_VIOLETA;
            }
            case 9: {
                return UserBoletaPane.COLOR_ROJO;
            }
            default: {
                return UserBoletaPane.COLOR_GRIS;
            }
        }
    }

    /**
     * Crea una representación gráfica de una lista politica
     *
     * @param numero
     * @param nombre
     * @return
     */
    public JPanel listaPoliticaABoletaPane(Integer numero, String nombre) {
        Random colorRandom = new Random();
        Integer enteroRand = colorRandom.nextInt(10);

        return new UserBoletaPane(this, numero, nombre, getOneColor(enteroRand));
    }

    /**
     * Actualiza el contenido del panel
     *
     * @param panel, panel a actualizar
     */
    private void actualizarPane(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }

    /**
     * Controla la selección de la lista a votar.
     *
     * Asegura que el usuario vote una sola lista
     *
     * @param boleta, boleta clickeada en su contenedor padre
     */
    public void selectedListaPanel(JPanel boleta) {
        if (!listasContainer.isEnabled()) {
            return;
        }
        if (!selectedListaTieneUnaLista) {
            listaSeleccionada = boleta;
            selectedListaTieneUnaLista = true;
            //contenedor.setVisible(btnConfirmarTxt, true);
            btnConfirmarTxt.setVisible(true);
        } else {
            if (boleta.equals(listaSeleccionada)) {
                agregarBoleta(boleta, listasContainer);
                listaSelectedContainer.removeAll();
                actualizarPane(listaSelectedContainer);
                actualizarPane(listasContainer);
                selectedListaTieneUnaLista = false;
                //contenedor.setVisible(btnConfirmarTxt, false);
                btnConfirmarTxt.setVisible(false);
                return;
            } else {
                agregarBoleta(listaSeleccionada, listasContainer);
                listaSelectedContainer.removeAll();
                agregarBoleta(boleta, listaSelectedContainer);
                listaSeleccionada = boleta;
                actualizarPane(listaSelectedContainer);
                actualizarPane(listasContainer);
                return;
            }
        }
        agregarBoleta(boleta, listaSelectedContainer);
        actualizarPane(listaSelectedContainer);
    }

    /**
     * Agrega un panel hijo(boleta) a un panel padre(contenedor)
     *
     * @param boleta, boleta a mostrar
     * @param contenedor, panel padre o contenedor de la boleta
     */
    private void agregarBoleta(JPanel boleta, JPanel contenedor) {
        boleta.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(boleta);
    }

    /**
     * Agrega una única boleta al contenedor correspondiente
     *
     * @param boleta, boleta a mostrar
     */
    private void agregarBoleta(JPanel boleta) {
        agregarBoleta(boleta, listasContainer);
    }

    /**
     * Agrega las las boletas de listaBoletas al contenedor correspondiente
     *
     * @param listaBoletas, lista de boletas para mostrar
     */
    private void agregarBoletas(List<UserBoletaPane> listaBoletas) {

        listaBoletas.forEach(boleta -> {
            agregarBoleta(boleta);
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgContainer = new javax.swing.JPanel();
        headerContainer = new javax.swing.JPanel();
        headerTitleTxt = new javax.swing.JLabel();
        headerBarContainer = new javax.swing.JPanel();
        btnExitContainer = new javax.swing.JPanel();
        btnExitTxt = new javax.swing.JLabel();
        listaSelectedContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listasContainer = new javax.swing.JPanel();
        botoneraContainer = new javax.swing.JPanel();
        btnVotarContainer = new javax.swing.JPanel();
        btnVotarTxt = new javax.swing.JLabel();
        diputadosTitleTxt = new javax.swing.JLabel();
        diputadosTitleTxt1 = new javax.swing.JLabel();
        btnConfirmarContainer = new javax.swing.JPanel();
        btnConfirmarTxt = new javax.swing.JLabel();

        bgContainer.setBackground(new java.awt.Color(245, 244, 246));

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

        listaSelectedContainer.setBackground(new java.awt.Color(255, 255, 255));
        listaSelectedContainer.setMaximumSize(new java.awt.Dimension(200, 250));
        listaSelectedContainer.setMinimumSize(new java.awt.Dimension(200, 250));
        listaSelectedContainer.setLayout(new javax.swing.BoxLayout(listaSelectedContainer, javax.swing.BoxLayout.Y_AXIS));

        listasContainer.setBackground(new java.awt.Color(255, 255, 255));
        listasContainer.setMaximumSize(new java.awt.Dimension(200, 250));
        listasContainer.setMinimumSize(new java.awt.Dimension(200, 250));
        listasContainer.setLayout(new javax.swing.BoxLayout(listasContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(listasContainer);

        botoneraContainer.setBackground(new java.awt.Color(245, 244, 246));

        btnVotarTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnVotarTxt.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnVotarTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnVotarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVotarTxt.setText("VOTAR");
        btnVotarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVotarTxt.setOpaque(true);
        btnVotarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVotarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVotarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVotarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnVotarContainerLayout = new javax.swing.GroupLayout(btnVotarContainer);
        btnVotarContainer.setLayout(btnVotarContainerLayout);
        btnVotarContainerLayout.setHorizontalGroup(
            btnVotarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVotarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        btnVotarContainerLayout.setVerticalGroup(
            btnVotarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVotarContainerLayout.createSequentialGroup()
                .addComponent(btnVotarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout botoneraContainerLayout = new javax.swing.GroupLayout(botoneraContainer);
        botoneraContainer.setLayout(botoneraContainerLayout);
        botoneraContainerLayout.setHorizontalGroup(
            botoneraContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoneraContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVotarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        botoneraContainerLayout.setVerticalGroup(
            botoneraContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoneraContainerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnVotarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        diputadosTitleTxt.setBackground(new java.awt.Color(0, 0, 0));
        diputadosTitleTxt.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        diputadosTitleTxt.setForeground(new java.awt.Color(43, 179, 205));
        diputadosTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diputadosTitleTxt.setText("Listas Politicas");

        diputadosTitleTxt1.setBackground(new java.awt.Color(0, 0, 0));
        diputadosTitleTxt1.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        diputadosTitleTxt1.setForeground(new java.awt.Color(43, 179, 205));
        diputadosTitleTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diputadosTitleTxt1.setText("Lista Seleccionada");

        btnConfirmarTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnConfirmarTxt.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnConfirmarTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfirmarTxt.setText("CONFIRMAR");
        btnConfirmarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarTxt.setOpaque(true);
        btnConfirmarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnConfirmarContainerLayout = new javax.swing.GroupLayout(btnConfirmarContainer);
        btnConfirmarContainer.setLayout(btnConfirmarContainerLayout);
        btnConfirmarContainerLayout.setHorizontalGroup(
            btnConfirmarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConfirmarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        );
        btnConfirmarContainerLayout.setVerticalGroup(
            btnConfirmarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConfirmarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgContainerLayout = new javax.swing.GroupLayout(bgContainer);
        bgContainer.setLayout(bgContainerLayout);
        bgContainerLayout.setHorizontalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoneraContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diputadosTitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgContainerLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diputadosTitleTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaSelectedContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        bgContainerLayout.setVerticalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addComponent(headerContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diputadosTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diputadosTitleTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgContainerLayout.createSequentialGroup()
                        .addComponent(listaSelectedContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botoneraContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnVotarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVotarTxtMouseEntered
        btnVotarTxt.setBackground(new Color(58, 77, 92));
    }//GEN-LAST:event_btnVotarTxtMouseEntered

    private void btnVotarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVotarTxtMouseExited
        btnVotarTxt.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_btnVotarTxtMouseExited

    private void btnConfirmarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarTxtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarTxtMouseEntered

    private void btnConfirmarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarTxtMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarTxtMouseExited

    private void btnConfirmarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarTxtMouseClicked
        //contenedor.setVisible(btnVotarTxt, true);
        listasContainer.removeAll();
        listasContainer.setEnabled(false);
        btnVotarTxt.setVisible(true);
        btnConfirmarTxt.setVisible(false);
    }//GEN-LAST:event_btnConfirmarTxtMouseClicked

    private void btnVotarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVotarTxtMouseClicked
        UserBoletaPane boletaVotada;
        UserBoletaEnBlancoPane boletaEnBlanco;

        if (listaSelectedContainer.getComponent(0) instanceof UserBoletaPane) {
            boletaVotada = (UserBoletaPane) listaSelectedContainer.getComponent(0);
            Controlador.setNumeroListaVotadaUno(boletaVotada.getNumero());
        }

        if (listaSelectedContainer.getComponent(0) instanceof UserBoletaEnBlancoPane) {
            boletaEnBlanco = (UserBoletaEnBlancoPane) listaSelectedContainer.getComponent(0);
            Controlador.setNumeroListaVotadaUno(boletaEnBlanco.getNumero());
        }

        Voto EliminarEsto = Controlador.nuevoVoto();
        System.out.println(EliminarEsto.toString());

        contenedor.setBotoneraEnabled(true);
        contenedor.generarNuevaInstanciaDeVotacion();
    }//GEN-LAST:event_btnVotarTxtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JPanel botoneraContainer;
    private javax.swing.JPanel btnConfirmarContainer;
    private javax.swing.JLabel btnConfirmarTxt;
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel btnVotarContainer;
    private javax.swing.JLabel btnVotarTxt;
    private javax.swing.JLabel diputadosTitleTxt;
    private javax.swing.JLabel diputadosTitleTxt1;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listaSelectedContainer;
    private javax.swing.JPanel listasContainer;
    // End of variables declaration//GEN-END:variables
}
