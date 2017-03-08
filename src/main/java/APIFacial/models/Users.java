package APIFacial.models;

import javax.persistence.*;

/**
 * Created by thomaz on 03/03/17.
 */

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(unique = true)
    private String email;
    private String password;

    public Users(){

	}

	public Users(Integer id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}