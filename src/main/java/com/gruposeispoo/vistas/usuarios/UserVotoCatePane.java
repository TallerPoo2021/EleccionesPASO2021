package com.gruposeispoo.vistas.usuarios;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.clases.ListaPolitica;
import com.gruposeispoo.clases.Voto;
import com.gruposeispoo.vistas.Index;
import com.gruposeispoo.vistas.IndexSlidePane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JPanel;

public class UserVotoCatePane extends javax.swing.JPanel {

    private List<UserCorteBoletaPane> boletas = new ArrayList<>();
    private int nroBoletaSenadoresVotada = 0;
    private int nroBoletaDiputadosVotada = 0;
    private final Controlador controlador;
    private final Index contenedor;
    private final IndexSlidePane slidePane;

    /**
     * Constructor
     *
     * @param contenedor
     */
    public UserVotoCatePane(Index contenedor) {
        initComponents();
        this.contenedor = contenedor;
        slidePane = new IndexSlidePane(contenedor, false);
        controlador = Controlador.getInstancia();
        //separadorDeBoletaSuperior
        senadoresContainer.add(Box.createRigidArea(new Dimension(10, 10)));
        diputadosContainer.add(Box.createRigidArea(new Dimension(10, 10)));
        //BoletaEnBlancoParaVotoEnBlanco
        diputadosContainer.add(new UserBoletaEnBlancoPane(this, true));
        senadoresContainer.add(new UserBoletaEnBlancoPane(this, false));
        //MostrarBoletasEnPantalla
        mostrarBoletas();
        //Comienzo con botones invisibles
        btnConfirmarTxt.setVisible(false);
        btnVotarTxt.setVisible(false);
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
     * Dado un contenedor de boletas de corteBoleta y una boleta de corteBoleta
     * clickeada, procedemos a distinguir dicha boleta de las demás sin clickear
     *
     * @param boletaClickeada
     */
    public void actualizarTodasLasBoletas(JPanel boletaClickeada) {
        int c = 0;
        UserCorteBoletaPane boletaAux = null;
        UserBoletaEnBlancoPane boletaBlancoAux = null;
        JPanel contenedorDeBoleta = senadoresContainer;

        if (boletaClickeada instanceof UserBoletaEnBlancoPane) {
            boletaBlancoAux = (UserBoletaEnBlancoPane) boletaClickeada;

            if (boletaBlancoAux.isFlagDiputados()) {
                contenedorDeBoleta = diputadosContainer;
                nroBoletaDiputadosVotada = boletaBlancoAux.getNumero();
                listaDiputadosSelectedTxt.setText("LD: " + " " + "en blanco");
                controlador.setNumeroListaVotadaUno(nroBoletaDiputadosVotada);
            } else {
                nroBoletaSenadoresVotada = boletaBlancoAux.getNumero();
                listaSenadoresSelectedTxt.setText("LS: " + " " + "en blanco");
                controlador.setNumeroListaVotadaDos(nroBoletaSenadoresVotada);
            }
        }

        if (boletaClickeada instanceof UserCorteBoletaPane) {
            boletaAux = (UserCorteBoletaPane) boletaClickeada;

            if (boletaAux.isFlagDiputados()) {
                contenedorDeBoleta = diputadosContainer;
                nroBoletaDiputadosVotada = boletaAux.getNumero();
                listaDiputadosSelectedTxt.setText("LD: " + " " + nroBoletaDiputadosVotada);
                controlador.setNumeroListaVotadaUno(nroBoletaDiputadosVotada);
            } else {
                nroBoletaSenadoresVotada = boletaAux.getNumero();
                listaSenadoresSelectedTxt.setText("LS: " + " " + nroBoletaSenadoresVotada);
                controlador.setNumeroListaVotadaDos(nroBoletaSenadoresVotada);
            }
        }

        if (!btnConfirmarTxt.isVisible()) {
            btnConfirmarTxt.setVisible(true);
        }

        try {

            while (true) {
                c++;
                if (c == 1) {
                    boletaBlancoAux = (UserBoletaEnBlancoPane) contenedorDeBoleta.getComponent(c);
                    boletaBlancoAux.setClicked(false);
                    continue;
                }
                boletaAux = (UserCorteBoletaPane) contenedorDeBoleta.getComponent(c);
                boletaAux.setClicked(false);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            if (boletaClickeada instanceof UserBoletaEnBlancoPane) {
                boletaBlancoAux = (UserBoletaEnBlancoPane) boletaClickeada;
                boletaBlancoAux.setClicked(true);
            }else{
                boletaAux = (UserCorteBoletaPane) boletaClickeada;
                boletaAux.setClicked(true);
            }
        }
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
     * Agrega las las boletas de listaBoletas al contenedor correspondiente
     *
     * @param listaBoletas, lista de boletas para mostrar
     */
    private void agregarBoletas(List<UserCorteBoletaPane> listaBoletas) {

        listaBoletas.forEach(boleta -> {
            agregarBoleta(boleta);
        });

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
    private void agregarBoleta(UserCorteBoletaPane boleta) {

        if (boleta.isFlagDiputados()) {
            agregarBoleta(boleta, diputadosContainer);
            return;
        }
        agregarBoleta(boleta, senadoresContainer);
    }

    /**
     * LLena la lista de boletas con las correspondientes representaciones
     * gráficas de las listas politicas en listasPoliticas s
     */
    public void setBoletas() {
        List<ListaPolitica> listasPoliticas = controlador.getListasPolticas();
        List<String> nombresDiputados = new ArrayList<>();
        List<String> nombresSenadores = new ArrayList<>();

        for (ListaPolitica listaPolitica : listasPoliticas) {

            if (!(listaPolitica.getDiputados() == null)) {
                listaPolitica.getDiputados().forEach(diputado -> {
                    nombresDiputados.add(diputado.getNombre() + " " + diputado.getApellido());
                });
            }

            if (!nombresDiputados.isEmpty()) {
                UserCorteBoletaPane nuevaBoleta = (UserCorteBoletaPane) listaPoliticaACorteBoletaPane(listaPolitica.getNumero(), nombresDiputados, true);
                boletas.add(nuevaBoleta);
            }

            if (!(listaPolitica.getSenadores() == null)) {
                listaPolitica.getSenadores().forEach(senador -> {
                    nombresSenadores.add(senador.getNombre() + " " + senador.getApellido());
                });
            }

            if (!nombresSenadores.isEmpty()) {
                UserCorteBoletaPane nuevaBoleta = (UserCorteBoletaPane) listaPoliticaACorteBoletaPane(listaPolitica.getNumero(), nombresSenadores, false);
                boletas.add(nuevaBoleta);
            }

        }
    }

    /**
     * Crea una representación gráfica de una lista politica
     *
     * @param numero
     * @param nombres
     * @return
     */
    public JPanel listaPoliticaACorteBoletaPane(Integer numero, List<String> nombres, boolean flag) {
        return new UserCorteBoletaPane(this, numero, nombres, flag);
    }

    private void agregarCandidato(JPanel candidato, JPanel contenedor) {
        candidato.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenedor.add(candidato);
        actualizarPane(contenedor);
    }

    private void agregarDiputado(JPanel diputado) {
        agregarCandidato(diputado, diputadosContainer);
    }

    private void agregarSenador(JPanel senador) {
        agregarCandidato(senador, senadoresContainer);
    }

    private void agregarSenadores(List<UserBoletaPane> listaSenadores) {
        listaSenadores.forEach(senador -> {
            agregarSenador(senador);
        });
    }

    private void agregarDiputados(List<UserBoletaPane> listaDiputados) {
        listaDiputados.forEach(diputado -> {
            agregarDiputado(diputado);
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
        diputadosTitleTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        diputadosContainer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        senadoresContainer = new javax.swing.JPanel();
        senadoresTitleTxt = new javax.swing.JLabel();
        botoneraContainer = new javax.swing.JPanel();
        btnVotarContainer = new javax.swing.JPanel();
        btnVotarTxt = new javax.swing.JLabel();
        btnConfirmarContainer = new javax.swing.JPanel();
        btnConfirmarTxt = new javax.swing.JLabel();
        listaSenadoresSelectedTxt = new javax.swing.JLabel();
        listaDiputadosSelectedTxt = new javax.swing.JLabel();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerContainerLayout.createSequentialGroup()
                .addComponent(headerBarContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(btnExitContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerContainerLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(headerTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
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

        diputadosTitleTxt.setBackground(new java.awt.Color(0, 0, 0));
        diputadosTitleTxt.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        diputadosTitleTxt.setForeground(new java.awt.Color(43, 179, 205));
        diputadosTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diputadosTitleTxt.setText("Diputados");
        diputadosTitleTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        diputadosContainer.setBackground(new java.awt.Color(255, 255, 255));
        diputadosContainer.setLayout(new javax.swing.BoxLayout(diputadosContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(diputadosContainer);

        senadoresContainer.setBackground(new java.awt.Color(255, 255, 255));
        senadoresContainer.setLayout(new javax.swing.BoxLayout(senadoresContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(senadoresContainer);

        senadoresTitleTxt.setBackground(new java.awt.Color(0, 0, 0));
        senadoresTitleTxt.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        senadoresTitleTxt.setForeground(new java.awt.Color(43, 179, 205));
        senadoresTitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        senadoresTitleTxt.setText("Senadores");
        senadoresTitleTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
            .addComponent(btnVotarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        );
        btnVotarContainerLayout.setVerticalGroup(
            btnVotarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVotarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
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
                .addComponent(btnVotarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

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

        listaSenadoresSelectedTxt.setBackground(new java.awt.Color(245, 244, 246));
        listaSenadoresSelectedTxt.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        listaSenadoresSelectedTxt.setForeground(new java.awt.Color(43, 179, 205));
        listaSenadoresSelectedTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listaSenadoresSelectedTxt.setText("LS: en blanco");
        listaSenadoresSelectedTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaSenadoresSelectedTxt.setOpaque(true);

        listaDiputadosSelectedTxt.setBackground(new java.awt.Color(245, 244, 246));
        listaDiputadosSelectedTxt.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        listaDiputadosSelectedTxt.setForeground(new java.awt.Color(43, 179, 205));
        listaDiputadosSelectedTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listaDiputadosSelectedTxt.setText("LD: en blanco");
        listaDiputadosSelectedTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaDiputadosSelectedTxt.setOpaque(true);

        javax.swing.GroupLayout bgContainerLayout = new javax.swing.GroupLayout(bgContainer);
        bgContainer.setLayout(bgContainerLayout);
        bgContainerLayout.setHorizontalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botoneraContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgContainerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(diputadosTitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addComponent(listaDiputadosSelectedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgContainerLayout.createSequentialGroup()
                        .addComponent(listaSenadoresSelectedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senadoresTitleTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        bgContainerLayout.setVerticalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addComponent(headerContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diputadosTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senadoresTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgContainerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConfirmarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgContainerLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaDiputadosSelectedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaSenadoresSelectedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
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
        btnConfirmarTxt.setBackground(new Color(58, 77, 92));
    }//GEN-LAST:event_btnConfirmarTxtMouseEntered

    private void btnConfirmarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarTxtMouseExited
        btnConfirmarTxt.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_btnConfirmarTxtMouseExited

    private void btnConfirmarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarTxtMouseClicked

        diputadosContainer.removeAll();
        senadoresContainer.removeAll();
        diputadosContainer.setEnabled(false);
        senadoresContainer.setEnabled(false);
        btnVotarTxt.setVisible(true);
        btnConfirmarTxt.setVisible(false);

    }//GEN-LAST:event_btnConfirmarTxtMouseClicked

    private void btnVotarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVotarTxtMouseClicked
//        Voto EliminarEsto = controlador.nuevoVoto();
//        System.out.println(EliminarEsto.toString());

        controlador.nuevoVoto();
        contenedor.actualizarContentPane(slidePane);
        slidePane.actualizarPane();
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
    private javax.swing.JPanel diputadosContainer;
    private javax.swing.JLabel diputadosTitleTxt;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel listaDiputadosSelectedTxt;
    private javax.swing.JLabel listaSenadoresSelectedTxt;
    private javax.swing.JPanel senadoresContainer;
    private javax.swing.JLabel senadoresTitleTxt;
    // End of variables declaration//GEN-END:variables
}
