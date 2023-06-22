package br.inatel;

import java.util.*;

class Software {

    private ArrayList<Tutor> tutors;

    public Software() {
        this.tutors = new ArrayList<>();
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public ArrayList<Tutor> showTutors() {
        for (Tutor list : tutors) {
            //System.out.println("Tutor: " + list.getNome() + ", Cpf: " + list.getCpf());
            ArrayList<Pet> pets = list.getPets();

            System.out.println("Pets de " + list.getNome() + " (" + list.getCpf() + "): ");
            for (Pet listpets : pets) {
                System.out.println("Coleira: " + listpets.getColeira() + ", Especie: " + listpets.getEspecie() + ", Nome: " + listpets.getNome() + ", " + listpets.getPeso() + " kg(s)");
            }
        }
        return tutors;
    }

    public ArrayList<Tutor> showPets(String pesquisa) {

        for (Tutor list : tutors) {

            String cpf = list.getCpf();

            if (cpf.equals(pesquisa)) {
                ArrayList<Pet> pets = list.getPets();
                System.out.println("Pets de " + list.getNome() + " (" + list.getCpf() + "): ");
                for (Pet listpets : pets) {
                    System.out.println("Coleira: " + listpets.getColeira() + ", Especie: " + listpets.getEspecie() + ", Nome: " + listpets.getNome() + ", " + listpets.getPeso() + " Kg(s)");
                }
            }
        }
        return tutors;
    }
}