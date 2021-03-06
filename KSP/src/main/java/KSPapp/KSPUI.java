/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSPapp;

import javax.swing.JOptionPane;

/**
 *
 * @author rivorivo
 */
public class KSPUI extends javax.swing.JFrame {

    private Peli peli;
    /**
    *konstruktori
    */
    public KSPUI() {
        initComponents();
        Siirtoikkuna.setVisible(false);
        Loppuikkuna.setVisible(false);
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
        Alkuikkuna = new javax.swing.JPanel();
        OkNappi = new javax.swing.JButton();
        pelinKoko = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PeruutaNappi = new javax.swing.JButton();
        Siirtoikkuna = new javax.swing.JPanel();
        SiirtoOtsikko = new javax.swing.JLabel();
        SaksetNappi = new javax.swing.JButton();
        KiviNappi = new javax.swing.JButton();
        PaperiNappi = new javax.swing.JButton();
        tulospalkki = new javax.swing.JLabel();
        kierros = new javax.swing.JLabel();
        Loppuikkuna = new javax.swing.JPanel();
        lopputulosOtsikko = new javax.swing.JLabel();
        lopputilanne = new javax.swing.JLabel();
        voittaja = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OkNappi.setText("Ok");
        OkNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkNappiActionPerformed(evt);
            }
        });

        jLabel1.setText("\"Kuinka monta peliä?(ota monta)\"");

        PeruutaNappi.setText("Peruuta");
        PeruutaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeruutaNappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AlkuikkunaLayout = new javax.swing.GroupLayout(Alkuikkuna);
        Alkuikkuna.setLayout(AlkuikkunaLayout);
        AlkuikkunaLayout.setHorizontalGroup(
            AlkuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(AlkuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlkuikkunaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(AlkuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AlkuikkunaLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pelinKoko, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(OkNappi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PeruutaNappi)
                            .addGap(14, 14, 14))
                        .addComponent(jLabel1))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AlkuikkunaLayout.setVerticalGroup(
            AlkuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(AlkuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlkuikkunaLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(AlkuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pelinKoko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(OkNappi)
                        .addComponent(PeruutaNappi))
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        SiirtoOtsikko.setText("Valitse siirtosi");

        SaksetNappi.setText("Sakset");
        SaksetNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaksetNappiActionPerformed(evt);
            }
        });

        KiviNappi.setText("Kivi");
        KiviNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KiviNappiActionPerformed(evt);
            }
        });

        PaperiNappi.setText("Paperi");
        PaperiNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaperiNappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SiirtoikkunaLayout = new javax.swing.GroupLayout(Siirtoikkuna);
        Siirtoikkuna.setLayout(SiirtoikkunaLayout);
        SiirtoikkunaLayout.setHorizontalGroup(
            SiirtoikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SiirtoikkunaLayout.createSequentialGroup()
                .addComponent(KiviNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SaksetNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PaperiNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SiirtoikkunaLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(SiirtoOtsikko)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(kierros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SiirtoikkunaLayout.createSequentialGroup()
                .addComponent(tulospalkki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SiirtoikkunaLayout.setVerticalGroup(
            SiirtoikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SiirtoikkunaLayout.createSequentialGroup()
                .addComponent(SiirtoOtsikko)
                .addGap(0, 0, 0)
                .addGroup(SiirtoikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaksetNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KiviNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PaperiNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tulospalkki, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kierros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        lopputulosOtsikko.setText("Lopputulos:");

        javax.swing.GroupLayout LoppuikkunaLayout = new javax.swing.GroupLayout(Loppuikkuna);
        Loppuikkuna.setLayout(LoppuikkunaLayout);
        LoppuikkunaLayout.setHorizontalGroup(
            LoppuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lopputilanne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LoppuikkunaLayout.createSequentialGroup()
                .addGroup(LoppuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lopputulosOtsikko)
                    .addComponent(voittaja, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 126, Short.MAX_VALUE))
        );
        LoppuikkunaLayout.setVerticalGroup(
            LoppuikkunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoppuikkunaLayout.createSequentialGroup()
                .addComponent(lopputulosOtsikko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lopputilanne, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(voittaja)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 73, Short.MAX_VALUE)
                .addComponent(Alkuikkuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Siirtoikkuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Loppuikkuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 100, Short.MAX_VALUE)
                .addComponent(Alkuikkuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Siirtoikkuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Loppuikkuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkNappiActionPerformed
        // TODO add your handling code here:
        int koko = 0;

        while (true) {
            try {
                koko = Integer.parseInt(pelinKoko.getText());
                Alkuikkuna.setVisible(false);
                Siirtoikkuna.setVisible(true);
                this.peli = new Peli(koko);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Anna numero kiitos!");
                break;
            }
        }

    }//GEN-LAST:event_OkNappiActionPerformed

    private void PeruutaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeruutaNappiActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_PeruutaNappiActionPerformed

    private void KiviNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KiviNappiActionPerformed
        peli.pelaa("Kivi");
        tulospalkki.setText(peli.getTilanne());
        kierros.setText(peli.getKierros());
        if (peli.tarkistaPituus() == true) {
            Siirtoikkuna.setVisible(false);
            Loppuikkuna.setVisible(true);
            lopputilanne.setText(peli.getTilanne());
            voittaja.setText(peli.getKokoPelinVoittaja());
        }
    }//GEN-LAST:event_KiviNappiActionPerformed

    private void PaperiNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaperiNappiActionPerformed
        peli.pelaa("Paperi");
        tulospalkki.setText(peli.getTilanne());
        kierros.setText(peli.getKierros());
        if (peli.tarkistaPituus() == true) {
            Siirtoikkuna.setVisible(false);
            Loppuikkuna.setVisible(true);
            lopputilanne.setText(peli.getTilanne());
            voittaja.setText(peli.getKokoPelinVoittaja());
        }
    }//GEN-LAST:event_PaperiNappiActionPerformed

    private void SaksetNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaksetNappiActionPerformed
        peli.pelaa("Sakset");
        tulospalkki.setText(peli.getTilanne());
        kierros.setText(peli.getKierros());
        if (peli.tarkistaPituus() == true) {
            Siirtoikkuna.setVisible(false);
            Loppuikkuna.setVisible(true);
            lopputilanne.setText(peli.getTilanne());
            voittaja.setText(peli.getKokoPelinVoittaja());
        }
    }//GEN-LAST:event_SaksetNappiActionPerformed

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
            java.util.logging.Logger.getLogger(KSPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KSPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KSPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KSPUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KSPUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Alkuikkuna;
    private javax.swing.JButton KiviNappi;
    private javax.swing.JPanel Loppuikkuna;
    private javax.swing.JButton OkNappi;
    private javax.swing.JButton PaperiNappi;
    private javax.swing.JButton PeruutaNappi;
    private javax.swing.JButton SaksetNappi;
    private javax.swing.JLabel SiirtoOtsikko;
    private javax.swing.JPanel Siirtoikkuna;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel kierros;
    private javax.swing.JLabel lopputilanne;
    private javax.swing.JLabel lopputulosOtsikko;
    private javax.swing.JTextField pelinKoko;
    private javax.swing.JLabel tulospalkki;
    private javax.swing.JLabel voittaja;
    // End of variables declaration//GEN-END:variables

}
