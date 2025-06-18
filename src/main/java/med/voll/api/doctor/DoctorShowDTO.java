package med.voll.api.doctor;

import med.voll.api.address.Address;

public record DoctorShowDTO(
      Long id,
      String name,
      String email,
      String phone,
      String crm,
      Specialty specialty,
      boolean active,
      Address address) {
   public DoctorShowDTO(Doctor doctor) {
      this(
         doctor.getId(),
         doctor.getName(),
         doctor.getEmail(),
         doctor.getPhone(), 
         doctor.getCrm(),
         doctor.getSpecialty(),
         doctor.isActive(),
         doctor.getAddress());
   }
}
