package com.oppa.payboxsoft.impl;

import com.oppa.payboxsoft.api.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdditionalFeesRepository extends CrudRepository<AdditionalFeesEntity, Long> {

    Optional<AdditionalFeesEntity> findByService(Service service);
}
