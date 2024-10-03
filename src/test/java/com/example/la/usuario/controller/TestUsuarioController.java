package com.example.la.usuario.controller;

import com.example.la.common.usuario.entity.Rol;
import com.example.la.common.usuario.entity.Usuario;
import com.example.la.common.usuario.service.RolService;
import com.example.la.common.usuario.service.UsuarioService;
import com.example.la.usuario.MicroservicioUsuarioApplication;
import com.example.la.usuario.config.OpenApiConfiguration;
import com.example.la.usuario.domain.RequestImagen;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Test unitario
@SpringBootTest(classes={MicroservicioUsuarioApplication.class, OpenApiConfiguration.class})
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUsuarioController {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private RolService rolService;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public void init() {
        objectMapper = new ObjectMapper();
        Usuario usuario=new Usuario();
    }

    @Test
    public void actualizarUsuario() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setName("nombre");
        usuario.setEmail("email");
        usuario.setPassword("passw");

        Mockito.when(usuarioService.actualizarUsuario(any(Usuario.class))).thenReturn(usuario);

        String content=objectMapper.writeValueAsString(usuario);
        MvcResult result = mvc.perform(put("/actualizar/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201)).andReturn();

        String json = result.getResponse().getContentAsString();

        Usuario usuarioAct = objectMapper.readValue(json, Usuario.class);

        Assert.notNull(usuarioAct, "OK");
    }

    @Test
    public void actualizarUsuarioPass1() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setName("nombre");
        usuario.setEmail("email");

        Mockito.when(usuarioService.actualizarUsuario(any(Usuario.class))).thenReturn(usuario);

        String content=objectMapper.writeValueAsString(usuario);
        MvcResult result = mvc.perform(put("/actualizar/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201)).andReturn();

        String json = result.getResponse().getContentAsString();

        Usuario usuarioAct = objectMapper.readValue(json, Usuario.class);

        Assert.notNull(usuarioAct, "OK");
    }

    @Test
    public void actualizarUsuarioPass2() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setName("nombre");
        usuario.setEmail("email");
        usuario.setPassword("");

        Mockito.when(usuarioService.actualizarUsuario(any(Usuario.class))).thenReturn(usuario);

        String content=objectMapper.writeValueAsString(usuario);
        MvcResult result = mvc.perform(put("/actualizar/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201)).andReturn();

        String json = result.getResponse().getContentAsString();

        Usuario usuarioAct = objectMapper.readValue(json, Usuario.class);

        Assert.notNull(usuarioAct, "OK");
    }

    @Test
    public void actualizarUsuarioError() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setName("nombre");
        usuario.setEmail("email");
        usuario.setPassword("passw");

        Mockito.when(usuarioService.actualizarUsuario(any(Usuario.class))).thenReturn(null);

        String content=objectMapper.writeValueAsString(usuario);
        MvcResult result = mvc.perform(put("/actualizar/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404)).andReturn();

        String json = result.getResponse().getContentAsString();

        Assert.state(!StringUtils.hasLength(json),"OK");
    }

    @Test
    public void crearRol() throws Exception{
        Rol rol=new Rol();
        rol.setName("nombre");

        String content=objectMapper.writeValueAsString(rol);
        Mockito.when(rolService.crearRol(any(Rol.class))).thenReturn(rol);

        MvcResult result = mvc.perform(post("/rol").contentType(MediaType.APPLICATION_JSON)
                .content(content)).andExpect(status().is(201)).andReturn();

        String json=result.getResponse().getContentAsString();

        Rol rolAct = objectMapper.readValue(json, Rol.class);

        Assert.notNull(rolAct,"OK");
    }

    @Test
    public void crearRolError() throws Exception{
        Rol rol=new Rol();
        rol.setName("nombre");

        String content=objectMapper.writeValueAsString(rol);
        Mockito.when(rolService.crearRol(any(Rol.class))).thenReturn(null);

        mvc.perform(post("/rol").contentType(MediaType.APPLICATION_JSON)
                .content(content)).andExpect(status().is(500));

    }

    @Test
    public void actualizarImagen() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setName("nombre");
        usuario.setEmail("email");
        usuario.setPassword("passw");

        Mockito.when(usuarioService.actualizaImagenUsuario(any(Long.class),anyString())).thenReturn(usuario);

        RequestImagen request=new RequestImagen();
        request.setImagen("img");

        String content=objectMapper.writeValueAsString(request);

        MvcResult result = mvc.perform(put("/actualizarImagen/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201)).andReturn();

        String json = result.getResponse().getContentAsString();

        Usuario usuarioAct = objectMapper.readValue(json, Usuario.class);

        Assert.notNull(usuarioAct, "OK");
    }

    @Test
    public void actualizarImagenError() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setName("nombre");
        usuario.setEmail("email");
        usuario.setPassword("passw");

        Mockito.when(usuarioService.actualizaImagenUsuario(any(Long.class),anyString())).thenReturn(null);

        RequestImagen request=new RequestImagen();
        request.setImagen("img");

        String content=objectMapper.writeValueAsString(request);

        MvcResult result = mvc.perform(put("/actualizarImagen/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404)).andReturn();

        String json = result.getResponse().getContentAsString();

        Assert.state(!StringUtils.hasLength(json),"OK");
    }

    @Test
    public void actualizarRol() throws Exception{
        Rol rol = new Rol();
        rol.setName("nombre");

        Mockito.when(rolService.actualizarRol(any(Rol.class))).thenReturn(rol);

        String content=objectMapper.writeValueAsString(rol);
        MvcResult result = mvc.perform(put("/rol/actualizar/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201)).andReturn();

        String json = result.getResponse().getContentAsString();

        Usuario usuarioAct = objectMapper.readValue(json, Usuario.class);

        Assert.notNull(usuarioAct, "OK");

    }

    @Test
    public void actualizarRolError() throws Exception{
        Rol rol = new Rol();
        rol.setName("nombre");

        Mockito.when(rolService.actualizarRol(any(Rol.class))).thenReturn(null);

        String content=objectMapper.writeValueAsString(rol);
        MvcResult result = mvc.perform(put("/rol/actualizar/13")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404)).andReturn();

        String json = result.getResponse().getContentAsString();

        Assert.state(!StringUtils.hasLength(json),"OK");

    }

    @Test
    public void deleteUsuario() throws Exception{
        Mockito.doNothing().when(usuarioService).eliminarUsuario(any(Long.class));
        mvc.perform(delete("/eliminar/1")).andExpect(status().isOk());
    }

    @Test
    public void eliminarRol() throws Exception{
        Mockito.doNothing().when(rolService).eliminarRol(any(Long.class));
        mvc.perform(delete("/rol/eliminar/1")).andExpect(status().isOk());
    }
}
