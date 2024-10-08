package com.example.la.usuario.service;

import com.example.la.soap.*;

import java.util.List;

public interface ServicioPaises {


    public List<TContinent> getContinents();

    public List<TCountryCodeAndName> getPaises();

    public String getCapitalPaisxCodigo(String codigoPais);

    public TCurrency getMonedaxCodigo(String codigoPais);

    public List<TCountryCodeAndName> getPaisesUsandoMoneda(String codigoMoneda);

    public String getBanderaPorPais(String codigoPais);

    public String getCodigoTelefonoxCodigoISO(String codigoPais);

    public String getCodigoISOxPais(String pais);

    public String getPaisxCodigoISO(String codigoPais);

    public String getNombreMonedaxCodigoMoneda(String codigoMoneda);

    public TCountryInfo getDatosPaisxCodigoPais(String codigoPais);

    public List<TCountryInfo> getDatosPaises();

    public String getCodigoLenguajexNombre(String nombreLenguaje);

    public String getNombreLenguajexCodigo(String codigoLenguaje);

    public List<TContinent> getContinentesxCodigo();

    public List<TCountryCodeAndName> getNombrePaisesxCodigo();

    public List<TCountryCodeAndName> getNombrePaisesxNombre();

    public List<TCountryCodeAndNameGroupedByContinent> getListaPaisesxContinente();

    public List<TCurrency> getListaMonedasxCodigo();

    public List<TCurrency> getListaMonedasxNombre();

    public List<TLanguage> getListaLenguajesxCodigo();

    public List<TLanguage> getListaLenguajesxNombre();
}
