package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Dossier;

import java.util.List;

public interface IDossier {
    List<Dossier> retrieveProblems();
    Dossier addProblem(Dossier s);
    void deleteProblemById(Long id);
    void deleteProblem(Dossier s);
    Dossier updateProblem(Dossier s);
    Dossier retrieveProblemById(Long id);
    public Dossier AddTestProb(Dossier test, Long testid);
}
