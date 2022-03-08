package service.impl.employee;

import Entity.Employee;
import Entity.Professor;
import repository.imp.ProfessorRepositoryEmployee;
import service.Service;

import java.util.List;
import java.util.Random;

public class ProfessorServiceEmployee implements Service<Professor> {
    ProfessorRepositoryEmployee professorRepositoryEmployee = new ProfessorRepositoryEmployee();
    @Override
    public void add(Professor professor) {
        Random random = new Random();
        int id = random.ints(4, 2000, 3000).findFirst().getAsInt();
        professor.setEmployeeId(id);
        try {
            professorRepositoryEmployee.add(professor);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("professor not added");
        }
    }

    @Override
    public void remove(Professor professor) {

    }

    @Override
    public List<Professor> findAll() {
        List<Professor> list = null;
        try {
            list= professorRepositoryEmployee.findAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Not find");
        }
        return list;
    }

    @Override
    public Professor showInformation(int id) {
        Professor professor = null;
        try {
            professor =professorRepositoryEmployee.showInformation(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("User not find");
        }
        return professor;
    }
}
