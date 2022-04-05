package OperacionesAritmeticas;
import static OperacionesAritmeticas.Tokens.*;
%%
%class Lexer
%type Tokens

L=[a-zA-Z]
D=[0-9]+
espacio=[ ,\t,\r]+
Salto = [\n]+
Punto = [.]
Coma = [,]
%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
/* "//".* {/*Ignore*/} */

{Salto} {lexeme=yytext(); return Salto;}

"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}

[-]?{D}({Punto}|{Coma}){D} {lexeme=yytext(); return Decimal;}
[-]?{D} {lexeme=yytext(); return Entero;}

{L} {lexeme=yytext(); return Variable;}
 . {lexeme=yytext(); return ERROR;}