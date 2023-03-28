package br.com.eguadordorigo.adopet.controller;

import br.com.eguadordorigo.adopet.model.dto.TutorDto;
import br.com.eguadordorigo.adopet.service.TutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TutorController.class)
@ActiveProfiles("test")
class TutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TutorService service;

    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    void deveConsultarTodosOsTutoresComSucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tutores"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deveCadastrarUmTutorComSucesso() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/tutores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createTutor()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private byte[] createTutor() throws JsonProcessingException {
        TutorDto tutorDto = new TutorDto();
        tutorDto.setNome("Teste");
        tutorDto.setEmail("teste@teste.com");
        tutorDto.setSenha("Teste123");
        return ow.writeValueAsBytes(tutorDto);
    }

}