package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.Repositery.CommentaireformsRepository;
import com.bezkoder.springjwt.models.Commentaire_forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommantaireFormService implements ICommontaireform{
    @Autowired
    CommentaireformsRepository ifroms;

    @Override
    public Commentaire_forum addQcm(Commentaire_forum s) {

        return ifroms.save(s);
    }
    @Override
    public Commentaire_forum retrieveCourseById(Long id) {

        return ifroms.findById(id).get();
    }
}
