package med.voll.api.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{

   Address findByAddressableIdAndAddressableType(Long addressableId, String addressableType);

}
