
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caiqu
 */
public class ordenando extends javax.swing.JFrame {

    /**
     * Creates new form ordenando
     */
    public ordenando() {
        initComponents();
    }

    ArrayList<String> nomes = new ArrayList();
    ArrayList<String> idades = new ArrayList();

    public boolean verifyInteger(String ve) {
        try {
            Integer teste = Integer.parseInt(ve);
            System.out.println(ve);
            return true;
        } catch (NumberFormatException nexc) {
            return false;
        }
    }

    public boolean verifyCanvas() {
        if (tf_nome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome não inserido!");
            return true;
        } else if (tf_idade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "idade não inserida!");
            return true;
        } else if (verifyInteger(tf_idade.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Número invalido!");
            return true;
        } else if (verifyInteger(tf_nome.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Somente letras!");
            return true;
        } else {
            return false;
        }

    }

    public boolean verifyDuplicata() {
        String nome = tf_nome.getText();
        if (nomes.contains(nome) == false) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Nome já existe!");
            return true;
        }
    }

    public void inserir() {
        if (verifyCanvas() == false && verifyDuplicata() == false) {
            nomes.add(tf_nome.getText().toUpperCase());
            idades.add(tf_idade.getText().toUpperCase());
        }

    }

    public Integer procuraPos(String nome) {
        Integer posicao = -1;
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equals(nome)) {
                posicao = i;
            }
        }
        return posicao;
    }

    public void removeNome() {
        if (verifyCanvas() == false && false == verifyDuplicata()) {
            String remover = tf_nome.getText();
            int pos = procuraPos(remover);
            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Nome não existe!");
            } else {
                nomes.remove(pos);
                idades.remove(pos);
                JOptionPane.showMessageDialog(null, "Nome removido!");
            }

        }
    }

    public void setaPainel(int nome_loc, int idade_loc) {
        String escreve = nome_loc + " | " + nomes.get(nome_loc) + " | " + idades.get(idade_loc);
        tf_show.setText(escreve);

    }

    public void showLocalizado() {
        if (verifyCanvas() == false) {
            String nome = tf_nome.getText();
            int pos = procuraPos(nome);
            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Nome não existe!");
            } else {
                int nome_loc = pos;
                int idade_loc = pos;
                setaPainel(nome_loc, idade_loc);
            }

        }
    }

    public ArrayList dicionario(String chave, ArrayList lista, ArrayList retorno) {
        ArrayList<String> index = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            if (chave.equals(lista.get(i))) {
                index.add((String) lista.get(i));
                index.add((String) retorno.get(i));
            }
        }
        return index;
    }

    public void ordenaSelecionadoMenor() {
        ArrayList<String> ordenadoIdades = new ArrayList();
        ArrayList<String> ordenadoNomes = new ArrayList();
        String imprime = "";
        int menor = 100;
        for (int i = 0; i < idades.size(); i++) {
            int numero = Integer.parseInt(idades.get(i));
            if (numero < menor) {
                menor = numero;
                if (ordenadoIdades.size() > 0) {
                    ordenadoIdades.add(0, idades.get(i));
                } else {
                    ordenadoIdades.add(idades.get(i));
                }
            } else {
                ordenadoIdades.add(idades.get(i));
            }
        }
        for (int i = 0; i < idades.size(); i++) {
            ordenadoNomes.add((String) dicionario(ordenadoIdades.get(i), idades, nomes).get(1));
            imprime += (String) dicionario(ordenadoIdades.get(i), idades, nomes).get(1) + " " + ordenadoIdades.get(i) + " anos\n";

        }
        tf_show.setText(imprime);
    }

    public void identifySelected() {
        if (cbx_comando.getSelectedIndex() == 1) {
            ordenaSelecionadoMenor();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tf_nome = new javax.swing.JTextField();
        tf_idade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_show = new javax.swing.JTextArea();
        btn_insert = new javax.swing.JButton();
        cbx_comando = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_shows = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(null);
        setName("Ordenando"); // NOI18N

        tf_nome.setNextFocusableComponent(tf_idade);

        jLabel1.setText("Nome");

        jLabel2.setText("Idade");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenando"));

        tf_show.setEditable(false);
        tf_show.setColumns(20);
        tf_show.setRows(5);
        jScrollPane1.setViewportView(tf_show);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_insert.setText("INSERIR");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        cbx_comando.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordem Alfabética", "Ordem decrescente de idade" }));
        cbx_comando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_comandoActionPerformed(evt);
            }
        });

        jButton1.setText("REMOVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("LOCALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_shows.setText("MOSTRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbx_comando, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btn_shows))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_idade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btn_insert))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbx_comando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_shows)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        inserir();

    }//GEN-LAST:event_btn_insertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        removeNome();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showLocalizado();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbx_comandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_comandoActionPerformed
        identifySelected();
    }//GEN-LAST:event_cbx_comandoActionPerformed

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
            java.util.logging.Logger.getLogger(ordenando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordenando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordenando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordenando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenando().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_shows;
    private javax.swing.JComboBox<String> cbx_comando;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_idade;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextArea tf_show;
    // End of variables declaration//GEN-END:variables
}
