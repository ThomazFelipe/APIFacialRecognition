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
	@Lob
	@Column(nullable=false, columnDefinition="mediumblob")
	private Byte[] image;

    public Users(){	}

	public Users(Integer id, String email, String password, Byte [] image) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.image = image;
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

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}
}