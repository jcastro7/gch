/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.gch.dao;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pe.edu.cibertec.gch.modelo.Profesor;
/**
 *
 * @author jcastro
 */
public class ProfesorDaoTest {

    ProfesorDao profDao;
    
    @Before
    public void setUp() {
        profDao = new ProfesorDaoImpl();
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testRegistrar(){
        thrown.expect(UnsupportedOperationException.class);
	thrown.expectMessage("Not supported yet.");
        Profesor prof = new Profesor("44870557", "Jose", "", "", "", "", "", "", "", "", "", "","", "", "");
//        profDao.registrar(prof);
        profDao.obtenerSegun(prof.getCodigo());
    }

    @Test
    public void testActualizar(){
        thrown.expect(UnsupportedOperationException.class);
	thrown.expectMessage("Not supported yet.");
//        Profesor prof = new Profesor("44870557", "Jose", "", "", "", "", "", "", "", "", "", "","", "", "");
        Profesor prof = null;
        profDao.actualizar(prof);
    }

    @Test
    public void testEliminarSegun(){
        thrown.expect(UnsupportedOperationException.class);
	thrown.expectMessage("Not supported yet.");
        profDao.eliminarSegun("");
    }

    @Test
    public void testListarTodo(){
        Profesor prof = new Profesor("44870557", "Jose", "", "", "", "", "", "", "", "", "", "","", "", "");
        profDao.registrar(prof);
        assertEquals(prof, profDao.listarTodo().get(0));
    }
}