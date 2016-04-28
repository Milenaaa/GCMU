package GCMU.classes;

import java.sql.SQLException;

import GCMU.DataBase.ChavesDAO;
import GCMU.DataBase.DocenteDAO;

/**
 *
 * @author GCMU Essa classe representa a entidade chave que podera ser reservada
 * por um discente ou docente e ter� as informa��es para que eles saibam a
 * situa��o dessa chave
 */
public class Chaves {

    private String identificacao;
    private int id;
    private String status;
    private DocenteReservaChave docenteReserva;
    private Docente docente;
    private DiscenteReservaChave discenteReserva;
    private Discente discente;

    public Chaves(String identificacao, String status) {

        this.identificacao = identificacao;
        this.status = status;

    }

    public Chaves() {
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the docenteReserva
     */
    public DocenteReservaChave getDocenteReserva() {
        return docenteReserva;
    }

    /**
     * @param docenteReserva the docenteReserva to set
     */
    public void setDocenteReserva(DocenteReservaChave docenteReserva) {
        this.docenteReserva = docenteReserva;
    }

    /**
     * @return the docente
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return the discenteReserva
     */
    public DiscenteReservaChave getDiscenteReserva() {
        return discenteReserva;
    }

    /**
     * @param discenteReserva the discenteReserva to set
     */
    public void setDiscenteReserva(DiscenteReservaChave discenteReserva) {
        this.discenteReserva = discenteReserva;
    }

    /**
     * @return the discente
     */
    public Discente getDiscente() {
        return discente;
    }

    /**
     * @param discente the discente to set
     */
    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

}
