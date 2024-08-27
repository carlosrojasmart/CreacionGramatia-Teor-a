import gen.gramaticaLexer;
import gen.gramaticaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Lee el archivo de entrada
        String filePath = "src/main/Files/imput_teoria.txt"; // Reemplaza con la ruta de tu archivo
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // 2. Agrega ';' al final de cada línea si no existe
        String input = lines.stream()
                .map(line -> line.trim().endsWith(";") ? line : line + ";")
                .collect(Collectors.joining("\n"));

        // 3. Crea un lexer basado en tu archivo de gramática generado (gramaticaLexer)
        gramaticaLexer lexer = new gramaticaLexer(CharStreams.fromString(input));

        // 4. Convierte los tokens generados por el lexer en un stream de tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 5. Crea un parser usando tu archivo de gramática generado (gramaticaParser)
        gramaticaParser parser = new gramaticaParser(tokens);

        // 6. Analiza el programa a partir de la regla inicial 'prog' (ajusta según tu gramática)
        ParseTree tree = parser.prog();

        // 7. Crea una instancia de tu visitor personalizado (EvalVisitor)
        EvalVisitor visitor = new EvalVisitor();

        // 8. Aplica el visitor al árbol de análisis sintáctico
        visitor.visit(tree);

        // Imprime el árbol de análisis para depuración (opcional)
        System.out.println(tree.toStringTree(parser));
    }
}
