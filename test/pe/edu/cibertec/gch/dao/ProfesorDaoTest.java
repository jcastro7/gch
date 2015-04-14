/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 *
 * @author jcastro
 */
public class ProfesorDaoTest {
    
    public ProfesorDaoTest() {
    }
    
    @Test
    public void testRegistrar(){
        ProfesorDao profDao = new ProfesorDaoImpl();
        Profesor prof = new Profesor("", "", "", "", "", "", "", "", "", "", "", "","", "", "");
        profDao.registrar(prof);
    }
}
