package com.wainhouse.tta.domain;

import com.wainhouse.tta.domain.Task;
import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    Task task1 = new Task(1, "Watch Tv show", "30/11/2021", "02/12/2021", "Urgent");


    // Testing Getters and Setters
    @Test
    public void testGetId() {
        assertEquals(1, task1.getId());
    }

    @Test
    public void testGetTask() {
        assertEquals("Watch Tv show", task1.getTask());
    }

    @Test
    public void testDateAdded() {
        assertEquals("30/11/2021", task1.getDateAdded());
    }

    @Test
    public void testGetDateCompleted() {
        assertEquals("02/12/2021", task1.getDateCompleted());
    }

    @Test
    public void testGetType() {
        assertEquals("Urgent", task1.getType());
    }


    @Test
    public void testSetId() {
        assertEquals(1, task1.getId());
        task1.setId(2);
        assertEquals(2, task1.getId());
    }

    @Test
    public void testSetTask() {
        assertEquals("Watch Tv show", task1.getTask());
        task1.setTask("Hoover");
        assertEquals("Hoover", task1.getTask());
    }

    @Test
    public void testSetDateAdded() {
        assertEquals("30/11/2021", task1.getDateAdded());
        task1.setDateAdded("31/11/2021");
        assertEquals("31/11/2021", task1.getDateAdded());
    }

    @Test
    public void testSetDateCompleted() {
        assertEquals("02/12/2021", task1.getDateCompleted());
        task1.setDateCompleted("02/12/2021");
        assertEquals("02/12/2021", task1.getDateCompleted());
    }

    @Test
    public void testSetType() {
        assertEquals("Urgent", task1.getType());
        task1.setType("Moderate");
        assertEquals("Moderate", task1.getType());
    }

}
