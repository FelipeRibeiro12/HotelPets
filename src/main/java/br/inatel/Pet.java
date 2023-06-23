package br.inatel;

public class Pet {

    private int coleira; // Pk
    private String especie;
    private String nome;
    private String tCpf; // Fk

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

    public void mostrarInfos() {
        System.out.println("Coleira: " + coleira);
        System.out.println("Nome: " + nome);
        System.out.println("Especie: " + especie);
    }
}