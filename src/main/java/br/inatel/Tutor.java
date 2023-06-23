package br.inatel;

import java.util.*;

public class Tutor {

    private String cpf; // Fk
    private String nome;
    private int idade;
    private ArrayList<Pet> pets;

    // Construtor
    public Tutor(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void mostrarInfos() {
        System.out.println("Cpf: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}