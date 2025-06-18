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
import med.voll.api.address.AddressDTO;
import med.voll.api.address.AddressRepository;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorDTO;
import med.voll.api.doctor.DoctorListDTO;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.DoctorShowDTO;
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
   public ResponseEntity<DoctorShowDTO> create(@RequestBody @Valid DoctorDTO doctor) {
      Address doctorAddresses;
      AddressDTO incomingAddressDTO = doctor.address();

      doctorAddresses = new Address(incomingAddressDTO);
      addressRepository.save(doctorAddresses);

      Doctor newDoctor = new Doctor(doctor);
      newDoctor.setAddress(doctorAddresses);

      Doctor savedDoctor = repository.save(newDoctor);

      return ResponseEntity.ok(new DoctorShowDTO(savedDoctor));
   }

   @GetMapping
   public ResponseEntity<Page<DoctorListDTO>> list(@PageableDefault(sort = { "name" }) Pageable pageable) {
      var page = repository.findAllByActiveTrue(pageable).map(DoctorListDTO::new);

      return ResponseEntity.ok(page);
   }

   @GetMapping("/{id}")
   public ResponseEntity<DoctorShowDTO> show(@PathVariable Long id) {
      var doctor = repository.getReferenceById(id);

      return ResponseEntity.ok(new DoctorShowDTO(doctor));
   }
   
   @PutMapping
   @Transactional
   public ResponseEntity<DoctorShowDTO> update(@RequestBody @Valid DoctorUpdateDTO doctorData) {
      var doctor = repository.getReferenceById(doctorData.id());
      doctor.updateData(doctorData);

      Address currentAddress = doctor.getAddress();
      if (currentAddress != null && doctorData.address() != null) {
         currentAddress.updateData(doctorData.address());
         addressRepository.save(currentAddress);
      }

      Doctor updatedDoctor = repository.save(doctor);

      return ResponseEntity.ok(new DoctorShowDTO(updatedDoctor));
   }

   @DeleteMapping("/{id}")
   @Transactional
   public ResponseEntity<Void> delete(@PathVariable Long id) {
      var doctor = repository.getReferenceById(id);
      doctor.delete();

      return ResponseEntity.noContent().build();
   }
}
