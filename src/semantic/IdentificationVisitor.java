package semantic;

import ast.expressions.*;
import ast.program.Definition;
import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.types.*;
import semantic.symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void>{

    private SymbolTable table = new SymbolTable();

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {


        insertDefinition(functionDefinition);

        table.set();
        super.visit(functionDefinition, param);
        table.reset();

        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        insertDefinition(variableDefinition);
        return null;
    }

    private void insertDefinition(Definition definition) {
        boolean inserted = table.insert(definition);
        if(!inserted){
            new ErrorType(definition.getLine(), definition.getColumn(),
                    String.format("The identifier '%s' has already been used within the same scope", definition.getName()) );
        }
    }

    @Override
    public Void visit(Variable variable, Void param) {

        Definition definition = table.find(variable.getName());

        if(definition==null){
            new ErrorType(variable.getLine(), variable.getColumn(), String.format("The variable '%s' does not correspond with any definition name", variable.getName()));
        }

        variable.setDefinition(definition);

        return null;
    }


}
