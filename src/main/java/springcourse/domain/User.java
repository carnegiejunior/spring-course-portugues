package springcourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springcourse.domain.enums.Role;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	@Getter(onMethod = @__({@JsonIgnore}))
	@Setter(onMethod = @__({@JsonProperty}))
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@Getter(onMethod = @__({@JsonIgnore}))
	@Setter(onMethod = @__({@JsonProperty}))
	@OneToMany(mappedBy = "owner")
	private List<Request> requests = new ArrayList<>();
	
	@Getter(onMethod = @__({@JsonIgnore}))
	@Setter(onMethod = @__({@JsonProperty}))
	@OneToMany(mappedBy = "owner")
	private List<RequestStage> stages = new ArrayList<>();
	
}
