/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Materiais;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MateriaisDAOTest {
    
    Materiais materiais;
    
    public MateriaisDAOTest() {


    }
   
    
    @Before
    public void setUp() {
        
        materiais = new Materiais("Controle", "Reservado", "nenhuma", 13, "Lab. Redes");
        
    }

   /**
     * Test of insert method, of class MateriaisDAO.
     */
    @Test
    public void testInsert() throws Exception {
       
     
        MateriaisDAO instance = new MateriaisDAO();
        instance.insert(materiais);
        System.out.println("Inserido!");
    
    
    }

    /**
     * Test of read method, of class MateriaisDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        MateriaisDAO instance = new MateriaisDAO();
        assertTrue(instance.read()!= null);
    }

    /**
     * Test of delete method, of class MateriaisDAO.
     */
    @Test
    public void testDelete() throws Exception {
       /* System.out.println("delete");
        MateriaisDAO instance = new MateriaisDAO();
        instance.delete(materiais);*/
        
    }

    /**
     * Test of update method, of class MateriaisDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        materiais.setStatus("Livre");
        MateriaisDAO instance = new MateriaisDAO();
        instance.update(materiais);
    }
   
}
