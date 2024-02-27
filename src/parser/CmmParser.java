// Generated from F:/3º/DLP/Lab/repo/dlp/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

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
		RULE_program = 0, RULE_definition = 1, RULE_main_function_definition = 2, 
		RULE_function_definition = 3, RULE_variable_definition = 4, RULE_statement = 5, 
		RULE_expression = 6, RULE_type = 7, RULE_function_return_type = 8, RULE_parameters = 9, 
		RULE_built_in_type = 10, RULE_block = 11, RULE_function_invocation = 12, 
		RULE_arguments = 13, RULE_struct_fields = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "main_function_definition", "function_definition", 
			"variable_definition", "statement", "expression", "type", "function_return_type", 
			"parameters", "built_in_type", "block", "function_invocation", "arguments", 
			"struct_fields"
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
		public DefinitionContext di;
		public Main_function_definitionContext main;
		public DefinitionContext dj;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public Main_function_definitionContext main_function_definition() {
			return getRuleContext(Main_function_definitionContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					((ProgramContext)_localctx).di = definition();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			((ProgramContext)_localctx).main = main_function_definition();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018882L) != 0)) {
				{
				{
				setState(37);
				((ProgramContext)_localctx).dj = definition();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(EOF);
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
	public static class DefinitionContext extends ParserRuleContext {
		public Variable_definitionContext v;
		public Function_definitionContext f;
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				((DefinitionContext)_localctx).v = variable_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				((DefinitionContext)_localctx).f = function_definition();
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(50);
			match(T__1);
			setState(51);
			match(T__2);
			setState(52);
			match(T__3);
			setState(53);
			match(T__4);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(56);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(54);
						statement();
						}
						break;
					case 2:
						{
						setState(55);
						variable_definition();
						}
						break;
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(61);
			match(T__5);
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
		public Function_return_typeContext t;
		public ParametersContext params;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public Function_return_typeContext function_return_type() {
			return getRuleContext(Function_return_typeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			((Function_definitionContext)_localctx).t = function_return_type();
			setState(64);
			match(ID);
			setState(65);
			match(T__2);
			setState(66);
			((Function_definitionContext)_localctx).params = parameters();
			setState(67);
			match(T__3);
			setState(68);
			match(T__4);
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(71);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(69);
						statement();
						}
						break;
					case 2:
						{
						setState(70);
						variable_definition();
						}
						break;
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(76);
			match(T__5);
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
	public static class Variable_definitionContext extends ParserRuleContext {
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
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVariable_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVariable_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVariable_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((Variable_definitionContext)_localctx).t = type(0);
			setState(79);
			((Variable_definitionContext)_localctx).v1 = match(ID);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(80);
				match(T__6);
				setState(81);
				((Variable_definitionContext)_localctx).vi = match(ID);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
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
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Function_invocationContext fi;
		public Token WHILE;
		public ExpressionContext e;
		public BlockContext b;
		public Token IF;
		public BlockContext b1;
		public BlockContext b2;
		public Token RET;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				((StatementContext)_localctx).e1 = expression(0);
				setState(90);
				match(T__8);
				setState(91);
				((StatementContext)_localctx).e2 = expression(0);
				setState(92);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new Assignment( ((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast ); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				((StatementContext)_localctx).fi = function_invocation();
				setState(96);
				match(T__7);
				 ((StatementContext)_localctx).ast =  ((StatementContext)_localctx).fi.ast; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				((StatementContext)_localctx).WHILE = match(T__9);
				setState(100);
				match(T__2);
				setState(101);
				((StatementContext)_localctx).e = expression(0);
				setState(102);
				match(T__3);
				setState(103);
				((StatementContext)_localctx).b = block();
				 ((StatementContext)_localctx).ast =  new While( ((StatementContext)_localctx).WHILE.getLine(), ((StatementContext)_localctx).WHILE.getCharPositionInLine()+1, ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b.ast ); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				((StatementContext)_localctx).IF = match(T__10);
				setState(107);
				match(T__2);
				setState(108);
				((StatementContext)_localctx).e = expression(0);
				setState(109);
				match(T__3);
				setState(110);
				((StatementContext)_localctx).b = block();
				 ((StatementContext)_localctx).ast =  new IfElse( ((StatementContext)_localctx).IF.getLine(), ((StatementContext)_localctx).IF.getCharPositionInLine()+1, ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b.ast, null ); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				((StatementContext)_localctx).IF = match(T__10);
				setState(114);
				match(T__2);
				setState(115);
				((StatementContext)_localctx).e = expression(0);
				setState(116);
				match(T__3);
				setState(117);
				((StatementContext)_localctx).b1 = block();
				setState(118);
				match(T__11);
				setState(119);
				((StatementContext)_localctx).b2 = block();
				 ((StatementContext)_localctx).ast =  new IfElse( ((StatementContext)_localctx).IF.getLine(), ((StatementContext)_localctx).IF.getCharPositionInLine()+1, ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b1.ast, ((StatementContext)_localctx).b2.ast ); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				match(T__12);
				setState(123);
				expression(0);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(124);
					match(T__6);
					setState(125);
					expression(0);
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(T__7);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(133);
				match(T__13);
				setState(134);
				expression(0);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(135);
					match(T__6);
					setState(136);
					expression(0);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(T__7);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(144);
				((StatementContext)_localctx).RET = match(T__14);
				setState(145);
				((StatementContext)_localctx).e = expression(0);
				setState(146);
				match(T__7);
				 ((StatementContext)_localctx).ast =  new Return( ((StatementContext)_localctx).RET.getLine(), ((StatementContext)_localctx).RET.getCharPositionInLine()+1, ((StatementContext)_localctx).e.ast ); 
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(152);
				((ExpressionContext)_localctx).fi = function_invocation();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).fi.ast; 
				}
				break;
			case 2:
				{
				setState(155);
				match(T__2);
				setState(156);
				((ExpressionContext)_localctx).e = expression(0);
				setState(157);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e.ast; 
				}
				break;
			case 3:
				{
				setState(160);
				((ExpressionContext)_localctx).P = match(T__2);
				setState(161);
				((ExpressionContext)_localctx).t = type(0);
				setState(162);
				match(T__3);
				setState(163);
				((ExpressionContext)_localctx).e = expression(11);
				 ((ExpressionContext)_localctx).ast =  new Cast( ((ExpressionContext)_localctx).P.getLine(), ((ExpressionContext)_localctx).P.getCharPositionInLine()+1, ((ExpressionContext)_localctx).t.ast, ((ExpressionContext)_localctx).e.ast ); 
				}
				break;
			case 4:
				{
				setState(166);
				((ExpressionContext)_localctx).MINUS = match(T__18);
				setState(167);
				((ExpressionContext)_localctx).e = expression(10);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus( ((ExpressionContext)_localctx).MINUS.getLine(), ((ExpressionContext)_localctx).MINUS.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast ); 
				}
				break;
			case 5:
				{
				setState(170);
				((ExpressionContext)_localctx).EXC = match(T__19);
				setState(171);
				((ExpressionContext)_localctx).e = expression(9);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot( ((ExpressionContext)_localctx).EXC.getLine(), ((ExpressionContext)_localctx).EXC.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast ); 
				}
				break;
			case 6:
				{
				setState(174);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable( ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null) ); 
				}
				break;
			case 7:
				{
				setState(176);
				((ExpressionContext)_localctx).IC = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral( ((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null)) ); 
				}
				break;
			case 8:
				{
				setState(178);
				((ExpressionContext)_localctx).CC = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral( ((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null)) ); 
				}
				break;
			case 9:
				{
				setState(180);
				match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral( ((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null)) ); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(185);
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
						setState(186);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(190);
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
						setState(191);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                                                                   (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(195);
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
						setState(196);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Comparison( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                                                                                                (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(200);
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
						setState(201);
						((ExpressionContext)_localctx).e2 = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Logical( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                                                                     (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(205);
						match(T__15);
						setState(206);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(207);
						match(T__16);
						 ((ExpressionContext)_localctx).ast =  new Indexing( ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast ); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(211);
						match(T__17);
						setState(212);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess( ((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null) ); 
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				{
				setState(220);
				((TypeContext)_localctx).b = built_in_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).b.ast; 
				}
				break;
			case T__32:
				{
				setState(223);
				((TypeContext)_localctx).STRUCT = match(T__32);
				setState(224);
				match(T__4);
				setState(225);
				((TypeContext)_localctx).sf = struct_fields();
				setState(226);
				match(T__5);
				 ((TypeContext)_localctx).ast =  new StructType( ((TypeContext)_localctx).STRUCT.getLine(), ((TypeContext)_localctx).STRUCT.getCharPositionInLine()+1, ((TypeContext)_localctx).sf.ast ); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(231);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(232);
					match(T__15);
					setState(233);
					((TypeContext)_localctx).IC = match(INT_CONSTANT);
					setState(234);
					match(T__16);
					 ((TypeContext)_localctx).ast =  new ArrayType( ((TypeContext)_localctx).t.ast.getLine(), ((TypeContext)_localctx).t.ast.getColumn(), ((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).IC!=null?((TypeContext)_localctx).IC.getText():null)) ); 
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class Function_return_typeContext extends ParserRuleContext {
		public Type ast;
		public Built_in_typeContext b;
		public Token VOID;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public Function_return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunction_return_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunction_return_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunction_return_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_return_typeContext function_return_type() throws RecognitionException {
		Function_return_typeContext _localctx = new Function_return_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_return_type);
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				((Function_return_typeContext)_localctx).b = built_in_type();
				 ((Function_return_typeContext)_localctx).ast =  ((Function_return_typeContext)_localctx).b.ast; 
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				((Function_return_typeContext)_localctx).VOID = match(T__0);
				 ((Function_return_typeContext)_localctx).ast =  new VoidType( ((Function_return_typeContext)_localctx).VOID.getLine(), ((Function_return_typeContext)_localctx).VOID.getCharPositionInLine()+1 ); 
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
		enterRule(_localctx, 18, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			((ParametersContext)_localctx).b1 = built_in_type();
			setState(249);
			((ParametersContext)_localctx).ID = match(ID);
			 _localctx.ast.add( new VariableDefinition( ((ParametersContext)_localctx).b1.ast.getLine(), ((ParametersContext)_localctx).b1.ast.getColumn(), ((ParametersContext)_localctx).b1.ast, (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null) ) ); 
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(251);
				match(T__6);
				setState(252);
				((ParametersContext)_localctx).bi = built_in_type();
				setState(253);
				((ParametersContext)_localctx).ID = match(ID);
				 _localctx.ast.add( new VariableDefinition( ((ParametersContext)_localctx).bi.ast.getLine(), ((ParametersContext)_localctx).bi.ast.getColumn(), ((ParametersContext)_localctx).bi.ast, (((ParametersContext)_localctx).ID!=null?((ParametersContext)_localctx).ID.getText():null) ) ); 
				}
				}
				setState(260);
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
		enterRule(_localctx, 20, RULE_built_in_type);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				((Built_in_typeContext)_localctx).T = match(T__33);
				 ((Built_in_typeContext)_localctx).ast =  new IntType( ((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1 ); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				((Built_in_typeContext)_localctx).T = match(T__34);
				 ((Built_in_typeContext)_localctx).ast =  new CharType( ((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1 ); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
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
		public StatementContext s1;
		public StatementContext si;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 22, RULE_block);
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				((BlockContext)_localctx).s1 = statement();
				 _localctx.ast.add(((BlockContext)_localctx).s1.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(T__4);
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(273);
						((BlockContext)_localctx).si = statement();
						 _localctx.ast.add(((BlockContext)_localctx).si.ast); 
						}
						} 
					}
					setState(280);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(281);
				match(T__5);
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
		enterRule(_localctx, 24, RULE_function_invocation);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				((Function_invocationContext)_localctx).ID = match(ID);
				setState(286);
				match(T__2);
				setState(287);
				((Function_invocationContext)_localctx).args = arguments();
				setState(288);
				match(T__3);
				 ((Function_invocationContext)_localctx).ast =  new FunctionInvocation( ((Function_invocationContext)_localctx).ID.getLine(), ((Function_invocationContext)_localctx).ID.getCharPositionInLine()+1,
				                                                 new Variable(((Function_invocationContext)_localctx).ID.getLine(), ((Function_invocationContext)_localctx).ID.getCharPositionInLine()+1, (((Function_invocationContext)_localctx).ID!=null?((Function_invocationContext)_localctx).ID.getText():null)),
				                                                 ((Function_invocationContext)_localctx).args.ast); 
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
		enterRule(_localctx, 26, RULE_arguments);
		int _la;
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				((ArgumentsContext)_localctx).e1 = expression(0);
				 _localctx.ast.add( ((ArgumentsContext)_localctx).e1.ast ); 
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(295);
					match(T__6);
					setState(296);
					((ArgumentsContext)_localctx).ei = expression(0);
					 _localctx.ast.add( ((ArgumentsContext)_localctx).ei.ast ); 
					}
					}
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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
		enterRule(_localctx, 28, RULE_struct_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(307);
				((Struct_fieldsContext)_localctx).t = type(0);
				setState(308);
				((Struct_fieldsContext)_localctx).ID = match(ID);
				setState(309);
				match(T__7);
				 _localctx.ast.add( new StructField( ((Struct_fieldsContext)_localctx).t.ast.getLine(), ((Struct_fieldsContext)_localctx).t.ast.getColumn(), ((Struct_fieldsContext)_localctx).t.ast, (((Struct_fieldsContext)_localctx).ID!=null?((Struct_fieldsContext)_localctx).ID.getText():null) ) ); 
				}
				}
				setState(314); 
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
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 7:
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
		"\u0004\u0001*\u013d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0003\u00010\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00029\b\u0002"+
		"\n\u0002\f\u0002<\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003H\b\u0003\n\u0003\f\u0003K\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004S\b\u0004"+
		"\n\u0004\f\u0004V\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u007f\b\u0005\n\u0005\f\u0005\u0082\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u008a\b\u0005\n"+
		"\u0005\f\u0005\u008d\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0096\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00b7\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00d7\b\u0006\n\u0006\f\u0006"+
		"\u00da\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00e6\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u00ed\b\u0007\n\u0007\f\u0007\u00f0\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00f7\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0101\b\t\n\t\f\t\u0104\t\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u010c\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u0115\b\u000b\n\u000b\f\u000b\u0118\t\u000b\u0001\u000b"+
		"\u0003\u000b\u011b\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u0124\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u012c\b\r\n\r\f\r\u012f\t\r\u0001\r\u0003\r\u0132\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u0139"+
		"\b\u000e\u000b\u000e\f\u000e\u013a\u0001\u000e\u0000\u0002\f\u000e\u000f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u0000\u0004\u0001\u0000\u0015\u0017\u0002\u0000\u0013\u0013\u0018"+
		"\u0018\u0001\u0000\u0019\u001e\u0001\u0000\u001f \u0158\u0000!\u0001\u0000"+
		"\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000"+
		"\u0006?\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000\n\u0095\u0001"+
		"\u0000\u0000\u0000\f\u00b6\u0001\u0000\u0000\u0000\u000e\u00e5\u0001\u0000"+
		"\u0000\u0000\u0010\u00f6\u0001\u0000\u0000\u0000\u0012\u00f8\u0001\u0000"+
		"\u0000\u0000\u0014\u010b\u0001\u0000\u0000\u0000\u0016\u011a\u0001\u0000"+
		"\u0000\u0000\u0018\u0123\u0001\u0000\u0000\u0000\u001a\u0131\u0001\u0000"+
		"\u0000\u0000\u001c\u0138\u0001\u0000\u0000\u0000\u001e \u0003\u0002\u0001"+
		"\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!"+
		"\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000$(\u0003\u0004\u0002\u0000%\'\u0003"+
		"\u0002\u0001\u0000&%\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000"+
		"(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000"+
		"\u0000*(\u0001\u0000\u0000\u0000+,\u0005\u0000\u0000\u0001,\u0001\u0001"+
		"\u0000\u0000\u0000-0\u0003\b\u0004\u0000.0\u0003\u0006\u0003\u0000/-\u0001"+
		"\u0000\u0000\u0000/.\u0001\u0000\u0000\u00000\u0003\u0001\u0000\u0000"+
		"\u000012\u0005\u0001\u0000\u000023\u0005\u0002\u0000\u000034\u0005\u0003"+
		"\u0000\u000045\u0005\u0004\u0000\u00005:\u0005\u0005\u0000\u000069\u0003"+
		"\n\u0005\u000079\u0003\b\u0004\u000086\u0001\u0000\u0000\u000087\u0001"+
		"\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000=>\u0005\u0006\u0000\u0000>\u0005\u0001\u0000\u0000\u0000?@\u0003"+
		"\u0010\b\u0000@A\u0005%\u0000\u0000AB\u0005\u0003\u0000\u0000BC\u0003"+
		"\u0012\t\u0000CD\u0005\u0004\u0000\u0000DI\u0005\u0005\u0000\u0000EH\u0003"+
		"\n\u0005\u0000FH\u0003\b\u0004\u0000GE\u0001\u0000\u0000\u0000GF\u0001"+
		"\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000LM\u0005\u0006\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0003"+
		"\u000e\u0007\u0000OT\u0005%\u0000\u0000PQ\u0005\u0007\u0000\u0000QS\u0005"+
		"%\u0000\u0000RP\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000WX\u0005\b\u0000\u0000X\t\u0001\u0000\u0000"+
		"\u0000YZ\u0003\f\u0006\u0000Z[\u0005\t\u0000\u0000[\\\u0003\f\u0006\u0000"+
		"\\]\u0005\b\u0000\u0000]^\u0006\u0005\uffff\uffff\u0000^\u0096\u0001\u0000"+
		"\u0000\u0000_`\u0003\u0018\f\u0000`a\u0005\b\u0000\u0000ab\u0006\u0005"+
		"\uffff\uffff\u0000b\u0096\u0001\u0000\u0000\u0000cd\u0005\n\u0000\u0000"+
		"de\u0005\u0003\u0000\u0000ef\u0003\f\u0006\u0000fg\u0005\u0004\u0000\u0000"+
		"gh\u0003\u0016\u000b\u0000hi\u0006\u0005\uffff\uffff\u0000i\u0096\u0001"+
		"\u0000\u0000\u0000jk\u0005\u000b\u0000\u0000kl\u0005\u0003\u0000\u0000"+
		"lm\u0003\f\u0006\u0000mn\u0005\u0004\u0000\u0000no\u0003\u0016\u000b\u0000"+
		"op\u0006\u0005\uffff\uffff\u0000p\u0096\u0001\u0000\u0000\u0000qr\u0005"+
		"\u000b\u0000\u0000rs\u0005\u0003\u0000\u0000st\u0003\f\u0006\u0000tu\u0005"+
		"\u0004\u0000\u0000uv\u0003\u0016\u000b\u0000vw\u0005\f\u0000\u0000wx\u0003"+
		"\u0016\u000b\u0000xy\u0006\u0005\uffff\uffff\u0000y\u0096\u0001\u0000"+
		"\u0000\u0000z{\u0005\r\u0000\u0000{\u0080\u0003\f\u0006\u0000|}\u0005"+
		"\u0007\u0000\u0000}\u007f\u0003\f\u0006\u0000~|\u0001\u0000\u0000\u0000"+
		"\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0083\u0084\u0005\b\u0000\u0000\u0084\u0096"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u000e\u0000\u0000\u0086\u008b"+
		"\u0003\f\u0006\u0000\u0087\u0088\u0005\u0007\u0000\u0000\u0088\u008a\u0003"+
		"\f\u0006\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000"+
		"\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0005\b\u0000\u0000\u008f\u0096\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005\u000f\u0000\u0000\u0091\u0092\u0003\f\u0006\u0000"+
		"\u0092\u0093\u0005\b\u0000\u0000\u0093\u0094\u0006\u0005\uffff\uffff\u0000"+
		"\u0094\u0096\u0001\u0000\u0000\u0000\u0095Y\u0001\u0000\u0000\u0000\u0095"+
		"_\u0001\u0000\u0000\u0000\u0095c\u0001\u0000\u0000\u0000\u0095j\u0001"+
		"\u0000\u0000\u0000\u0095q\u0001\u0000\u0000\u0000\u0095z\u0001\u0000\u0000"+
		"\u0000\u0095\u0085\u0001\u0000\u0000\u0000\u0095\u0090\u0001\u0000\u0000"+
		"\u0000\u0096\u000b\u0001\u0000\u0000\u0000\u0097\u0098\u0006\u0006\uffff"+
		"\uffff\u0000\u0098\u0099\u0003\u0018\f\u0000\u0099\u009a\u0006\u0006\uffff"+
		"\uffff\u0000\u009a\u00b7\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0003"+
		"\u0000\u0000\u009c\u009d\u0003\f\u0006\u0000\u009d\u009e\u0005\u0004\u0000"+
		"\u0000\u009e\u009f\u0006\u0006\uffff\uffff\u0000\u009f\u00b7\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0005\u0003\u0000\u0000\u00a1\u00a2\u0003\u000e"+
		"\u0007\u0000\u00a2\u00a3\u0005\u0004\u0000\u0000\u00a3\u00a4\u0003\f\u0006"+
		"\u000b\u00a4\u00a5\u0006\u0006\uffff\uffff\u0000\u00a5\u00b7\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0005\u0013\u0000\u0000\u00a7\u00a8\u0003\f\u0006"+
		"\n\u00a8\u00a9\u0006\u0006\uffff\uffff\u0000\u00a9\u00b7\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0005\u0014\u0000\u0000\u00ab\u00ac\u0003\f\u0006\t"+
		"\u00ac\u00ad\u0006\u0006\uffff\uffff\u0000\u00ad\u00b7\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0005%\u0000\u0000\u00af\u00b7\u0006\u0006\uffff\uffff"+
		"\u0000\u00b0\u00b1\u0005&\u0000\u0000\u00b1\u00b7\u0006\u0006\uffff\uffff"+
		"\u0000\u00b2\u00b3\u0005(\u0000\u0000\u00b3\u00b7\u0006\u0006\uffff\uffff"+
		"\u0000\u00b4\u00b5\u0005\'\u0000\u0000\u00b5\u00b7\u0006\u0006\uffff\uffff"+
		"\u0000\u00b6\u0097\u0001\u0000\u0000\u0000\u00b6\u009b\u0001\u0000\u0000"+
		"\u0000\u00b6\u00a0\u0001\u0000\u0000\u0000\u00b6\u00a6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00aa\u0001\u0000\u0000\u0000\u00b6\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b0\u0001\u0000\u0000\u0000\u00b6\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\n\b\u0000\u0000\u00b9\u00ba\u0007\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0003\f\u0006\t\u00bb\u00bc\u0006\u0006\uffff\uffff\u0000"+
		"\u00bc\u00d7\u0001\u0000\u0000\u0000\u00bd\u00be\n\u0007\u0000\u0000\u00be"+
		"\u00bf\u0007\u0001\u0000\u0000\u00bf\u00c0\u0003\f\u0006\b\u00c0\u00c1"+
		"\u0006\u0006\uffff\uffff\u0000\u00c1\u00d7\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\n\u0006\u0000\u0000\u00c3\u00c4\u0007\u0002\u0000\u0000\u00c4\u00c5"+
		"\u0003\f\u0006\u0007\u00c5\u00c6\u0006\u0006\uffff\uffff\u0000\u00c6\u00d7"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\n\u0005\u0000\u0000\u00c8\u00c9\u0007"+
		"\u0003\u0000\u0000\u00c9\u00ca\u0003\f\u0006\u0006\u00ca\u00cb\u0006\u0006"+
		"\uffff\uffff\u0000\u00cb\u00d7\u0001\u0000\u0000\u0000\u00cc\u00cd\n\r"+
		"\u0000\u0000\u00cd\u00ce\u0005\u0010\u0000\u0000\u00ce\u00cf\u0003\f\u0006"+
		"\u0000\u00cf\u00d0\u0005\u0011\u0000\u0000\u00d0\u00d1\u0006\u0006\uffff"+
		"\uffff\u0000\u00d1\u00d7\u0001\u0000\u0000\u0000\u00d2\u00d3\n\f\u0000"+
		"\u0000\u00d3\u00d4\u0005\u0012\u0000\u0000\u00d4\u00d5\u0005%\u0000\u0000"+
		"\u00d5\u00d7\u0006\u0006\uffff\uffff\u0000\u00d6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00d6\u00bd\u0001\u0000\u0000\u0000\u00d6\u00c2\u0001\u0000\u0000"+
		"\u0000\u00d6\u00c7\u0001\u0000\u0000\u0000\u00d6\u00cc\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d2\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\r\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0006\u0007\uffff\uffff\u0000\u00dc\u00dd\u0003\u0014\n\u0000"+
		"\u00dd\u00de\u0006\u0007\uffff\uffff\u0000\u00de\u00e6\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005!\u0000\u0000\u00e0\u00e1\u0005\u0005\u0000\u0000"+
		"\u00e1\u00e2\u0003\u001c\u000e\u0000\u00e2\u00e3\u0005\u0006\u0000\u0000"+
		"\u00e3\u00e4\u0006\u0007\uffff\uffff\u0000\u00e4\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e5\u00db\u0001\u0000\u0000\u0000\u00e5\u00df\u0001\u0000\u0000"+
		"\u0000\u00e6\u00ee\u0001\u0000\u0000\u0000\u00e7\u00e8\n\u0001\u0000\u0000"+
		"\u00e8\u00e9\u0005\u0010\u0000\u0000\u00e9\u00ea\u0005&\u0000\u0000\u00ea"+
		"\u00eb\u0005\u0011\u0000\u0000\u00eb\u00ed\u0006\u0007\uffff\uffff\u0000"+
		"\u00ec\u00e7\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000"+
		"\u00ef\u000f\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f2\u0003\u0014\n\u0000\u00f2\u00f3\u0006\b\uffff\uffff\u0000"+
		"\u00f3\u00f7\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u0001\u0000\u0000"+
		"\u00f5\u00f7\u0006\b\uffff\uffff\u0000\u00f6\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u0011\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0003\u0014\n\u0000\u00f9\u00fa\u0005%\u0000\u0000\u00fa"+
		"\u0102\u0006\t\uffff\uffff\u0000\u00fb\u00fc\u0005\u0007\u0000\u0000\u00fc"+
		"\u00fd\u0003\u0014\n\u0000\u00fd\u00fe\u0005%\u0000\u0000\u00fe\u00ff"+
		"\u0006\t\uffff\uffff\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fb"+
		"\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0013"+
		"\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0005\"\u0000\u0000\u0106\u010c\u0006\n\uffff\uffff\u0000\u0107\u0108"+
		"\u0005#\u0000\u0000\u0108\u010c\u0006\n\uffff\uffff\u0000\u0109\u010a"+
		"\u0005$\u0000\u0000\u010a\u010c\u0006\n\uffff\uffff\u0000\u010b\u0105"+
		"\u0001\u0000\u0000\u0000\u010b\u0107\u0001\u0000\u0000\u0000\u010b\u0109"+
		"\u0001\u0000\u0000\u0000\u010c\u0015\u0001\u0000\u0000\u0000\u010d\u010e"+
		"\u0003\n\u0005\u0000\u010e\u010f\u0006\u000b\uffff\uffff\u0000\u010f\u011b"+
		"\u0001\u0000\u0000\u0000\u0110\u0116\u0005\u0005\u0000\u0000\u0111\u0112"+
		"\u0003\n\u0005\u0000\u0112\u0113\u0006\u000b\uffff\uffff\u0000\u0113\u0115"+
		"\u0001\u0000\u0000\u0000\u0114\u0111\u0001\u0000\u0000\u0000\u0115\u0118"+
		"\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0001\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0116"+
		"\u0001\u0000\u0000\u0000\u0119\u011b\u0005\u0006\u0000\u0000\u011a\u010d"+
		"\u0001\u0000\u0000\u0000\u011a\u0110\u0001\u0000\u0000\u0000\u011b\u0017"+
		"\u0001\u0000\u0000\u0000\u011c\u0124\u0001\u0000\u0000\u0000\u011d\u011e"+
		"\u0005%\u0000\u0000\u011e\u011f\u0005\u0003\u0000\u0000\u011f\u0120\u0003"+
		"\u001a\r\u0000\u0120\u0121\u0005\u0004\u0000\u0000\u0121\u0122\u0006\f"+
		"\uffff\uffff\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u011c\u0001"+
		"\u0000\u0000\u0000\u0123\u011d\u0001\u0000\u0000\u0000\u0124\u0019\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0003\f\u0006\u0000\u0126\u012d\u0006\r"+
		"\uffff\uffff\u0000\u0127\u0128\u0005\u0007\u0000\u0000\u0128\u0129\u0003"+
		"\f\u0006\u0000\u0129\u012a\u0006\r\uffff\uffff\u0000\u012a\u012c\u0001"+
		"\u0000\u0000\u0000\u012b\u0127\u0001\u0000\u0000\u0000\u012c\u012f\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012e\u0132\u0001\u0000\u0000\u0000\u012f\u012d\u0001"+
		"\u0000\u0000\u0000\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u0125\u0001"+
		"\u0000\u0000\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0132\u001b\u0001"+
		"\u0000\u0000\u0000\u0133\u0134\u0003\u000e\u0007\u0000\u0134\u0135\u0005"+
		"%\u0000\u0000\u0135\u0136\u0005\b\u0000\u0000\u0136\u0137\u0006\u000e"+
		"\uffff\uffff\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u0133\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u0138\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u001d\u0001"+
		"\u0000\u0000\u0000\u0019!(/8:GIT\u0080\u008b\u0095\u00b6\u00d6\u00d8\u00e5"+
		"\u00ee\u00f6\u0102\u010b\u0116\u011a\u0123\u012d\u0131\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}