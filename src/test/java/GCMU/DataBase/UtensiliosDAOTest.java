/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Utensilios;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtensiliosDAOTest {
    
    Utensilios utensilios;
    
    public UtensiliosDAOTest() {

    }
   
    
    @Before
    public void setUp() {
        
        utensilios = new Utensilios("Celular", "Vermelho", "Vivencia", "Motorola");
        
    }

   /**
     * Test of insert method, of class UtesiliosDAO.
     */
    @Test
    public void testInsert() throws Exception {
       
     
        UtensiliosDAO instance = new UtensiliosDAO();
        instance.insert(utensilios);
        System.out.println("Inserido!");
    
    
    }
    /**
     * Test of read method, of class UtesiliosDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        UtensiliosDAO instance = new UtensiliosDAO();
        assertTrue(instance.read()!= null);
    }

    /**
     * Test of delete method, of class UtesiliosDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        UtensiliosDAO instance = new UtensiliosDAO();
        instance.delete(utensilios);
        
    }

    /**
     * Test of update method, of class UtesiliosDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        utensilios.setMarca("Apple");
        UtensiliosDAO instance = new UtensiliosDAO();
        instance.update(utensilios);
    }
   
}