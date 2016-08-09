package entity;

/**
 * Created by pocok on 8/9/16.
 */
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="User")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private long id;

  @NotEmpty
  @Size(min=4, max=30)
  @Column(name="name")
  private String name;

  @NotEmpty
  @Size(min=5, max=30)
  @Column(name="email")
  private String email;

  @NotEmpty
  @Min(8)
  @Column(name="password")
  private String password;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String toString() {
    return "User(Name: " + this.name + ", Email: " + this.email + ", ID: " + this.id +")";
  }


}
