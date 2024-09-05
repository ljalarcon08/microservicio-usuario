package com.example.la.usuario.proyection;

import com.example.la.common.usuario.proyection.UsuarioInterface;

import java.util.List;

public class PaginaUsuarioImpl {

    private Long totalRegistros;
    private List<UsuarioInterfaceImpl> usuarios;

    public Long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public List<UsuarioInterfaceImpl> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioInterfaceImpl> usuarios) {
        this.usuarios = usuarios;
    }
}
