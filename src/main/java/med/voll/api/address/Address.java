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

   public void updateData(AddressDTO addressData) {
      if(addressData.street() != null) {
         this.street = addressData.street();
      }

      if(addressData.neighbourhood() != null) {
         this.neighbourhood = addressData.neighbourhood();
      }

      if(addressData.postcode() != null) {
         this.postcode = addressData.postcode();
      }

      if(addressData.city() != null) {
         this.city = addressData.city();
      }

      if(addressData.uf() != null) {
         this.uf = addressData.uf();
      }

      if(addressData.number() != null) {
         this.number = addressData.number();
      }

      if(addressData.complement() != null) {
         this.complement = addressData.complement();
      }
   }
}
