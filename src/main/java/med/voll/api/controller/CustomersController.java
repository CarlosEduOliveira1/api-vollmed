package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import med.voll.api.customer.Customer;
import med.voll.api.customer.CustomerDTO;
import med.voll.api.customer.CustomerListDTO;
import med.voll.api.customer.CustomerRepository;
import med.voll.api.customer.CustomerUpdateDTO;

@RestController 
@RequestMapping("clientes")
public class CustomersController {

   @Autowired
   private CustomerRepository repository;

   @PostMapping
   public void create(@RequestBody @Valid CustomerDTO customer) {
      repository.save(new Customer(customer));
   }

   @GetMapping
   public Page<CustomerListDTO> list(Pageable pageable) {
      return repository.findAllByActiveTrue(pageable).map(CustomerListDTO::new);
   }

   @PutMapping
   @Transactional
   public void update(@RequestBody @Valid CustomerUpdateDTO customerData) {
      var customer = repository.getReferenceById(customerData.id());
      customer.updateData(customerData);
   }

   @DeleteMapping("/{id}")
   @Transactional 
   public void delete(@PathVariable Long id) {
      var customer = repository.getReferenceById(id);
      customer.delete();
   }
}
