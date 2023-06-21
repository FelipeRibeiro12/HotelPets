package br.inatel;

import java.util.*;

class Tutor {

    private int id;
    private String cpf;
    private String nome;
    private ArrayList<Pet> pets;
    private static int cont;

    public Tutor(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}