package com.simceel.simceelback.dominio.medicao;

import com.simceel.simceelback.dominio.medicao.MedicaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simceel.simceelback.SimceelBackApplication;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.hasToString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimceelBackApplication.class)
@WebAppConfiguration
@ContextConfiguration
public class MedicaoUnitTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    MedicaoRepository medicaoRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        RestAssuredMockMvc.mockMvc(this.mockMvc);
    }

    @After
    public void finish() {
    }

    @Test
    public void cadastrarComDadosValidos(){

        Medicao medicao = new Medicao();
        medicao.setDescricao("descricao");
        medicao.setPot_Medida("pot_medida");

        BDDMockito.given(this.medicaoRepository.save(any(Medicao.class))).willReturn(medicao);

        given()
                .body(medicao)
                .contentType(ContentType.JSON)
                .when()
                .post("/medicao")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("descricao", equalTo("Pot_Consumida"))
                .body("pot_medida", equalTo("550.2"));

    }



}