package Project.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int age;
	private String nationality;
	private String club;
	
	@ManyToOne
	@JoinColumn(name = "positionid")
	private Position position;
	
	public Player() {
	}

	public Player(String name, int age, String nationality, String club, Position position) {
		super();
		this.name = name;
		this.age = age;
		this.nationality = nationality;
		this.club = club;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		if(this.position != null)
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", nationality=" + nationality + ", club="
				+ "club" +  this.getPosition().getName() + "]";
		else
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", nationality=" + nationality + ", club="
				+ club + "]";
		
	}
	
	
	
	
	
	
	
	
}
