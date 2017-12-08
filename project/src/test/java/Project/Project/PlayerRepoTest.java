package Project.Project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Project.domain.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerRepoTest {

    @Autowired
    private PlayerRepo repository;

    @Test
    public void findByLastnameShouldReturnPlayer() {
        List<Player> players = repository.findByName("Frank Lampard");
        
        assertThat(players).hasSize(1);
        assertThat(players.get(0).getClub()).isEqualTo("Chelsea");
    }
    
    @Test
    public void createNewPlayer(PlayerRepo prepo, PositionRepo orepo, UserRepo urepo) {
    	Player Player = new Player("Christiano Ronaldo", 32, "Portugal", "Real Madrid", orepo.findByName("Forwarder").get(0));
    	repository.save(Player);
    	assertThat(Player.getId()).isNotNull();
    }    

}