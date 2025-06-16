package med.voll.api.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.customer.Customer;
import med.voll.api.doctor.Doctor;

@Table(name = "addresses")
@Entity(name = "address")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "addressable_id")
   private Long addressableId;

   @Column(name = "addressable_type")
   private String addressableType;

   private String street;
   private String neighbourhood;
   private String postcode;
   private String city;
   private String uf;
   private String number;
   private String complement;

   public Address(AddressDTO address, Long addressableId, String addressableType) {
      this.street = address.street();
      this.neighbourhood = address.neighbourhood();
      this.postcode = address.postcode();
      this.city = address.city();
      this.uf = address.uf();
      this.number = address.number();
      this.complement = address.complement();
      this.addressableId = addressableId;
      this.addressableType = addressableType;
   }

   public void updateData(AddressDTO addressData) {
      if (addressData.street() != null) {
         this.street = addressData.street();
      }

      if (addressData.neighbourhood() != null) {
         this.neighbourhood = addressData.neighbourhood();
      }

      if (addressData.postcode() != null) {
         this.postcode = addressData.postcode();
      }

      if (addressData.city() != null) {
         this.city = addressData.city();
      }

      if (addressData.uf() != null) {
         this.uf = addressData.uf();
      }

      if (addressData.number() != null) {
         this.number = addressData.number();
      }

      if (addressData.complement() != null) {
         this.complement = addressData.complement();
      }
   }
}
