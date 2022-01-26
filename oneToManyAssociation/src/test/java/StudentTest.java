import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import p.lodz.pl.model.Mark;
import p.lodz.pl.model.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void writeTest() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Student student = new Student("Wiktorr", 22);
            for (int i = 0; i < 5; i++) {
                Mark mark = new Mark(i + 1, true);  //student in constructor
                if (i > 3) {
                    mark.setEditable(false);
                }
                student.addMark(i, mark);
            }

            session.save(student);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void readTest() {

    }

//    void close() {
//        if !(session.getTransaction().wasCommited()) {
//            session.getTransaction().rollback();
//            //log
//        }
//        session.close();
//    }

}