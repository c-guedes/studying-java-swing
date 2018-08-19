
import com.sun.xml.internal.fastinfoset.algorithm.IntegerEncodingAlgorithm;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class valores extends javax.swing.JFrame {

    /**
     * Creates new form valores
     */
    public valores() {
        initComponents();
    }

    ArrayList<Double> numeros = new ArrayList();

    public Double verifyComma() {
        String numero = tf_inserir.getText();
        if (numero.contains(",")) {
            Double novo = Double.parseDouble(numero.replace(",", "."));
            return novo;
        } else {
            return Double.parseDouble(numero);
        }

    }

    public boolean verifyArray() {
        if (numeros.isEmpty()) {
            tf_maior.setText("-1");
            tf_menor.setText("-1");
            tf_media.setText("-1");
            tf_valores.setText("Lista vazia!");
            //char[] c = tf_inserir.getText().toCharArray();
            //boolean b = Character.isDigit(c);
            return true;
        } else {
            return false;
        }

    }

    public void inserirNumero() {
        if (pegaNumero() != null) {
            numeros.add(pegaNumero());
            tf_inserir.setText("");
            System.out.println(numeros);
            Character.isDigit('a');
        }
    }

    public Double pegaNumero() {
        if (!"".equals(tf_inserir.getText())) {
            return verifyComma();
        } else {
            return null;
        }
    }

    public String verifyMaior() {
        double maior = 0;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) > maior) {
                maior = numeros.get(i);
            }
        }
        return Double.toString(maior);
    }

    public String verifyMenor() {
        double menor = IntegerEncodingAlgorithm.INT_MAX_CHARACTER_SIZE;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) < menor) {
                menor = numeros.get(i);
            }
        }
        return Double.toString(menor);
    }

    public String verifyMedia() {
        int soma = 0;
        int media;
        for (int posicao = 0; posicao < numeros.size(); posicao++) {
            soma += numeros.get(posicao);
        }
        media = soma / numeros.size();
        return Integer.toString(media);
    }

    public void showMaior() {
        tf_maior.setText(verifyMaior());
    }

    public void showMenor() {
        tf_menor.setText(verifyMenor());
    }

    public void showMedia() {
        tf_media.setText(verifyMedia());
    }

    public void pegaSelecao() {
        if (cbx_view.getSelectedIndex() == 1) {
            showPares();
        }
        if (cbx_view.getSelectedIndex() == 2) {
            showImpares();
        }
        if (cbx_view.getSelectedIndex() == 0) {
            String texto = "";
            for (int i = 0; i < numeros.size(); i++) {
                texto += numeros.get(i) + " ";
                tf_valores.setText(texto);
            }
        }

    }

    public ArrayList<Double> verifyPares() {
        ArrayList<Double> pares = new ArrayList();
        for (int i = 0; i < numeros.size(); i++) {
            if ((numeros.get(i) % 2) == 0) {
                pares.add(numeros.get(i));
            }
        }
        return pares;
    }

    public ArrayList<Double> verifyImpares() {
        ArrayList<Double> impares = new ArrayList();
        for (int i = 0; i < numeros.size(); i++) {
            if ((numeros.get(i) % 2) != 0) {
                impares.add(numeros.get(i));
            }
        }
        return impares;
    }

    public void showPares() {
        ArrayList<Double> pares = verifyPares();
        String texto = "";
        for (int i = 0; i < pares.size(); i++) {
            texto += pares.get(i) + " ";
        }
        tf_valores.setText(texto);
    }

    public void showImpares() {
        ArrayList<Double> impares = verifyImpares();
        String texto = "";
        for (int i = 0; i < impares.size(); i++) {
            texto += impares.get(i) + " ";
        }
        tf_valores.setText(texto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_inserir = new javax.swing.JTextField();
        btn_inserir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_maior = new javax.swing.JTextField();
        tf_menor = new javax.swing.JTextField();
        tf_media = new javax.swing.JTextField();
        btn_calcular = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_valores = new javax.swing.JTextField();
        cbx_view = new javax.swing.JComboBox<>();
        btn_exibir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Digite o número:");

        btn_inserir.setText("Inserir");
        btn_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirActionPerformed(evt);
            }
        });

        jLabel2.setText("Maior >>>");

        jLabel3.setText("Menor >>");

        jLabel4.setText("Média >>>");

        tf_maior.setEditable(false);
        tf_maior.setBackground(new java.awt.Color(255, 255, 255));

        tf_menor.setEditable(false);
        tf_menor.setBackground(new java.awt.Color(255, 255, 255));

        tf_media.setEditable(false);
        tf_media.setBackground(new java.awt.Color(255, 255, 255));

        btn_calcular.setText("CALCULAR");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        jLabel5.setText("Valores");

        tf_valores.setEditable(false);
        tf_valores.setBackground(new java.awt.Color(255, 255, 255));

        cbx_view.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pares", "Impares" }));

        btn_exibir.setText("Exibir");
        btn_exibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exibirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbx_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_exibir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_valores, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_media, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(tf_maior, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_menor, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(36, 36, 36)
                        .addComponent(btn_calcular)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_inserir))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_maior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_menor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_media, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_valores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exibir))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirActionPerformed
        inserirNumero();
    }//GEN-LAST:event_btn_inserirActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed

        if (verifyArray() == false) {
            verifyMaior();
            showMaior();
            showMenor();
            showMedia();
        }

    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_exibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exibirActionPerformed
        pegaSelecao();
    }//GEN-LAST:event_btn_exibirActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(valores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(valores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(valores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(valores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new valores().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_exibir;
    private javax.swing.JButton btn_inserir;
    private javax.swing.JComboBox<String> cbx_view;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tf_inserir;
    private javax.swing.JTextField tf_maior;
    private javax.swing.JTextField tf_media;
    private javax.swing.JTextField tf_menor;
    private javax.swing.JTextField tf_valores;
    // End of variables declaration//GEN-END:variables
}
