package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.Repositery.CommentaireformsRepository;
import com.bezkoder.springjwt.Services.IPost;
import com.bezkoder.springjwt.Services.ICommontaireform;
import com.bezkoder.springjwt.models.Posts;
import com.bezkoder.springjwt.models.Commentaire_forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/feed")
public class Certif_testControlleur {
   @Autowired
   IPost iCertif_test;
   @Autowired
   ICommontaireform ICERTIF ;


   @PostMapping(value = "/add-post")
   public Posts addQcm(@RequestBody Posts s) {
      return iCertif_test.addQcm(s);

   }
   @PostMapping(value="/ass-commentaire")
   public Commentaire_forum addQcm(@RequestBody Commentaire_forum s){

      return ICERTIF.addQcm(s);
   }

}
