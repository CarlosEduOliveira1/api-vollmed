package med.voll.api.customer;

import med.voll.api.address.AddressDTO;

public record CustomerUpdateDTO(Long id, String name, String phone, AddressDTO address) {

}
