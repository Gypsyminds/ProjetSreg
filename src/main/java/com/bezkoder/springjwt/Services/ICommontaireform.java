package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Commentaire_forum;

public interface ICommontaireform {
    public Commentaire_forum addQcm(Commentaire_forum s);
    public Commentaire_forum retrieveCourseById(Long id) ;
}
