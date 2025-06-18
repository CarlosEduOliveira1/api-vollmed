package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.Address;
import med.voll.api.address.AddressDTO;
import med.voll.api.address.AddressRepository;
import med.voll.api.customer.Customer;
import med.voll.api.customer.CustomerDTO;
import med.voll.api.customer.CustomerListDTO;
import med.voll.api.customer.CustomerRepository;
import med.voll.api.customer.CustomerShowDTO;
import med.voll.api.customer.CustomerUpdateDTO;

@RestController
@RequestMapping("clientes")
public class CustomersController {

   @Autowired
   private CustomerRepository repository;

   @Autowired
   private AddressRepository addressRepository;

   @PostMapping
   public ResponseEntity<CustomerShowDTO> create(@RequestBody @Valid CustomerDTO customer) {
      Address customerAddress;
      AddressDTO incomingAddress = customer.address();
      customerAddress = new Address(incomingAddress);

      addressRepository.save(customerAddress);

      Customer newCustomer = new Customer(customer);
      newCustomer.setAddress(customerAddress);

      Customer savedCustomer = repository.save(newCustomer);

      return ResponseEntity.ok(new CustomerShowDTO(savedCustomer));
   }

   @GetMapping
   public ResponseEntity<Page<CustomerListDTO>> list(Pageable pageable) {
      var page = repository.findAllByActiveTrue(pageable).map(CustomerListDTO::new);
      
      return ResponseEntity.ok(page);
   }

   @GetMapping("/{id}")
   public ResponseEntity<CustomerShowDTO> show(@PathVariable Long id) {
      Customer customer = repository.getReferenceById(id);

      return ResponseEntity.ok(new CustomerShowDTO(customer));
   }

   @PutMapping
   @Transactional
   public ResponseEntity<CustomerShowDTO> update(@RequestBody @Valid CustomerUpdateDTO customerData) {
      var customer = repository.getReferenceById(customerData.id());
      customer.updateData(customerData);

      var currentAddress = customer.getAddress();
      if(currentAddress != null && customerData.address() != null) {
         currentAddress.updateData(customerData.address());
         addressRepository.save(currentAddress);
      }

      Customer updatedCustomer = repository.save(customer);

      return ResponseEntity.ok(new CustomerShowDTO(updatedCustomer));
   }

   @DeleteMapping("/{id}")
   @Transactional
   public ResponseEntity<Void> delete(@PathVariable Long id) {
      var customer = repository.getReferenceById(id);
      customer.delete();

      return ResponseEntity.noContent().build();
   }
}
