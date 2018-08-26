
package pk.edu.nust.seecs.springlogaspects.view;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pk.edu.nust.seecs.springlogaspects.bo.CourseBo;
import pk.edu.nust.seecs.springlogaspects.bo.StudentBo;


public class Executioner extends JFrame implements Runnable {
    
    public static void main(String[] args) {
        Executioner admin = new Executioner();
        Thread t = new Thread(admin);
        t.start();
    }

    public Executioner(){
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        CourseBo courseManager = applicationContext.getBean("courseManager",CourseBo.class);
        
        //Executioner admin = new Executioner();
        Integer CourseId1 = courseManager.addNewCourse("Advanced Programming", 4);
        this.courseIds.add(CourseId1);
        this.courseIds.add(courseManager.addNewCourse("Web Engineering", 4));
        
        //New Student Id Array
        ArrayList<Integer> studentIds = new ArrayList<>();
        //StudentBo studentManager = admin.getStudentManager();
        StudentBo studentManager = applicationContext.getBean("studentManager",StudentBo.class);
        studentIds.add(studentManager.addStudents("Fahad Satti", this.courseIds));
        /*
        * Since Java passes objects by reference, admin.courseIds is empty here,
        * since I have removed all the elements in the addStudents method.
        * The next 2 students will not get any course, if I use the same
        * container of courseIds.
        */
        studentIds.add(studentManager.addStudents("Shahzad Saleem", this.courseIds));
        studentIds.add(studentManager.addStudents("Qaisar Choudhary", this.courseIds));
        
        Iterator<Integer> studentIterator = studentIds.iterator();
        JTextArea outputText= new JTextArea();
        
        while(studentIterator.hasNext()){
            Integer studentWithId = studentIterator.next();
            outputText.append("Now Printing student with id:"+studentWithId);
            
            studentManager.sayHello(studentWithId);
            //studentManager.getInfo();
            studentManager.printCourses(outputText);
        }
        this.add(outputText);
        this.pack();
        
    }
    ArrayList<Integer> courseIds = new ArrayList<>();

    @Override
    public void run() {
        this.setVisible(true);
    }
}
