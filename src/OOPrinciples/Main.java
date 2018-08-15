package OOPrinciples;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        GraduateProgram cognizant = new GraduateProgram();
        LearningModule module1 = new LearningModule(123, "Introduction to Java");

        String[] gradNames = {"Andy", "Yu", "Anu", "Mirko"};
        String[] gradIds = {"772211", "112233", "445211", "998811"};
        String[] languages = {"Java", "Javascript", "Typescript", "Python"};
        String[] universities = {"RMIT", "Deakin", "Monash", "Melbourne Uni"};
        int salary = 67000;

        Graduate andy = new Graduate(gradNames[0], gradIds[0], salary);
        Graduate yu = new Graduate(gradNames[1], gradIds[1], salary);
        Graduate anu = new Graduate(gradNames[2], gradIds[2], salary);
        Graduate mirko = new Graduate(gradNames[3], gradIds[3], salary);
        Graduate johnno = new Graduate("Johnno", "556677", salary);

        for(int i=0; i < 4; i++) {
            Graduate g = new Graduate(gradNames[i], gradIds[i], salary);
            g.setFaveLanguage(languages[i]);
            g.setUniversity(universities[i]);
            cognizant.addGraduate(g);
        }

        for(Graduate g : cognizant.getGrads()) {
            System.out.println(cognizant.getGradWithId(g.getId()));
        }

//        System.out.println(cognizant.getGradWithId("12345"));
//
//        cognizant.removeGraduateWithId("12345");
//        cognizant.removeGraduateWithId("998811");

        module1.addStudent(andy);
        module1.addStudent(andy);
        module1.addStudent(yu);
        module1.addStudent(anu);
        module1.addStudent(mirko);
        module1.addStudent(johnno);
        module1.getStudents();

        String salaryOutput = NumberFormat.getNumberInstance(Locale.US).format(andy.getSalary());

        System.out.println("$"+salaryOutput);

        System.out.println(module1.getAvailableSpots());


//        for(Graduate g : cognizant.getGrads()) {
//            System.out.println(cognizant.getGradWithId(g.getId()));
//        }

    }

}
