package med.voll.api.customer;

import java.time.LocalDate;

import med.voll.api.person.Gender;

public record CustomerListDTO(
      Long id,
      String name,
      String document,
      String email,
      String phone,
      LocalDate birthdate,
      Gender gender) {

   public CustomerListDTO(Customer customer) {
      this(
         customer.getId(),
         customer.getName(),
         customer.getDocument(),
         customer.getEmail(),
         customer.getPhone(),
         customer.getBirthdate(),
         customer.getGender()
      );
   }
}
