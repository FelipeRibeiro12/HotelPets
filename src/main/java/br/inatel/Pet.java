package br.inatel;

public class Pet {

    private int coleira; //Id
    private String especie;
    private String nome;
    private int peso;

    //construtor
    public Pet(int coleira, String especie, String nome, int idade) {
        this.coleira = coleira;
        this.especie = especie;
        this.nome = nome;
        this.peso = peso;
    }

    public int getColeira() {
        return coleira;
    }

    public void setColeira(int coleira) {
        this.coleira = coleira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getPeso() {
        return peso;
    }

    public void setIdade(int peso) {
        this.peso = peso;
    }
}