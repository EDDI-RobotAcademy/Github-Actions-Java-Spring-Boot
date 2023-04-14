package com.example.demo.message.mvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import com.example.demo.aspect.SecurityChecker;
import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.service.BoardServiceImpl;
import com.example.demo.message.controller.MessageController;
import com.example.demo.message.entity.Message;
import com.example.demo.message.repository.MessageRepository;
import com.example.demo.message.service.MessageService;
import com.example.demo.message.service.MessageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@DisplayName("MVC Mocking - Message 테스트")
@WebMvcTest(controllers = { MessageController.class })
@Import({ AopAutoConfiguration.class, SecurityChecker.class })
public class MessageControllerTest {

  @Mock
  private MessageRepository mockMessageRepository;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MessageService mockMessageService;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @DisplayName("Message Post 쓰기 테스트")
  public void 메시지_POST_쓰기_테스트() throws Exception {
    Message firstMessage = new Message("First Message");
    when(mockMessageRepository.save(firstMessage)).thenReturn(new Message("First Message"));

    ObjectMapper objectMapper = new ObjectMapper();
    String message = objectMapper.writeValueAsString(new Message("First Message"));

    mockMvc.perform(post("/messages")
                    .content(message)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Message GET 조회 테스트")
  public void 메시지_GET_조회_테스트() throws Exception {
    Message firstMessage = new Message("First Message");
    List<Message> allMessages = Arrays.asList(firstMessage);
    when(mockMessageService.getMessages()).thenReturn(allMessages);

    mockMvc.perform(MockMvcRequestBuilders.get("/messages/lists"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].text", is(firstMessage.getText())));
  }
}