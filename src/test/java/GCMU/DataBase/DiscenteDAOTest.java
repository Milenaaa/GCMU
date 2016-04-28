
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Discente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiscenteDAOTest {
    
    Discente discente;
    
    public DiscenteDAOTest() {

    }

  @Before
    public void setUp() {
        
        discente = new Discente (12345, "Informatica", "Geraldo", "geraldomota@gmail.com", "Todas");       
    }

   /**
     * Test of insert method, of class DiscenteDAO.
     */
    @Test
    public void testInsert() throws Exception {
       
     
        DiscenteDAO instance = new DiscenteDAO();
        instance.insert(discente);
        System.out.println("Inserido!"); 
    }
   /**
     * Test of read method, of class DiscenteDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        DiscenteDAO instance = new DiscenteDAO();
        assertTrue(instance.read()!= null);
    }

    /**
     * Test of read2 method, of class DiscenteDAO.
     */
    @Test
    public void testRead2() throws Exception {
      
        DiscenteDAO instance = new DiscenteDAO ();
        assertTrue(instance.read2(discente)!= null);
    }

   /**
     * Test of delete method, of class DiscenteDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DiscenteDAO instance = new DiscenteDAO();
        instance.delete(discente);     
    }

    /**
     * Test of update method, of class DiscenteDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        discente.setCurso("Mineração");
        DiscenteDAO instance = new DiscenteDAO();
        instance.update(discente);
    }   
}