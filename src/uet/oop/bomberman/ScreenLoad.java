//package uet.oop.bomberman;
//
///**
// *
// * @author trung
// */
//public class ScreenLoad extends javax.swing.JFrame {
//
//    /**
//     * Creates new form ScreenLoad
//     */
//    public ScreenLoad() {
//        initComponents();
//    }
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        screenLoad = new javax.swing.JPanel();
//        jLabel1 = new javax.swing.JLabel();
//        Load = new javax.swing.JProgressBar();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        screenLoad.setPreferredSize(new java.awt.Dimension(1488, 624));
//        screenLoad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//
//        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/textures/ScreenLoading.png"))); // NOI18N
//        jLabel1.setText("backgroundImage");
//        jLabel1.setPreferredSize(new java.awt.Dimension(1488, 610));
//        screenLoad.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));
//
//        Load.setPreferredSize(new java.awt.Dimension(1488, 5));
//        screenLoad.add(Load, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 614, -1, 10));
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addComponent(screenLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(0, 0, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addComponent(screenLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(0, 0, Short.MAX_VALUE))
//        );
//
//        pack();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public void iterate() {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ScreenLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ScreenLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ScreenLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ScreenLoad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        _scLoad = new ScreenLoad();
//        _scLoad.setVisible(true);
//        _scLoad.setLocationRelativeTo(null);
//
//        try {
//            for(int i=0;i <= 100; i+=2) {
//                Thread.sleep(100);
//                _scLoad.Load.setValue(i);
//            }
//            isDone = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JProgressBar Load;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JPanel screenLoad;
//    public static ScreenLoad _scLoad;
//
//    public static boolean isDone = false;
//}
