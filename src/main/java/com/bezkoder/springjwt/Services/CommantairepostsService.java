package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.Repositery.CommentairePostsRepository;
import com.bezkoder.springjwt.models.Commentaires_post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommantairepostsService implements IComantairepost{

    @Autowired
    CommentairePostsRepository iQuestion_qcm;
    //@Override
    //public List<Profe> retrieveAllProfs() {

      //  return (List<Profe>) profrepo.findAll();
    //}
      @Override
      public List<Commentaires_post> retrieveAllQcm() {

          return (List<Commentaires_post>) iQuestion_qcm.findAll();
      }

    @Override
    public Commentaires_post addQcm(Commentaires_post s) {
        //    s.setDate_start(LocalDateTime.now());
        return iQuestion_qcm.save(s);
    }

    @Override
    public void deleteQcmById(Long id) {
        iQuestion_qcm.deleteById(id);

    }

    @Override
    public void deleteQcm(Commentaires_post s) {
        iQuestion_qcm.delete(s);
    }

    @Override
    public Commentaires_post updateQcm(Commentaires_post s) {
        return iQuestion_qcm.save(s);
    }

    @Override
    public Commentaires_post retrieveQcmById(Long id) {
        return iQuestion_qcm.findById(id).get();
    }

}
