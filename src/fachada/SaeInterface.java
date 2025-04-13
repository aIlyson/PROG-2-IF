package fachada;

import dados.Key;
import dados.Reserve;
import dados.Teacher;
import excecao.*;

import java.util.Date;

public interface SaeInterface {

    //KEY METHODS

    public void insertKey(Key newKey) throws FullVectorException;
    public void removeKey(String number) throws KeyNotFoundException, EmptyVectorException;
    public void changeKey(String number, Integer op, String newValue) throws EmptyVectorException, KeyNotFoundException;
    public void updateKey(String number) throws EmptyVectorException, KeyNotFoundException;
    public Key consultKey(String number) throws KeyNotFoundException, EmptyVectorException;
    public Key[] listKeys() throws EmptyVectorException;

    // TEACHER METHODS

    public void insertTeacher(Teacher te) throws FullVectorException, SiapeIsInUseException, TeacherNotFoundException, EmptyVectorException;
    public void removeTeacher(String siape) throws TeacherNotFoundException, EmptyVectorException;
    public void changeTeacher(String siape, Integer op, String newValue) throws EmptyVectorException, TeacherNotFoundException;
    public void updateTeacher(String siape) throws EmptyVectorException, TeacherNotFoundException;
    public Teacher consultTeacher(String siape) throws TeacherNotFoundException, EmptyVectorException;
    public Teacher[] listTeachers() throws EmptyVectorException;

    // RESERVE METHODS

    public void insertReserve(String SIAPE, String keyNumber, String goal, String solicitation_hour, String devolution_hour, String id) throws FullVectorException, TeacherNotFoundException, EmptyVectorException, KeyNotFoundException, NoLevelException;
    public void removeReserve(String id) throws ReserveNotFoundException, EmptyVectorException;
    public void changeReserve(String id, Integer op, String newValue) throws EmptyVectorException, ReserveNotFoundException;
    public void updateReserve(String id) throws EmptyVectorException, ReserveNotFoundException;
    public Reserve consultReserve(String id) throws ReserveNotFoundException, EmptyVectorException;
    public Reserve[] listReserves() throws EmptyVectorException;
}
