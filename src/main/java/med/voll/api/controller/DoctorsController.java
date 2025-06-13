package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorDTO;
import med.voll.api.doctor.DoctorListDTO;
import med.voll.api.doctor.DoctorRepository;

@RestController
@RequestMapping("medicos")
public class DoctorsController {

   @Autowired
   private DoctorRepository repository;

   @PostMapping
   @Transactional
   public void create(@RequestBody @Valid DoctorDTO doctor) {
      repository.save(new Doctor(doctor));
   }

   @GetMapping
   public Page<DoctorListDTO> list(@PageableDefault(sort = {"name"}) Pageable pageable) {
      return repository.findAll(pageable).map(DoctorListDTO::new);
   }

   @PutMapping
   @Transactional
   public void update(@RequestBody @Valid DoctorUpdateDTO doctor) {

   }
}
