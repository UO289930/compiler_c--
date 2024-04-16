package codegeneration;

/**
 *
 * execute[[Read: statement -> expression]] =
 * 	address[[expression]]
 * 	<in> expression.type.suffix()
 * 	<store> expression.type.suffix()
 *
 * execute[[Write: statement -> expression]] =
 * 	value[[expression]]
 * 	<out> expression.type.suffix()
 *
 * execute[[Assignment: statement -> expression1 expression2]] =
 * 	address[[expression1]]
 * 	value[[expression2]]
 * 	<store> expression1.type.suffix()
 *
 * execute[[VariableDefinition: definition -> type ID]] = definition.toString()
 *
 * execute[[FunctionDefiniton: definition -> type ID varDefiniton* statement*]] =
 *
 * execute[[Program: program -> definition*]] =
 */
public class ExecuteCGVisitor {
}
