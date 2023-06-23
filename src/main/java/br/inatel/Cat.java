package br.inatel;

public class Cat extends Pet {

    public static int coleiraPet;

    private String pelagem;

    /*public Cat(int coleira, String nome, String especie, String tcpf) {
        super(coleira, nome, especie, tcpf);
    }*/

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