package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /** Not a javadoc (ignored). */
  public GerenciamentoVotacao() {
    pessoasCandidatas = new ArrayList<>();
    pessoasEleitoras = new ArrayList<>();
    cpfsComputados = new ArrayList<>();
  }

  /** Not a javadoc (ignored). */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
      } else {
        PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
        pessoasCandidatas.add(novaPessoaCandidata);
      }
    }
  }

  /** Not a javadoc (ignored). */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora eleitora : pessoasEleitoras) {
      if (eleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      } else {
        PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
        pessoasEleitoras.add(novaPessoaEleitora);
      }
    }
  }

  private PessoaCandidata getPessoaCandidata(int numero) {
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        return candidata;
      }
    }
    return null;
  }

  /** Not a javadoc (ignored). */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : cpfsComputados) {
      if (Objects.equals(cpf, cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
      } else {
        PessoaCandidata candidata = getPessoaCandidata(numeroPessoaCandidata);
        if (candidata == null) {
          System.out.println("Pessoa candidata não encontrada!");
        } else {
          candidata.receberVoto();
          cpfsComputados.add(cpfPessoaEleitora);
        }
      }
    }
  }

  /** Not a javadoc (ignored). */
  public void mostrarResultado() {
    int totalVotos = cpfsComputados.size();
    if (totalVotos > 0) {
      for (PessoaCandidata candidata : pessoasCandidatas) {
        int percentual = Math.round((float) candidata.getVotos() / totalVotos * 100);
        System.out.println("Nome: " + candidata.getNome() + " - " + candidata.getVotos()
            + " votos ( " + percentual + "% )");
      }
      System.out.println("Total de Votos: " + totalVotos);
    } else {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
  }
}
