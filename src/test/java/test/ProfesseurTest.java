package test;

import org.example.Etudiant;
import org.example.Evaluation;
import org.example.Matiere;
import org.example.Professeur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfesseurTest {

    @Test
    public void testCalculerMoyenneMatiere() {

        Professeur professeur = new Professeur();
        Matiere math = new Matiere("MATH101", "Mathématiques");
        Etudiant etudiantA = new Etudiant(2023);
        Etudiant etudiantB = new Etudiant(2023);

        professeur.ajouterMatiere(math);
        new Evaluation(15.0f, etudiantA, math);
        new Evaluation(10.0f, etudiantB, math);


        float moyenne = professeur.calculerMoyenneMatiere(math);


        assertEquals(12.5f, moyenne, 0.01, "La moyenne finale de la matière est incorrecte");
    }
}
