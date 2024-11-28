package test;

import org.example.Etudiant;
import org.example.Evaluation;
import org.example.Matiere;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEtudiant {

    @Test
    public void testAjouterEvaluationEtCalculMoyenne() {

        Etudiant etudiant = new Etudiant(2023);


        Matiere math = new Matiere("MATH101", "Mathématiques");
        Matiere francais = new Matiere("FRA101", "Français");


        new Evaluation(15.0f, etudiant, math);
        new Evaluation(10.0f, etudiant, francais);


        assertEquals(12.5f, etudiant.calculeMoyenneGenerale(), 0.01, "La moyenne générale de l'étudiant est incorrecte");
    }

    @Test
    public void testAnneeGetter() {
        Etudiant etudiant = new Etudiant(2023);
        assertEquals(2023, etudiant.getAnnee(), "L'année de l'étudiant est incorrecte");
    }
}