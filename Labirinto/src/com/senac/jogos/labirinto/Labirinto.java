package com.senac.jogos.labirinto;

import static java.lang.System.*;

import java.io.FileInputStream;
import java.util.Random;
import java.util.Scanner;

public class Labirinto {

	private static final Scanner teclado = new Scanner(System.in);

	private static final int AJUDA = 0;
	private static final int MOVER = 1;
	private static final int OLHAR = 2;
	private static final int ATACAR = 3;
	private static final int PEGAR = 4;
	private static final int ERRO = 5;

	public static int getErro() {
		return ERRO;
	}

	public static int getAjuda() {
		return AJUDA;
	}

	public static int getMover() {
		return MOVER;
	}

	public static int getOlhar() {
		return OLHAR;
	}

	public static int getAtacar() {
		return ATACAR;
	}

	public static int getPegar() {
		return PEGAR;
	}

	private Sala[] salas;
	private int countSalas;
	private int salaAtual;

	private void run() {
		inicializaLabirinto();

		executaComando();
		exibeStatus();
		printPrompt();

		int cmd = getCommand(teclado.next());
		processCommand(cmd);
		try {
			leLabirinto(new Scanner(new FileInputStream("labirinto.txt")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		exibeStatus();

		/*
		 * for (Sala s: salas) { if (s == null) break; out.println(s); }
		 */

		/*
		 * while (! isGameOver()) {
		 * 
		 * exibeStatus(); executaComando(); }
		 */

	}

	private void executaComando() {

		System.out.println("=====  BEM VINDO AO LABIRINTO ====== ");
		System.out
				.println("\n Ande pelo labirinto digitando o comando 'mover'");
		System.out.println( " Informe a direção: North, South, East, West. ");
		
		System.out.println("===================================================");
		/*
		System.out
				.println("Pegue um item digitando o comando 'pegar NOMEDOITEM'");
		System.out
				.println("Ataque o inimigo digitando o comando 'Atacar' quando em uma sala que tenha um inimigo");
		System.out
				.println("Termine o programa digitando 'fim fim' (duas vezes mesmo)");
				*/
	}

	private void exibeStatus() {
		System.out.println("Voce está na Sala" + countSalas);
		System.out.println(salaAtual);
		/*
		System.out.println(String
				.format("Nesta sala existem os seguintes itens:"));
		*/
	}

	private void inicializaLabirinto() {
		Random r = new Random();
		salaAtual = r.nextInt(31) + 1;
		salas = new Sala[50];
		salas[0] = new Sala();
		countSalas = 0;
		try {
			leLabirinto(new Scanner(new FileInputStream("labirinto.txt")));
		} catch (Exception e) {
			err.println(e.getMessage());
			exit(1);
		}

	}

	private void leLabirinto(Scanner arquivo) throws Exception {
		String cmd = arquivo.next().toLowerCase();
		while (cmd.equals("room")) {
			int salaId = arquivo.nextInt();
			salas[salaId] = new Sala();
			Sala sala = salas[salaId];
			if (salaId == countSalas)
				countSalas = salaId;

			String direcao = arquivo.next();

			do {
				if (arquivo.hasNextInt()) {
					salaId = arquivo.nextInt();
				} else if (arquivo.next().equalsIgnoreCase("EXIT")) {
					salaId = 0;
				} else
					break;

				sala.addConexao(direcao, salaId);

				if (salaAtual == salaId) {
					System.out.println("achou");
				}
				if (!arquivo.hasNext())
					return;
				cmd = arquivo.next().toLowerCase();
				if (cmd.equals("trap")) {
					sala.setArmadilha(direcao);
					if (!arquivo.hasNext())
						return;
					cmd = arquivo.next();
				}
				direcao = cmd;

			} while (!cmd.equals("room"));

		}
		throw new Exception("Arquivo de descricao do labirinto invalido.");
	}

	public static void main(String[] args) {
		(new Labirinto()).run();

	}

	public void printPrompt() {
		
		System.out
		.println("COMANDOS DISPONIVEIS DO JOGO: \n MOVER \n"
				+ "ajuda");
		/*
		System.out
				.println("COMANDOS DISPONIVEIS DO JOGO: \n MOVER   OLHAR   ATACAR  PEGAR \n"
						+ " LARGAR CHAVE  LARGAR ARMA  LARGAR ARMADURA  ajuda");
		*/
	}

	public int getCommand(String command) {
		String cmd = command.toLowerCase();

		if (cmd.equals("mover"))
			return MOVER;
		if (cmd.equals("olhar"))
			return OLHAR;
		if (cmd.equals("atacar"))
			return ATACAR;
		if (cmd.equals("pegar"))
			return PEGAR;
		if (cmd.equals("help"))
			return AJUDA;

		return ERRO;
	}

	public void processCommand(int cmd) {
		switch (cmd) {
		case AJUDA:
			ajuda();
			break;
		case MOVER:
			mover();
			break;
		case OLHAR:
			olhar();
			break;
		case ATACAR:
			atacar();
			break;
		case PEGAR:
			pegar();
			break;
		default:
			System.out.print("Comando Invalido");
		}
	}

	private String digiteDirecao() {
		System.out.println("Digite a direção para qual deseja mover:");
		return teclado.next();
	}

	private void mover() {

		do {
			try {
				Sala s = salas[salaAtual];
				System.out.println(salas[salaAtual]);
				System.out.println(salaAtual);
				String direcao = digiteDirecao();
				salaAtual = s.getSaida(direcao);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (salaAtual != 0);
	}

	private void olhar() {

	}

	private void atacar() {

	}

	private void pegar() {

	}

	// Mostrar os Comandos do Jogo.
	public void ajuda() {
		System.out
				.println("MOVER   OLHAR   ATACAR  PEGAR  LARGAR CHAVE  LARGAR ARMA  LARGAR ARMADURA  ajuda");
	}

}
