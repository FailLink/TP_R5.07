package test;

import org.example.Etudiant;
import org.example.Evaluation;
import org.example.Matiere;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestEvaluation {

    @Test
    public void testEvaluationCreation() {

        Etudiant etudiant = new Etudiant(2023);
        Matiere math = new Matiere("MATH101", "Mathématiques");


        Evaluation evaluation = new Evaluation(16.0f, etudiant, math);

        // Vérifications
        assertEquals(16.0f, evaluation.getNote(), 0.01, "La note de l'évaluation est incorrecte");
        assertEquals(etudiant, evaluation.getEtudiant(), "L'étudiant associé à l'évaluation est incorrect");
        assertEquals(math, evaluation.getMatiere(), "La matière associée à l'évaluation est incorrecte");
    }
}