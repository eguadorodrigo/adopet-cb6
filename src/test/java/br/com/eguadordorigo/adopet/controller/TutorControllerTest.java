package br.com.eguadordorigo.adopet.controller;

import br.com.eguadordorigo.adopet.model.dto.TutorDto;
import br.com.eguadordorigo.adopet.service.TutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


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
        TutorDto tutorDto = new TutorDto();
        tutorDto.setNome("Teste");
        tutorDto.setEmail("teste@teste.com");
        tutorDto.setSenha("Teste123");
        return ow.writeValueAsBytes(tutorDto);
    }
    private byte[] criarObjetoTutorParaAtualizar() throws JsonProcessingException {
        TutorDto tutorDto = new TutorDto();
        tutorDto.setNome("Teste");
        tutorDto.setEmail("teste@teste.com");
        tutorDto.setSenha("Teste123");
        return ow.writeValueAsBytes(tutorDto);
    }
}
