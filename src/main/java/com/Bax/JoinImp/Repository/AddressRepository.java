package com.Bax.JoinImp.Repository;

import com.Bax.JoinImp.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
