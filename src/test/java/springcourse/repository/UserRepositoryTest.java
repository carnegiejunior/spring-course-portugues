package springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import springcourse.domain.User;
import springcourse.domain.enums.Role;

@SpringBootTest
@DisplayName("Teste de repositórios de usuário")
class UserRepositoryTest {

	@Autowired UserRepository userRepository;
	final static String USER_NAME_1 = "USER_TEST_ID_1";
	final static String USER_NAME_2 = "USER_TEST_ID_2";
	final static String EMAIL_USER = "EMAIL_FOR_USER_TEST@TESTE.LOCAL";

	
//    @Before  
//    public void setup() {  
//       // Locale.setDefault(new Locale("en", "US"));  
//    }  
//  
//    @After  
//    public void cleanUp() {  
//        //Locale.setDefault(localeOriginal);  
//    }  
	
	@Test
	void deve_RetornaUsuarioLogado_Test() {
		
		User user1Entity = new User(null,USER_NAME_1,EMAIL_USER,"123",Role.ADMINISTRATOR,null,null);
		
		this.userRepository.save(user1Entity);
		
		Optional<User> loggedUser = userRepository.login(EMAIL_USER, "123");
		
		assertThat(loggedUser.get().getEmail()).isEqualTo(EMAIL_USER);
		
		this.userRepository.delete(loggedUser.get());
	
	}
	

}