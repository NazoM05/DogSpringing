package dogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dogs.model.Produto;

@Repository
public interface DogPrtRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByCategoria(Integer categoria);
}
