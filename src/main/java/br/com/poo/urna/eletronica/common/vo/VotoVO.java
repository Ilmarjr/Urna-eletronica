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
public class VotoVO {
    private int candidato;
    private int voto = 0;
    /**
     * 
     * @param numCandidato 
     */
    public VotoVO(int numCandidato){
        setCandidato(numCandidato);
    }
    
    public void updateVoto(){
        voto++;
    }

    public int getCandidato() {
        return candidato;
    }

    public void setCandidato(int candidato) {
        this.candidato = candidato;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    
}
