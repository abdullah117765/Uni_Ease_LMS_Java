package BusinessLogic;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TeacherBacklogTest {


    @Test
    void assignTeachertoCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TeacherBacklog.getInstance().AssignTeachertoCourse("2","20","SE","oop-12377","a2");
        String c = outContent.toString();
        assertEquals("teacher assigned",c);

    }

    @Test
    void assignTeachertoCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TeacherBacklog.getInstance().AssignTeachertoCourse("2","20","SE","oop-12377","a2");
        String c = outContent.toString();
        assertNotEquals("teacher not assigned",c);

    }


    @Test
    void searchAsssignedTeacher_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TeacherBacklog.getInstance().SearchAsssignedTeacher("2","20","SE","oop-12377","a2");
        String c = outContent.toString();
        assertEquals("assigned teacher found",c);
    }

    @Test
    void searchAsssignedTeacher_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TeacherBacklog.getInstance().SearchAsssignedTeacher("3","23","AI","Ai-123","a00");
        String c = outContent.toString();
        assertEquals("assigned teacher not found",c);
    }

    @Test
    void testUnassignteachertoCourse_T() {
            final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            TeacherBacklog.getInstance().unassignteachertoCourse("2","20","SE","oop-12377","a2");
            String c = outContent.toString();
            assertEquals("teacher unassigned",c);
    }

        @Test
        void testUnassignteachertoCourse_F() {
                final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent));
                TeacherBacklog.getInstance().unassignteachertoCourse("3","23","AI","Ai-123","a00");
                String c = outContent.toString();
                assertEquals("teacher not unassigned",c);

            }


    @Test
    void displayAsssignedTeacher_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TeacherBacklog.getInstance().DisplayAsssignedTeacher("a9");
        String c = outContent.toString();
        assertEquals("assigned teachers displayed",c);
    }

    @Test
    void displayAsssignedTeacher_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TeacherBacklog.getInstance().DisplayAsssignedTeacher("a9");
        String c = outContent.toString();
        assertNotEquals("assigned teachers not displayed",c);
    }
}