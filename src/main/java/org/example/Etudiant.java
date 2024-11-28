package org.example;
import java.util.ArrayList;

public class Etudiant {
    private int annee;
    private ArrayList<Evaluation> evaluations;


    public Etudiant(int annee) {
        this.annee = annee;
        this.evaluations = new ArrayList<>();
    }


    public void ajouterEvaluation(Evaluation evaluation) {
        this.evaluations.add(evaluation);
    }


    public float calculeMoyenneGenerale() {
        float somme = 0;
        for (Evaluation evaluation : evaluations) {
            somme += evaluation.getNote();
        }
        return !evaluations.isEmpty() ? somme / evaluations.size() : 0;
    }


    public int getAnnee() {
        return annee;
    }
}