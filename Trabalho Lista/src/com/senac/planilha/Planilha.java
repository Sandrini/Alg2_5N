package com.senac.planilha;

import com.senac.Listas.*;

import java.util.Scanner;

import com.senac.algoritmos.AvaliadorExpressao;
import com.senac.algoritmos.InvalidOperator;
import com.senac.algoritmos.InvalidToken;

public class Planilha {

	/**
	 * @param args
	 * @throws InvalidOperator
	 * @throws InvalidToken
	 */

	public static void main(String[] args) throws InvalidOperator, InvalidToken {
		
		String nome;
		String formula;
		double result = 0;
		Lista lista = new Lista();
		Scanner sc1 = new Scanner(System.in);
		while (true) {
			Celula celula = new Celula();
			System.out.println("Digite a celula: ");
			nome = new Scanner(System.in).next();

     		if (nome.equalsIgnoreCase("fim")) {
				System.out.println("Fim do Programa");
				break;
			}		
			celula.setnome(nome);
			lista.adicionaNoComeco(celula.getnome());

			System.out.println("Digite a Formula: ");
			Scanner sc = new Scanner(System.in);
			
				formula = sc.nextLine();
				celula.setformula(formula);
				lista.adicionaQualquerPosicao(0,celula.getformula());
				if (formula.equalsIgnoreCase("fim")) {
					System.out.println("Fim do Programa");
					break;
				
				}
				String postfix = AvaliadorExpressao
						.convertInfixToPostfix(formula);
				result = AvaliadorExpressao.evaluateRPN(postfix);
				System.out.println(celula.getnome() + '\n');
				//System.out.println(celula.getnome() + ":" + result + '\n');
				
	
				

			}
		}
	
	}
	
	
	
	


