package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.response.TutorResponse;
import br.com.eguadorodrigo.adopet.service.TutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@DirtiesContext
class TutorControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @MockBean
    private TutorService service;

    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    @DisplayName("Teste de chamada com sucesso da rota GET para todos os Tutores")
    void deveConsultarTodosOsTutoresComSucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/tutores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(service, times(1)).listarTodos();
    }

    @Test
    @DisplayName("Teste de chamada com sucesso da rota GET para um Tutor por id")
    void deveConsultarUmTutorPorIdComSucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/tutores/{id}",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(service, times(1)).listarPorId(any());
    }

    @Test
    @DisplayName("Teste de chamada com sucesso da rota POST para cadastrar um Tutor")
    void deveCadastrarUmTutorComSucesso() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/tutores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(criarObjetoTutor()))
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(service, times(1)).criar(any());
    }


    @Test
    @DisplayName("Teste de chamada com sucesso da rota PUT para atualizar um Tutor")
    void deveAtualizarUmTutorComSucesso() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/tutores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(criarObjetoTutorParaAtualizar()))
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(service, times(1)).atualizar(any());
    }

    @Test
    @DisplayName("Teste de chamada com sucesso da rota DELETE para excluir um Tutor")
    void deveDeletarUmTutorComSucesso() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/tutores/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        verify(service, times(1)).deletar(any());
    }


    private byte[] criarObjetoTutor() throws JsonProcessingException {
        TutorResponse tutorResponse = new TutorResponse(ConstantesGlobais.SUCESSO_CRIAR_TUTOR_CHAVE, ConstantesGlobais.SUCESSO_CRIAR_TUTOR_VALOR);
        return ow.writeValueAsBytes(tutorResponse);
    }
    private byte[] criarObjetoTutorParaAtualizar() throws JsonProcessingException {
        TutorResponse tutorResponse = new TutorResponse(ConstantesGlobais.SUCESSO_ATUALIZAR_TUTOR_CHAVE, ConstantesGlobais.SUCESSO_ATUALIZAR_TUTOR_VALOR);
        return ow.writeValueAsBytes(tutorResponse);
    }
}
