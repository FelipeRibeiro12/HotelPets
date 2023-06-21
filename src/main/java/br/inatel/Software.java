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
            System.out.println("Tutor: " + list.getNome() + ", Cpf: " + list.getCpf());
            ArrayList<Pet> pets = list.getPets();

            System.out.println("Pets: ");
            for (Pet listpets : pets) {
                System.out.println("Especie: " + listpets.getEspecie() + ", Nome: " + listpets.getNome() + ", " + listpets.getIdade() + " ano(s)");
            }
        }
        return tutors;
    }

}