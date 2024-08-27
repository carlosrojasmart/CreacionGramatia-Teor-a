import gen.gramaticaBaseVisitor;
import gen.gramaticaParser;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends gramaticaBaseVisitor<Object> {
    private Map<String, Object> memory = new HashMap<>();  // Almacena las variables y sus valores

    @Override
    public Object visitAssignStmt(gramaticaParser.AssignStmtContext ctx) {
        String id = ctx.ID().getText();
        Object value = visit(ctx.expr());  // Evalúa la expresión en el lado derecho
        memory.put(id, value);  // Guarda el valor en la "memoria"
        System.out.println(id + " = " + value);
        return value;
    }

    @Override
    public Object visitWriteStmt(gramaticaParser.WriteStmtContext ctx) {
        Object value = visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    @Override
    public Object visitExpr(gramaticaParser.ExprContext ctx) {
        if (ctx.ID() != null) {  // Si la expresión es una variable
            String id = ctx.ID().getText();
            return memory.get(id);  // Recupera el valor de la "memoria"
        } else if (ctx.NUMBER() != null) {  // Si la expresión es un número
            return Integer.valueOf(ctx.NUMBER().getText());
        } else if (ctx.STRING() != null) {  // Si la expresión es una cadena
            return ctx.STRING().getText().replace("\"", "");  // Elimina las comillas
        } else if (ctx.expr().size() == 2) {  // Si la expresión es binaria
            Object left = visit(ctx.expr(0));
            Object right = visit(ctx.expr(1));
            switch (ctx.op.getText()) {
                case "+":
                    return (Integer) left + (Integer) right;
                case "-":
                    return (Integer) left - (Integer) right;
                case "*":
                    return (Integer) left * (Integer) right;
                case "/":
                    return (Integer) left / (Integer) right;
                case ">":
                    return (Integer) left > (Integer) right;
                case "<":
                    return (Integer) left < (Integer) right;
                case ">=":
                    return (Integer) left >= (Integer) right;
                case "<=":
                    return (Integer) left <= (Integer) right;
                case "==":
                    return left.equals(right);
                case "!=":
                    return !left.equals(right);
                // Agrega más operadores según sea necesario
            }
        } else if (ctx.expr().size() == 1 && ctx.getChildCount() == 2) {  // Si es una expresión unaria, como -expr
            Object value = visit(ctx.expr(0));
            if (ctx.op.getText().equals("-")) {
                return -(Integer) value;
            }
        }
        return null;
    }

    @Override
    public Object visitIfStmt(gramaticaParser.IfStmtContext ctx) {
        Object condition = visit(ctx.expr());
        if (condition instanceof Boolean && (Boolean) condition) {
            return visit(ctx.stmt(0));  // Evalúa el bloque 'si'
        } else if (ctx.getChildCount() > 5) {  // Si hay un bloque 'sino'
            return visit(ctx.stmt(1));  // Evalúa el bloque 'sino'
        }
        return null;
    }



}
