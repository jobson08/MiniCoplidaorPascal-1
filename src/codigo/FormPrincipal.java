/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author jamme
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
    }
    
     private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtEntrada.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINHA " + cont + "\t\t\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                TxtResutLexico.setText(resultado);
                return;
            }
            switch (token) {              
                case Linha:
                    cont++;
                    resultado += "Linha " + cont + "\n";
                    break;  
                case T_dado:
                    resultado += "  <Reservada Tipo Dados>\t" + lexer.lexeme + "\n";
                    break; 
                case String:
                    resultado += "  <Reservada Tipo Dados>\t" + lexer.lexeme + "\n";
                    break;        
                case Begin:
                    resultado += "  <Reservada Begin>\t" + lexer.lexeme + "\n";
                    break;
                case End:
                    resultado += "  <Reservada End>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada If>\t" + lexer.lexeme + "\n";
                    break;
                 case Then:
                    resultado += "  <Reservada Then>\t" + lexer.lexeme + "\n";
                    break;
                  case Else:
                    resultado += "  <Reservada Else>\t" + lexer.lexeme + "\n";
                    break;    
                case While:
                    resultado += "  <Reservada While>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada Do>\t" + lexer.lexeme + "\n";
                    break;
                case Util:
                    resultado += "  <Reservada Util>\t" + lexer.lexeme + "\n";
                    break; 
                case Repeat:
                    resultado += "  <Reservada Repeat>\t" + lexer.lexeme + "\n";
                    break;
                case All:
                    resultado += "  <Reservada All>\t" + lexer.lexeme + "\n";
                    break;
                case And:
                    resultado += "  <Reservada And>\t" + lexer.lexeme + "\n";
                    break;
                 case Or:
                    resultado += "  <Reservada Or>\t" + lexer.lexeme + "\n";
                    break;
                 case Programa_inicio:
                    resultado += "  <Reservada Programa>\t" + lexer.lexeme + "\n";
                    break;     
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Soma:
                    resultado += "  <Operador soma>\t" + lexer.lexeme + "\n";
                    break;
                case Subtracao:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplica:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Divisao:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Maior:
                    resultado += "  <Maior>\t" + lexer.lexeme + "\n";
                    break;
                case Menor:
                    resultado += "  <Menor>\t" + lexer.lexeme + "\n";
                    break;
                case Maior_Ingual:
                    resultado += "  <Maior Ingual>\t" + lexer.lexeme + "\n";
                    break;
                case Menor_Ingual:
                    resultado += "  <Menor Ingual>\t" + lexer.lexeme + "\n";
                    break;
                case Diferente:
                    resultado += "  <Diferente>\t" + lexer.lexeme + "\n";
                    break;    
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_abertura:
                    resultado += "  <Parentesis de abertura>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_fechar:
                    resultado += "  <Parentesis de fecamento>\t" + lexer.lexeme + "\n";
                    break;
                case Ponto:
                    resultado += "  <Ponto>\t" + lexer.lexeme + "\n";
                    break;             
                case P_virgula:
                    resultado += "  <Ponto e virgula>\t" + lexer.lexeme + "\n";
                    break;
                case Atribuicao:
                    resultado += "  <Atribuicao>\t" + lexer.lexeme + "\n";
                    break;           
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtResutLexico = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        BtnLimparLexico = new javax.swing.JButton();
        BtnArquivo = new javax.swing.JButton();
        BtnAnalizarLexico = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtResutSintatico = new javax.swing.JTextArea();
        BtnLimparSintatico = new javax.swing.JButton();
        BtnAnalizarSintatico = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ANALIZADOR LEXICO");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TxtResutLexico.setColumns(20);
        TxtResutLexico.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TxtResutLexico.setRows(5);
        jScrollPane1.setViewportView(TxtResutLexico);

        txtEntrada.setColumns(20);
        txtEntrada.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtEntrada.setRows(5);
        jScrollPane2.setViewportView(txtEntrada);

        BtnLimparLexico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnLimparLexico.setText("Limpar");
        BtnLimparLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparLexicoActionPerformed(evt);
            }
        });

        BtnArquivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnArquivo.setText("Buscar Arquivo");
        BtnArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnArquivoActionPerformed(evt);
            }
        });

        BtnAnalizarLexico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnAnalizarLexico.setText("Analizar");
        BtnAnalizarLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnalizarLexicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnAnalizarLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnLimparLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLimparLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAnalizarLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(70, 70, 70))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TxtResutSintatico.setColumns(20);
        TxtResutSintatico.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TxtResutSintatico.setRows(5);
        jScrollPane3.setViewportView(TxtResutSintatico);

        BtnLimparSintatico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnLimparSintatico.setText("Limpar");
        BtnLimparSintatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparSintaticoActionPerformed(evt);
            }
        });

        BtnAnalizarSintatico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnAnalizarSintatico.setText("Analizar");
        BtnAnalizarSintatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnalizarSintaticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnAnalizarSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnLimparSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLimparSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAnalizarSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ANALIZADOR SINTATICO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(295, 295, 295))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLimparLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparLexicoActionPerformed
        // TODO add your handling code here:
        TxtResutLexico.setText(null);   
    }//GEN-LAST:event_BtnLimparLexicoActionPerformed

    private void BtnArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnArquivoActionPerformed
        // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtEntrada.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnArquivoActionPerformed

    private void BtnAnalizarLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnalizarLexicoActionPerformed
        // TODO add your handling code here:
          try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnAnalizarLexicoActionPerformed

    private void BtnLimparSintaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparSintaticoActionPerformed
        // TODO add your handling code here:
        TxtResutSintatico.setText(null);
    }//GEN-LAST:event_BtnLimparSintaticoActionPerformed

    private void BtnAnalizarSintaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnalizarSintaticoActionPerformed
        // TODO add your handling code here:
        String ST = txtEntrada.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            TxtResutSintatico.setText("Analisis realizado correctamente");
            TxtResutSintatico.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            TxtResutSintatico.setText("Error de sintaxis. Na Linha: " + (sym.right + 1) + " Coluna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            TxtResutSintatico.setForeground(Color.red);
        }
    }//GEN-LAST:event_BtnAnalizarSintaticoActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnalizarLexico;
    private javax.swing.JButton BtnAnalizarSintatico;
    private javax.swing.JButton BtnArquivo;
    private javax.swing.JButton BtnLimparLexico;
    private javax.swing.JButton BtnLimparSintatico;
    private javax.swing.JTextArea TxtResutLexico;
    private javax.swing.JTextArea TxtResutSintatico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtEntrada;
    // End of variables declaration//GEN-END:variables
}
