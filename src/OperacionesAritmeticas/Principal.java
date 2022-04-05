package OperacionesAritmeticas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author JulioMulul
 */
public class Principal {
    ///*
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Reader lector = new BufferedReader(new FileReader("C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorLexicoAritmetica/src/OperacionesAritmeticas/archivo.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            
            int contSalto = 1;
            int contLinea = 0;
            while (true) {
                contLinea += 1;
                
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    
                    resultado += "\nFIN";
                    System.out.println(resultado);
                    return;
                }
                switch (tokens) {
                    case ERROR:
                        resultado += lexer.lexeme + ": Simbolo no definido ---"  + "Linea: " + contSalto + " Columna: " + contLinea + "\n";
                        break;
                    case Salto:
                        contLinea = 0;
                        contSalto += 1;
                        //resultado += "Token: " + tokens + "\n";
                        break;
                        
                    case Entero: case Variable:
                        resultado += lexer.lexeme + ": Es " + tokens + "\n";
                        break;
                    default:
                        resultado += lexer.lexeme + ": " + tokens  + "\n";
                        break;
                }
            }
    }
    //*/
    
    
    /*
    public static void main(String[] args) {
        String ruta = "C:/Users/JulioMulul/Documents/NetBeansProjects/AnalizadorLexicoAritmetica/src/OperacionesAritmeticas/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    */
}














