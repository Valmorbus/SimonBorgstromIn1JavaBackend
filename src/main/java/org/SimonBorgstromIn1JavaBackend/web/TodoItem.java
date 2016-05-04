/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.SimonBorgstromIn1JavaBackend.web;

/**
 *
 * @author borgs_000
 */
public class TodoItem {
    
    private String description;
    private String dueDate;
    private String done;
    

    public TodoItem(String description, String dueDate, String done) {
        this.description = description;
        this.dueDate = dueDate;
        this.done = done;
        if (this.done == null){
            this.done = "";
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String isDone() {
        return done;
    }
    
    public String toJson(){
        return "{"+"\"Description\""+":\""+description+"\","+"\"Duedate\""+":\""+dueDate+"\""+
                ","+"\"Done\""+":\""+done+"\"}";
    }
    
}
