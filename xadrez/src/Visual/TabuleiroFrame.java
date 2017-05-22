package Visual;

import Objetos.Tabuleiro;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import operacao.Algoritimo;

public class TabuleiroFrame extends javax.swing.JFrame {

    private TabuleiroVisual tabuleiroVisual;
    

    public TabuleiroFrame() {
        super("AG - Problema das 5-Rainhas e um Cavalo");
        initComponents();

        this.setLocationRelativeTo(null); 

        painelAbas.setTitleAt(0, "Tabuleiro");

        SpinnerNumberModel spnmMutationRate = new SpinnerNumberModel(0.05, 0.01, 1, 0.01);
        jSpinnerTaxaMutacao.setModel(spnmMutationRate);

        SpinnerNumberModel spnmCrossoverRate = new SpinnerNumberModel(0.05, 0.01, 1, 0.01);
        jSpinnerTaxaCrossover.setModel(spnmCrossoverRate);

        SpinnerNumberModel spnmNGen = new SpinnerNumberModel(10000, 1, 100000, 50);
        jSpinnerMaximoGeracoes.setModel(spnmNGen);

        SpinnerNumberModel spnmTamPop = new SpinnerNumberModel(10, 1, 500, 5);
        jSpinnerTamPopulacao.setModel(spnmTamPop);

        

        tabuleiroVisual = new TabuleiroVisual(new Tabuleiro(), painelTabuleiro.getWidth());
        
        
        
        painelTabuleiro.setLayout(new BorderLayout());
        painelTabuleiro.add(tabuleiroVisual, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        painelAbas = new javax.swing.JTabbedPane();
        painelTabuleiro = new javax.swing.JPanel();
        painelGrafico = new javax.swing.JPanel();
        painelControles = new javax.swing.JPanel();
        jLabelCrossoverRate = new javax.swing.JLabel();
        jLabelMutationRate = new javax.swing.JLabel();
        jLabelNumberOfGenerations = new javax.swing.JLabel();
        jSpinnerMaximoGeracoes = new javax.swing.JSpinner();
        jSpinnerTaxaMutacao = new javax.swing.JSpinner();
        jSpinnerTaxaCrossover = new javax.swing.JSpinner();
        IniciarBotao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerTamPopulacao = new javax.swing.JSpinner();
        jCheckBoxElitismo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setDividerLocation(280);

        javax.swing.GroupLayout painelTabuleiroLayout = new javax.swing.GroupLayout(painelTabuleiro);
        painelTabuleiro.setLayout(painelTabuleiroLayout);
        painelTabuleiroLayout.setHorizontalGroup(
            painelTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        painelTabuleiroLayout.setVerticalGroup(
            painelTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        painelAbas.addTab("tab1", painelTabuleiro);

        javax.swing.GroupLayout painelGraficoLayout = new javax.swing.GroupLayout(painelGrafico);
        painelGrafico.setLayout(painelGraficoLayout);
        painelGraficoLayout.setHorizontalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        painelGraficoLayout.setVerticalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        painelAbas.addTab("tab2", painelGrafico);

        jSplitPane1.setRightComponent(painelAbas);

        jLabelCrossoverRate.setText("Taxa de Crossover:");

        jLabelMutationRate.setText("Taxa de Mutação:");

        jLabelNumberOfGenerations.setText("Número de Gerações:");

        IniciarBotao.setText("Iniciar");
        IniciarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarBotaoActionPerformed(evt);
            }
        });

        logArea.setEditable(false);
        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        jLabel2.setText("Tamanho da População:");

        jCheckBoxElitismo.setSelected(true);
        jCheckBoxElitismo.setText("Elitismo");

        javax.swing.GroupLayout painelControlesLayout = new javax.swing.GroupLayout(painelControles);
        painelControles.setLayout(painelControlesLayout);
        painelControlesLayout.setHorizontalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IniciarBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelControlesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelControlesLayout.createSequentialGroup()
                                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(painelControlesLayout.createSequentialGroup()
                                        .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelCrossoverRate)
                                            .addComponent(jLabelMutationRate)
                                            .addComponent(jLabelNumberOfGenerations))
                                        .addGap(8, 8, 8))
                                    .addGroup(painelControlesLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpinnerTaxaCrossover, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jSpinnerTaxaMutacao, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jSpinnerMaximoGeracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jSpinnerTamPopulacao)))
                            .addComponent(jCheckBoxElitismo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        painelControlesLayout.setVerticalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControlesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerTaxaCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCrossoverRate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMutationRate)
                    .addComponent(jSpinnerTaxaMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerMaximoGeracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumberOfGenerations))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerTamPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxElitismo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IniciarBotao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(painelControles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarBotaoActionPerformed
        
        Algoritimo.setTaxaDeCrossover(Double.valueOf(jSpinnerTaxaCrossover.getValue().toString()));
        Algoritimo.setTaxaDeMutacao(Double.valueOf(jSpinnerTaxaMutacao.getValue().toString()));
        Algoritimo.setNumeroMaximoGeracoes(Integer.valueOf(jSpinnerMaximoGeracoes.getValue().toString()));
        Algoritimo.setTamanhoPopulacao(Integer.valueOf(jSpinnerTamPopulacao.getValue().toString()));
        Algoritimo.setElitismo(jCheckBoxElitismo.isSelected());
        logArea.setText(null);
        Algoritimo.AG(this);
    }//GEN-LAST:event_IniciarBotaoActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabuleiroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabuleiroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabuleiroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabuleiroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabuleiroFrame().setVisible(true);
            }
        });
    }

    public void setLog(String texto) {
        logArea.append(texto + "\n");
        logArea.setCaretPosition(logArea.getText().length() - 1);
    }

    public TabuleiroVisual getTabuleiroVisual() {
        return tabuleiroVisual;
    }

    public void setEstadoIniciarBotao(boolean estado) {
       IniciarBotao.setEnabled(estado);
    }

  

    public void addGraphic(JPanel img) {
        painelGrafico.removeAll();
        GroupLayout mainPanelLayout = new GroupLayout(painelGrafico);
        painelGrafico.setLayout(mainPanelLayout);
        GroupLayout.SequentialGroup hGroup = mainPanelLayout.createSequentialGroup();
        hGroup.addGap(5, 5, 5);
        hGroup.addComponent(img);
        mainPanelLayout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = mainPanelLayout.createSequentialGroup();
        vGroup.addGap(5, 5, 5);
        vGroup.addComponent(img);
        mainPanelLayout.setVerticalGroup(vGroup);
        img.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton IniciarBotao;
    private javax.swing.JCheckBox jCheckBoxElitismo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCrossoverRate;
    private javax.swing.JLabel jLabelMutationRate;
    private javax.swing.JLabel jLabelNumberOfGenerations;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerMaximoGeracoes;
    private javax.swing.JSpinner jSpinnerTamPopulacao;
    private javax.swing.JSpinner jSpinnerTaxaCrossover;
    private javax.swing.JSpinner jSpinnerTaxaMutacao;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelControles;
    private javax.swing.JPanel painelGrafico;
    private javax.swing.JPanel painelTabuleiro;
    // End of variables declaration//GEN-END:variables
}
