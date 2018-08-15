package OOPrinciples;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class GraduateProgram {

    private ArrayList<Graduate> grads = new ArrayList<Graduate>();


    public GraduateProgram() {}

    public void addGraduate(Graduate grad) {
        this.grads.add(grad);
    }

    public String getGradWithId(String id) {
        for(Graduate g : this.grads) {
            if(g.getId().equalsIgnoreCase(id)) {
                return "{ Name: " + g.getName() + ", ID: " + g.getId() + ", University: " + g.getUniversity()
                        + ", Fave Language: " + g.getFaveLanguage() + " }";
            }
        }
        return "Grad not found with that ID.";
    }

    public ArrayList<Graduate> getGrads() {
        return this.grads;
    }

    public void removeGraduateWithId(String id) {
        Iterator<Graduate> i= this.grads.iterator();

        while(i.hasNext()) {
           Graduate g = i.next();

           if(g.getId().equalsIgnoreCase(id)) {
               String name = g.getName();
               i.remove();
               System.out.println("Sucessfully removed " + name);
               System.out.println("breaking");
               break;
           }

           if(!i.hasNext()){
               System.out.println("ID: " + id + " not found.");
           }
        }
    }

}
