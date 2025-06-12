package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.doctor.DoctorDTO;

@RestController
@RequestMapping("medicos")
public class DoctorsController {

   @PostMapping
   public void setDoctor(@RequestBody DoctorDTO doctor) {
      System.out.println(doctor);
   }
}
