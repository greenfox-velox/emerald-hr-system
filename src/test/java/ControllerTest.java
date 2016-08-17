import com.Emerald.hrSystem.fsfsf;
import com.Emerald.hrSystem.Model.User;
import com.Emerald.hrSystem.Model.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by pocok on 8/14/16.
 */
public class ControllerTest {

  @Mock
  private UserDAO userDAO;


  @InjectMocks
  private fsfsf controller;

  private MockMvc mockMvc;


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("resources/templates/");
    viewResolver.setSuffix(".html");


    mockMvc = MockMvcBuilders.standaloneSetup(controller)
                            .setViewResolvers(viewResolver)
                            .build();
  }

  @Test
  public void testList() throws Exception{
    List<User> users = new ArrayList<>();
    users.add(new User());
    users.add(new User());

    when(userDAO.list()).thenReturn((List) users);

    mockMvc.perform(get("/users"))
            .andExpect(status().isOk())
            .andExpect(view().name("users"))
            .andExpect(model().attribute("userDb", hasSize(2)));

  }

  @Test
  public void testRegistrationGet() throws Exception{

    mockMvc.perform(get("/registration"))
        .andExpect(status().isOk())
        .andExpect(view().name("registration"))
        .andExpect(model().attribute("newUser", instanceOf(User.class)));

  }

  @Test
  public void testDeleteUser() throws Exception{

    userDAO.saveOrUpdate(new User());

    mockMvc.perform(post("/delete/1"))
        .andExpect(status().is(201))
        .andExpect(content().string("Deleted!"));

  }

  @Test
  public void testRegister() throws Exception{

    String userName = "TestUser";
    String password = "test12341234";
    String email = "test@test.com";
    String passwordConfirm = "test12341234";

    RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/registration")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("userName", userName)
        .param("password", password)
        .param("email", email)
        .param("passwordConfirm", passwordConfirm);

    mockMvc.perform(reqBuilder)
        .andExpect(status().isOk())
        .andExpect(view().name("welcome"));

  }


}
