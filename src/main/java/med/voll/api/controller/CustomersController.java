package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.customer.Customer;
import med.voll.api.customer.CustomerDTO;
import med.voll.api.customer.CustomerListDTO;
import med.voll.api.customer.CustomerRepository;

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
      return repository.findAll(pageable).map(CustomerListDTO::new);
   }
}
