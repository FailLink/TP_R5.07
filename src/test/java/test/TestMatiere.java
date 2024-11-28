package test;

import org.example.Etudiant;
import org.example.Evaluation;
import org.example.Matiere;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestMatiere {

    @Test
    public void testAjouterEvaluationEtCalculMoyenne() {

        Matiere math = new Matiere("MATH101", "Mathématiques");


        Etudiant etudiant1 = new Etudiant(2023);
        Etudiant etudiant2 = new Etudiant(2023);


        new Evaluation(12.0f, etudiant1, math);
        new Evaluation(14.0f, etudiant2, math);


        assertEquals(13.0f, math.calculeMoyenne(), 0.01, "La moyenne de la matière est incorrecte");
    }

    @Test
    public void testGetters() {
        Matiere matiere = new Matiere("SCI101", "Sciences");
        assertEquals("SCI101", matiere.getCode(), "Le code de la matière est incorrect");
        assertEquals("Sciences", matiere.getNom(), "Le nom de la matière est incorrect");
    }
}