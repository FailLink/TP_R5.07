package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.example.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GestionNotesSteps {

    private Professeur professeur;
    private Map<String, Etudiant> etudiants;
    private Map<String, Matiere> matieres;
    private float moyenneCalculee;
    private static final String ERR = "La matière n'existe pas";

    @Given("un professeur enseignant la matière {string}")
    public void unProfesseurEnseignantLaMatiere(String nomMatiere) {
        professeur = new Professeur();
        matieres = new HashMap<>();
        Matiere matiere = new Matiere("MATH101", nomMatiere);
        matieres.put(nomMatiere, matiere);
        professeur.ajouterMatiere(matiere);
    }

    @Given("les étudiants suivants ont les notes pour la matière {string}:")
    public void lesEtudiantsSuivantsOntLesNotesPourLaMatiere(String nomMatiere, DataTable dataTable) {
        etudiants = new HashMap<>();
        Matiere matiere = matieres.get(nomMatiere);
        assertNotNull(matiere, ERR);

        for (Map<String, String> row : dataTable.asMaps()) {
            String etudiantNom = row.get("Etudiant");
            float note = Float.parseFloat(row.get("Note"));

            Etudiant etudiant = etudiants.computeIfAbsent(etudiantNom, k -> new Etudiant(2023));
            new Evaluation(note, etudiant, matiere);
        }
    }

    @When("le professeur calcule la moyenne de la matière {string}")
    public void leProfesseurCalculeLaMoyenneDeLaMatiere(String nomMatiere) {
        Matiere matiere = matieres.get(nomMatiere);
        assertNotNull(matiere, ERR);
        moyenneCalculee = matiere.calculeMoyenne();
    }

    @Then("la moyenne finale de la matière {string} doit être {float}")
    public void laMoyenneFinaleDeLaMatiereDoitEtre(float moyenneAttendue) {
        assertEquals(moyenneAttendue, moyenneCalculee, 0.01, "La moyenne calculée est incorrecte");
    }

    @Given("un professeur enseignant les matières suivantes:")
    public void unProfesseurEnseignantLesMatièresSuivantes(DataTable dataTable) {
        professeur = new Professeur();
        matieres = new HashMap<>();

        for (Map<String, String> row : dataTable.asMaps()) {
            Matiere matiere = new Matiere(row.get("Code"), row.get("Nom"));
            matieres.put(row.get("Nom"), matiere);
            professeur.ajouterMatiere(matiere);
        }
    }

    @Given("les étudiants suivants ont les notes pour chaque matière:")
    public void lesEtudiantsSuivantsOntLesNotesPourChaqueMatière(DataTable dataTable) {
        etudiants = new HashMap<>();

        for (Map<String, String> row : dataTable.asMaps()) {
            String etudiantNom = row.get("Etudiant");
            String matiereNom = row.get("Matière");
            float note = Float.parseFloat(row.get("Note"));

            Etudiant etudiant = etudiants.computeIfAbsent(etudiantNom, k -> new Etudiant(2023));
            Matiere matiere = matieres.get(matiereNom);

            new Evaluation(note, etudiant, matiere);
        }
    }

    @When("le professeur consulte les moyennes des matières")
    public void leProfesseurConsulteLesMoyennesDesMatières() {
        // Aucune action requise ici ; les moyennes sont consultables via les matières
    }

    @Then("les moyennes doivent être:")
    public void lesMoyennesDoitEtre(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps()) {
            String matiereNom = row.get("Matière");
            float moyenneAttendue = Float.parseFloat(row.get("Moyenne"));

            Matiere matiere = matieres.get(matiereNom);
            assertNotNull(matiere, ERR);
            assertEquals(moyenneAttendue, matiere.calculeMoyenne(), 0.01, "La moyenne pour " + matiereNom + " est incorrecte");
        }
    }
}