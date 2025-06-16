package med.voll.api.doctor;

import med.voll.api.address.AddressDTO;

public record DoctorUpdateDTO(Long id, String name, String phone, AddressDTO address) {
}
