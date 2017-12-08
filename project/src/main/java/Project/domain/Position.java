package Project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int positionid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
	private List<Player> players;
	
	public Position(){}
	
	public Position(String name) {
		super();
		this.name = name;
	}
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	@Override
	public String toString() {
		return "Position [positionid=" + positionid + ", name=" + name + ", players=" + players + "]";
	}
	
	
}
