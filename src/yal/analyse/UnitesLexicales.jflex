package yal.analyse ;

import java_cup.runtime.*;
import yal.exceptions.AnalyseLexicaleException;

%%

%class AnalyseurLexical
%public

%line
%column

%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{

  private StringBuilder chaine ;

  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

idf = [A-Za-z_][A-Za-z_0-9]*

csteE = [0-9]+

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]
commentaire = [/][/].*

%%

"programme"            { return symbol(CodesLexicaux.PROGRAMME); }
"debut"                { return symbol(CodesLexicaux.DEBUT); }
"fin"              	   { return symbol(CodesLexicaux.FIN); }

"ecrire"                { return symbol(CodesLexicaux.ECRIRE); }
"lire"                  { return symbol(CodesLexicaux.LIRE); }
"entier"                { return symbol(CodesLexicaux.TYPE, yytext()); }
"booleen"               { return symbol(CodesLexicaux.TYPE, yytext()); }
"reel"                  { return symbol(CodesLexicaux.TYPE, yytext()); }

"si"                    { return symbol(CodesLexicaux.SI, yytext()); }
"alors"                 { return symbol(CodesLexicaux.ALORS, yytext()); }
"sinon"                 { return symbol(CodesLexicaux.SINON, yytext()); }
"finsi"                 { return symbol(CodesLexicaux.FINSI, yytext()); }

"tantque"               { return symbol(CodesLexicaux.TANTQUE, yytext()); }
"repeter"               { return symbol(CodesLexicaux.REPETER, yytext()); }
"fintantque"            { return symbol(CodesLexicaux.FINTANTQUE, yytext()); }

"+"                     { return symbol(CodesLexicaux.PLUS, yytext()); }
"-"                     { return symbol(CodesLexicaux.MOINS, yytext()); }
"*"                     { return symbol(CodesLexicaux.FOIS, yytext()); }
"/"                     { return symbol(CodesLexicaux.DIVISE, yytext()); }
">"                     { return symbol(CodesLexicaux.SUPERIEUR, yytext()); }
"<"                     { return symbol(CodesLexicaux.INFERIEUR, yytext()); }
"=="                    { return symbol(CodesLexicaux.EGALEGAL, yytext()); }
"!="                    { return symbol(CodesLexicaux.DIFFERENT, yytext()); }

"="                    { return symbol(CodesLexicaux.EGAL); }
";"                    { return symbol(CodesLexicaux.POINTVIRGULE); }

{csteE}      	       { return symbol(CodesLexicaux.CSTENTIERE, yytext()); }

{idf}      	           { return symbol(CodesLexicaux.IDF, yytext()); }

{espace}               { }
{commentaire}          { }
.                      { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }