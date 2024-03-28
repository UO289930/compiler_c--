package semantic.symboltable;

import java.util.*;
import ast.program.Definition;

public class SymbolTable {
	
	private int scope=0;
	private final List<Map<String, Definition>> table = new ArrayList<>();
	public SymbolTable()  {
		// Global scope
		table.add(new HashMap<>());
	}

	public void set() {
		table.add(new HashMap<>());
		scope++;
	}
	
	public void reset() {
		if(scope<=0){
			throw new IllegalStateException("You are already inside the global scope");
		}
		table.remove(scope--);
	}
	
	public boolean insert(Definition definition) {

		if(findInCurrentScope(definition.getName())!=null){
			return false;
		}

		table.get(scope).put(definition.getName(), definition);
		definition.setScope(scope);
		return true;
	}
	
	public Definition find(String id) {

		// Not yet found
		for(int currentScope=scope; currentScope>=0; currentScope-- ){
			Definition definition = table.get(currentScope).get(id);

			if(definition!=null){
				return definition;
			}

		}

		return null;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}
}
