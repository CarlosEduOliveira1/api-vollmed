package med.voll.api.customer;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;
import med.voll.api.person.Gender;

@Table(name = "customers")
@Entity(name = "customer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String document;
   private String email;
   private boolean active;
   private String phone;
   private LocalDate birthdate;

   @Enumerated(EnumType.STRING)
   private Gender gender;

   @Transient
   private Address address;

   public Customer(CustomerDTO customer) {
      this.name = customer.name();
      this.document = customer.document();
      this.email = customer.email();
      this.active = true;
      this.phone = customer.phone();
      this.birthdate = customer.birthdate();
      this.gender = customer.gender();
      // this.address = new Address(customer.address());
   }

   public void updateData(CustomerUpdateDTO customerData) {
      if(customerData.name() != null) {
         this.name = customerData.name();
      }

      if(customerData.phone() != null) {
         this.phone = customerData.phone();
      }

      // if(customerData.address() != null) {
      //    this.address.updateData(customerData.address());
      // }
   }

   public void delete() {
      this.active = false;
   }
}
