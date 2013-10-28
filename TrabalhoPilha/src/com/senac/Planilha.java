package com.senac;

import com.senac.algoritmos.AvaliadorRPN;
import com.senac.algoritmos.RPNTranslator;

import static java.lang.System.*;

public class Planilha {
	public static void main(String[] args) throws Exception {
		out.println( AvaliadorRPN.avalia("2 3 4 + *") );
		out.println(RPNTranslator("2 + 4 * 5"));
		out.println(AvaliadorRPN.avalia(RPNTranslator("2 + 4 ) 5")));
	}
}
