// Generated from F:/3º/DLP/Lab/repo/dlp/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmmParser}.
 */
public interface CmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(CmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(CmmParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(CmmParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void enterVariable_definition(CmmParser.Variable_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void exitVariable_definition(CmmParser.Variable_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(CmmParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(CmmParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(CmmParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(CmmParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(CmmParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(CmmParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunction_body(CmmParser.Function_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunction_body(CmmParser.Function_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CmmParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CmmParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void enterFunction_invocation(CmmParser.Function_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void exitFunction_invocation(CmmParser.Function_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void enterStruct_field(CmmParser.Struct_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void exitStruct_field(CmmParser.Struct_fieldContext ctx);
}