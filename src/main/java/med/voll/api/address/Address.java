package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

   private String street;
   private String neighbourhood;
   private String postcode;
   private String city;
   private String uf;
   private String number;
   private String complement;

   public Address(AddressDTO address) {
      this.street = address.street();
      this.neighbourhood = address.neighbourhood();
      this.postcode = address.postcode();
      this.city = address.city();
      this.uf = address.uf();
      this.number = address.number();
      this.complement = address.complement();
   }
}
