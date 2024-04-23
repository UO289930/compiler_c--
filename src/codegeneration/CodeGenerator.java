package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.types.FunctionType;
import ast.types.Type;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CodeGenerator {

    private final FileWriter outputFile;
    private int nthLabel = 1;

    public CodeGenerator(String inputFile, String outputFile) throws IOException {
        this.outputFile = new FileWriter(outputFile);
        source(inputFile);
    }

    public String nextLabel() {
        return String.format("label%s", nthLabel++);
    }

    private void debug(String debug) {
        writeLine( String.format("\n#%s", debug) );
    }

    private void source(String arg) {
        debug( String.format("source %s%s%s\n", '"', arg, '"') );
    }

    private void writeLine(String line) {
        try{
            outputFile.append( String.format("%s\n", line) );
        } catch (IOException e) {
            throw new RuntimeException("The code generation phase did not manage to save the generated code");
        }
    }

    public void line(int line) {
        debug( String.format("line %d", line) );
    }

    public <T> void push(String suffix, T elem) {
        writeLine( String.format("push%s %s", suffix, elem) );
    }
    public void add(String suffix) {
        writeLine( String.format("add%s", suffix) );
    }
    public void sub(String suffix) {
        writeLine( String.format("sub%s", suffix) );
    }

    public void globalVariable(int offset) {
        push("a", offset);
    }

    public void localVariable(int offset) {
        push("a", "bp");
        push("i", offset);
        add("i");
    }

    public void convert(Type type2, Type type1) {
        if(!type2.suffix().contentEquals(type1.suffix())){
            writeLine( type2.convertTo(type1) );
        }
    }

    public void arithmetic(String operator, String suffix) {
        switch(operator){
            case "+": add(suffix);
                break;
            case "-": sub(suffix);
                break;
            case "*": mul(suffix);
                break;
            case "/": writeLine( String.format("div%s", suffix) );
                break;
            default:
                assert false;
        }
    }

    public <T> void literal(String suffix, T value) {
        push(suffix, value);
    }

    public void comparison(String operator, String suffix) {
        String operationCode = null;
        switch(operator){
            case ">":
                operationCode = String.format("gt%s", suffix);
                break;
            case "<": operationCode = String.format("lt%s", suffix);
                break;
            case ">=": operationCode = String.format("ge%s", suffix);
                break;
            case "<=": operationCode = String.format("le%s", suffix);
                break;
            case "==": operationCode = String.format("eq%s", suffix);
                break;
            case "!=": operationCode = String.format("ne%s", suffix);
                break;
            default: assert false;
        }

        writeLine( operationCode );
    }

    public void logical(String operator) {
        switch(operator){
            case "&&": writeLine( "and" );
                break;
            case "||": writeLine( "or" );
                break;
            default:
                assert false;
        }
    }


    public void reminder() {
        writeLine( "modi" );
    }

    public void not() {
        writeLine( "not" );
    }

    public void load(String suffix) {
        writeLine( String.format("load%s", suffix) );
    }

    public void store(String suffix) {
        writeLine( String.format("store%s", suffix) );
    }

    public void read(String suffix) {
        writeLine( String.format("in%s", suffix) );
    }

    public void write(String suffix) {
        writeLine( String.format("out%s", suffix) );
    }

    public void comment(String comment) {
        writeLine( String.format("' * %s", comment) );
    }

    public void label(String name) {
        writeLine( String.format("%s:", name) );
    }

    public void enter(List<VariableDefinition> locals) {
        int bytesLocals = locals.isEmpty() ? 0 : -locals.get(locals.size()-1).getOffset();
        writeLine( String.format("enter %s", bytesLocals) );
    }

    public void ret(FunctionDefinition functionDefinition) {
        FunctionType funcType = (FunctionType) functionDefinition.getType();

        List<VariableDefinition> params = funcType.getParameters();
        List<VariableDefinition> locals = functionDefinition.getVariableDefinitions();

        int returnedBytes = funcType.getReturnType().numberOfBytes();
        int bytesLocals = locals.isEmpty() ? 0 : -locals.get(locals.size()-1).getOffset();
        int bytesParams = params.isEmpty() ? 0 :
                locals.get(locals.size()-1).getOffset() + locals.get(locals.size()-1).getType().numberOfBytes();

        writeLine( String.format("ret %d,%d,%d", returnedBytes, bytesLocals, bytesParams) );
    }

    public void close() throws IOException {
        outputFile.close();
    }

    public void callMain() {
        comment("Invocation to the main function");
        writeLine( "call main" );
        writeLine( "halt" );
    }
    public void jump(String jumpOperation, String elseLabel) {
        writeLine( String.format("%s %s", jumpOperation, elseLabel) );
    }

    public void mul(String suffix) {
        writeLine( String.format("mul%s", suffix) );
    }
}
