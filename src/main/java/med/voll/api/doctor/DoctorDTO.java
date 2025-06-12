package med.voll.api.doctor;

import med.voll.api.address.AddressDTO;

public record DoctorDTO(
      String nome,
      String email,
      String crm,
      Specialty especialidade,
      AddressDTO endereco) {
}