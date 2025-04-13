package repositorio;

import dados.Key;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.KeyNotFoundException;

public class KeyRepo implements KeyInterface {

    private static final int MAX = 100;
    private Key[] keyArray;
    private int index;

    public KeyRepo() {
        this.keyArray = new Key[MAX];
        this.index = -1;
    }

    @Override
    public void insertKey(Key newKey) throws FullVectorException {
        this.index = this.index + 1;
        if (this.index < MAX) {
            keyArray[this.index] = newKey;
        } else {
            throw new FullVectorException();
        };
    }

    @Override
    public void removeKey(String number) throws KeyNotFoundException, EmptyVectorException {
        if (this.index >= 0) {
            boolean found = false;
            int indexFound = 0;
            for (int i = 0; i <= this.index; i++) {
                if (number.equals(this.keyArray[i].getNumber())) {
                    found = true;
                    indexFound = i;
                    break;
                }
            };
            if (found) {
                for (int i = indexFound; i <= this.index; i++) {
                    this.keyArray[i] = this.keyArray[i+1];
                };
                this.keyArray[this.index] = null; // delete index empty
                this.index = this.index - 1;
            } else {
                throw new KeyNotFoundException();
            }
        } else {
            throw new EmptyVectorException();
        }
    }

    @Override
    public void changeKey(String number, Integer op, String newValue) throws EmptyVectorException, KeyNotFoundException {
        Key key = consultKey(number);
        switch (op) {
            case 1 -> key.setNumber(newValue);
            case 2 -> key.setRoom(newValue);
            case 3 -> key.setMinLevel(newValue);
        }
    }

    @Override
    public void updateKey(String number) throws EmptyVectorException, KeyNotFoundException {
        Key key = consultKey(number);
    }

    @Override
    public Key consultKey(String number) throws KeyNotFoundException, EmptyVectorException {
        Key key;
        if (this.index >= 0) {
            boolean found = false;
            int indexFound = 0;
            for (int i = 0; i <= this.index; i++) {
                if (number.equals((this.keyArray[i].getNumber()))) {
                    found = true;
                    indexFound = i;
                    break;
                }
            }
            if (found) {
                key = this.keyArray[indexFound];
            } else {
                throw new KeyNotFoundException();
            }
        } else {
            throw new EmptyVectorException();
        }
        return key;
    }

    @Override
    public Key[] list() throws EmptyVectorException {
        Key keyList[] = null; // creating a new vector of keys
        if (this.index >= 0) {
            keyList = new Key[this.index+1];
            for (int i = 0; i <= this.index; i++) { // perguntar sobre o index a ricardo
                keyList[i] = this.keyArray[i];
            }
        } else {
            throw new EmptyVectorException();
        }
        return keyList;
    }
}
