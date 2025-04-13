package fachada;

import negocio.KeyRegister;
import negocio.ReserveRegister;
import negocio.TeacherRegister;
import dados.Key;
import dados.Reserve;
import dados.Teacher;
import excecao.*;

import java.util.Date;

public class Sae implements SaeInterface{

    private ReserveRegister reserveRegister;
    private TeacherRegister teacherRegister;
    private KeyRegister keyRegister;

    public Sae() {
        this.reserveRegister = new ReserveRegister();
        this.teacherRegister = new TeacherRegister();
        this.keyRegister = new KeyRegister();
    }


    @Override
    public void insertKey(Key newKey) throws FullVectorException {
        this.keyRegister.insertKey(newKey);
    }

    @Override
    public void removeKey(String number) throws KeyNotFoundException, EmptyVectorException {
        this.keyRegister.removeKey(number);
    }

    @Override
    public void changeKey(String number, Integer op, String newValue) throws EmptyVectorException, KeyNotFoundException {
        this.keyRegister.changeKey(number, op, newValue);
    }

    @Override
    public void updateKey(String number) throws EmptyVectorException, KeyNotFoundException {
        this.keyRegister.updateKey(number);
    }

    @Override
    public Key consultKey(String number) throws KeyNotFoundException, EmptyVectorException {
        return this.keyRegister.consultKey(number);
    }

    @Override
    public Key[] listKeys() throws EmptyVectorException {
        return this.keyRegister.list();
    }

    @Override
    public void insertTeacher(Teacher newTeacher) throws FullVectorException, SiapeIsInUseException, TeacherNotFoundException, EmptyVectorException {
        this.teacherRegister.insertTeacher(newTeacher);
    }

    @Override
    public void removeTeacher(String siape) throws TeacherNotFoundException, EmptyVectorException {
        this.teacherRegister.removeTeacher(siape);
    }

    @Override
    public void changeTeacher(String siape, Integer op, String newValue) throws EmptyVectorException, TeacherNotFoundException {
        this.teacherRegister.changeTeacher(siape, op, newValue);
    }

    @Override
    public void updateTeacher(String siape) throws EmptyVectorException, TeacherNotFoundException {
        this.teacherRegister.updateTeacher(siape);
    }

    @Override
    public Teacher consultTeacher(String siape) throws TeacherNotFoundException, EmptyVectorException {
        return this.teacherRegister.consultTeacher(siape);
    }

    @Override
    public Teacher[] listTeachers() throws EmptyVectorException {
        return this.teacherRegister.list();
    }

    @Override
    public void insertReserve(
            String SIAPE,
            String keyNumber,
            String goal,
            String solicitation_hour,
            String devolution_hour,
            String id
    ) throws FullVectorException, TeacherNotFoundException, EmptyVectorException, KeyNotFoundException, NoLevelException {
        Teacher teacher = this.teacherRegister.consultTeacher(SIAPE);
        Key key = this.keyRegister.consultKey(keyNumber);
        Reserve newReserve = new Reserve(teacher, key, goal, solicitation_hour, devolution_hour, id);
        this.reserveRegister.insertReserve(newReserve);
    }

    @Override
    public void removeReserve(String id) throws ReserveNotFoundException, EmptyVectorException {
        this.reserveRegister.removeReserve(id);
    }

    @Override
    public void changeReserve(String id, Integer op, String newValue) throws EmptyVectorException, ReserveNotFoundException {
        this.reserveRegister.changeReserve(id, op, newValue);
    }

    @Override
    public void updateReserve(String id) throws EmptyVectorException, ReserveNotFoundException {
        this.reserveRegister.updateReserve(id);
    }

    @Override
    public Reserve consultReserve(String id) throws ReserveNotFoundException, EmptyVectorException {
        return this.reserveRegister.consultReserve(id);
    }

    @Override
    public Reserve[] listReserves() throws EmptyVectorException {
        return this.reserveRegister.list();
    }
}
