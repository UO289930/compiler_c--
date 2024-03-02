// Generated from F:/3º/DLP/Lab/repo/dlp/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

    import dto.*;
    import ast.types.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.program.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitions(CmmParser.DefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#main_function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_function_definition(CmmParser.Main_function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(CmmParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#function_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_body(CmmParser.Function_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#variable_definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_definitions(CmmParser.Variable_definitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(CmmParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#built_in_or_record}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuilt_in_or_record(CmmParser.Built_in_or_recordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(CmmParser.Return_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(CmmParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#built_in_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuilt_in_type(CmmParser.Built_in_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CmmParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#function_invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_invocation(CmmParser.Function_invocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CmmParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmmParser#struct_fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_fields(CmmParser.Struct_fieldsContext ctx);
}