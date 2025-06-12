package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorDTO;
import med.voll.api.doctor.DoctorRepository;

@RestController
@RequestMapping("medicos")
public class DoctorsController {

   @Autowired
   private DoctorRepository repository;

   @PostMapping
   @Transactional
   public void setDoctor(@RequestBody @Valid DoctorDTO doctor) {
      repository.save(new Doctor(doctor));
   }
}
