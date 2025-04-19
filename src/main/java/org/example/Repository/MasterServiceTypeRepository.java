package org.example.Repository;

import org.example.Entity.MasterServiceType;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterServiceTypeRepository extends JpaRepository<MasterServiceType, Integer> {
}
