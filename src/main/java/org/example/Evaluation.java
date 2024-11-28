package org.example;
public class Evaluation {
    private float note;
    private Etudiant etudiant;
    private Matiere matiere;


    public Evaluation(float note, Etudiant etudiant, Matiere matiere) {
        this.note = note;
        this.etudiant = etudiant;
        this.matiere = matiere;
        matiere.ajouterEvaluation(this);
        etudiant.ajouterEvaluation(this);
    }


    public float getNote() {
        return note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }
}