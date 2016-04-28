/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Chaves;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChavesDAOTest {
    
    Chaves chaves;
    
    public ChavesDAOTest() {

    }
   
    
    @Before
    public void setUp() {
        
        chaves = new Chaves("Lab. Redes", "Reservado");
        
    }

   /**
     * Test of insert method, of class ChavesDAO.
     */
    @Test
    public void testInsert() throws Exception {
       
     
        ChavesDAO instance = new ChavesDAO();
        instance.insert(chaves);
        System.out.println("Inserido!");
    
    
    }
    /**
     * Test of read method, of class ChavesDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        ChavesDAO instance = new ChavesDAO();
        assertTrue(instance.read()!= null);
    }

    /**
     * Test of delete method, of class ChavesDAO.
     */
    @Test
    public void testDelete() throws Exception {
       /* System.out.println("delete");
        ChavesDAO instance = new ChavesDAO();
        instance.delete(chaves);*/
        
    }

    /**
     * Test of update method, of class ChavesDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        chaves.setStatus("Livre");
        ChavesDAO instance = new ChavesDAO();
        instance.updateReserva(chaves);
    }
   
}
   