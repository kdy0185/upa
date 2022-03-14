package study.subject.upa.domain.dataparse.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * @Class : DataParseControllerTest
 * @Author : KDW
 * @Date : 2022-03-12
 * @Description : Controller 관련 테스트 Class
 */
@SpringBootTest
class DataParseControllerTest {

    @Autowired
    private DataParseController dataParseController;
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(dataParseController).build();
    }

    @Test
    @DisplayName("형식에 맞지 않은 입력 데이터 테스트")
    public void inValidJsonData() throws Exception {
//        String jsonData = "";
//        String jsonData = "abcd1234";
//        String jsonData = "{abcd1234}";
        String jsonData = "{\"abcd\"}";

        mockMvc.perform(get("/api/dataParsing")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
            .andExpect(
                result -> assertTrue(
                    Objects.requireNonNull(result.getResolvedException()).getClass()
                        .isAssignableFrom(HttpMessageNotReadableException.class)
                )
            ).andReturn();
    }

    @Test
    @DisplayName("올바르지 않은 입력 데이터 테스트")
    public void notValidJsonData() throws Exception {
//        String jsonData = "{\"a\" : \"b\"}";
        String jsonData = "{\"url\" : \"abcd\"}";

        mockMvc.perform(get("/api/dataParsing")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
            .andExpect(
                result -> assertTrue(
                    Objects.requireNonNull(result.getResolvedException()).getClass()
                        .isAssignableFrom(MethodArgumentNotValidException.class)
                )
            ).andReturn();
    }

    @Test
    @DisplayName("정상 처리 테스트")
    public void validJsonData() throws Exception {
        String jsonData = "{\n"
            + "    \"url\" : \"http://google.com/\",\n"
            + "    \"dataType\" : \"H\",\n"
            + "    \"unit\" : 20\n"
            + "}";

        mockMvc.perform(get("/api/dataParsing")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
            .andExpect(status().isOk());
    }
}
