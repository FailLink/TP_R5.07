package org.example;

import java.util.ArrayList;
import java.util.List;

public class Professeur {
    private List<Matiere> matieres;

    public Professeur() {
        this.matieres = new ArrayList<>();
    }

    public void ajouterMatiere(Matiere matiere) {
        matieres.add(matiere);
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public float calculerMoyenneMatiere(Matiere matiere) {
        return matiere.calculeMoyenne();
    }

    public List<Float> consulterMoyennes() {
        List<Float> moyennes = new ArrayList<>();
        for (Matiere matiere : matieres) {
            moyennes.add(matiere.calculeMoyenne());
        }
        return moyennes;
    }
}