package service.impl.employee;

import org.hibernate.SessionFactory;
import repository.LoginRepository;
import repository.imp.SessionFactorySingleton;

public class LoginService {
    LoginRepository loginRepository = new LoginRepository();
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public boolean checking(Integer id,Integer passcode){
        if(id>=4000){
            return student(id,passcode);
        }
        else {
            return employee(id,passcode);
        }
    }
    private boolean student(Integer id,Integer passcode){
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                return loginRepository.student(id,passcode);
            } catch (Exception e) {
                t.rollback();
                return false;

            }
        }

    }
    private boolean employee(Integer id,Integer passcode){
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                return loginRepository.employee(id,passcode);
            } catch (Exception e) {
                t.rollback();
                return false;

            }
        }
    }
}
