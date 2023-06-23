package br.inatel;

public class Pet {

    private int coleira; //Id
    private String especie;
    private String nome;
    private String tCpf;

    //construtor
    public Pet(int coleira, String especie, String nome, String tCpf) {
        this.coleira = coleira;
        this.especie = especie;
        this.nome = nome;
        this.tCpf = tCpf;
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

    public String gettCpf() {
        return tCpf;
    }

    public void settCpf(String tCpf) {
        this.tCpf = tCpf;
    }
}