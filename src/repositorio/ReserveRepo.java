package repositorio;

import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.NoLevelException;
import excecao.ReserveNotFoundException;

public class ReserveRepo implements ReserveInterface {

    private static final int MAX = 100;
    private Reserve[] reserveArray;
    private int index;

    public ReserveRepo() {
        this.reserveArray = new Reserve[MAX];
        this.index = -1;
    }

    @Override
    public void insertReserve(Reserve newReserve) throws FullVectorException, NoLevelException {
        this.index = this.index + 1;
        if (this.index < MAX) {
            int teacherLevel = Integer.parseInt(newReserve.getTeacher().getAccessLevel());
            int keyMinLevel = Integer.parseInt(newReserve.getKey().getMinLevel());

            if (teacherLevel >= keyMinLevel) {
                reserveArray[this.index] = newReserve;
            } else {
                throw new NoLevelException();
            }
        } else {
            throw new FullVectorException();
        };
    }

    @Override
    public void removeReserve(String id) throws ReserveNotFoundException, EmptyVectorException {
        if (this.index >= 0) {
            boolean found = false;
            int indexFound = 0;
            for (int i = 0; i <= this.index; i++) {
                if (id.equals(this.reserveArray[i].getId())) {
                    found = true;
                    indexFound = i;
                    break;
                }
            };
            if (found) {
                for (int i = indexFound; i <= index; i++) {
                    this.reserveArray[i] = this.reserveArray[i+1];
                };
                this.reserveArray[this.index] = null; // delete index empty
                this.index = this.index - 1;
            } else {
                throw new ReserveNotFoundException();
            }
        } else {
            throw new EmptyVectorException();
        }
    }

    @Override
    public void changeReserve(String id, Integer op, String newValue) throws EmptyVectorException, ReserveNotFoundException {
        Reserve reserve;
        if (this.index >= 0) {
            reserve = consultReserve(id);
            switch (op) {
                case 1: // Teacher
                    break;
                case 2: // Key
                    break;
                case 3: // Goal
                    reserve.setActivity(newValue);
//                    break;
//                case 4: // Solic_Hour
//                    Date nowHour = new Date();
//                    reserve.setSolicitation_hour(nowHour);
//                    break;
//                case 5: // Devol_Hour
//                    Date devoHour = new Date().after();
//                    break;

            }
        }
    }

    @Override
    public void updateReserve(String id) throws EmptyVectorException, ReserveNotFoundException {
        Reserve reOld = consultReserve(id);
    }

    @Override
    public Reserve consultReserve(String id) throws ReserveNotFoundException, EmptyVectorException {
        Reserve reserve;
        if (this.index >= 0) {
            boolean found = false;
            int indexFound = 0;
            for (int i = 0; i <= this.index; i++) {
                if (id.equals((this.reserveArray[i].getId()))) {
                    found = true;
                    indexFound = i;
                    break;
                }
            }
            if (found) {
                reserve = this.reserveArray[indexFound];
            } else {
                throw new ReserveNotFoundException();
            }
        } else {
            throw new EmptyVectorException();
        }
        return reserve;
    }

    @Override
    public Reserve[] list() throws EmptyVectorException {
        Reserve reList[] = null; // creating a new vector of reserves
        if (this.index >= 0) {
            reList = new Reserve[this.index+1];
            for (int i = 0; i <= this.index; i++) { // perguntar sobre o index a ricardo
                reList[i] = this.reserveArray[i];
            }
        } else {
            throw new EmptyVectorException();
        }
        return reList;
    }
}
