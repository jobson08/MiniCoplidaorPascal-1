package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}


/* Comentarios */
"{}".* {/*Ignore*/}

/* Tipo de dato Int (Para el main) */
( "int" ) {return new Symbol(sym.Int, yychar, yyline, yytext());}

/* Tipos de dados */
( Integer | Real ) {return new Symbol(sym.T_dado, yychar, yyline, yytext());}

/* Palavra reservada String*/
(String) {return new Symbol(sym.String, yychar, yyline, yytext());}

/* Palavra reservada begin*/
(Begin) {return new Symbol(sym.Begin, yychar, yyline, yytext());}

/* Palavra reservada end*/
(End)  {return new Symbol(sym.End, yychar, yyline, yytext());}

/* Palavra reservada If */
(if)  {return new Symbol(sym.If, yychar, yyline, yytext());}

/* Palavra reservada then*/
(then) {return new Symbol(sym.Then, yychar, yyline, yytext());}

/* Palavra  reservada Else */
(else) {return new Symbol(sym.Else, yychar, yyline, yytext());}

/* Palavra  reservada While */
(while) {return new Symbol(sym.While, yychar, yyline, yytext());}

/* Palavra  reservada Do */
(do) {return new Symbol(sym.Do, yychar, yyline, yytext());}

/* Palavra  reservada util */
(util) {return new Symbol(sym.Util, yychar, yyline, yytext());}

/* Palavra  reservada repeat */
(repeat) {return new Symbol(sym.Repeat, yychar, yyline, yytext());}

/* Palavra  reservada all */
(all) {return new Symbol(sym.All, yychar, yyline, yytext());}

/* Palavra  reservada and */
(and)  {return new Symbol(sym.And, yychar, yyline, yytext());}

/* Palavra  reservada or*/
(or) {return new Symbol(sym.Or, yychar, yyline, yytext());}

/* Palavra  reservada program */
(Programa)  {return new Symbol(sym.Programa_inicio, yychar, yyline, yytext());}

/* Operador Igual */
("=") {return new Symbol(sym.Igual, yychar, yyline, yytext());}

/* Operador Soma */
("+") {return new Symbol(sym.Soma, yychar, yyline, yytext());}

/* Operador Resto */
("-") {return new Symbol(sym.Subtracao, yychar, yyline, yytext());}

/* Operador Multiplicacao */
("*") {return new Symbol(sym.Multiplica, yychar, yyline, yytext());}

/* Operador Divisao */
("/") {return new Symbol(sym.Divisao, yychar, yyline, yytext());}

/* Operador Maior */
(">") {return new Symbol(sym.Maior, yychar, yyline, yytext());}

/* Operador Menor */
("<") {return new Symbol(sym.Menor, yychar, yyline, yytext());}

/* Operador Maior Ingual */
(">=") {return new Symbol(sym.Maior_Ingual, yychar, yyline, yytext());}

/* Operador Menor Ingual */
("<=") {return new Symbol(sym.Menor_Ingual, yychar, yyline, yytext());}

/* Operador Diferente */
("<>") {return new Symbol(sym.Diferente, yychar, yyline, yytext());}

/*Operadores Booleanos*/
(true | false  )  {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}

/* Parentesis de abertura */
("(")  {return new Symbol(sym.Parentesis_abertura, yychar, yyline, yytext());}

/* Parentesis de fechar */
( ")")  {return new Symbol(sym.Parentesis_fechar, yychar, yyline, yytext());}

/* ponto */
( "." )  {return new Symbol(sym.Ponto, yychar, yyline, yytext());}

/* ponto y virgula */
(";")  {return new Symbol(sym.P_virgula, yychar, yyline, yytext());}

/* ponto y Atribuicao */
( ":=" )  {return new Symbol(sym.Atribuicao, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}