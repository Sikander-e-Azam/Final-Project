
package pk.edu.nust.seecs.springlogaspects.bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.springframework.beans.factory.annotation.Autowired;
import pk.edu.nust.seecs.springlogaspects.dao.StudentDao;
import pk.edu.nust.seecs.springlogaspects.entity.Course;
import pk.edu.nust.seecs.springlogaspects.entity.Student;

public class StudentBoImpl implements StudentBo{

    @Autowired
    StudentDao studentPersistor;
    
    Student studentActor;
    
    @Override
    public void sayHello(Integer studentId) {
        studentActor = studentPersistor.getStudentById(studentId);
    }

    @Override
    public String getInfo() {
        return studentActor.toString();
    }

    @Override
    public void printCourses(JTextArea outputText) {
        outputText.append("Student ID:"+studentActor.getStudentId()+"\r\n");
        outputText.append("Student Courses:"+studentActor.getCourses().size()+"\r\n");

        Iterator<Course> courseListIterator = studentActor.getCourses().iterator();
        while(courseListIterator.hasNext()){
            outputText.append(courseListIterator.next().toString()+"\r\n");
        }
       
    }
    
    @Override
    public Integer addStudents(String studentName, ArrayList<Integer> studentCourses) {
        Student newStudent = new Student();
        newStudent.setName(studentName);
        studentPersistor.addStudent(newStudent);
        
        Iterator<Integer> studentCourseIterator = studentCourses.iterator();
        while(studentCourseIterator.hasNext()){
            studentPersistor.addCourse(newStudent, studentCourseIterator.next());
        }
        return newStudent.getStudentId();
    }
    
}
