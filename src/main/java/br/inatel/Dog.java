package br.inatel;

public class Dog extends Pet {

    public static int coleiraPet; // Pk

    private String cor;

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