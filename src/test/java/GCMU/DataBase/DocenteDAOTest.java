
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Docente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fanny
 */
public class DocenteDAOTest {
    
    Docente docente;
    
    public DocenteDAOTest() {
    }
   
    
    @Before
    public void setUp() {
        
        docente = new Docente("Professor",12345, "Geraldo","geraldomota@gmail.com", "Todas");
        
    }
    
   
    /**
     * Test of insert method, of class DocenteDAO.
     */
    @Test
    public void testInsert() throws Exception {
       
     
        DocenteDAO instance = new DocenteDAO();
        instance.insert(docente);
        System.out.println("Inserido!");
    
    
    }

    /**
     * Test of read method, of class DocenteDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        DocenteDAO instance = new DocenteDAO();
        assertTrue(instance.read()!= null);
    }

    /**
     * Test of read2 method, of class DocenteDAO.
     */
    @Test
    public void testRead2() throws Exception {
      
        DocenteDAO instance = new DocenteDAO();
        assertTrue(instance.read2(docente)!= null);
    }

    /**
     * Test of getById method, of class DocenteDAO.
     */
    /*@Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        DocenteDAO instance = new DocenteDAO();
        assertTrue(instance.getById(12345)!= null);
    }*/


    /**
     * Test of delete method, of class DocenteDAO.
     */
    @Test
    public void testDelete() throws Exception {
       /* System.out.println("delete");
        DocenteDAO instance = new DocenteDAO();
        instance.delete(docente);*/
        
    }

    /**
     * Test of update method, of class DocenteDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        docente.setCargo("Professor de física");
        DocenteDAO instance = new DocenteDAO();
        instance.update(docente);
    }

  
    
}
