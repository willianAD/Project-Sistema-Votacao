package com.betrybe.sistemadevotacao;

public abstract class PessoaEleitora extends Pessoa {
  private int cpf;

  public PessoaEleitora(String nome, int cpf) {
    super.nome = nome;
    this.cpf = cpf;
  }

  public int getCpf() {
    return cpf;
  }

  public void setCpf(int cpf) {
    this.cpf = cpf;
  }
}
