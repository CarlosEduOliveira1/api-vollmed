package med.voll.api.customer;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

   @OneToOne
   @JoinTable(
      name = "customers_addresses",
      joinColumns = @JoinColumn(name = "customer_id"),
      inverseJoinColumns = @JoinColumn(name = "address_id")
   )
   private Address address;

   public Customer(CustomerDTO customer) {
      this.name = customer.name();
      this.document = customer.document();
      this.email = customer.email();
      this.active = true;
      this.phone = customer.phone();
      this.birthdate = customer.birthdate();
      this.gender = customer.gender();
   }

   public void setAddress(Address address) { this.address = address; }

   public void updateData(CustomerUpdateDTO customerData) {
      if(customerData.name() != null) {
         this.name = customerData.name();
      }

      if(customerData.phone() != null) {
         this.phone = customerData.phone();
      }
   }

   public void delete() {
      this.active = false;
   }
}
