/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String rota1 = "C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/src/codigo/Lexer.flex";
        String rota2 = "C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/src/codigo/LexerCup.flex";
        String[] rotaS = {"-parser", "Sintax", "C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/src/codigo/Sintax.cup"};
        generar(rota1, rota2, rotaS);
    }
    public static void generar(String rota1, String rota2, String[] rotaS) throws IOException, Exception{
        File archivo;
        archivo = new File(rota1);
        JFlex.Main.generate(archivo);
        archivo = new File(rota2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rotaS);
        
        Path rutaSym = Paths.get("C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/sym.java"), 
                Paths.get("C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/src/codigo/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/Sintax.java"), 
                Paths.get("C:/Users/jamme/OneDrive/Documentos/NetBeansProjects/MiniCopiladroPascal/src/codigo/Sintax.java")
        );
    }
}
