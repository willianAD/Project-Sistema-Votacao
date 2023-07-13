package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {
  GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
  Scanner scanner = new Scanner(System.in);
  int votos = 0;

  /** Not a javadoc (ignored). */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Principal principal = new Principal();
    principal.menuCandidato();
  }

  private void menuCandidato() {
    System.out.println("Cadastrar pessoa candidata?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
    String select1 = scanner.nextLine();
    if (select1 == "1") {
      System.out.println("Entre com o nome da pessoa candidata:");
      String nomeInput = scanner.nextLine();
      String nome = nomeInput;
      System.out.println("Entre com o número da pessoa candidata:");
      String numeroInput = scanner.nextLine();
      int numero = Integer.parseInt(numeroInput);
      gerenciamento.cadastrarPessoaCandidata(nome, numero);
      menuCandidato();
    } else if (select1 == "2") {
      menuEleitora();
    } else {
      scanner.close();
    }
  }

  private void menuEleitora() {
    System.out.println("Cadastrar pessoa eleitora?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
    String select2 = scanner.nextLine();
    if (select2 == "1") {
      System.out.println("Entre com o nome da pessoa eleitora:");
      String nomeInput = scanner.nextLine();
      String nome = nomeInput;
      System.out.println("Entre com o cpf da pessoa eleitora:");
      String cpfInput = scanner.nextLine();
      String cpf = cpfInput;
      gerenciamento.cadastrarPessoaEleitora(nome, cpf);
      menuEleitora();
    } else if (select2 == "2") {
      menuVoto();
    } else {
      scanner.close();
    }
  }

  private void menuVoto() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
    String select3 = scanner.nextLine();
    if (select3 == "1") {
      System.out.println("Entre com o cpf da pessoa eleitora:");
      String cpfInput = scanner.nextLine();
      String cpf = cpfInput;
      System.out.println("Entre com o número da pessoa candidata:");
      String numeroInput = scanner.nextLine();
      int numero = Integer.parseInt(numeroInput);
      gerenciamento.votar(cpf, numero);
      votos++;
      menuVoto();
    } else if (select3 == "2") {
      gerenciamento.mostrarResultado();
      menuVoto();
    } else if (select3 == "3") {
      if (votos == 0) {
        gerenciamento.mostrarResultado();
        menuVoto();
      } else {
        gerenciamento.mostrarResultado();
      }
    } else {
      scanner.close();
    }
  }
}
