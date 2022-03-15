package service.impl;

import Entity.Professor;
import Entity.SectionCourse;
import Entity.Student;
import org.hibernate.SessionFactory;
import repository.imp.ProfessRepository;
import repository.imp.ProfessorRepositoryEmployee;
import repository.imp.SessionFactorySingleton;

import java.util.List;

public class ProfessorService {
    private int id;
    SessionFactory sessionFactory;
    ProfessRepository professRepository;

    public ProfessorService() {
        professRepository = new ProfessRepository();
        sessionFactory = SessionFactorySingleton.getInstance();
    }

    public void setId(int id) {
        this.id = id;
        professRepository.setId(id);
    }

    public void insertScore(int studentId, int score){
        try(var seesion=sessionFactory.getCurrentSession()){
            var t = seesion.getTransaction();
            try {
               t.begin();
                professRepository.insertScore(studentId, score);
                t.commit();
            }catch (Exception e){
                e.printStackTrace();
                t.rollback();
            }
        }

    }
    public List<SectionCourse> myStudent(){
        List<SectionCourse> list = null;
        try(var seesion=sessionFactory.openSession()){
            var t = seesion.getTransaction();
            try {
                t.begin();
               list= professRepository.myStudent();
            }catch (Exception e){
                e.printStackTrace();
                t.rollback();
                return null;
            }
        }
        return list;
    }
    public Professor myInfo(){
        Professor professor=professRepository.myInfo();
        if (professor.getStatus().equals("ft")){
            Long unit = professRepository.myUnit();
            professor.setAllUnit(unit);
        }
        return professor;
        }

    }
