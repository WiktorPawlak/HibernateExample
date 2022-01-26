package p.lodz.pl.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class StudentTest {
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
}
