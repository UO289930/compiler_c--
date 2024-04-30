// Generated from C:/Users/UO289930/Desktop/DLP_lexer-parser/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

    import dto.*;
    import ast.types.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.program.*;

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
	 * Enter a parse tree produced by {@link CmmParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(CmmParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(CmmParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#main_function_definition}.
	 * @param ctx the parse tree
	 */
	void enterMain_function_definition(CmmParser.Main_function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#main_function_definition}.
	 * @param ctx the parse tree
	 */
	void exitMain_function_definition(CmmParser.Main_function_definitionContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#variable_definitions}.
	 * @param ctx the parse tree
	 */
	void enterVariable_definitions(CmmParser.Variable_definitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#variable_definitions}.
	 * @param ctx the parse tree
	 */
	void exitVariable_definitions(CmmParser.Variable_definitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(CmmParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(CmmParser.StatementsContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(CmmParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(CmmParser.Return_typeContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#built_in_type}.
	 * @param ctx the parse tree
	 */
	void enterBuilt_in_type(CmmParser.Built_in_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#built_in_type}.
	 * @param ctx the parse tree
	 */
	void exitBuilt_in_type(CmmParser.Built_in_typeContext ctx);
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
	 * Enter a parse tree produced by {@link CmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(CmmParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(CmmParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmmParser#struct_fields}.
	 * @param ctx the parse tree
	 */
	void enterStruct_fields(CmmParser.Struct_fieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmmParser#struct_fields}.
	 * @param ctx the parse tree
	 */
	void exitStruct_fields(CmmParser.Struct_fieldsContext ctx);
}