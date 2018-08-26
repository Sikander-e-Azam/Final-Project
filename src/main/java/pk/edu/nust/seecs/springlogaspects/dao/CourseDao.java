package pk.edu.nust.seecs.springlogaspects.dao;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pk.edu.nust.seecs.springlogaspects.entity.Course;

/**
 * Data Access Object for Course Entity. 
 * <p>
 Wrapper Class for CRUD operations on Course.
 */

public class CourseDao {
    
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void addCourse(Course course) {
        Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteCourse(int courseid) {
        Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            Course course = (Course) session.load(Course.class, new Integer(courseid));
            session.delete(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateCourse(Course course) {
        Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<Course>();
        Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            courses = session.createQuery("from Course").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return courses;
    }

    public Course getCourseById(int courseid) {
        Course course = null;
        Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Course where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", courseid);
            course = (Course) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return course;
    }
}