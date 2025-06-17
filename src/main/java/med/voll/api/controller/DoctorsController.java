package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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

   // @PostMapping
   // @Transactional
   // public ResponseEntity create(@RequestBody @Valid DoctorDTO doctor) {
   //    Doctor savedDoctor = repository.save(new Doctor(doctor));

   //    Address address = new Address(
   //          doctor.address(),
   //          savedDoctor.getId(),
   //          "Doctor");
   //    addressRepository.save(address);
   // }

   // @GetMapping
   // public ResponseEntity<Page<DoctorListDTO>> list(@PageableDefault(sort = { "name" }) Pageable pageable) {
   //    var page = repository.findAllByActiveTrue(pageable).map(DoctorListDTO::new);

   //    return ResponseEntity.ok(page);
   // }
   @GetMapping("/test")
   public ResponseEntity<Doctor> getDoctorWithIdTwo() {
      Long id = 2L;
      Doctor doctor = repository.findById(id).orElse(null);
      if (doctor == null) {
         return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(doctor);
   }

   // @PutMapping
   // @Transactional
   // public ResponseEntity update(@RequestBody @Valid DoctorUpdateDTO doctorData) {
   //    var doctor = repository.getReferenceById(doctorData.id());
   //    doctor.updateData(doctorData);

   //    var address = addressRepository.findByAddressableIdAndAddressableType(doctorData.id(), "Doctor");
   //    if (address != null && doctorData.address() != null) {
   //       address.updateData(doctorData.address());
   //       addressRepository.save(address);
   //    }
   // }

   // @DeleteMapping("/{id}")
   // @Transactional
   // public ResponseEntity delete(@PathVariable Long id) {
   //    var doctor = repository.getReferenceById(id);
   //    doctor.delete();

   //    return ResponseEntity.noContent().build();
   // }
}
