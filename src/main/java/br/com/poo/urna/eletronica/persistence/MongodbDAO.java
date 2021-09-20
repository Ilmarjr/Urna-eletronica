/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo.urna.eletronica.persistence;

import br.com.poo.urna.eletronica.common.vo.CandidatoVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * @author Ilmar Macedo Alves Junior
 * @matricula 201851406603
 *
 * @docente Dr. Oberdan Rocha Pinheiro
 *
 */
public class MongodbDAO {

    /**
     * Conexão ao MongoDB
     *
     * @return
     */
    private DBCollection connection() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        DB database = mongoClient.getDB("poo2");
        DBCollection collection = database.getCollection("candidato");
        return collection;
    }

    /*
    * @param num
    * @return
    */
    public CandidatoVO findByNumber(int num) {
        DBObject query = new BasicDBObject("numero", num);
        DBCursor cursor = connection().find(query);
        DBObject candidato = cursor.one();

        if (candidato == null) {
            return null;
        }

        Double numDB = (Double) candidato.get("numero");
        CandidatoVO vo = new CandidatoVO((String) candidato.get("nome"),
                numDB.intValue(),
                (String) candidato.get("partido"),
                (String) candidato.get("sigla"));
        vo.setVoto((int) candidato.get("votos"));
        return vo;
    }
    /**
     * Encontrar o partido 
     * @param sigla
     * @return 
     */
    public CandidatoVO findPartido(String sigla) {
        DBObject query = new BasicDBObject("sigla", sigla);
        DBCursor cursor = connection().find(query);
        DBObject candidato = cursor.one();

        if (candidato == null) {
            return null;
        }

        Double numDB = (Double) candidato.get("numero");
        CandidatoVO vo = new CandidatoVO((String) candidato.get("nome"),
                numDB.intValue(),
                (String) candidato.get("partido"),
                (String) candidato.get("sigla"));
        vo.setVoto((int) candidato.get("votos"));
        return vo;
    }
    /**
     * Adicionar voto ao MongoDB
     * @param numCandidato 
     */
    public void updateVoto(int numCandidato) {
        DBCursor cursor = connection().find(new BasicDBObject("numero", numCandidato));
        DBObject candidato = cursor.one();

        int voto = ((int) candidato.get("votos"));
        voto++;
        connection().update(new BasicDBObject("numero", numCandidato),
                new BasicDBObject("$set", new BasicDBObject("votos", voto)));
    }
    /**
     * Zerar os votos no MongoDB
     */
    public void zerarContagem() {
        connection().updateMulti(new BasicDBObject("votos", new BasicDBObject("$gte", 0)),
                new BasicDBObject("$set", new BasicDBObject("votos", 0)));
    }
}
