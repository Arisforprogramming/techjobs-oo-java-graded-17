package org.launchcode.techjobs.oo;


import org.junit.Test;

import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
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
        assertEquals("ACME", jobTestThree.getEmployer().getValue());
        assertEquals("Desert", jobTestThree.getLocation().getValue());
        assertEquals("Quality control", jobTestThree.getPositionType().getValue());
        assertEquals("Persistence", jobTestThree.getCoreCompetency().getValue());
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

        String expectedJob ="\n" +"ID: "+ aJob.getId()+"\n" +
                "Name: "+ aJob.getName() +"\n" +
                "Employer: "+ aJob.getEmployer() + "\n" +
                "Location: "+ aJob.getLocation() + "\n" +
                "Position Type: "+ aJob.getPositionType() + "\n" +
                "Core Competency: "+ aJob.getCoreCompetency() + "\n";
        assertEquals(expectedJob,aJob.toString());

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTestEmpty = new Job("",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String ExpectedEmptyJob = "\n" +"ID: "+ jobTestEmpty.getId()+"\n" +
                "Name:"+" Data not available"+"\n" +
                "Employer:"+" ACME"+"\n" +
                "Location:"+" Desert"+"\n" +
                "Position Type:"+" Quality control"+"\n"+
                "Core Competency:"+" Persistence"+"\n";

        assertEquals(ExpectedEmptyJob,jobTestEmpty.toString());
    }
}

