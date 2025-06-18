package med.voll.api.customer;

import java.time.LocalDate;

import med.voll.api.address.Address;
import med.voll.api.person.Gender;

public record CustomerShowDTO(
   Long id,
   String name,
   String document,
   String email,
   boolean active,
   String phone,
   LocalDate birthdate,
   Gender gender,
   Address address
) {
   public CustomerShowDTO(Customer customer) {
      this(
         customer.getId(),
         customer.getName(),
         customer.getDocument(),
         customer.getEmail(),
         customer.isActive(),
         customer.getPhone(),
         customer.getBirthdate(),
         customer.getGender(),
         customer.getAddress());
   }
}
