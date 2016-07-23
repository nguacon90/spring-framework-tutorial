package vn.com.nguacon.model.refreshcascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="country_refresh")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	public Country() {
	}
	
	public Country(String name) {
		this.name = name;
	}
	public Country(String name, State state) {
		this.name = name;
		this.state = state;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="sateId", nullable=false)
	private State state;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", state=" + state.getName() + "]";
	}
	
}
