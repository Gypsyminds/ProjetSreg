package com.bezkoder.springjwt.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class User  implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date birth_date ;
  private String country ;
  private String name;
  private String type;
  private Long image ;
  private String district;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @OneToMany(mappedBy = "posts")
  private Set<Posts> pos;

@OneToOne(mappedBy = "deps")
private depuser dep ;

  @OneToMany(mappedBy = "forum")
  private Set<Forum> fors;

  @OneToMany(mappedBy = "dd")
  private Set<Dossier> dd;

  @OneToMany(mappedBy = "rec")
  private Set<Reclamation> recs;

  public User() {
  }

  public User(String username, String email, String password,String country , Date birth_date) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.country = country ;
    this.birth_date = birth_date;
  }

  public User(String identifiant, String email, String encode) {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id_condidat) {
    this.id= id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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
  public Date getBirth_date(){ return birth_date;}
  public void setBirth_date(Date birth_date){this.birth_date = birth_date;}
  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

}
