package org.SimonBorgstromIn1JavaBackend.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

@WebServlet(name = "MyServlet", urlPatterns = {"/myservlet", "/index"})
public class MyServlet extends HttpServlet {

    public static final String DESCRIPTION = "description";
    public static final String DUEDATE = "duedate";
    public static final String DONE = "done";
    public static final String KEY ="key";
    public HashMap<Integer, TodoItem> saveMap = new HashMap<Integer, TodoItem>();
    private int count = 0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String description = req.getParameter(DESCRIPTION);
        String duedate = req.getParameter(DUEDATE);
        String doneString = req.getParameter(DONE);
        String keyString = req.getParameter(KEY);
        System.out.println("keyString" +keyString);
        if (keyString==null){
        TodoItem ti = new TodoItem(description, duedate, doneString);
     
        saveMap.put(++count, ti);
      // System.out.println(count);
        }
        else if (keyString != null){
                  TodoItem ti = saveMap.get(Integer.valueOf(keyString)+1);
                  ti.setDueDate(duedate);

        }
        
       
           
    }

    Optional<Boolean> isDone(String doneString, HttpServletResponse resp) throws IOException {
        Boolean done = null;
        if("true".equals(doneString)){
            return Optional.of(true);
        }else if("false".equals(doneString)){
            return Optional.of(false);
        }else{
            resp.sendError(400, "Done parameter should be true or false");
            return Optional.empty();
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //isDone(doneString, resp);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        //resp.sendRedirect("");
       String objectToReturn = "[";
   // String objectToReturn ="";
        for (Map.Entry<Integer, TodoItem> entry : saveMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue().toJson();
            objectToReturn +=value;
            if(count != key)
                objectToReturn +=",";
            System.out.println(count +" " +key);  
        }   
        objectToReturn +="]";
        System.out.println(objectToReturn +count);
       
        PrintWriter out = resp.getWriter();
     
        out.print(objectToReturn);

        out.close();
        
    }
}