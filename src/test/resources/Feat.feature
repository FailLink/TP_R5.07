Feature: Test BDD
  Scenario: Calculer la moyenne finale d'une matière
    Given un professeur enseignant la matière "Mathématiques"
    And les étudiants suivants ont les notes pour la matière "Mathématiques":
      | Etudiant | Note |
      | Alice    | 15   |
      | Bob      | 10   |
      | Carol    | 18   |
    When le professeur calcule la moyenne de la matière "Mathématiques"
    Then la moyenne finale de la matière "Mathématiques" doit être 14.33

  Scenario: Consulter les moyennes de toutes les matières
    Given un professeur enseignant les matières suivantes:
      | Code      | Nom           |
      | MATH101   | Mathématiques |
      | PHY101    | Physique      |
    And les étudiants suivants ont les notes pour chaque matière:
      | Etudiant | Matière        | Note |
      | Alice    | Mathématiques  | 15   |
      | Bob      | Mathématiques  | 10   |
      | Alice    | Physique       | 14   |
      | Bob      | Physique       | 16   |
    When le professeur consulte les moyennes des matières
    Then les moyennes doivent être:
      | Matière       | Moyenne |
      | Mathématiques | 12.5    |
      | Physique      | 15.0    |
