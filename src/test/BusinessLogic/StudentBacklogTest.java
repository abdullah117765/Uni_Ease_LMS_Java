package BusinessLogic;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentBacklogTest {

    @Test
    void registerCoursetrue() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();

        stb.RegisterCourse("2", "20", "SE","SE2002","A1");

        String c = outContent.toString();
        assertEquals("Course Added",c);


    }
    @Test
    void registerCoursetfalse() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();

        stb.RegisterCourse("2", "20", "SE","SE2002","A1");

        String c = outContent.toString();
        assertNotEquals("Course not Added",c);


    }




    @Test
    void unregisterCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();

        stb.unregisterCourse("2", "20", "SE","SE2002","A1");

        String c = outContent.toString();
        assertEquals("course is unregistered",c);

    }

    @Test
    void unregisterCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();

        stb.unregisterCourse("2", "20", "SE","SE299","A1");

        String c = outContent.toString();
        assertEquals("course not unregistered",c);

    }



    @Test
    void searchRegisterCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();

        stb.SearchRegisterCourse("2", "20", "SE","oop-123","a1");

        String c = outContent.toString();
        assertEquals("course is found",c);
    }

    @Test
    void searchRegisterCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();

        stb.SearchRegisterCourse("2", "24", "SE","oop-123","a99");

        String c = outContent.toString();
        assertEquals("course not found",c);
    }


    @Test
    void displayableCoursesRegisteredByStudent_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();


stb.DisplayRegisterCourse("3","21","SE","DS-124","a2");
        String c = outContent.toString();
        assertEquals("course is displayed",c);

    }


    @Test
    void DisplayableCoursesRegisteredByStudent_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StudentBacklog stb= new StudentBacklog();

        stb.DisplayRegisterCourse("2", "20", "SE","oop-123","a99");

        String c = outContent.toString();
        assertEquals("course not displayed",c);

    }







}