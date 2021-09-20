/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.urna.eletronica.common.vo;

/**
 * @author Ilmar Macedo Alves Junior
 * @matricula 201851406603
 *
 * @docente Dr. Oberdan Rocha Pinheiro
 *
 */
public class CandidatoVO {

    private String nome;
    private int numero;
    private String partido;
    private String sigla;
    private int voto;
    /**
     * Construtor
     * @param nome
     * @param numero
     * @param partido
     * @param sigla 
     */
    public CandidatoVO(String nome, int numero, String partido, String sigla) {
        setNome(nome);
        setNumero(numero);
        setPartido(partido);
        setSigla(sigla);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

}
