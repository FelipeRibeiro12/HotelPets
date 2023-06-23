package br.inatel;

public class Cat extends Pet {

    public static int coleiraPet; // Pk

    private String pelagem;

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    @Override
    public void mostrarInfos() {
        System.out.println("Pelagem: " + pelagem);
    }
}