package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Commentaires_post;

import java.util.List;

public interface IComantairepost {
    //public List<Profe> retrieveAllProfs();

    List<Commentaires_post> retrieveAllQcm();
    Commentaires_post addQcm(Commentaires_post s);
    void deleteQcmById(Long id);
    void deleteQcm(Commentaires_post s);
    Commentaires_post updateQcm(Commentaires_post s);
    Commentaires_post retrieveQcmById(Long id);
}
