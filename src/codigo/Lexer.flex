package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espaco=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%

/* Espasso em Branco */
{espaco} {/*Ignore*/}

/* Comentarios */
 "{}".* {/*Ignore*/}

/* Pular Linha */
"\n" {return Linha;}

/* Tipos de dados */
( integer | real ) {lexeme=yytext(); return  T_dado;}

int  {lexeme=yytext(); return Int;}

string  {lexeme=yytext(); return String;}

/* Palavra reservada begin*/
begin {lexeme=yytext(); return Begin;}

/* Palavra reservada end*/
end  {lexeme=yytext(); return End;}

/* Palavra reservada nome*/
Nome {lexeme=yytext(); return Nome;}

/* Palavra reservada If */
if  {lexeme=yytext(); return If;}

/* Palavra reservada then*/
then {lexeme=yytext(); return Then;}

/* Palavra  reservada Else */
else {lexeme=yytext(); return Else;}

/* Palavra  reservada While */
while {lexeme=yytext(); return While;}

/* Palavra  reservada Do */
do {lexeme=yytext(); return Do;}

/* Palavra  reservada util */
util {lexeme=yytext(); return Util;}

/* Palavra  reservada repeat */
repeat {lexeme=yytext(); return Repeat;}

/* Palavra  reservada all */
all {lexeme=yytext(); return All;}

/* Palavra  reservada and */
and  {lexeme=yytext(); return And;}

/* Palavra  reservada or*/
or {lexeme=yytext(); return Or;}

/* Palavra  reservada program */
program  {lexeme=yytext(); return Program;}

/* Operador Igual */
"=" {lexeme=yytext(); return Igual;}

/* Operador Soma */
"+" {lexeme=yytext(); return Soma;}

/* Operador Resto */
"-" {lexeme=yytext(); return Subtracao;}

/* Operador Multiplicacao */
"*" {lexeme=yytext(); return Multiplica;}

/* Operador Divisao */
"/" {lexeme=yytext(); return Divisao;}

/* Operador Maior */
">" {lexeme=yytext(); return Maior;}

/* Operador Menor */
"<" {lexeme=yytext(); return Menor;}

/* Operador Maior Ingual */
">=" {lexeme=yytext(); return Maior_Ingual;}

/* Operador Menor Ingual */
"<=" {lexeme=yytext(); return Menor_Ingual;}

/* Operador Diferente */
"<>" {lexeme=yytext(); return Diferente;}

/*Operadores Booleanos*/
/*(or | and ) {lexeme=yytext(); return Op_booleano;}*/

/* Parentesis de abertura */
"("  {lexeme=yytext(); return Parentesis_abertura;}

/* Parentesis de fechar */
 ")"  {lexeme=yytext(); return Parentesis_fechar;}

/* ponto */
"."  {lexeme=yytext(); return Ponto;}

/* ponto y virgula */
";"  {lexeme=yytext(); return P_virgula;}

/* ponto y Atribuicao */
":="  {lexeme=yytext(); return Atribuicao;}

/* Identificador */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* Numero */
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}

/* Error de analisis */
 . {return ERROR;}