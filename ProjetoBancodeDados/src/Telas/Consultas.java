package Telas;

import DAO.Inseredados;
import DAO.LivroDAO;
import DAO.UsuarioDAO;
import conexao.Conexao;



public class Consultas extends javax.swing.JFrame {
      
    public Consultas() {
        initComponents();
              // Cria o banco caso ele ainda não exista 
            if(new Conexao().Conect()== null){
                new Conexao().CreateDB();
                new Inseredados().insere();
            } 
            
    }
    
  
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        busca = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        geral = new javax.swing.JComboBox<>();
        especifico = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        painel.setBackground(new java.awt.Color(0, 0, 0));
        painel.setBorder(new javax.swing.border.MatteBorder(null));

        tabela.setBackground(new java.awt.Color(0, 0, 0));
        tabela.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabela.setForeground(new java.awt.Color(255, 255, 255));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Escola", "CONTATO"
            }
        ));
        tabela.setToolTipText("RESULTADOS");
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabela.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        busca.setBackground(new java.awt.Color(255, 255, 255));
        busca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        busca.setForeground(new java.awt.Color(0, 0, 0));
        busca.setCaretColor(new java.awt.Color(0, 0, 0));
        busca.setEnabled(false);

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        buscar.setForeground(new java.awt.Color(0, 0, 0));
        buscar.setText("PESQUISAR");
        buscar.setEnabled(false);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("BUSCA:");

        geral.setBackground(new java.awt.Color(255, 255, 255));
        geral.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        geral.setForeground(new java.awt.Color(0, 0, 0));
        geral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "USUÁRIOS", "OBRAS", "EMPRÉSTIMOS" }));
        geral.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                geralItemStateChanged(evt);
            }
        });

        especifico.setBackground(new java.awt.Color(255, 255, 255));
        especifico.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        especifico.setForeground(new java.awt.Color(0, 0, 0));
        especifico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
        especifico.setEnabled(false);
        especifico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                especificoItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TIPO DE BUSCA:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("GERAL:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ESPECÍFICO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 140, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(geral, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(especifico, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(especifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(jLabel1)
                    .addComponent(geral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
      
    }//GEN-LAST:event_buscarActionPerformed

    private void geralItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_geralItemStateChanged
        // TODO add your handling code here:
            switch (geral.getSelectedIndex()){
                case 0: 
                    especifico.removeAllItems();
                    especifico.setEnabled(false);
                    buscar.setEnabled(false);
                    break;
                case 1: // OPÇÕES DE BUSCA PARA USUÁRIOS
                    especifico.removeAllItems();
                    especifico.addItem("DADOS PESSOAIS");
                    especifico.addItem("EMPRÉSTIMOS");
                    especifico.setEnabled(true);
                    break;
                case 2:// OPÇÕES DE BUSCA PARA OBRAS
                    especifico.removeAllItems();
                    especifico.addItem("DISPONÍVEIS");
                    especifico.addItem("INDISPONÍVEIS");
                    especifico.addItem("AUTOR");
                    especifico.setEnabled(true);
                    break;
                case 3: // OPÇÕES DE BUSCA PARA EMPRÉSTIMOS
                    especifico.removeAllItems();
                    especifico.addItem("TODOS");
                    especifico.addItem("ATRASADOS");
                    especifico.setEnabled(true);
                    break;
            }
    }//GEN-LAST:event_geralItemStateChanged

    private void especificoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_especificoItemStateChanged
        // BUSCAS   
        buscar.setEnabled(true);
            switch (especifico.getSelectedIndex()){
                case 0:
                    if(geral.getSelectedIndex() == 1){
                                    tabela.setModel(new javax.swing.table.DefaultTableModel(
                                         new Object [][] {},
                                        new String [] {
                                        "NOME", "CPF", "RG", "EMAIL", "TELEFONE", "RUA","BAIRRO","N°","CIDADE"}));
                   new UsuarioDAO().ConsultaUserP(new Conexao().Conect(), tabela);}
                    if(geral.getSelectedIndex() == 2){
                                    tabela.setModel(new javax.swing.table.DefaultTableModel(
                                         new Object [][] {},
                                        new String [] {
                                        "OBRA", "EXEMPLARES CADASTRADOS"}));
                    new LivroDAO().ConsultaLivro(new Conexao().Conect(), tabela);}
                                        
                    break;
                case 1:
                    if(geral.getSelectedIndex() == 1)
                                    tabela.setModel(new javax.swing.table.DefaultTableModel(
                                         new Object [][] {},
                                        new String [] {
                                        "DATA DO EMPRÉSTIMO", "Nº EXEMPLAR","TÍTULO", "NOME DO USUÁRIO", "CPF", "AUTOR","ISBN"}));
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
    }//GEN-LAST:event_especificoItemStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<String> especifico;
    private javax.swing.JComboBox<String> geral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
