package negocio;

import dados.Teacher;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.SiapeIsInUseException;
import excecao.TeacherNotFoundException;
import repositorio.ReserveRepo;
import repositorio.TeacherRepo;

public class TeacherRegister implements TeacherInterface {

    private TeacherRepo teacherRepository;

    public TeacherRegister() { this.teacherRepository = new TeacherRepo(); }


    @Override
    public void insertTeacher(Teacher newTeacher) throws FullVectorException, TeacherNotFoundException, EmptyVectorException, SiapeIsInUseException {
        Teacher siapeInUse = this.consultTeacher(newTeacher.getSiape());
        if (siapeInUse == null) {
            this.teacherRepository.insertTeacher(newTeacher);
        } else {
            throw new SiapeIsInUseException();
        }
    }

    @Override
    public void removeTeacher(String siape) throws TeacherNotFoundException, EmptyVectorException {
        this.teacherRepository.removeTeacher(siape);
    }

    @Override
    public void changeTeacher(String siape, Integer op, String newValue) throws EmptyVectorException, TeacherNotFoundException {
        this.teacherRepository.changeTeacher(siape, op, newValue);
    }

    @Override
    public void updateTeacher(String siape) throws EmptyVectorException, TeacherNotFoundException {
        this.teacherRepository.updateTeacher(siape);
    }

    @Override
    public Teacher consultTeacher(String siape) throws TeacherNotFoundException, EmptyVectorException {
        return this.teacherRepository.consultTeacher(siape);
    }

    @Override
    public Teacher[] list() throws EmptyVectorException {
        return this.teacherRepository.list();
    }
}
