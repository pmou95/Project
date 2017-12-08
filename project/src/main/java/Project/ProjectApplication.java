package Project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Project.domain.Player;
import Project.domain.PlayerRepo;
import Project.domain.Position;
import Project.domain.PositionRepo;
import Project.domain.User;
import Project.domain.UserRepo;



@SpringBootApplication
public class ProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner playerDemo(PlayerRepo prepo, PositionRepo orepo, UserRepo urepo){
		return(args) -> {
			log.info("save a couple of players");
			orepo.save(new Position ("Goal Keeper"));
			orepo.save(new Position ("Defender"));
			orepo.save(new Position ("Midfielder"));
			orepo.save(new Position ("Forwarder"));

			prepo.save(new Player("John Terry", 36,"England","Chelsea",orepo.findByName("Defender").get(0)));
			prepo.save(new Player("Frank Lampard", 39,"England","Chelsea",orepo.findByName("Midfielder").get(0)));
			
			// Create users: admin/admin user/user
						User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
						User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
						urepo.save(user1);
						urepo.save(user2);
			
			log.info("Fetching all players");
			for (Player player : prepo.findAll()) {
				log.info(player.toString());
			}
		};
	}
}
