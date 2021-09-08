package service_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import service_db.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, String>{
}
