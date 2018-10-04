
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Transferencia extends javax.swing.JFrame {

    /**
     * Creates new form Transferencia
     */
    public Transferencia() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tbnum1 = new javax.swing.JTextField();
        tbNum2 = new javax.swing.JTextField();
        tbValor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("transferência");

        jLabel1.setText("Número da conta 1:");

        jLabel2.setText("Número da conta 2:");

        jLabel3.setText("Valor a Transferir:");

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("cancelar");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbnum1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbNum2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbValor)))
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbnum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        int conta1 = Integer.parseInt(tbnum1.getText());
        int conta2 = Integer.parseInt(tbNum2.getText());
        double valor = Double.parseDouble(tbValor.getText());
         
        if(tbValor.getText().equals("")||tbnum1.getText().equals("")||tbNum2.getText().equals(""))
            JOptionPane.showMessageDialog(null, "preencha todos os campos");
        else{
            if(conta1 == Principal.conta1.getNumero()){
                if(Principal.conta1.getSaldo()>=valor){
                    if(conta2 == Poupanca.conta2.getNumero()){
                         Object[] botoes = { "Confirmar", "Cancelar" };
                        int answer = JOptionPane.showOptionDialog(null,
                            "Titular: "+Principal.conta1.getNome()+"\nDestino : (conta poupança) Titular: "+Poupanca.conta2.getNome()+"\nConfirme o depósito",
                            "Confirmação",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            botoes, botoes[0]);
                        switch(answer){
                            case 0:
                                Principal.conta1.setSaldo(Principal.conta1.getSaldo() - valor);
                                Poupanca.conta2.setSaldo(Poupanca.conta2.getSaldo() + valor);
                                JOptionPane.showMessageDialog(null, "Transferência realizada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                            case 1:    
                                JOptionPane.showMessageDialog(null, "Operação cancelada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                        }
                    }
                     if(conta2 == Especial.conta3.getNumero()){
                        Object[] botoes = { "Confirmar", "Cancelar" };
                        int answer = JOptionPane.showOptionDialog(null,
                            "Titular: "+Principal.conta1.getNome()+"\nDestino : (conta poupança) Titular: "+Especial.conta3.getNome()+"\nConfirme o depósito",
                            "Confirmação",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            botoes, botoes[0]);
                        switch(answer){
                            case 0:
                                Principal.conta1.setSaldo(Principal.conta1.getSaldo() - valor);
                                Especial.conta3.setSaldo(Especial.conta3.getSaldo() + valor);
                                JOptionPane.showMessageDialog(null, "Transferência realizada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                            case 1:    
                                JOptionPane.showMessageDialog(null, "Operação cancelada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                        }
                    }
                }          
            }
            //--------------------------------------------------------------------------------------------//
        if(conta1 == Poupanca.conta2.getNumero()){
                if(Poupanca.conta2.getSaldo()>=valor){
                    if(conta2 == Principal.conta1.getNumero()){
                       Object[] botoes = { "Confirmar", "Cancelar" };
                        int answer = JOptionPane.showOptionDialog(null,
                            "Titular: "+Poupanca.conta2.getNome()+"\nDestino : (conta poupança) Titular: "+Principal.conta1.getNumero()+"\nConfirme o depósito",
                            "Confirmação",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            botoes, botoes[0]);
                        switch(answer){
                            case 0:
                                Poupanca.conta2.setSaldo(Poupanca.conta2.getSaldo() - valor);
                                Principal.conta1.setSaldo(Principal.conta1.getSaldo() + valor);
                                JOptionPane.showMessageDialog(null, "Transferência realizada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                            case 1:    
                                JOptionPane.showMessageDialog(null, "Operação cancelada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                        }
                    }
                     if(conta2 == Especial.conta3.getNumero()){
                        Object[] botoes = { "Confirmar", "Cancelar" };
                        int answer = JOptionPane.showOptionDialog(null,
                            "Titular: "+Poupanca.conta2.getNome()+"\nDestino : (conta poupança) Titular: "+Principal.conta1.getNumero()+"\nConfirme o depósito",
                            "Confirmação",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            botoes, botoes[0]);
                        switch(answer){
                            case 0:
                                Poupanca.conta2.setSaldo(Poupanca.conta2.getSaldo() - valor);
                                Especial.conta3.setSaldo(Especial.conta3.getSaldo() + valor);
                                JOptionPane.showMessageDialog(null, "Transferência realizada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                            case 1:    
                                JOptionPane.showMessageDialog(null, "Operação cancelada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                        }
                    }
                }          
            }
      //--------------------------------------------------------------------------------------------//
       if(conta1 == Especial.conta3.getNumero()){
                if(Especial.conta3.getSaldo()>=valor){
                    if(conta2 == Principal.conta1.getNumero()){
                        Object[] botoes = { "Confirmar", "Cancelar" };
                        int answer = JOptionPane.showOptionDialog(null,
                            "Titular: "+Poupanca.conta2.getNome()+"\nDestino : (conta poupança) Titular: "+Principal.conta1.getNumero()+"\nConfirme o depósito",
                            "Confirmação",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            botoes, botoes[0]);
                        switch(answer){
                            case 0:
                                Especial.conta3.setSaldo(Especial.conta3.getSaldo() - valor);
                                Principal.conta1.setSaldo(Principal.conta1.getSaldo() + valor);
                                JOptionPane.showMessageDialog(null, "Transferência realizada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                            case 1:    
                                JOptionPane.showMessageDialog(null, "Operação cancelada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                        }
                    }
                     if(conta2 == Poupanca.conta2.getNumero()){
                        Object[] botoes = { "Confirmar", "Cancelar" };
                        int answer = JOptionPane.showOptionDialog(null,
                            "Titular: "+Poupanca.conta2.getNome()+"\nDestino : (conta poupança) Titular: "+Principal.conta1.getNumero()+"\nConfirme o depósito",
                            "Confirmação",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            botoes, botoes[0]);
                        switch(answer){
                            case 0:
                                Especial.conta3.setSaldo(Especial.conta3.getSaldo() - valor);
                                Poupanca.conta2.setSaldo(Poupanca.conta2.getSaldo() + valor);
                                JOptionPane.showMessageDialog(null, "Transferência realizada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                            case 1:    
                                JOptionPane.showMessageDialog(null, "Operação cancelada");
                                this.setVisible(false);
                                new IGContas().setVisible(true);
                                break;
                        }
                    }
                }          
            }
    }
    
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new IGContas ().setVisible(true);
            this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transferencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tbNum2;
    private javax.swing.JTextField tbValor;
    private javax.swing.JTextField tbnum1;
    // End of variables declaration//GEN-END:variables
}