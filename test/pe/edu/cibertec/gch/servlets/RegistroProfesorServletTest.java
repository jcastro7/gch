package pe.edu.cibertec.gch.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*http://octaviomartin.blogspot.com/2013/04/mocking-partially-class-mixing-mock-and.html*/

public class RegistroProfesorServletTest {

    private RegistroProfesorServlet registroProfesorServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;

    @Before
    public void setUp() {
        registroProfesorServlet = new RegistroProfesorServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        when(req.getRequestDispatcher(anyString())).thenReturn(requestDispatcherMock);
    }

    @Test
    public void testDoPostConDatos() throws Exception {
        datosProfesor(req);
        registroProfesorServlet.doPost(req, resp);
        verify(resp).sendRedirect("listarProfesores");
    }

    @Test
    public void testDoPostVacio() throws Exception {
        datosProfesor(req);
        when(req.getParameter("codigo")).thenReturn("");
        when(req.getParameter("nombres")).thenReturn("");
        registroProfesorServlet.doPost(req, resp);
        verify(req).setAttribute("mensaje", "Hay errores en los datos enviados");
    }

    @Test
    public void testDoPostNulo() throws Exception {
        datosProfesor(req);
        when(req.getParameter("codigo")).thenReturn(null);
        registroProfesorServlet.doPost(req, resp);
        verify(req).setAttribute("mensaje", "Hay errores en los datos enviados");
    }

    private void datosProfesor(HttpServletRequest req) {
        when(req.getParameter("codigo")).thenReturn("44870557");
        when(req.getParameter("nombres")).thenReturn("Jose");
        when(req.getParameter("apellidoPaterno")).thenReturn("Castro");
        when(req.getParameter("apellidoMaterno")).thenReturn("Mendoza");
        when(req.getParameter("direccion")).thenReturn("Mz B Lt 32 San Francisco");
        when(req.getParameter("referencia")).thenReturn("Ñaña");
        when(req.getParameter("telefono1")).thenReturn("123-4567");
        when(req.getParameter("email1")).thenReturn("jcastro@mindef.gob.pe");
        when(req.getParameter("fechaNacimiento")).thenReturn("07/02/1988");
        when(req.getParameter("sexo")).thenReturn("M");
        when(req.getParameter("estadoCivil")).thenReturn("1");
    }
}
