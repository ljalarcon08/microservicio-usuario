package com.example.la.usuario.service.impl;

import com.example.la.soap.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class ServicioPaisesImplTest {

    @InjectMocks
    private ServicioPaisesImpl servicioPaises;

    @Mock
    private CountryInfoServiceSoapType service;

    @Test
    public void getContinentsTest(){
        Mockito.when(service.listOfContinentsByName()).thenReturn(new ArrayOftContinent());
        List<TContinent> respuesta = servicioPaises.getContinents();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getPaisesTest(){
        Mockito.when(service.listOfCountryNamesByName()).thenReturn(new ArrayOftCountryCodeAndName());
        List<TCountryCodeAndName> respuesta = servicioPaises.getPaises();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCapitalPaisxCodigoTest(){
        Mockito.when(service.capitalCity(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getCapitalPaisxCodigo("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getMonedaxCodigoTest(){
        Mockito.when(service.countryCurrency(anyString())).thenReturn(new TCurrency());
        TCurrency respuesta = servicioPaises.getMonedaxCodigo("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getPaisesUsandoMonedaTest(){
        Mockito.when(service.countriesUsingCurrency(anyString())).thenReturn(new ArrayOftCountryCodeAndName());
        List<TCountryCodeAndName> respuesta = servicioPaises.getPaisesUsandoMoneda("codigoMoneda");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getBanderaPorPaisTest(){
        Mockito.when(service.countryFlag(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getBanderaPorPais("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCodigoTelefonoxCodigoISOTest(){
        Mockito.when(service.countryIntPhoneCode(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getCodigoTelefonoxCodigoISO("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCodigoISOxPaisTest(){
        Mockito.when(service.countryISOCode(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getCodigoISOxPais("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getPaisxCodigoISOTest(){
        Mockito.when(service.countryName(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getPaisxCodigoISO("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombreMonedaxCodigoMonedaTest(){
        Mockito.when(service.currencyName(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getNombreMonedaxCodigoMoneda("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getDatosPaisxCodigoPaisTest(){
        Mockito.when(service.fullCountryInfo(anyString())).thenReturn(new TCountryInfo());
        TCountryInfo respuesta = servicioPaises.getDatosPaisxCodigoPais("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getDatosPaisesTest(){
        Mockito.when(service.fullCountryInfoAllCountries()).thenReturn(new ArrayOftCountryInfo());
        List<TCountryInfo> respuesta = servicioPaises.getDatosPaises();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getCodigoLenguajexNombreTest(){
        Mockito.when(service.languageISOCode(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getCodigoLenguajexNombre("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombreLenguajexCodigoTest(){
        Mockito.when(service.languageName(anyString())).thenReturn("String");
        String respuesta = servicioPaises.getNombreLenguajexCodigo("codigoPais");
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getContinentesxCodigoTest(){
        Mockito.when(service.listOfContinentsByCode()).thenReturn(new ArrayOftContinent());
        List<TContinent> respuesta = servicioPaises.getContinentesxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombrePaisesxCodigoTest(){
        Mockito.when(service.listOfCountryNamesByCode()).thenReturn(new ArrayOftCountryCodeAndName());
        List<TCountryCodeAndName> respuesta = servicioPaises.getNombrePaisesxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getNombrePaisesxNombreTest(){
        Mockito.when(service.listOfCountryNamesByName()).thenReturn(new ArrayOftCountryCodeAndName());
        List<TCountryCodeAndName> respuesta = servicioPaises.getNombrePaisesxNombre();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaPaisesxContinenteTest(){
        Mockito.when(service.listOfCountryNamesGroupedByContinent()).thenReturn(new ArrayOftCountryCodeAndNameGroupedByContinent());
        List<TCountryCodeAndNameGroupedByContinent> respuesta = servicioPaises.getListaPaisesxContinente();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaMonedasxCodigoTest(){
        Mockito.when(service.listOfCurrenciesByCode()).thenReturn(new ArrayOftCurrency());
        List<TCurrency> respuesta = servicioPaises.getListaMonedasxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaMonedasxNombreTest(){
        Mockito.when(service.listOfCurrenciesByName()).thenReturn(new ArrayOftCurrency());
        List<TCurrency> respuesta = servicioPaises.getListaMonedasxNombre();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaLenguajesxCodigoTest(){
        Mockito.when(service.listOfLanguagesByCode()).thenReturn(new ArrayOftLanguage());
        List<TLanguage> respuesta = servicioPaises.getListaLenguajesxCodigo();
        Assert.notNull(respuesta,"error");
    }

    @Test
    public void getListaLenguajesxNombreTest(){
        Mockito.when(service.listOfLanguagesByName()).thenReturn(new ArrayOftLanguage());
        List<TLanguage> respuesta = servicioPaises.getListaLenguajesxNombre();
        Assert.notNull(respuesta,"error");
    }
}
