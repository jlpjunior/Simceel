package com.simceel.simceelback.dominio.usuario;


import com.simceel.simceelback.SimceelBackApplication;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimceelBackApplication.class)
@WebAppConfiguration
@ContextConfiguration
public class UsuarioIntegrationTest {

    @Autowired
    WebApplicationContext webApplicationContext;

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
    public void cadastrarComDadosValidos() throws IOException {

        Usuario usuario = new Usuario();
        usuario.setNome("nome");
        usuario.setCPF("cpf");

        given()
            .body(usuario)
            .contentType(ContentType.JSON)
        .when()
            .post("/usuario")
        .then()
            .statusCode(HttpStatus.CREATED.value())
            .body("nome", equalTo("LeoGodoi"))
            .body("cpf", equalTo("711498523"));

    }



}
