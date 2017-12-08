package Project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<Player, Long>
{

	List<Player> findByName(String string);

}