package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Reclamation;

import java.util.List;

public interface IReclamation {
    public List<Reclamation> retrieveAllCour();

   // Course addCour(Course s, Long idfile);

    // public Course addCour(Course s);
    public Reclamation retrieveCourseById(Long id);
   // public Course addCourse(Course s, MultipartFile file);

    public Reclamation addCour(Reclamation s) ;
}


