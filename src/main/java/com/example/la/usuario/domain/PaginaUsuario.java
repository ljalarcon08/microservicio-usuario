package com.example.la.usuario.domain;

import com.example.la.common.usuario.proyection.UsuarioInterface;

import java.util.List;

public class PaginaUsuario {

    private Long totalRegistros;
    private List<UsuarioInterface> usuarios;

    public Long getTotalRegistros() {
        return totalRegistros;
    }
    public void setTotalRegistros(Long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
    public List<UsuarioInterface> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<UsuarioInterface> usuarios) {
        this.usuarios = usuarios;
    }


}
