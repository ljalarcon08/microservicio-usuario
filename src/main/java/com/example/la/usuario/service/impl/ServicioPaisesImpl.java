package com.example.la.usuario.service.impl;

import com.example.la.soap.*;
import com.example.la.usuario.service.ServicioPaises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPaisesImpl implements ServicioPaises {

    @Autowired
    private CountryInfoServiceSoapType service;
    

    @Override
    public List<TContinent> getContinents(){
        return service.listOfContinentsByName().getTContinent();
    }

    @Override
    public List<TCountryCodeAndName> getPaises(){
        return service.listOfCountryNamesByName().getTCountryCodeAndName();
    }

    @Override
    public String getCapitalPaisxCodigo(String codigoPais){
        return service.capitalCity(codigoPais);
    }

    @Override
    public TCurrency getMonedaxCodigo(String codigoPais){
        return service.countryCurrency(codigoPais);
    }

    @Override
    public List<TCountryCodeAndName> getPaisesUsandoMoneda(String codigoMoneda){
        return service.countriesUsingCurrency(codigoMoneda).getTCountryCodeAndName();
    }

    @Override
    public String getBanderaPorPais(String codigoPais){

        return service.countryFlag(codigoPais);
    }

    @Override
    public String getCodigoTelefonoxCodigoISO(String codigoPais){

        return service.countryIntPhoneCode(codigoPais);
    }

    @Override
    public String getCodigoISOxPais(String pais){

        return service.countryISOCode(pais);
    }

    @Override
    public String getPaisxCodigoISO(String codigoPais){

        return service.countryName(codigoPais);
    }

    @Override
    public String getNombreMonedaxCodigoMoneda(String codigoMoneda){

        return service.currencyName(codigoMoneda);
    }

    @Override
    public TCountryInfo getDatosPaisxCodigoPais(String codigoPais){

        return service.fullCountryInfo(codigoPais);
    }

    @Override
    public List<TCountryInfo> getDatosPaises(){

        return service.fullCountryInfoAllCountries().getTCountryInfo();
    }

    @Override
    public String getCodigoLenguajexNombre(String nombreLenguaje){

        return service.languageISOCode(nombreLenguaje);
    }

    @Override
    public String getNombreLenguajexCodigo(String codigoLenguaje){

        return service.languageName(codigoLenguaje);
    }

    @Override
    public List<TContinent> getContinentesxCodigo(){

        return service.listOfContinentsByCode().getTContinent();
    }

    @Override
    public List<TCountryCodeAndName> getNombrePaisesxCodigo(){

        return service.listOfCountryNamesByCode().getTCountryCodeAndName();
    }


    @Override
    public List<TCountryCodeAndName> getNombrePaisesxNombre(){

        return service.listOfCountryNamesByName().getTCountryCodeAndName();
    }

    @Override
    public List<TCountryCodeAndNameGroupedByContinent> getListaPaisesxContinente(){

        return service.listOfCountryNamesGroupedByContinent().getTCountryCodeAndNameGroupedByContinent();
    }

    @Override
    public List<TCurrency> getListaMonedasxCodigo(){

        return service.listOfCurrenciesByCode().getTCurrency();
    }

    @Override
    public List<TCurrency> getListaMonedasxNombre(){

        return service.listOfCurrenciesByName().getTCurrency();
    }

    @Override
    public List<TLanguage> getListaLenguajesxCodigo(){

        return service.listOfLanguagesByCode().getTLanguage();
    }

    @Override
    public List<TLanguage> getListaLenguajesxNombre(){

        return service.listOfLanguagesByName().getTLanguage();
    }
}
