package org.SimonBorgstromIn1JavaBackend.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "MyServlet", urlPatterns = {"/myservlet", "/index"})
public class MyServlet extends HttpServlet {

    public static final String DESCRIPTION = "description";
    public static final String DUEDATE = "duedate";
    public static final String DONE = "done";
    public static final String KEY = "key";
    public HashMap<Integer, TodoItem> saveMap = new HashMap<Integer, TodoItem>();
    private int count = 0;



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String description = req.getParameter(DESCRIPTION);
        String duedate = req.getParameter(DUEDATE);
        String doneString = req.getParameter(DONE);
        String keyString = req.getParameter(KEY);
        System.out.println("donestring " + doneString);
        if (keyString == null) {
            TodoItem ti = new TodoItem(description, duedate, doneString);
            System.out.println("donestring " + doneString);
            saveMap.put(++count, ti);
            // System.out.println(count);
        } else if (keyString != null) {
            TodoItem ti = saveMap.get(Integer.valueOf(keyString) + 1);
            if (duedate != null) {
                ti.setDueDate(duedate);
            }
            System.out.println("valin" + (Integer.valueOf(keyString) + 1));
            if (doneString != null) {
                // ti = saveMap.get(Integer.valueOf(keyString)+1);

                ti.setDone("checked");
                System.out.println("inchecked" + doneString);
            }
        }
         resp.setStatus(resp.SC_OK);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        String objectToReturn = "[";
        for (Map.Entry<Integer, TodoItem> entry : saveMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue().toJson();
            objectToReturn += value;
            if (count != key) {
                objectToReturn += ",";
            }
            System.out.println(count + " " + key);
        }
        objectToReturn += "]";
        System.out.println(objectToReturn + count);

        PrintWriter out = resp.getWriter();

        out.print(objectToReturn);

        out.close();

    }
}
