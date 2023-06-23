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

}