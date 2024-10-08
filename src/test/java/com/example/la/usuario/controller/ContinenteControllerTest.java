package com.example.la.usuario.controller;

import com.example.la.soap.*;
import com.example.la.usuario.domain.RespuestaValor;
import com.example.la.usuario.service.ServicioPaises;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class ContinenteControllerTest {

    @InjectMocks
    private ContinenteController continenteController;

    @Mock
    private ServicioPaises servicioPaises;

    @Test
    public void getContinentesTest(){
        Mockito.when(servicioPaises.getContinents()).thenReturn(new ArrayList<TContinent>());
        List<TContinent> respuesta = continenteController.getContinentes();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getPaisesTest(){
        Mockito.when(servicioPaises.getPaises()).thenReturn(new ArrayList<TCountryCodeAndName>());
        List<TCountryCodeAndName> respuesta = continenteController.getPaises();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCapitalPaisxCodigoTest(){
        Mockito.when(servicioPaises.getCapitalPaisxCodigo(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getCapitalPaisxCodigo("codigo");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getMonedaPaisxCodigoTest(){
        Mockito.when(servicioPaises.getMonedaxCodigo(anyString())).thenReturn(new TCurrency());
        TCurrency respuesta = continenteController.getMonedaPaisxCodigo("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getPaisesUsandoMonedaTest(){
        Mockito.when(servicioPaises.getPaisesUsandoMoneda(anyString())).thenReturn(new ArrayList<TCountryCodeAndName>());
        List<TCountryCodeAndName> respuesta = continenteController.getPaisesUsandoMoneda("codigoMoneda");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getBanderaPorPaisTest(){
        Mockito.when(servicioPaises.getBanderaPorPais(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getBanderaPorPais("codigo");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCodigoTelefonoxCodigoISOTest(){
        Mockito.when(servicioPaises.getCodigoTelefonoxCodigoISO(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getCodigoTelefonoxCodigoISO("codigo");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCodigoISOxPaisTest(){
        Mockito.when(servicioPaises.getCodigoISOxPais(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getCodigoISOxPais("codigo");
        Assert.notNull(respuesta,"error");
    }


    @Test
    public void getPaisxCodigoISOTest(){
        Mockito.when(servicioPaises.getPaisxCodigoISO(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getPaisxCodigoISO("codigo");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombreMonedaxCodigoMonedaTest(){
        Mockito.when(servicioPaises.getNombreMonedaxCodigoMoneda(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getNombreMonedaxCodigoMoneda("codigo");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getDatosPaisxCodigoPaisTest(){
        Mockito.when(servicioPaises.getDatosPaisxCodigoPais(anyString())).thenReturn(new TCountryInfo());
        TCountryInfo respuesta = continenteController.getDatosPaisxCodigoPais("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getDatosPaisesTest(){
        Mockito.when(servicioPaises.getDatosPaises()).thenReturn(new ArrayList<TCountryInfo>());
        List<TCountryInfo> respuesta = continenteController.getDatosPaises();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCodigoLenguajexNombreTest(){
        Mockito.when(servicioPaises.getCodigoLenguajexNombre(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getCodigoLenguajexNombre("codigo");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombreLenguajexCodigoTest(){
        Mockito.when(servicioPaises.getNombreLenguajexCodigo(anyString())).thenReturn("String");
        RespuestaValor respuesta = continenteController.getNombreLenguajexCodigo("codigo");
        Assert.state("String".equals(respuesta.getValor()),"error");
    }

    @Test
    public void getContinentesxCodigoTest(){
        Mockito.when(servicioPaises.getContinentesxCodigo()).thenReturn(new ArrayList<TContinent>());
        List<TContinent> respuesta = continenteController.getContinentesxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombrePaisesxCodigoTest(){
        Mockito.when(servicioPaises.getNombrePaisesxCodigo()).thenReturn(new ArrayList<TCountryCodeAndName>());
        List<TCountryCodeAndName> respuesta = continenteController.getNombrePaisesxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombrePaisesxNombreTest(){
        Mockito.when(servicioPaises.getNombrePaisesxNombre()).thenReturn(new ArrayList<TCountryCodeAndName>());
        List<TCountryCodeAndName> respuesta = continenteController.getNombrePaisesxNombre();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaPaisesxContinenteTest(){
        Mockito.when(servicioPaises.getListaPaisesxContinente()).thenReturn(new ArrayList<TCountryCodeAndNameGroupedByContinent>());
        List<TCountryCodeAndNameGroupedByContinent> respuesta = continenteController.getListaPaisesxContinente();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaMonedasxCodigoTest(){
        Mockito.when(servicioPaises.getListaMonedasxCodigo()).thenReturn(new ArrayList<TCurrency>());
        List<TCurrency> respuesta = continenteController.getListaMonedasxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaMonedasxNombreTest(){
        Mockito.when(servicioPaises.getListaMonedasxNombre()).thenReturn(new ArrayList<TCurrency>());
        List<TCurrency> respuesta = continenteController.getListaMonedasxNombre();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaLenguajesxCodigoTest(){
        Mockito.when(servicioPaises.getListaLenguajesxCodigo()).thenReturn(new ArrayList<TLanguage>());
        List<TLanguage> respuesta = continenteController.getListaLenguajesxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaLenguajesxNombreTest(){
        Mockito.when(servicioPaises.getListaLenguajesxNombre()).thenReturn(new ArrayList<TLanguage>());
        List<TLanguage> respuesta = continenteController.getListaLenguajesxNombre();
        Assert.notNull(respuesta,"error");
    }
}
