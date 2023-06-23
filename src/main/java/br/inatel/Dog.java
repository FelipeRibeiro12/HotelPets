package br.inatel;

public class Dog extends Pet {

    public static int coleiraPet;

    private String cor;

    /*public Dog(int coleira, String nome, String especie, String tcpf) {
        super(coleira, nome, especie, tcpf);
    }*/

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void mostrarInfos() {
        System.out.println("Cor: " + cor);
    }
}