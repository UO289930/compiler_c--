import ast.errorhandler.ErrorHandler;
import ast.program.Program;
import ast.types.Type;
import codegeneration.*;
import dto.StackMemoryState;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import parser.*;

import org.antlr.v4.runtime.*;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;
import semantic.Visitor;

public class Main {
	
	public static void main(String... args) throws Exception {

		if (args.length<2) {
			System.err.println("Please, pass me the input and output file.");
			return;
		}

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CmmParser parser = new CmmParser(tokens);
		Program ast = parser.program().ast;

		// Semantic analysis

		Visitor<Void, Void> identificationVisitor = new IdentificationVisitor();
		if (!acceptVisitor(ast, identificationVisitor, null)) return;

		Visitor<Type, Void> typeCheckingVisitor = new TypeCheckingVisitor();
		if (!acceptVisitor(ast, typeCheckingVisitor, null)) return;

		Visitor<Void, Void> offsetVisitor = new OffsetVisitor();
		if(!acceptVisitor(ast, offsetVisitor, null)) return;


		// No errors here, so AST is shown
		IntrospectorModel model=new IntrospectorModel("Program", ast);
		new IntrospectorView("Introspector", model);


		// Code generation
		CodeGenerator codeGenerator = new CodeGenerator(args[0], args[1]);
		AddressCGVisitor addressCGVisitor = new AddressCGVisitor(codeGenerator);
		ValueCGVisitor valueCGVisitor = new ValueCGVisitor(codeGenerator, addressCGVisitor);
		addressCGVisitor.setValueCGVisitor(valueCGVisitor);
		Visitor<StackMemoryState, Void> executeCGVisitor = new ExecuteCGVisitor(codeGenerator, addressCGVisitor, valueCGVisitor);

		acceptVisitor(ast, executeCGVisitor, null);
		codeGenerator.close();
	}

	private static <TP,TR> boolean acceptVisitor(Program ast, Visitor<TP, TR> identificationVisitor, TP param) {
		ast.accept(identificationVisitor, param);

		if (ErrorHandler.getInstance().anyErrors()){
			ErrorHandler.getInstance().showErrors(System.err);
			return false;
		}
		return true;
	}


}
