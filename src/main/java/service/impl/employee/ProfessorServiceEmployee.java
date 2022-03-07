package service.impl.employee;

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
        professorRepositoryEmployee.add(professor);
    }

    @Override
    public void remove(Professor professor) {

    }

    @Override
    public List<Professor> findAll() {
        return null;
    }

    @Override
    public Professor showInformation(int id) {
        return null;
    }
}
