package com.gruposeispoo.vistas.admin;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.clases.Voto;
import com.gruposeispoo.vistas.Index;
import com.gruposeispoo.vistas.IndexSlidePane;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class AdminGraficosPane extends javax.swing.JPanel {

    private final Controlador controlador;
    private final Index contenedor;
    private final IndexSlidePane slidePane;
    private final List<String> listaPoliticas;
    private final Set<String> listasPoliticasConjunto;
    private final List<String> distritos;
    private final Set<String> distritosConjunto;

    /**
     *
     * CONSTRUCTOR
     *
     *
     */
    public AdminGraficosPane(Index contenedor) {
        initComponents();
        this.contenedor = contenedor;
        slidePane = new IndexSlidePane(contenedor, true);
        controlador = Controlador.getInstancia();

        listaPoliticas = new ArrayList<>();
        listasPoliticasConjunto = new HashSet<>();

        distritos = new ArrayList<>();
        distritosConjunto = new HashSet<>();

        crearGraficoBarras("Votos en blanco", "Categorias", "Cantidad de votos", dataSetVotosEnBlanco());
        crearGraficoBarras("Votos por lista", "Listas politicas", "Cantidad de votos", dataSetVotosPorLista());
        crearGraficoBarras("Votos por distrito", "Distritos", "Cantidad de votos", dataSetVotosPorDistrito());
        crearGraficoPastel("Votos", dataSetElectores());
    }

    /**
     * Creador de grafico de barras
     *
     * @param nombre, nombre del grafico
     * @param nombreEjeX
     * @param nombreEjeY
     * @param dataSet
     */
    private void crearGraficoPastel(String nombre, PieDataset dataSet) {
        JFreeChart pastel = ChartFactory.createPieChart(nombre, dataSet);
        ChartPanel panel = new ChartPanel(pastel);
        panel.setPreferredSize(new Dimension(600, 370));
        contentContainer.add(panel);
    }

    /**
     * Creador de grafico de barras
     *
     * @param nombre, nombre del grafico
     * @param nombreEjeX
     * @param nombreEjeY
     * @param dataSet
     */
    private void crearGraficoBarras(String nombre, String nombreEjeX, String nombreEjeY, CategoryDataset dataSet) {
        JFreeChart barras = ChartFactory.createBarChart(nombre, nombreEjeX, nombreEjeY, dataSet, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(barras);
        panel.setPreferredSize(new Dimension(600, 370));
        contentContainer.add(panel);
    }

    private PieDataset dataSetElectores() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int faltaVotar = controlador.getCantidadVotosRestantes();
        int votaron = controlador.getPadronElectores().size();

        dataset.setValue("Falta votar", faltaVotar);
        dataset.setValue("Votaron", votaron - faltaVotar);

        return dataset;
    }

    /**
     * CONJUNTO DE DATOS PARA VOTOS Y DISTRITOS
     *
     * @return
     */
    private CategoryDataset dataSetVotosPorLista() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (!(controlador.listasVotadas().isEmpty())) {
            controlador.listasVotadas().forEach(listaVotada -> {
                listasPoliticasConjunto.add(listaVotada.getNombre());
                listaPoliticas.add(listaVotada.getNombre());
            });

            double contador = 0.0;

            for (String listaPoliticaExterna : listasPoliticasConjunto) {
                for (String listaPoliticaInterna : listaPoliticas) {
                    if (listaPoliticaInterna.equals(listaPoliticaExterna)) {
                        contador++;
                    }
                }
                dataset.addValue(contador, listaPoliticaExterna, "Cantidad de votos");
                contador = 0.0;
            }

        }

        return dataset;
    }

    /**
     * CONJUNTO DE DATOS PARA VOTOS Y DISTRITOS
     *
     * @return
     */
    private CategoryDataset dataSetVotosPorDistrito() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (!(controlador.votosRealizados().isEmpty())) {
            controlador.votosRealizados().forEach(voto -> {
                if (!voto.getListas().isEmpty()) {
                    voto.getListas().forEach(listaVotada -> {
                        if (listaVotada.getDistrito() != null) {
                            distritosConjunto.add(listaVotada.getDistrito().getNombre());
                            distritos.add(listaVotada.getDistrito().getNombre());
                        }
                    });
                }
            });

            double contador = 0.0;

            for (String distritoExterno : distritosConjunto) {
                for (String distritoInterno : distritos) {
                    if (distritoInterno.equals(distritoExterno)) {
                        contador++;
                    }
                }
                dataset.addValue(contador, distritoExterno, "Cantidad de votos");
                contador = 0.0;
            }
        }

        return dataset;
    }

    /**
     * CONJUNTO DE DATOS PARA VOTOS EN BLANCO POR LISTA Y POR CATEGORIA
     *
     * @return
     */
    private CategoryDataset dataSetVotosEnBlanco() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (!(controlador.votosRealizados().isEmpty())) {
            double votosEnBlanco = 0.0;
            double votosSenadorEnBlanco = 0.0;
            double votosDiputadoEnBlanco = 0.0;
            double votosPositivos = 0.0;

            for (Voto voto : controlador.votosRealizados()) {

                if (voto.isCorteBoleta()) { //SE VOTO POR CATEGORIA

                    if (!voto.getListas().isEmpty()) {//HAY LISTAS VOTADAS
                        if (voto.getListas().size() == 2) { //HAY DOS LISTAS VOTADAS

                            if (voto.getListas().get(0).getNumero() == 0) { //PRIMER LISTA RELLENO. INDICA VOTO SOLO SENADOR
                                votosDiputadoEnBlanco++;
                                dataset.addValue(votosDiputadoEnBlanco, "Voto/Diputado/Blanco", "Cantidad de votos");
                                votosPositivos++;
                                dataset.addValue(votosPositivos, "Voto positivo", "Cantidad de votos");
                            } else {//DOS LISTAS VOTADAS VALIDAS
                                votosPositivos++;
                                dataset.addValue(votosPositivos, "Voto positivo", "Cantidad de votos");
                            }
                        } else {//SE VOTO UNA LISTA, INDICA VOTO DPUTADO
                            if (voto.getListas().get(0).getNumero() == 0) { //VOTO DIPUTADO PERO EN BLANCO
                                votosDiputadoEnBlanco++;
                                dataset.addValue(votosDiputadoEnBlanco, "Voto/Diputado/Blanco", "Cantidad de votos");
                                votosEnBlanco++;
                                dataset.addValue(votosEnBlanco, "Voto en blanco", "Cantidad de votos");
                            } else {
                                votosSenadorEnBlanco++;
                                dataset.addValue(votosSenadorEnBlanco, "Voto/Senador/Blanco", "Cantidad de votos");
                                votosPositivos++;
                                dataset.addValue(votosPositivos, "Voto positivo", "Cantidad de votos");
                            }
                        }
                    } else { //VOTO SIN LISTAS
                        votosEnBlanco++;
                        dataset.addValue(votosEnBlanco, "Voto en blanco", "Cantidad de votos");
                    }

                } else { //SE VOTO POR LISTA
                    /*
                        POR DEFECTO EL VOTO ES POR LISTA. POR LO QUE HAY QUE VERIFICAR QUE NO TENGA UNA LISTA
                     */
                    if (!voto.getListas().isEmpty()) {//VOTO CON LISTA
                        votosPositivos++;
                        dataset.addValue(votosPositivos, "Voto positivo", "Cantidad de votos");
                    } else {//VOTO SIN LISTA
                        votosEnBlanco++;
                        dataset.addValue(votosEnBlanco, "Voto en blanco", "Cantidad de votos");
                    }
                }
            }
        }

        return dataset;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        contentContainer = new javax.swing.JPanel();
        botoneraContainer = new javax.swing.JPanel();
        btnRegresarContainer = new javax.swing.JPanel();
        btnRegresarTxt = new javax.swing.JLabel();

        bgContainer.setBackground(new java.awt.Color(245, 244, 246));

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

        contentContainer.setBackground(new java.awt.Color(245, 244, 246));
        contentContainer.setLayout(new javax.swing.BoxLayout(contentContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(contentContainer);

        botoneraContainer.setBackground(new java.awt.Color(245, 244, 246));

        btnRegresarTxt.setBackground(new java.awt.Color(43, 179, 205));
        btnRegresarTxt.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnRegresarTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegresarTxt.setText("REGRESAR");
        btnRegresarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarTxt.setOpaque(true);
        btnRegresarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRegresarContainerLayout = new javax.swing.GroupLayout(btnRegresarContainer);
        btnRegresarContainer.setLayout(btnRegresarContainerLayout);
        btnRegresarContainerLayout.setHorizontalGroup(
            btnRegresarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegresarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        btnRegresarContainerLayout.setVerticalGroup(
            btnRegresarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegresarContainerLayout.createSequentialGroup()
                .addComponent(btnRegresarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout botoneraContainerLayout = new javax.swing.GroupLayout(botoneraContainer);
        botoneraContainer.setLayout(botoneraContainerLayout);
        botoneraContainerLayout.setHorizontalGroup(
            botoneraContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoneraContainerLayout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addComponent(btnRegresarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        botoneraContainerLayout.setVerticalGroup(
            botoneraContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoneraContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bgContainerLayout = new javax.swing.GroupLayout(bgContainer);
        bgContainer.setLayout(bgContainerLayout);
        bgContainerLayout.setHorizontalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(headerContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoneraContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bgContainerLayout.setVerticalGroup(
            bgContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContainerLayout.createSequentialGroup()
                .addComponent(headerContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
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

    private void btnRegresarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarTxtMouseEntered
        btnRegresarTxt.setBackground(new Color(58, 77, 92));
    }//GEN-LAST:event_btnRegresarTxtMouseEntered

    private void btnRegresarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarTxtMouseExited
        btnRegresarTxt.setBackground(new Color(43, 179, 205));
    }//GEN-LAST:event_btnRegresarTxtMouseExited

    private void btnRegresarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarTxtMouseClicked
        contenedor.actualizarContentPane(slidePane);
        slidePane.actualizarPane();
    }//GEN-LAST:event_btnRegresarTxtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContainer;
    private javax.swing.JPanel botoneraContainer;
    private javax.swing.JPanel btnExitContainer;
    private javax.swing.JLabel btnExitTxt;
    private javax.swing.JPanel btnRegresarContainer;
    private javax.swing.JLabel btnRegresarTxt;
    private javax.swing.JPanel contentContainer;
    private javax.swing.JPanel headerBarContainer;
    private javax.swing.JPanel headerContainer;
    private javax.swing.JLabel headerTitleTxt;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
