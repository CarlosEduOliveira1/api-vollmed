package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(

      @NotBlank
      String street,

      @NotBlank
      String neighbourhood,

      @NotBlank
      @Pattern(regexp = "\\d{8}")
      String postcode,

      @NotBlank
      String city,

      @NotBlank
      String uf,

      String number,

      String complement) {
}
