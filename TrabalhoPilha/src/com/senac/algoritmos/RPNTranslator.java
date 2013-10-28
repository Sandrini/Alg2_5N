package com.senac.algoritmos;

import java.util.Stack;

public class RPNTranslator {
	static String out = "";

	public RPNTranslator() {
	}

	public static String translator(String entrada){
		if (entrada == null) {
			System.out.println("Nada foi digitado!");
			return "";
		} else {
			char[] in = entrada.toCharArray();
			Stack<Character> pilha = new Stack<Character>();
			
			for (int i = 0; i < in.length; i++) {
				switch (in [i]){
				case '(':
					pilha.push('(');
				case ')':
					while (!pilha.isEmpty() && pilha.peek() != ')') {
						if (!pilha.isEmpty() && pilha.peek() == '(') {
							pilha.pop();	
						} else {
						out += pilha.pop();
					}
				}
			
					break;
				case '-':
					out += '-';
				break;
				case '+':
					out += '+';
				break;
				case '/':
					
					if (!pilha.isEmpty()
							&& (pilha.peek() == '/' || pilha.peek() == '*')) {
						out += pilha.pop();
					}
					pilha.push(in[i]);
					break;
					default:
						out += in [i];
						break;
		}
	}

}
		
		return out.toString();
	
    }
}