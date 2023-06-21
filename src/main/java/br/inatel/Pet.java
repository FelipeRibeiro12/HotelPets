package br.inatel;

public class Pet {

    private int coleira; //Id
    private String especie;
    private String nome;
    private int idade;

    //construtor
    public Pet(int coleira, String especie, String nome, int idade) {
        this.coleira = coleira;
        this.especie = especie;
        this.nome = nome;
        this.idade = idade;
    }

    /*public Pet() {
        idPet++;
    }*/

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getColeira() {
        return coleira;
    }

    public void setColeira(int coleira) {
        this.coleira = coleira;
    }
}