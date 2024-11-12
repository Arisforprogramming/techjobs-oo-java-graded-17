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
        assertNotEquals(jobTestOne.getId(),jobTestTwo.getId());
    }

   @Test
    public void testJobConstructorSetsAllFields(){
        Job jobTestThree =  new Job("Product tester",
                                    new Employer("ACME"),
                                    new Location("Desert"),
                                    new PositionType("Quality control"),
                                    new CoreCompetency("Persistence"));

        assertTrue(jobTestThree.getName() instanceof String);
        assertTrue(jobTestThree.getEmployer() instanceof Employer);
        assertTrue(jobTestThree.getLocation() instanceof Location);
        assertTrue(jobTestThree.getPositionType() instanceof PositionType);
        assertTrue(jobTestThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester",jobTestThree.getName());
        assertEquals("ACME",jobTestThree.getEmployer());
        assertEquals("Desert",jobTestThree.getLocation());
        assertEquals("Quality control",jobTestThree.getPositionType());
        assertEquals("Persistence",jobTestThree.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality(){
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


}

