package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.address.Address;
import med.voll.api.address.AddressRepository;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorDTO;
import med.voll.api.doctor.DoctorListDTO;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.DoctorUpdateDTO;

@RestController
@RequestMapping("medicos")
public class DoctorsController {

   @Autowired
   private DoctorRepository repository;

   @Autowired
   private AddressRepository addressRepository;

   @PostMapping
   @Transactional
   public void create(@RequestBody @Valid DoctorDTO doctor) {
      Doctor savedDoctor = repository.save(new Doctor(doctor));

      Address address = new Address(
         doctor.address(),
         savedDoctor.getId(),
         "Doctor"
      );
      addressRepository.save(address);
   }

   @GetMapping
   public Page<DoctorListDTO> list(@PageableDefault(sort = {"name"}) Pageable pageable) {
      return repository.findAllByActiveTrue(pageable).map(DoctorListDTO::new);
   }

   @PutMapping
   @Transactional
   public void update(@RequestBody @Valid DoctorUpdateDTO doctorData) {
      var doctor = repository.getReferenceById(doctorData.id());
      doctor.updateData(doctorData);
      
      var address = addressRepository.findByAddressableIdAndAddressableType(doctorData.id(), "Doctor");
      

   }

   @DeleteMapping("/{id}")
   @Transactional
   public void delete(@PathVariable Long id) {
      var doctor = repository.getReferenceById(id);
      doctor.delete();
   }
}
