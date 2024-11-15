package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    public CoreCompetency getEmployer;
    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
     id = nextId;
     nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        //this.id = id;
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {

        String jobPrintFormat = "";
        if(name.isEmpty()){
            name = "Data not available";
        }
        if(employer.getValue().equals("")){
            employer.setValue("Data not available");
        }
        if(location.getValue().equals("")){
            location.setValue("Data not available");
        }
        if(positionType.getValue().equals("")){
            positionType.setValue("Data not available");
        }
        if(coreCompetency.getValue().equals("")){
            coreCompetency.setValue("Data not available");
        }
        if (id == 0 && name == null && employer == null && location == null &&
                positionType == null && coreCompetency == null) {
            // Return the special message if only the id is populated
            return "\n"+ "OOPS! This job does not seem to exist." + "\n";
        }

            jobPrintFormat = "\n" +"ID:"+ id +"\n"+
                "Name:"+name+ "\n" +
                "Employer:"+employer+ "\n"+
                "Location:"+location+ "\n"+
                "Position Type:"+positionType+ "\n"+
                "Core Competency:"+coreCompetency+ "\n";

        return jobPrintFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
