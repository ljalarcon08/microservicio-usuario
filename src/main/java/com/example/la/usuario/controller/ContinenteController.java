package com.example.la.usuario.controller;

import com.example.la.soap.*;
import com.example.la.usuario.domain.RespuestaValor;
import com.example.la.usuario.service.ServicioPaises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/continente")
public class ContinenteController {

    @Autowired
    private ServicioPaises servicioPaises;

    @GetMapping()
    public List<TContinent> getContinentes(){
        return servicioPaises.getContinents();
    }

    @GetMapping("/paises")
    public List<TCountryCodeAndName> getPaises(){
        return servicioPaises.getPaises();
    }

    @GetMapping("/paises/capital/{codigo}")
    public RespuestaValor getCapitalPaisxCodigo(@PathVariable String codigo){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getCapitalPaisxCodigo(codigo));
        return respuesta;
    }

    @GetMapping("/paises/moneda/codigoPais/{codigoPais}")
    public TCurrency getMonedaPaisxCodigo(@PathVariable String codigoPais){
        return servicioPaises.getMonedaxCodigo(codigoPais);
    }

    @GetMapping("/paises/moneda/codigoMoneda/{codigoMoneda}")
    public List<TCountryCodeAndName> getPaisesUsandoMoneda(@RequestParam String codigoMoneda){
        return servicioPaises.getPaisesUsandoMoneda(codigoMoneda);
    }

    @GetMapping("/paises/bandera/{codigoPais}")
    public RespuestaValor getBanderaPorPais(@PathVariable String codigoPais){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getBanderaPorPais(codigoPais));
        return respuesta;
    }

    @GetMapping("/paises/codigoTel/{codigoPais}")
    public RespuestaValor getCodigoTelefonoxCodigoISO(@PathVariable String codigoPais){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getCodigoTelefonoxCodigoISO(codigoPais));
        return respuesta;
    }

    @GetMapping("/paises/ISO/{pais}")
    public RespuestaValor getCodigoISOxPais(@PathVariable String pais){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getCodigoISOxPais(pais));
        return respuesta;
    }

    @GetMapping("/paises/nombre/{codigoPais}")
    public RespuestaValor getPaisxCodigoISO(@PathVariable String codigoPais){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getPaisxCodigoISO(codigoPais));
        return respuesta;
    }

    @GetMapping("/paises/paisxmoneda/{codigoMoneda}")
    public RespuestaValor getNombreMonedaxCodigoMoneda(@PathVariable String codigoMoneda){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getNombreMonedaxCodigoMoneda(codigoMoneda));
        return respuesta;
    }

    @GetMapping("/paises/datos/{codigoPais}")
    public TCountryInfo getDatosPaisxCodigoPais(@PathVariable String codigoPais){
        return servicioPaises.getDatosPaisxCodigoPais(codigoPais);
    }

    @GetMapping("/paises/datos")
    public List<TCountryInfo> getDatosPaises(){
        return servicioPaises.getDatosPaises();
    }

    @GetMapping("/paises/lenguaje/nombre/{nombreLenguaje}")
    public RespuestaValor getCodigoLenguajexNombre(@PathVariable String nombreLenguaje){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getCodigoLenguajexNombre(nombreLenguaje));
        return respuesta;
    }

    @GetMapping("/paises/lenguaje/codigo/{codigoLenguaje}")
    public RespuestaValor getNombreLenguajexCodigo(@PathVariable String codigoLenguaje){
        RespuestaValor respuesta=new RespuestaValor();
        respuesta.setValor(servicioPaises.getNombreLenguajexCodigo(codigoLenguaje));
        return respuesta;
    }

    @GetMapping("/codigo")
    public List<TContinent> getContinentesxCodigo(){
        return servicioPaises.getContinentesxCodigo();
    }

    @GetMapping("/paises/ordencodigo")
    public List<TCountryCodeAndName> getNombrePaisesxCodigo(){
        return servicioPaises.getNombrePaisesxCodigo();
    }

    @GetMapping("/paises/ordennombre")
    public List<TCountryCodeAndName> getNombrePaisesxNombre(){
        return servicioPaises.getNombrePaisesxNombre();
    }

    @GetMapping("/paises/grupo")
    public List<TCountryCodeAndNameGroupedByContinent> getListaPaisesxContinente(){
        return servicioPaises.getListaPaisesxContinente();
    }

    @GetMapping("/monedas/codigo")
    public List<TCurrency> getListaMonedasxCodigo(){
        return servicioPaises.getListaMonedasxCodigo();
    }

    @GetMapping("/monedas/nombre")
    public List<TCurrency> getListaMonedasxNombre(){
        return servicioPaises.getListaMonedasxNombre();
    }

    @GetMapping("/lenguaje/codigo")
    public List<TLanguage> getListaLenguajesxCodigo(){
        return servicioPaises.getListaLenguajesxCodigo();
    }

    @GetMapping("/lenguaje/nombre")
    public List<TLanguage> getListaLenguajesxNombre(){
        return servicioPaises.getListaLenguajesxNombre();
    }
}
