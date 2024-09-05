package com.example.la.usuario.controller;


import com.example.la.common.usuario.entity.Rol;
import com.example.la.common.usuario.entity.Usuario;
import com.example.la.common.usuario.service.RolService;
import com.example.la.common.usuario.service.UsuarioService;
import com.example.la.usuario.MicroservicioUsuarioApplication;
import com.example.la.usuario.config.OpenApiConfiguration;
import com.example.la.usuario.proyection.PaginaUsuarioImpl;
import com.example.la.usuario.proyection.UsuarioInterfaceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//test de integracion - requiere conexion a base de datos
@SpringBootTest(classes={MicroservicioUsuarioApplication.class, OpenApiConfiguration.class})
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private BCryptPasswordEncoder bcryp;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public void init() {
        objectMapper = new ObjectMapper();
        Usuario usuario=new Usuario();
    }

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getUsuarioByEmailTest() throws Exception {
        MvcResult result = mvc.perform(get("/email/email@email.com")).andExpect(status().isOk()).andReturn();

        String json = result.getResponse().getContentAsString();

        List<UsuarioInterfaceImpl> usuario = objectMapper.readValue(json, new TypeReference<List<UsuarioInterfaceImpl>>() {
        });

        Assert.notNull(usuario, "OK");
    }

    @Test
    public void getUsuarioByIdTest() throws Exception {
        MvcResult result = mvc.perform(get("/1")).andExpect(status().isOk()).andReturn();

        String json = result.getResponse().getContentAsString();

        UsuarioInterfaceImpl usuario = objectMapper.readValue(json, UsuarioInterfaceImpl.class);

        Assert.notNull(usuario, "OK");
    }

    @Test
    public void getAllUsuariosTest() throws Exception{
        MvcResult result = mvc.perform(get("/")).andExpect(status().isOk()).andReturn();

        String json = result.getResponse().getContentAsString();

        List<UsuarioInterfaceImpl> usuario = objectMapper.readValue(json, new TypeReference<List<UsuarioInterfaceImpl>>() {
        });

        Assert.notNull(usuario, "OK");
    }

    @Test
    public void getPageUsuarioTest() throws Exception{
        MvcResult result = mvc.perform(get("/page?pagina=0&largo=1")).andExpect(status().isOk()).andReturn();

        String json = result.getResponse().getContentAsString();

        PaginaUsuarioImpl pagina = objectMapper.readValue(json, PaginaUsuarioImpl.class);

        Assert.notNull(pagina, "OK");
    }

    @Test
    public void getRolesByIdUsuario() throws Exception {
        MvcResult result = mvc.perform(get("/rol/1")).andExpect(status().isOk()).andReturn();

        String json = result.getResponse().getContentAsString();

        List<Rol> roles = objectMapper.readValue(json, new TypeReference<List<Rol>>() {
        });

        Assert.notNull(roles, "OK");
    }

    @Test
    public void getRoles() throws Exception {
        MvcResult result = mvc.perform(get("/rol")).andExpect(status().isOk()).andReturn();

        String json = result.getResponse().getContentAsString();

        List<Rol> roles = objectMapper.readValue(json, new TypeReference<List<Rol>>() {
        });

        Assert.notNull(roles, "OK");
    }
}
