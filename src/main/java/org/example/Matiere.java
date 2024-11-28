package org.example;
import java.util.ArrayList;

public class Matiere {
    private String code;
    private String nom;
    private ArrayList<Evaluation> evaluations;


    public Matiere(String code, String nom) {
        this.code = code;
        this.nom = nom;
        this.evaluations = new ArrayList<>();
    }


    public void ajouterEvaluation(Evaluation evaluation) {
        this.evaluations.add(evaluation);
    }


    public float calculeMoyenne() {
        float somme = 0;
        for (Evaluation evaluation : evaluations) {
            somme += evaluation.getNote();
        }
        return !evaluations.isEmpty() ? somme / evaluations.size() : 0;
    }


    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }
}
