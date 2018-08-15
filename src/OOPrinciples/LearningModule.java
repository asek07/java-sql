package OOPrinciples;

import java.util.ArrayList;

public class LearningModule {

    private int learningID;
    private String courseName;
    private int maxStudents = 3;
    private ArrayList<Graduate> students = new ArrayList<Graduate>();

    public LearningModule(int learningID, String courseName) {
        this.learningID = learningID;
        this.courseName = courseName;
    }

    public int getLearningID() {
        return learningID;
    }

    public void setLearningID(int learningID) {
        this.learningID = learningID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void addStudent(Graduate student) {
        boolean duplicateFound = false;

       if(this.students.size() == this.getMaxStudents()) {
           System.out.println("Cannot enrol " + student.getName()
                   + ". Max students reached. Please wait until someone un-enrols.");
       }
       else {
           for(Graduate g : this.students) {
               if(g.getId().equalsIgnoreCase(student.getId())) {
                   System.out.println("Duplicate student. Cannot add.");
                   duplicateFound = true;
               }
           }
           if(!duplicateFound){
               this.students.add(student);
               System.out.println("Successfully added " + student.getName());
           }
       }
    }

    public void getStudents() {

        System.out.println("Outputting enrolled students below: ");
        int i = 1;
        for(Graduate g : this.students) {

            String name = g.getName();
            String id = g.getId();

            System.out.println("\t" + i +". " + name + ", " + id);

            i++;
        }
    }

    public String getAvailableSpots() {
        int spotsAvail = this.getMaxStudents() - this.students.size();

            return "There are " + spotsAvail + " spots available.";

    }




}
