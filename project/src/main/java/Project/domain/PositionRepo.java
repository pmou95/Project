package Project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PositionRepo extends CrudRepository<Position, Long>{
	List<Position> findByName(String name);
}
