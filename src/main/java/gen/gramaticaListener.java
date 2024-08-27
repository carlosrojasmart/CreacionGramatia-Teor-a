package gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramaticaParser}.
 */
public interface gramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(gramaticaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(gramaticaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(gramaticaParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(gramaticaParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(gramaticaParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(gramaticaParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(gramaticaParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(gramaticaParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(gramaticaParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(gramaticaParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(gramaticaParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(gramaticaParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(gramaticaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(gramaticaParser.ExprContext ctx);
}