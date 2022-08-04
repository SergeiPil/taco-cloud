package com.piliugin.tacocloud.repository;

import com.piliugin.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends CrudRepository<Taco, String> {
}
