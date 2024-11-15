package org.launchcode.techjobs.oo;


import org.junit.Test;

import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJob() {
        // Create two Job objects using the empty constructor.
        Job jobTestOne = new Job();
        Job jobTestTwo = new Job();
        assertNotEquals(jobTestOne.getId(), jobTestTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTestThree = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(jobTestThree.getName() instanceof String);
        assertTrue(jobTestThree.getEmployer() instanceof Employer);
        assertTrue(jobTestThree.getLocation() instanceof Location);
        assertTrue(jobTestThree.getPositionType() instanceof PositionType);
        assertTrue(jobTestThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobTestThree.getName());
        assertEquals("ACME", jobTestThree.getEmployer());
        assertEquals("Desert", jobTestThree.getLocation());
        assertEquals("Quality control", jobTestThree.getPositionType());
        assertEquals("Persistence", jobTestThree.getCoreCompetency());
    }

    // Task 4 Test the equals Method
    // job class will already assign unique Id so don't need to put id field
    @Test
    public void testJobsForEquality() {
        Job jobTestFour = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job jobTestFive = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(jobTestFour.equals(jobTestFive));
    }

   // attempted to use lineSeparator
   /* @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String lineSeparator = System.lineSeparator();
        Job aJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        // Call toString() and assertEqual to check the expected result to be true
        String testJob = aJob.toString();
        assertEquals(lineSeparator , testJob.charAt(0));
        assertEquals(lineSeparator , testJob.charAt(testJob.length() - 1));

    }*/

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job aJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String testJob = aJob.toString();
        assertEquals('\n', testJob.charAt(0));
        assertEquals('\n', testJob.charAt(testJob.length()-1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job aJob = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String expectedJob ="\n" + "ID: " + aJob.getId() +"\n" +
                "Name: " + aJob.getName() +"\n" +
                "Employer: " + aJob.getEmployer() + "\n" +
                "Location: " + aJob.getLocation() + "\n" +
                "Position Type: " + aJob.getPositionType() + "\n" +
                "Core Competency: " + aJob.getCoreCompetency() + "\n";
        assertEquals(expectedJob, aJob.toString());

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTestEmpty = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

        String ExpectedEmptyJob = "\n" + "ID: " + jobTestEmpty.getId() +"\n" +
                "Name: Data not available" +"\n" +
                "Employer: Data not available" + "\n" +
                "Location: Data not available" + "\n" +
                "Position Type: Data not available" +  "\n" +
                "Core Competency: Data not available" +  "\n";

        assertEquals(ExpectedEmptyJob, jobTestEmpty.toString());
    }
}

