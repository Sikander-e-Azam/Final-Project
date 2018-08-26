package pk.edu.nust.seecs.springlogaspects.bo;

import java.util.ArrayList;
import javax.swing.JTextArea;

public interface StudentBo {

    public void sayHello(Integer studentId);

    public String getInfo();

    public void printCourses(JTextArea outputText);
    
    public Integer addStudents(String studentName, ArrayList<Integer> studentCourses);
    
}
