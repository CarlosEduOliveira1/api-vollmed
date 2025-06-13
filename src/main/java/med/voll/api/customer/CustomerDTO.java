package med.voll.api.customer;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import med.voll.api.address.AddressDTO;
import med.voll.api.person.Gender;

public record CustomerDTO(

      @NotBlank String name,

      @NotBlank 
      @Pattern(regexp = "(^\\d{11}|\\d{14}$)")
      String document,

      @NotBlank @Email String email,

      @NotBlank String phone,

      @NotNull @Past LocalDate birthdate,

      @NotNull Gender gender,

      @NotNull @Valid AddressDTO address) {
}
