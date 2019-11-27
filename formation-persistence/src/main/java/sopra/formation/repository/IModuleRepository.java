package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Module;

public interface IModuleRepository extends JpaRepository<Module, Integer> {
	
	@Query("select distinct m from Module m left join fetch m.salle s left join fetch m.matiere ma left join fetch m.filiere f left join fetch m.formateur fo where m.id = :id")
	Module findByIdDetail(@Param("id") Integer id);
}
