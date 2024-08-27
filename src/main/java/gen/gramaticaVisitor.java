package gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(gramaticaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(gramaticaParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(gramaticaParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#writeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(gramaticaParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(gramaticaParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(gramaticaParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(gramaticaParser.ExprContext ctx);
}