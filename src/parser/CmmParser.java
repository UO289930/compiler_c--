// Generated from F:/3�/DLP/Lab/repo/dlp/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

    import dto.*;
    import ast.types.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.program.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, ID=37, INT_CONSTANT=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, COMMENT=41, WHITESPACE=42;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_main_function_definition = 2, 
		RULE_function_definition = 3, RULE_function_body = 4, RULE_variable_definitions = 5, 
		RULE_statements = 6, RULE_expression = 7, RULE_type = 8, RULE_return_type = 9, 
		RULE_parameters = 10, RULE_built_in_type = 11, RULE_block = 12, RULE_function_invocation = 13, 
		RULE_arguments = 14, RULE_expressions = 15, RULE_struct_fields = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definitions", "main_function_definition", "function_definition", 
			"function_body", "variable_definitions", "statements", "expression", 
			"type", "return_type", "parameters", "built_in_type", "block", "function_invocation", 
			"arguments", "expressions", "struct_fields"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'main'", "'('", "')'", "'{'", "'}'", "','", "';'", "'='", 
			"'while'", "'if'", "'else'", "'write'", "'read'", "'return'", "'['", 
			"']'", "'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", 
			"'<='", "'<'", "'!='", "'=='", "'&&'", "'||'", "'struct'", "'int'", "'char'", 
			"'double'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "COMMENT", 
			"WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> defs = new ArrayList<>();
		public DefinitionsContext di;
		public Main_function_definitionContext main;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public Main_function_definitionContext main_function_definition() {
			return getRuleContext(Main_function_definitionContext.class,0);
		}
		public List<DefinitionsContext> definitions() {
			return getRuleContexts(DefinitionsContext.class);
		}
		public DefinitionsContext definitions(int i) {
			return getRuleContext(DefinitionsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					((ProgramContext)_localctx).di = definitions();
					 _localctx.defs.addAll(((ProgramContext)_localctx).di.ast); 
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(42);
			((ProgramContext)_localctx).main = main_function_definition();
			 _localctx.defs.add( ((ProgramContext)_localctx).main.ast ); 
			setState(44);
			match(EOF);
			 ((ProgramContext)_localctx).ast =  new Program( _localctx.defs ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<>();
		public Variable_definitionsContext v;
		public Function_definitionContext f;
		public Variable_definitionsContext variable_definitions() {
			return getRuleContext(Variable_definitionsContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				((DefinitionsContext)_localctx).v = variable_definitions();
				 _localctx.ast.addAll( ((DefinitionsContext)_localctx).v.ast ); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				((DefinitionsContext)_localctx).f = function_definition();
				 _localctx.ast.add( ((DefinitionsContext)_localctx).f.ast ); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Main_function_definitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public List<Statement> ss = new ArrayList<>();
		public List<VariableDefinition> vs = new ArrayList<>();
		public Token VOID;
		public Token MAIN;
		public Function_bodyContext body;
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Main_function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMain_function_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMain_function_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMain_function_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_function_definitionContext main_function_definition() throws RecognitionException {
		Main_function_definitionContext _localctx = new Main_function_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			((Main_function_definitionContext)_localctx).VOID = match(T__0);
			setState(56);
			((Main_function_definitionContext)_localctx).MAIN = match(T__1);
			setState(57);
			match(T__2);
			setState(58);
			match(T__3);
			setState(59);
			((Main_function_definitionContext)_localctx).body = function_body();
			 ((Main_function_definitionContext)_localctx).ast =  ParserHelper.createFuncDef( ((Main_function_definitionContext)_localctx).VOID.getLine(), ((Main_function_definitionContext)_localctx).VOID.getCharPositionInLine()+1, null, (((Main_function_definitionContext)_localctx).MAIN!=null?((Main_function_definitionContext)_localctx).MAIN.getText():null), null, ((Main_function_definitionContext)_localctx).body.ast ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Return_typeContext t;
		public Token ID;
		public ParametersContext params;
		public Function_bodyContext body;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunction_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			((Function_definitionContext)_localctx).t = return_type();
			setState(63);
			((Function_definitionContext)_localctx).ID = match(ID);
			setState(64);
			match(T__2);
			setState(65);
			((Function_definitionContext)_localctx).params = parameters();
			setState(66);
			match(T__3);
			setState(67);
			((Function_definitionContext)_localctx).body = function_body();
			 ((Function_definitionContext)_localctx).ast =  ParserHelper.createFuncDef( ((Function_definitionContext)_localctx).t.ast.getLine(), ((Function_definitionContext)_localctx).t.ast.getColumn(), ((Function_definitionContext)_localctx).t.ast, (((Function_definitionContext)_localctx).ID!=null?((Function_definitionContext)_localctx).ID.getText():null), ((Function_definitionContext)_localctx).params.ast, ((Function_definitionContext)_localctx).body.ast ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_bodyContext extends ParserRuleContext {
		public FunctionBody ast;
		public List<Statement> ss = new ArrayList<>();
		public List<VariableDefinition> vs = new ArrayList<>();
		public Variable_definitionsContext v;
		public StatementsContext s;
		public List<Variable_definitionsContext> variable_definitions() {
			return getRuleContexts(Variable_definitionsContext.class);
		}
		public Variable_definitionsContext variable_definitions(int i) {
			return getRuleContext(Variable_definitionsContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunction_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunction_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunction_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__4);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) {
				{
				{
				setState(71);
				((Function_bodyContext)_localctx).v = variable_definitions();
				 _localctx.vs.addAll( ((Function_bodyContext)_localctx).v.ast ); 
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2061585935368L) != 0)) {
				{
				{
				setState(79);
				((Function_bodyContext)_localctx).s = statements();
				 _localctx.ss.addAll( ((Function_bodyContext)_localctx).s.ast ); 
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(T__5);
			 ((Function_bodyContext)_localctx).ast =  new FunctionBody(_localctx.vs, _localctx.ss); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_definitionsContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public TypeContext t;
		public Token v1;
		public Token vi;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Variable_definitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVariable_definitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVariable_definitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVariable_definitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_definitionsContext variable_definitions() throws RecognitionException {
		Variable_definitionsContext _localctx = new Variable_definitionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((Variable_definitionsContext)_localctx).t = type(0);
			setState(91);
			((Variable_definitionsContext)_localctx).v1 = match(ID);
			 _localctx.ast.add( ParserHelper.createVarDef( ((Variable_definitionsContext)_localctx).t.ast.getLine(), ((Variable_definitionsContext)_localctx).t.ast.getColumn(), ((Variable_definitionsContext)_localctx).t.ast, (((Variable_definitionsContext)_localctx).v1!=null?((Variable_definitionsContext)_localctx).v1.getText():null) ) ); 
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(93);
				match(T__6);
				setState(94);
				((Variable_definitionsContext)_localctx).vi = match(ID);
				 _localctx.ast.add( ParserHelper.createVarDef( ((Variable_definitionsContext)_localctx).t.ast.getLine(), ((Variable_definitionsContext)_localctx).t.ast.getColumn(), ((Variable_definitionsContext)_localctx).t.ast, (((Variable_definitionsContext)_localctx).vi!=null?((Variable_definitionsContext)_localctx).vi.getText():null) ) );  
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public Function_invocationContext fi;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Token WHILE;
		public ExpressionContext e;
		public BlockContext b;
		public Token IF;
		public BlockContext b1;
		public BlockContext b2;
		public Token WRITE;
		public ExpressionsContext es;
		public Token READ;
		public Token RET;
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statements);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				((StatementsContext)_localctx).fi = function_invocation();
				setState(104);
				match(T__7);
				 _localctx.ast.add( ((StatementsContext)_localctx).fi.ast ); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				((StatementsContext)_localctx).e1 = expression(0);
				setState(108);
				match(T__8);
				setState(109);
				((StatementsContext)_localctx).e2 = expression(0);
				setState(110);
				match(T__7);
				 _localctx.ast.add( new Assignment( ((StatementsContext)_localctx).e1.ast.getLine(), ((StatementsContext)_localctx).e1.ast.getColumn(), ((StatementsContext)_localctx).e1.ast, ((StatementsContext)_localctx).e2.ast ) ); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				((StatementsContext)_localctx).WHILE = match(T__9);
				setState(114);
				match(T__2);
				setState(115);
				((StatementsContext)_localctx).e = expression(0);
				setState(116);
				match(T__3);
				setState(117);
				((StatementsContext)_localctx).b = block();
				 _localctx.ast.add( new While( ((StatementsContext)_localctx).WHILE.getLine(), ((StatementsContext)_localctx).WHILE.getCharPositionInLine()+1, ((StatementsContext)_localctx).e.ast, ((StatementsContext)_localctx).b.ast ) ); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				((StatementsContext)_localctx).IF = match(T__10);
				setState(121);
				match(T__2);
				setState(122);
				((StatementsContext)_localctx).e = expression(0);
				setState(123);
				match(T__3);
				setState(124);
				((StatementsContext)_localctx).b = block();
				 _localctx.ast.add( new IfElse( ((StatementsContext)_localctx).IF.getLine(), ((StatementsContext)_localctx).IF.getCharPositionInLine()+1, ((StatementsContext)_localctx).e.ast, ((StatementsContext)_localctx).b.ast, null ) ); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				((StatementsContext)_localctx).IF = match(T__10);
				setState(128);
				match(T__2);
				setState(129);
				((StatementsContext)_localctx).e = expression(0);
				setState(130);
				match(T__3);
				setState(131);
				((StatementsContext)_localctx).b1 = block();
				setState(132);
				match(T__11);
				setState(133);
				((StatementsContext)_localctx).b2 = block();
				 _localctx.ast.add( new IfElse( ((StatementsContext)_localctx).IF.getLine(), ((StatementsContext)_localctx).IF.getCharPositionInLine()+1, ((StatementsContext)_localctx).e.ast, ((StatementsContext)_localctx).b1.ast, ((StatementsContext)_localctx).b2.ast ) ); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				((StatementsContext)_localctx).WRITE = match(T__12);
				setState(137);
				((StatementsContext)_localctx).es = expressions();
				setState(138);
				match(T__7);
				 _localctx.ast.addAll( ParserHelper.createWriteStatements(((StatementsContext)_localctx).WRITE.getLine(), ((StatementsContext)_localctx).WRITE.getCharPositionInLine()+1, ((StatementsContext)_localctx).es.ast) ); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(141);
				((StatementsContext)_localctx).READ = match(T__13);
				setState(142);
				((StatementsContext)_localctx).es = expressions();
				setState(143);
				match(T__7);
				 _localctx.ast.addAll( ParserHelper.createReadStatements(((StatementsContext)_localctx).READ.getLine(), ((StatementsContext)_localctx).READ.getCharPositionInLine()+1, ((StatementsContext)_localctx).es.ast) ); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(146);
				((StatementsContext)_localctx).RET = match(T__14);
				setState(147);
				((StatementsContext)_localctx).e = expression(0);
				setState(148);
				match(T__7);
				 _localctx.ast.add( new Return( ((StatementsContext)_localctx).RET.getLine(), ((StatementsContext)_localctx).RET.getCharPositionInLine()+1, ((StatementsContext)_localctx).e.ast ) ); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public ExpressionContext e;
		public Function_invocationContext fi;
		public Token P;
		public TypeContext t;
		public Token MINUS;
		public Token EXC;
		public Token ID;
		public Token IC;
		public Token CC;
		public Token RC;
		public Token OP;
		public ExpressionContext e2;
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(154);
				((ExpressionContext)_localctx).fi = function_invocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).fi.ast; 
				}
				break;
			case 2:
				{
				setState(157);
				match(T__2);
				setState(158);
				((ExpressionContext)_localctx).e = expression(0);
				setState(159);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e.ast; 
				}
				break;
			case 3:
				{
				setState(162);
				((ExpressionContext)_localctx).P = match(T__2);
				setState(163);
				((ExpressionContext)_localctx).t = type(0);
				setState(164);
				match(T__3);
				setState(165);
				((ExpressionContext)_localctx).e = expression(11);
				 ((ExpressionContext)_localctx).ast =  new Cast( ((ExpressionContext)_localctx).P.getLine(), ((ExpressionContext)_localctx).P.getCharPositionInLine()+1, ((ExpressionContext)_localctx).t.ast, ((ExpressionContext)_localctx).e.ast ); 
				}
				break;
			case 4:
				{
				setState(168);
				((ExpressionContext)_localctx).MINUS = match(T__18);
				setState(169);
				((ExpressionContext)_localctx).e = expression(10);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus( ((ExpressionContext)_localctx).MINUS.getLine(), ((ExpressionContext)_localctx).MINUS.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast ); 
				}
				break;
			case 5:
				{
				setState(172);
				((ExpressionContext)_localctx).EXC = match(T__19);
				setState(173);
				((ExpressionContext)_localctx).e = expression(9);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot( ((ExpressionContext)_localctx).EXC.getLine(), ((ExpressionContext)_localctx).EXC.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast ); 
				}
				break;
			case 6:
				{
				setState(176);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable( ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null) ); 
				}
				break;
			case 7:
				{
				setState(178);
				((ExpressionContext)_localctx).IC = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral( ((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null)) ); 
				}
				break;
			case 8:
				{
				setState(180);
				((ExpressionContext)_localctx).CC = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral( ((ExpressionContext)_localctx).CC.getLine(), ((ExpressionContext)_localctx).CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CC!=null?((ExpressionContext)_localctx).CC.getText():null)) ); 
				}
				break;
			case 9:
				{
				setState(182);
				((ExpressionContext)_localctx).RC = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral( ((ExpressionContext)_localctx).RC.getLine(), ((ExpressionContext)_localctx).RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).RC!=null?((ExpressionContext)_localctx).RC.getText():null)) ); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(216);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(187);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  ParserHelper.createArithmeticOrReminder( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(192);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__23) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).ast =  ParserHelper.createArithmeticOrReminder( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(197);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929216L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(198);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Comparison( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(203);
						((ExpressionContext)_localctx).e2 = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Logical( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(207);
						match(T__15);
						setState(208);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(209);
						match(T__16);
						 ((ExpressionContext)_localctx).ast =  new Indexing( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(212);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(213);
						match(T__17);
						setState(214);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess( ((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null) ); 
						}
						break;
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t;
		public Built_in_typeContext b;
		public Token STRUCT;
		public Struct_fieldsContext sf;
		public Token IC;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public Struct_fieldsContext struct_fields() {
			return getRuleContext(Struct_fieldsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				{
				setState(222);
				((TypeContext)_localctx).b = built_in_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).b.ast; 
				}
				break;
			case T__32:
				{
				setState(225);
				((TypeContext)_localctx).STRUCT = match(T__32);
				setState(226);
				match(T__4);
				setState(227);
				((TypeContext)_localctx).sf = struct_fields();
				setState(228);
				match(T__5);
				 ((TypeContext)_localctx).ast =  ParserHelper.createStructType( ((TypeContext)_localctx).STRUCT.getLine(), ((TypeContext)_localctx).STRUCT.getCharPositionInLine()+1, ((TypeContext)_localctx).sf.ast ); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(233);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(234);
					match(T__15);
					setState(235);
					((TypeContext)_localctx).IC = match(INT_CONSTANT);
					setState(236);
					match(T__16);
					 ((TypeContext)_localctx).ast =  ParserHelper.createArrayType( ((TypeContext)_localctx).t.ast.getLine(), ((TypeContext)_localctx).t.ast.getColumn(), ((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).IC!=null?((TypeContext)_localctx).IC.getText():null)) ); 
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_typeContext extends ParserRuleContext {
		public Type ast;
		public Built_in_typeContext b;
		public Token VOID;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitReturn_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitReturn_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_return_type);
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				((Return_typeContext)_localctx).b = built_in_type();
				 ((Return_typeContext)_localctx).ast =  ((Return_typeContext)_localctx).b.ast; 
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				((Return_typeContext)_localctx).VOID = match(T__0);
				 ((Return_typeContext)_localctx).ast =  new VoidType( ((Return_typeContext)_localctx).VOID.getLine(), ((Return_typeContext)_localctx).VOID.getCharPositionInLine()+1 ); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public Built_in_typeContext b1;
		public Token ID;
		public Built_in_typeContext bi;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<Built_in_typeContext> built_in_type() {
			return getRuleContexts(Built_in_typeContext.class);
		}
		public Built_in_typeContext built_in_type(int i) {
			return getRuleContext(Built_in_typeContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		int _la;
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				((ParametersContext)_localctx).b1 = built_in_type();
				setState(251);
				((ParametersContext)_localctx).ID = match(ID);
				 _localctx.ast.add( ParserHelper.createVarDef( ((ParametersContext)_localctx).b1.ast.getLine(), ((ParametersContext)_localctx).b1.ast.getColumn(), ((ParametersContext)_localctx).b1.ast, (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null) ) ); 
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(253);
					match(T__6);
					setState(254);
					((ParametersContext)_localctx).bi = built_in_type();
					setState(255);
					((ParametersContext)_localctx).ID = match(ID);
					 _localctx.ast.add( ParserHelper.createVarDef( ((ParametersContext)_localctx).bi.ast.getLine(), ((ParametersContext)_localctx).bi.ast.getColumn(), ((ParametersContext)_localctx).bi.ast, (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null) ) ); 
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Built_in_typeContext extends ParserRuleContext {
		public Type ast;
		public Token T;
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBuilt_in_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBuilt_in_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBuilt_in_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_built_in_type);
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				((Built_in_typeContext)_localctx).T = match(T__33);
				 ((Built_in_typeContext)_localctx).ast =  new IntType( ((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1 ); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				((Built_in_typeContext)_localctx).T = match(T__34);
				 ((Built_in_typeContext)_localctx).ast =  new CharType( ((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1 ); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				((Built_in_typeContext)_localctx).T = match(T__35);
				 ((Built_in_typeContext)_localctx).ast =  new DoubleType( ((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1 ); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public StatementsContext s1;
		public StatementsContext si;
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case T__18:
			case T__19:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				((BlockContext)_localctx).s1 = statements();
				 _localctx.ast.addAll(((BlockContext)_localctx).s1.ast); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				match(T__4);
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2061585935368L) != 0)) {
					{
					{
					setState(278);
					((BlockContext)_localctx).si = statements();
					 _localctx.ast.addAll(((BlockContext)_localctx).si.ast); 
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(286);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_invocationContext extends ParserRuleContext {
		public FunctionInvocation ast;
		public Token ID;
		public ArgumentsContext args;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunction_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunction_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunction_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_invocationContext function_invocation() throws RecognitionException {
		Function_invocationContext _localctx = new Function_invocationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			((Function_invocationContext)_localctx).ID = match(ID);
			setState(290);
			match(T__2);
			setState(291);
			((Function_invocationContext)_localctx).args = arguments();
			setState(292);
			match(T__3);
			 ((Function_invocationContext)_localctx).ast =  ParserHelper.createFuncInvoc( ((Function_invocationContext)_localctx).ID.getLine(), ((Function_invocationContext)_localctx).ID.getCharPositionInLine()+1, (((Function_invocationContext)_localctx).ID!=null?((Function_invocationContext)_localctx).ID.getText():null), ((Function_invocationContext)_localctx).args.ast ); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<>();
		public ExpressionContext e1;
		public ExpressionContext ei;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arguments);
		int _la;
		try {
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__18:
			case T__19:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				((ArgumentsContext)_localctx).e1 = expression(0);
				 _localctx.ast.add( ((ArgumentsContext)_localctx).e1.ast ); 
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(297);
					match(T__6);
					setState(298);
					((ArgumentsContext)_localctx).ei = expression(0);
					 _localctx.ast.add( ((ArgumentsContext)_localctx).ei.ast ); 
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<>();
		public ExpressionContext e1;
		public ExpressionContext ei;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			((ExpressionsContext)_localctx).e1 = expression(0);
			 _localctx.ast.add( ((ExpressionsContext)_localctx).e1.ast );  
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(311);
				match(T__6);
				setState(312);
				((ExpressionsContext)_localctx).ei = expression(0);
				 _localctx.ast.add( ((ExpressionsContext)_localctx).ei.ast ); 
				}
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_fieldsContext extends ParserRuleContext {
		public List<StructField> ast = new ArrayList<>();
		public TypeContext t;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Struct_fieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStruct_fields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStruct_fields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStruct_fields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_fieldsContext struct_fields() throws RecognitionException {
		Struct_fieldsContext _localctx = new Struct_fieldsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_struct_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(320);
				((Struct_fieldsContext)_localctx).t = type(0);
				setState(321);
				((Struct_fieldsContext)_localctx).ID = match(ID);
				 _localctx.ast.add( new StructField( ((Struct_fieldsContext)_localctx).t.ast.getLine(), ((Struct_fieldsContext)_localctx).t.ast.getColumn(), ((Struct_fieldsContext)_localctx).t.ast, (((Struct_fieldsContext)_localctx).ID!=null?((Struct_fieldsContext)_localctx).ID.getText():null) ) ); 
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(323);
					match(T__6);
					setState(324);
					((Struct_fieldsContext)_localctx).ID = match(ID);
					 _localctx.ast.add( new StructField( ((Struct_fieldsContext)_localctx).t.ast.getLine(), ((Struct_fieldsContext)_localctx).t.ast.getColumn(), ((Struct_fieldsContext)_localctx).t.ast, (((Struct_fieldsContext)_localctx).ID!=null?((Struct_fieldsContext)_localctx).ID.getText():null) ) ); 
					}
					}
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(331);
				match(T__7);
				}
				}
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 8:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u0152\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00016\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"K\b\u0004\n\u0004\f\u0004N\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004S\b\u0004\n\u0004\f\u0004V\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005a\b\u0005\n\u0005\f\u0005d\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u0098\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b9\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u00d9\b\u0007\n\u0007\f\u0007\u00dc\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00e8\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00ef\b\b"+
		"\n\b\f\b\u00f2\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00f9"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0103\b\n\n\n\f\n\u0106\t\n\u0001\n\u0003\n\u0109\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0111"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u011a\b\f\n\f\f\f\u011d\t\f\u0001\f\u0003\f\u0120\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u012e\b\u000e\n\u000e"+
		"\f\u000e\u0131\t\u000e\u0001\u000e\u0003\u000e\u0134\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u013c\b\u000f\n\u000f\f\u000f\u013f\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0147\b\u0010\n"+
		"\u0010\f\u0010\u014a\t\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u014e"+
		"\b\u0010\u000b\u0010\f\u0010\u014f\u0001\u0010\u0000\u0002\u000e\u0010"+
		"\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \u0000\u0004\u0001\u0000\u0015\u0017\u0002\u0000\u0013"+
		"\u0013\u0018\u0018\u0001\u0000\u0019\u001e\u0001\u0000\u001f \u0168\u0000"+
		"\'\u0001\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u00047\u0001"+
		"\u0000\u0000\u0000\u0006>\u0001\u0000\u0000\u0000\bF\u0001\u0000\u0000"+
		"\u0000\nZ\u0001\u0000\u0000\u0000\f\u0097\u0001\u0000\u0000\u0000\u000e"+
		"\u00b8\u0001\u0000\u0000\u0000\u0010\u00e7\u0001\u0000\u0000\u0000\u0012"+
		"\u00f8\u0001\u0000\u0000\u0000\u0014\u0108\u0001\u0000\u0000\u0000\u0016"+
		"\u0110\u0001\u0000\u0000\u0000\u0018\u011f\u0001\u0000\u0000\u0000\u001a"+
		"\u0121\u0001\u0000\u0000\u0000\u001c\u0133\u0001\u0000\u0000\u0000\u001e"+
		"\u0135\u0001\u0000\u0000\u0000 \u014d\u0001\u0000\u0000\u0000\"#\u0003"+
		"\u0002\u0001\u0000#$\u0006\u0000\uffff\uffff\u0000$&\u0001\u0000\u0000"+
		"\u0000%\"\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000\u0000)\'\u0001"+
		"\u0000\u0000\u0000*+\u0003\u0004\u0002\u0000+,\u0006\u0000\uffff\uffff"+
		"\u0000,-\u0005\u0000\u0000\u0001-.\u0006\u0000\uffff\uffff\u0000.\u0001"+
		"\u0001\u0000\u0000\u0000/0\u0003\n\u0005\u000001\u0006\u0001\uffff\uffff"+
		"\u000016\u0001\u0000\u0000\u000023\u0003\u0006\u0003\u000034\u0006\u0001"+
		"\uffff\uffff\u000046\u0001\u0000\u0000\u00005/\u0001\u0000\u0000\u0000"+
		"52\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u000078\u0005\u0001"+
		"\u0000\u000089\u0005\u0002\u0000\u00009:\u0005\u0003\u0000\u0000:;\u0005"+
		"\u0004\u0000\u0000;<\u0003\b\u0004\u0000<=\u0006\u0002\uffff\uffff\u0000"+
		"=\u0005\u0001\u0000\u0000\u0000>?\u0003\u0012\t\u0000?@\u0005%\u0000\u0000"+
		"@A\u0005\u0003\u0000\u0000AB\u0003\u0014\n\u0000BC\u0005\u0004\u0000\u0000"+
		"CD\u0003\b\u0004\u0000DE\u0006\u0003\uffff\uffff\u0000E\u0007\u0001\u0000"+
		"\u0000\u0000FL\u0005\u0005\u0000\u0000GH\u0003\n\u0005\u0000HI\u0006\u0004"+
		"\uffff\uffff\u0000IK\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000\u0000"+
		"KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MT\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0003\f\u0006"+
		"\u0000PQ\u0006\u0004\uffff\uffff\u0000QS\u0001\u0000\u0000\u0000RO\u0001"+
		"\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000WX\u0005\u0006\u0000\u0000XY\u0006\u0004\uffff\uffff\u0000Y\t\u0001"+
		"\u0000\u0000\u0000Z[\u0003\u0010\b\u0000[\\\u0005%\u0000\u0000\\b\u0006"+
		"\u0005\uffff\uffff\u0000]^\u0005\u0007\u0000\u0000^_\u0005%\u0000\u0000"+
		"_a\u0006\u0005\uffff\uffff\u0000`]\u0001\u0000\u0000\u0000ad\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0005\b\u0000\u0000f\u000b"+
		"\u0001\u0000\u0000\u0000gh\u0003\u001a\r\u0000hi\u0005\b\u0000\u0000i"+
		"j\u0006\u0006\uffff\uffff\u0000j\u0098\u0001\u0000\u0000\u0000kl\u0003"+
		"\u000e\u0007\u0000lm\u0005\t\u0000\u0000mn\u0003\u000e\u0007\u0000no\u0005"+
		"\b\u0000\u0000op\u0006\u0006\uffff\uffff\u0000p\u0098\u0001\u0000\u0000"+
		"\u0000qr\u0005\n\u0000\u0000rs\u0005\u0003\u0000\u0000st\u0003\u000e\u0007"+
		"\u0000tu\u0005\u0004\u0000\u0000uv\u0003\u0018\f\u0000vw\u0006\u0006\uffff"+
		"\uffff\u0000w\u0098\u0001\u0000\u0000\u0000xy\u0005\u000b\u0000\u0000"+
		"yz\u0005\u0003\u0000\u0000z{\u0003\u000e\u0007\u0000{|\u0005\u0004\u0000"+
		"\u0000|}\u0003\u0018\f\u0000}~\u0006\u0006\uffff\uffff\u0000~\u0098\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0005\u000b\u0000\u0000\u0080\u0081\u0005"+
		"\u0003\u0000\u0000\u0081\u0082\u0003\u000e\u0007\u0000\u0082\u0083\u0005"+
		"\u0004\u0000\u0000\u0083\u0084\u0003\u0018\f\u0000\u0084\u0085\u0005\f"+
		"\u0000\u0000\u0085\u0086\u0003\u0018\f\u0000\u0086\u0087\u0006\u0006\uffff"+
		"\uffff\u0000\u0087\u0098\u0001\u0000\u0000\u0000\u0088\u0089\u0005\r\u0000"+
		"\u0000\u0089\u008a\u0003\u001e\u000f\u0000\u008a\u008b\u0005\b\u0000\u0000"+
		"\u008b\u008c\u0006\u0006\uffff\uffff\u0000\u008c\u0098\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0005\u000e\u0000\u0000\u008e\u008f\u0003\u001e\u000f"+
		"\u0000\u008f\u0090\u0005\b\u0000\u0000\u0090\u0091\u0006\u0006\uffff\uffff"+
		"\u0000\u0091\u0098\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u000f\u0000"+
		"\u0000\u0093\u0094\u0003\u000e\u0007\u0000\u0094\u0095\u0005\b\u0000\u0000"+
		"\u0095\u0096\u0006\u0006\uffff\uffff\u0000\u0096\u0098\u0001\u0000\u0000"+
		"\u0000\u0097g\u0001\u0000\u0000\u0000\u0097k\u0001\u0000\u0000\u0000\u0097"+
		"q\u0001\u0000\u0000\u0000\u0097x\u0001\u0000\u0000\u0000\u0097\u007f\u0001"+
		"\u0000\u0000\u0000\u0097\u0088\u0001\u0000\u0000\u0000\u0097\u008d\u0001"+
		"\u0000\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000\u0098\r\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0006\u0007\uffff\uffff\u0000\u009a\u009b\u0003"+
		"\u001a\r\u0000\u009b\u009c\u0006\u0007\uffff\uffff\u0000\u009c\u00b9\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005\u0003\u0000\u0000\u009e\u009f\u0003"+
		"\u000e\u0007\u0000\u009f\u00a0\u0005\u0004\u0000\u0000\u00a0\u00a1\u0006"+
		"\u0007\uffff\uffff\u0000\u00a1\u00b9\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0005\u0003\u0000\u0000\u00a3\u00a4\u0003\u0010\b\u0000\u00a4\u00a5\u0005"+
		"\u0004\u0000\u0000\u00a5\u00a6\u0003\u000e\u0007\u000b\u00a6\u00a7\u0006"+
		"\u0007\uffff\uffff\u0000\u00a7\u00b9\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0005\u0013\u0000\u0000\u00a9\u00aa\u0003\u000e\u0007\n\u00aa\u00ab\u0006"+
		"\u0007\uffff\uffff\u0000\u00ab\u00b9\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0005\u0014\u0000\u0000\u00ad\u00ae\u0003\u000e\u0007\t\u00ae\u00af\u0006"+
		"\u0007\uffff\uffff\u0000\u00af\u00b9\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005%\u0000\u0000\u00b1\u00b9\u0006\u0007\uffff\uffff\u0000\u00b2\u00b3"+
		"\u0005&\u0000\u0000\u00b3\u00b9\u0006\u0007\uffff\uffff\u0000\u00b4\u00b5"+
		"\u0005(\u0000\u0000\u00b5\u00b9\u0006\u0007\uffff\uffff\u0000\u00b6\u00b7"+
		"\u0005\'\u0000\u0000\u00b7\u00b9\u0006\u0007\uffff\uffff\u0000\u00b8\u0099"+
		"\u0001\u0000\u0000\u0000\u00b8\u009d\u0001\u0000\u0000\u0000\u00b8\u00a2"+
		"\u0001\u0000\u0000\u0000\u00b8\u00a8\u0001\u0000\u0000\u0000\u00b8\u00ac"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b0\u0001\u0000\u0000\u0000\u00b8\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b8\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b9\u00da\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\n\b\u0000\u0000\u00bb\u00bc\u0007\u0000\u0000\u0000\u00bc\u00bd\u0003"+
		"\u000e\u0007\t\u00bd\u00be\u0006\u0007\uffff\uffff\u0000\u00be\u00d9\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c0\n\u0007\u0000\u0000\u00c0\u00c1\u0007\u0001"+
		"\u0000\u0000\u00c1\u00c2\u0003\u000e\u0007\b\u00c2\u00c3\u0006\u0007\uffff"+
		"\uffff\u0000\u00c3\u00d9\u0001\u0000\u0000\u0000\u00c4\u00c5\n\u0006\u0000"+
		"\u0000\u00c5\u00c6\u0007\u0002\u0000\u0000\u00c6\u00c7\u0003\u000e\u0007"+
		"\u0007\u00c7\u00c8\u0006\u0007\uffff\uffff\u0000\u00c8\u00d9\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\n\u0005\u0000\u0000\u00ca\u00cb\u0007\u0003\u0000"+
		"\u0000\u00cb\u00cc\u0003\u000e\u0007\u0006\u00cc\u00cd\u0006\u0007\uffff"+
		"\uffff\u0000\u00cd\u00d9\u0001\u0000\u0000\u0000\u00ce\u00cf\n\r\u0000"+
		"\u0000\u00cf\u00d0\u0005\u0010\u0000\u0000\u00d0\u00d1\u0003\u000e\u0007"+
		"\u0000\u00d1\u00d2\u0005\u0011\u0000\u0000\u00d2\u00d3\u0006\u0007\uffff"+
		"\uffff\u0000\u00d3\u00d9\u0001\u0000\u0000\u0000\u00d4\u00d5\n\f\u0000"+
		"\u0000\u00d5\u00d6\u0005\u0012\u0000\u0000\u00d6\u00d7\u0005%\u0000\u0000"+
		"\u00d7\u00d9\u0006\u0007\uffff\uffff\u0000\u00d8\u00ba\u0001\u0000\u0000"+
		"\u0000\u00d8\u00bf\u0001\u0000\u0000\u0000\u00d8\u00c4\u0001\u0000\u0000"+
		"\u0000\u00d8\u00c9\u0001\u0000\u0000\u0000\u00d8\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d4\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db\u000f\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0006\b\uffff\uffff\u0000\u00de\u00df\u0003\u0016\u000b"+
		"\u0000\u00df\u00e0\u0006\b\uffff\uffff\u0000\u00e0\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0005!\u0000\u0000\u00e2\u00e3\u0005\u0005\u0000\u0000"+
		"\u00e3\u00e4\u0003 \u0010\u0000\u00e4\u00e5\u0005\u0006\u0000\u0000\u00e5"+
		"\u00e6\u0006\b\uffff\uffff\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7"+
		"\u00dd\u0001\u0000\u0000\u0000\u00e7\u00e1\u0001\u0000\u0000\u0000\u00e8"+
		"\u00f0\u0001\u0000\u0000\u0000\u00e9\u00ea\n\u0001\u0000\u0000\u00ea\u00eb"+
		"\u0005\u0010\u0000\u0000\u00eb\u00ec\u0005&\u0000\u0000\u00ec\u00ed\u0005"+
		"\u0011\u0000\u0000\u00ed\u00ef\u0006\b\uffff\uffff\u0000\u00ee\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u0011\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4\u0003"+
		"\u0016\u000b\u0000\u00f4\u00f5\u0006\t\uffff\uffff\u0000\u00f5\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0005\u0001\u0000\u0000\u00f7\u00f9\u0006"+
		"\t\uffff\uffff\u0000\u00f8\u00f3\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f9\u0013\u0001\u0000\u0000\u0000\u00fa\u00fb\u0003"+
		"\u0016\u000b\u0000\u00fb\u00fc\u0005%\u0000\u0000\u00fc\u0104\u0006\n"+
		"\uffff\uffff\u0000\u00fd\u00fe\u0005\u0007\u0000\u0000\u00fe\u00ff\u0003"+
		"\u0016\u000b\u0000\u00ff\u0100\u0005%\u0000\u0000\u0100\u0101\u0006\n"+
		"\uffff\uffff\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u00fd\u0001"+
		"\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0109\u0001"+
		"\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0107\u0109\u0001"+
		"\u0000\u0000\u0000\u0108\u00fa\u0001\u0000\u0000\u0000\u0108\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u0015\u0001\u0000\u0000\u0000\u010a\u010b\u0005"+
		"\"\u0000\u0000\u010b\u0111\u0006\u000b\uffff\uffff\u0000\u010c\u010d\u0005"+
		"#\u0000\u0000\u010d\u0111\u0006\u000b\uffff\uffff\u0000\u010e\u010f\u0005"+
		"$\u0000\u0000\u010f\u0111\u0006\u000b\uffff\uffff\u0000\u0110\u010a\u0001"+
		"\u0000\u0000\u0000\u0110\u010c\u0001\u0000\u0000\u0000\u0110\u010e\u0001"+
		"\u0000\u0000\u0000\u0111\u0017\u0001\u0000\u0000\u0000\u0112\u0113\u0003"+
		"\f\u0006\u0000\u0113\u0114\u0006\f\uffff\uffff\u0000\u0114\u0120\u0001"+
		"\u0000\u0000\u0000\u0115\u011b\u0005\u0005\u0000\u0000\u0116\u0117\u0003"+
		"\f\u0006\u0000\u0117\u0118\u0006\f\uffff\uffff\u0000\u0118\u011a\u0001"+
		"\u0000\u0000\u0000\u0119\u0116\u0001\u0000\u0000\u0000\u011a\u011d\u0001"+
		"\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001"+
		"\u0000\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u011b\u0001"+
		"\u0000\u0000\u0000\u011e\u0120\u0005\u0006\u0000\u0000\u011f\u0112\u0001"+
		"\u0000\u0000\u0000\u011f\u0115\u0001\u0000\u0000\u0000\u0120\u0019\u0001"+
		"\u0000\u0000\u0000\u0121\u0122\u0005%\u0000\u0000\u0122\u0123\u0005\u0003"+
		"\u0000\u0000\u0123\u0124\u0003\u001c\u000e\u0000\u0124\u0125\u0005\u0004"+
		"\u0000\u0000\u0125\u0126\u0006\r\uffff\uffff\u0000\u0126\u001b\u0001\u0000"+
		"\u0000\u0000\u0127\u0128\u0003\u000e\u0007\u0000\u0128\u012f\u0006\u000e"+
		"\uffff\uffff\u0000\u0129\u012a\u0005\u0007\u0000\u0000\u012a\u012b\u0003"+
		"\u000e\u0007\u0000\u012b\u012c\u0006\u000e\uffff\uffff\u0000\u012c\u012e"+
		"\u0001\u0000\u0000\u0000\u012d\u0129\u0001\u0000\u0000\u0000\u012e\u0131"+
		"\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130"+
		"\u0001\u0000\u0000\u0000\u0130\u0134\u0001\u0000\u0000\u0000\u0131\u012f"+
		"\u0001\u0000\u0000\u0000\u0132\u0134\u0001\u0000\u0000\u0000\u0133\u0127"+
		"\u0001\u0000\u0000\u0000\u0133\u0132\u0001\u0000\u0000\u0000\u0134\u001d"+
		"\u0001\u0000\u0000\u0000\u0135\u0136\u0003\u000e\u0007\u0000\u0136\u013d"+
		"\u0006\u000f\uffff\uffff\u0000\u0137\u0138\u0005\u0007\u0000\u0000\u0138"+
		"\u0139\u0003\u000e\u0007\u0000\u0139\u013a\u0006\u000f\uffff\uffff\u0000"+
		"\u013a\u013c\u0001\u0000\u0000\u0000\u013b\u0137\u0001\u0000\u0000\u0000"+
		"\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000"+
		"\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u001f\u0001\u0000\u0000\u0000"+
		"\u013f\u013d\u0001\u0000\u0000\u0000\u0140\u0141\u0003\u0010\b\u0000\u0141"+
		"\u0142\u0005%\u0000\u0000\u0142\u0148\u0006\u0010\uffff\uffff\u0000\u0143"+
		"\u0144\u0005\u0007\u0000\u0000\u0144\u0145\u0005%\u0000\u0000\u0145\u0147"+
		"\u0006\u0010\uffff\uffff\u0000\u0146\u0143\u0001\u0000\u0000\u0000\u0147"+
		"\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148"+
		"\u0149\u0001\u0000\u0000\u0000\u0149\u014b\u0001\u0000\u0000\u0000\u014a"+
		"\u0148\u0001\u0000\u0000\u0000\u014b\u014c\u0005\b\u0000\u0000\u014c\u014e"+
		"\u0001\u0000\u0000\u0000\u014d\u0140\u0001\u0000\u0000\u0000\u014e\u014f"+
		"\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150"+
		"\u0001\u0000\u0000\u0000\u0150!\u0001\u0000\u0000\u0000\u0016\'5LTb\u0097"+
		"\u00b8\u00d8\u00da\u00e7\u00f0\u00f8\u0104\u0108\u0110\u011b\u011f\u012f"+
		"\u0133\u013d\u0148\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}