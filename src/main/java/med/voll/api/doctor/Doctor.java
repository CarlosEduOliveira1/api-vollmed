package med.voll.api.doctor;

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

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String phone;
   private String email;
   private String crm;

   @Enumerated(EnumType.STRING)
   private Specialty specialty;

   private boolean active;

   @Transient
   private Address address;

   public Doctor(DoctorDTO doctor) {
      this.name = doctor.name();
      this.phone = doctor.phone();
      this.email = doctor.email();
      this.crm = doctor.crm();
      this.specialty = doctor.specialty();
      this.active = true;
      // this.address = new Address(doctor.address());
   }

   public void updateData(DoctorUpdateDTO doctorData) {
      if(doctorData.name() != null) {
         this.name = doctorData.name();
      }

      if(doctorData.phone() != null) {
         this.phone = doctorData.phone();
      }

      // if(doctorData.address() != null) {
      //    this.address.updateData(doctorData.address());
      // }
   }

   public void delete() {
      this.active = false;
   }
}
