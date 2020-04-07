package dz.algerie.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dz.algerie.app.model.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long>{
	
	@Query(value="From Commune c join c.wilaya w where w.name=:name")
	List<Commune> allCommunesByWilaya(@Param("name") String name);
}
