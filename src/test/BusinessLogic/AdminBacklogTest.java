package BusinessLogic;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AdminBacklogTest {

    @Test
    void addCourse_T() {

            final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
             AdminBacklog.getInstance().addCourse("Ai", "3", "ai-123");
            String c = outContent.toString();
            assertEquals("course added",c);

    }

    @Test
    void addCourse_F() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().addCourse("Ai", "3", "ai-123");
        String c = outContent.toString();
        assertNotEquals("course not added",c);

    }


    @Test
    void searchCourse_T() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().SearchCourse( "ai-123");
        String c = outContent.toString();
        assertEquals("courses are found",c);

    }

    @Test
    void searchCourse_F() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().SearchCourse( "ai-123");
        String c = outContent.toString();
        assertNotEquals("courses not found",c);

    }



    @Test
    void displayCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().DisplayCourse();
        String c = outContent.toString();
        assertEquals("course is displayed",c);
    }


    @Test
    void displayCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().DisplayCourse();
        String c = outContent.toString();
        assertNotEquals("course not displayed",c);
    }

    @Test
    void deleteCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().DeleteCourse("ai-123");
        String c = outContent.toString();
        assertEquals("course is deleted",c);
    }

    @Test
    void deleteCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().DeleteCourse( "ai-333");
        String c = outContent.toString();
        assertEquals("course not deleted",c);

    }

    @Test
    void offerCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().OfferCourse("2", "20", "oop-123","SE");
        String c = outContent.toString();
        assertEquals("course is offered",c);

    }

    @Test
    void offerCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().OfferCourse("2", "20", "oop-123","SE");
        String c = outContent.toString();
        assertNotEquals("course not offered",c);

    }

    @Test
    void displayOfferCourse_T() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().DisplayOfferCourse("2", "20", "oop-123","SE");
        String c = outContent.toString();
        assertEquals("offered courses  is displayed",c);
    }



    @Test
    void displayOfferCourse_F() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().DisplayOfferCourse("7", "20", "ri-123","Ai");
        String c = outContent.toString();
        assertEquals("offered courses not displayed",c);
    }


    @Test
    void searchofferedCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().SearchofferCourse("4", "20", "oop-123","SE");
        String c = outContent.toString();
        assertEquals("course is found",c);
    }

    @Test
    void searchofferCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().SearchofferCourse("3", "23", "Dg-333","AI");
        String c = outContent.toString();
        assertEquals("course not found",c);
    }


    @Test
    void unofferCourse_T() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().unofferCourse("2", "20", "oop-123","SE");
        String c = outContent.toString();
        assertEquals("course is unoffered",c);
    }

    @Test
    void unofferCourse_F() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        AdminBacklog.getInstance().unofferCourse("2", "20", "oop-123777","SE");
        String c = outContent.toString();
        assertEquals("course not unoffered",c);
    }





}