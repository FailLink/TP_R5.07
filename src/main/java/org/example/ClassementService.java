package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ClassementService {

    public List<Etudiant> classerEtudiants(List<Etudiant> etudiants) {
        return etudiants.stream()
                .sorted((e1, e2) -> Float.compare(e2.calculeMoyenneGenerale(), e1.calculeMoyenneGenerale()))
                .collect(Collectors.toList());
    }
}