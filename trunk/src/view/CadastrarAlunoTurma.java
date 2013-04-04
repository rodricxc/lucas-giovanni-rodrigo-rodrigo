/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.AlunoDao;
import model.dao.AlunoDaoImpl;
import model.dao.AlunoTurmaDao;
import model.dao.AlunoTurmaDaoImpl;
import model.dao.TurmaDao;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.AlunoTurma;
import model.pojo.Turma;

/**
 *
 * @author rodricxc
 */
public class CadastrarAlunoTurma extends javax.swing.JDialog {

    private List<Turma> listaTurma;
    private Turma turma = null;
    private Aluno aluno = null;
    /**
     * Creates new form CadastrarAlunoTurma
     */;
    /**
     * Creates new form CadastrarAlunoTurma
     */
    public CadastrarAlunoTurma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listaTurma = TurmaDaoImpl.getInstance().get();
        for (Turma t : listaTurma) {
            this.turmaCombo.addItem(t);
        }
        turma = (Turma) turmaCombo.getSelectedItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        turmaCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoAluno = new javax.swing.JTextField();
        adicionarBotao = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Alunos na Turma");

        jButton1.setText("Selecionar...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel1.setText("Selecione um Aluno:");

        turmaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmaComboActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecione uma Turma:");

        jLabel3.setText("Alunos na Turma:");

        campoAluno.setEditable(false);
        campoAluno.setEnabled(false);
        campoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlunoActionPerformed(evt);
            }
        });

        adicionarBotao.setText("Adicionar");
        adicionarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarBotaoActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(turmaCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(campoAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adicionarBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turmaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(campoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adicionarBotao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SelecionarAluno o;
        o = new SelecionarAluno(null, true);
        o.setVisible(true);
        Aluno a = o.getAluno();
                
        if(a!=null){
            aluno = a;
            campoAluno.setText(a.toString());
            campoAluno.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"Nenhum aluno selecionado!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        Object[] linha = new Object[3];

        model.setRowCount(0);

        for (AlunoTurma at : turma.getAlunoTurmas()) {
            linha[0] = at.getAluno().getNome();
            linha[1] = at.getAluno().getCpf();
            
            model.addRow(linha);
        }
        tabela.repaint();
        
        
        
    }
    
    private void campoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAlunoActionPerformed

    private void adicionarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarBotaoActionPerformed
        if(turma==null){
            System.out.println("-----------------------------");
            JOptionPane.showMessageDialog(null,"Cadastre uma turma!");
            this.dispose();
        }
        System.out.println("-------------aa--------------");
            
        turma = (Turma) turmaCombo.getSelectedItem();
        
        if(aluno!=null){
            AlunoTurma at =new AlunoTurma(turma, aluno);
            turma.addAluno(at);
            aluno.addAlunoTurma(at);
            TurmaDao tDao = TurmaDaoImpl.getInstance();
            AlunoDao aDao = AlunoDaoImpl.getInstance();
            AlunoTurmaDao atDao = AlunoTurmaDaoImpl.getInstance();
            atDao.add(at);
            tDao.update(turma);
            aDao.update(aluno);     
            atualizarTabela();
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um Aluno!");
        }
    }//GEN-LAST:event_adicionarBotaoActionPerformed

    private void turmaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmaComboActionPerformed
        turma = (Turma) turmaCombo.getSelectedItem();  
        atualizarTabela();
    }//GEN-LAST:event_turmaComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarAlunoTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarAlunoTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarAlunoTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarAlunoTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarAlunoTurma dialog = new CadastrarAlunoTurma(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarBotao;
    private javax.swing.JTextField campoAluno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox turmaCombo;
    // End of variables declaration//GEN-END:variables
}
