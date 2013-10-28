package com.senac.algoritmos;

import java.util.Scanner;

import com.senac.estruturas.PilhaCheia;
import com.senac.estruturas.PilhaOperador;
import com.senac.estruturas.PilhaVazia;


public class TradutorRPN {
	static String saida;
	public TradutorRPN() {
		saida = "";
	}
	
	private static int checkPriority(char operador) throws InvalidOperator {
		switch (operador) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '(':
			return 3;
		case ')':
			return 0;
		default:
			throw new InvalidOperator(operador);
		}
	}
	
	public static void translate(String expressao) throws PilhaCheia,
		InvalidOperator, PilhaVazia {
		PilhaOperador pilha = new PilhaOperador(50);
		Scanner scan = new Scanner(expressao);
		while (scan.hasNext()) {
			if (scan.hasNextInt()){
				pilha.push(scan.nextInt());
			} else {
				String operand = scan.next();
				int priority = checkPriority(operand.charAt(0));
				switch (priority) {
				
				case 3:
					while (operand != "(") {
						saida += pilha.pop();
					}
					break;
				case 2:
					
					break;
				case 1:
					
					break;
					default:
						break;
					}
					
				}
			}
			
		}
	}


