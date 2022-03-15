package service.impl;

import org.hibernate.SessionFactory;
import repository.LoginRepository;
import repository.imp.SessionFactorySingleton;

public class LoginService {
    LoginRepository loginRepository = new LoginRepository();
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public boolean checking(Integer id,Integer passcode){
        if(id >= 4000){
            return student(id,passcode);
        }
        else if (id >=1000 & id<=3999){
            return employee(id,passcode);
        }
        else return false;
    }
    private boolean student(Integer id,Integer passcode){
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                return loginRepository.student(id,passcode);
            } catch (Exception e) {
                t.rollback();
                return false;

            }
        }

    }
    private boolean employee(Integer id,Integer passcode){
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                return loginRepository.employee(id,passcode);
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
                return false;

            }
        }
    }
}
