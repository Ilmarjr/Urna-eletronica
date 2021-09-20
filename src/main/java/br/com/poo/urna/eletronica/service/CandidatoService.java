/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.urna.eletronica.service;

import br.com.poo.urna.eletronica.common.exception.BusinessException;
import br.com.poo.urna.eletronica.common.vo.CandidatoVO;
import br.com.poo.urna.eletronica.persistence.MongodbDAO;

/**
 * @author Ilmar Macedo Alves Junior
 * @matricula 201851406603
 *
 * @docente Dr. Oberdan Rocha Pinheiro
 *
 */
public class CandidatoService {

    MongodbDAO dao = new MongodbDAO();

    public CandidatoVO findByNumber(int num) throws BusinessException {
        CandidatoVO vo = dao.findByNumber(num);

        if (vo == null) {
            throw new BusinessException("Numero Errado");
        }
        return vo;
    }
    /**
     * 
     * @param num
     * @return
     * @throws BusinessException 
     */
    public CandidatoVO findPartido(int num) throws BusinessException {
        CandidatoVO vo = null;
        if (num == 91) {
            vo = dao.findPartido("PEsp");
            return vo;
        } else if (num == 92) {
            vo = dao.findPartido("PMus");
            return vo;
        } else if (num == 93) {
            vo = dao.findPartido("PProf");
            return vo;
        } else if (num == 94) {
            vo = dao.findPartido("PFest");
            return vo;
        } else if (num == 95) {
            vo = dao.findPartido("PFolc");
            return vo;
        }

        if (vo == null) {
            throw new BusinessException("Numero Errado");
        }
        return vo;
    }
    /**
     * 
     * @param num 
     */
    public void updateVoto(int num) {
        dao.updateVoto(num);
    }
    
    public void zerarContagem() {
        dao.zerarContagem();
    }
}
