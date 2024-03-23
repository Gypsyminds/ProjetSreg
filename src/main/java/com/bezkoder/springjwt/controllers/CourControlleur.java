package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Repositery.*;
import com.bezkoder.springjwt.Services.ICondidat;
import com.bezkoder.springjwt.Services.IReclamation;
import com.bezkoder.springjwt.Services.IPdf;
import com.bezkoder.springjwt.Services.IComantairepost;
import com.bezkoder.springjwt.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cour")
public class CourControlleur {
    @Autowired
    IReclamation icourse ;
    @Autowired
    ICondidat icondidat ;

    @Autowired
    UserRepository userRepository;
    @Autowired
    CondidatRepository condidat ;
 ;
    @Autowired
    IComantairepost iprof ;
    @Autowired
    CommentaireformsRepository certifrepo ;
    @Autowired
    PostsRepository testrepo ;
    @Autowired
    pdfRepository pdfrep;


    @Autowired
    IPdf pdf ;
    @PostMapping(value = "/add-cour")
    public Reclamation addCour(@RequestBody Reclamation s) {
      // s.setFile(file.getBytes());
     //  Long idfile = pdfrep.idlastf();
      // s.setFilepdf(idfile);
        Long id = pdfrep.idlastf();
      //  s.setFilepdf(id);
        return icourse.addCour(s);
    }

    @GetMapping(value ="/showall")
    public List<Reclamation> retrieveAllCourse() {

        return icourse.retrieveAllCour();
    }
    @GetMapping(value ="/showCourse/{id}")
    public Reclamation retriveProb(@PathVariable Long id) {

        return icourse.retrieveCourseById(id);
    }
    @GetMapping(value="/showusers")
    public List<User> showusers(){

        return icondidat.retrieveAllUsers();
    }

    //}
    @GetMapping(value="/nbrcertif")
    public int affcertif(){
        return certifrepo.nubcertifs();
    }
    @GetMapping(value="/nbrtest")
    public int afftest(){
        return testrepo.nubtest();
    }



    @GetMapping("/img/{imgId}")
    public byte[] getimgBytes(@PathVariable Long imgId) {
        imageuser pdfEntity = pdf.retrieveById(imgId);
        return pdfEntity.getPicByte();
    }
    @GetMapping("/imgs/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        imageuser image = pdf.retrieveById(id);


        if (image.getPicByte() != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image.getPicByte());
            // Now you can use picByte without a NullPointerException
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image.getPicByte());

    }

    @PostMapping("/uploads")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            pdf.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping(path = { "/get/{imageName}" })
    public imageuser getImages(@PathVariable("imageName") Long  imageName) throws IOException {
        final Optional<imageuser> retrievedImage = Optional.ofNullable(pdf.retrieveById(imageName));
        imageuser img = new imageuser(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

}
