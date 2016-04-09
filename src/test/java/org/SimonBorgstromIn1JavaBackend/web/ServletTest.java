

package org.SimonBorgstromIn1JavaBackend.web;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import  org.mockito.InOrder;
import static org.mockito.Mockito.*;

/**
 *
 * @author uno
 */
public class ServletTest {

    private MyServlet sut;
   
    private HttpServletResponse response;
    private HttpServletRequest request;
    private PrintWriter out;
    
   
    /*
    
    @Before
    public void run_before_each_test() throws FileNotFoundException, IOException{
        sut = new MyServlet();
        response = mock(HttpServletResponse.class);
        request = mock(HttpServletRequest.class);
        out = new PrintWriter(TESTFILE);
        when(response.getWriter()).thenReturn(out);
    }
    private static final String TESTFILE = "testfile.txt";
    
 
    
    @Test
    public void doGet_content_type_of_get_should_be_text_html () throws ServletException, IOException{    
        sut.doGet(null, response);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        verify(response,times(1)).setContentType(arg.capture());
        String actual = arg.getValue();
        String expected = "text/html";
        assertEquals(expected, actual);   
               
    }
    
    @Test 
        public void doGet_should_be_able_to_output_data() throws ServletException, IOException{
        sut.doGet(null, response);
        verify(response,times(1)).getWriter();
    }
     
    @Test
    public void doGet_content_type_headers_should_be_set_before_writing_data() throws IOException, ServletException{
        sut.doGet(null, response);
        InOrder inOrder=inOrder(response);
        inOrder.verify(response).setContentType(any(String.class));
        inOrder.verify(response).getWriter();    
    }
    
    @Test
    public void doGet_content_type_should_be_text_html() throws ServletException, IOException{
        sut.doGet(null, response);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        verify(response,times(1)).setContentType(arg.capture());
        String actual = arg.getValue();
        String expected = "text/html";
        assertEquals(expected, actual);   
    }
    
    @Test
    public void doGet_shold_return_page_as_UTF8() throws ServletException, IOException{
        sut.doGet(request, response);
        verify(response, times(1)).setCharacterEncoding("UTF-8");
    }
    
     @Test
    public void doGet_character_encoding_headers_should_be_set_before_writing_data() throws IOException, ServletException{
        sut.doGet(null, response);
        InOrder inOrder=inOrder(response);
        inOrder.verify(response).setCharacterEncoding(any(String.class));
        inOrder.verify(response).getWriter(); 
        
    }
    
    @Test
    public void doGet_should_deliver_HTML5() throws ServletException, IOException{
        sut.doGet(request, response);
        String webcontent  = new String(Files.readAllBytes(Paths.get(TESTFILE)));
        assertTrue("Should have html 5 Doctype tag",webcontent.startsWith("<!DOCTYPE html>"));
    }
    
    
    
    
 
    @Test 
    public void page_should_end_with_a_closing_html_tag() throws ServletException, IOException{
        sut.doGet(request, response);
        String webcontent  = new String(Files.readAllBytes(Paths.get(TESTFILE)));
        assertTrue(webcontent.toLowerCase().contains("</html>")); 
    }

        
    
    @Test
    public void doPost_should_not_write_anything_to_client_but_instead_redirect_to_get() throws ServletException, IOException{
        sut.doPost(request, response);
        verify(response, times(0)).getWriter();
        verify(response,times(1)).sendRedirect("");   
    }
    
    @Test
    public void doPost_should_aquire_description_parameter() throws ServletException, IOException{
        sut.doPost(request, response);
        verify(request,times(1)).getParameter(MyServlet.DESCRIPTION);
        assertNotNull(MyServlet.DESCRIPTION);
    }
    
    @Test
    public void doPost_should_aquire_duedate_parameter() throws ServletException, IOException{
        sut.doPost(request, response);
        verify(request, times(1)).getParameter(MyServlet.DUEDATE);
        assertNotNull(MyServlet.DUEDATE);
    }
    
    @Test
    public void doPost_should_aquire_done_parameter() throws ServletException, IOException{
        sut.doPost(request, response);
        verify(request, times(1)).getParameter(MyServlet.DONE);
        assertNotNull(MyServlet.DUEDATE);
    }
    
    @Test
    public void doPost_should_return_return_status_400_when_done_not_true_or_false_or_null() throws IOException, ServletException{
        
        when(request.getParameter(MyServlet.DONE)).thenReturn("rappakalja");
        sut.doPost(request, response);
        ArgumentCaptor<Integer> statusarg = ArgumentCaptor.forClass(Integer.class);
        verify(response, times(1)).sendError(statusarg.capture(), anyString());
        
        assertThat(statusarg.getValue(), is(400));
       
    }
    
    @Test
    public void isPresent_should_be_present_and_true_when_done() throws IOException{
    
        Optional<Boolean> actual = sut.isDone("true", response);
        assertTrue(actual.isPresent());
        assertTrue(actual.get());
    }
    
    @Test
    public void isPresent_should_be_present_and_false_when_not_done() throws IOException{
    
        Optional<Boolean> actual = sut.isDone("false", response);
        assertTrue(actual.isPresent());
        assertFalse(actual.get());
    }
    
    @Test
    public void isPresent_should_be_absent_and_false_when_not_done() throws IOException{
    
        Optional<Boolean> actual = sut.isDone("rappakaljva", response);
        assertFalse(actual.isPresent());
    }
    
    @Test
    public void shouldHaveWebServletAnnotation(){
        Annotation[] annotations = MyServlet.class.getAnnotations();
        Class<? extends Annotation> actual = annotations[0].annotationType();
        Class<javax.servlet.annotation.WebServlet> expected = javax.servlet.annotation.WebServlet.class;
        assertEquals(expected, actual); 
    }
    */
}
