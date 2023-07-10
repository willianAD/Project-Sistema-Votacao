package com.betrybe.sistemadevotacao;

public abstract class PessoaCandidata extends Pessoa {
  public int numero;
  public int votos;

  public PessoaCandidata(String nome, int numero) {
    super.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public void receberVoto() {
    this.votos += 1;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }
}
