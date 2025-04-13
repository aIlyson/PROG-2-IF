package negocio;

import dados.Key;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.KeyNotFoundException;
import repositorio.KeyRepo;

public class KeyRegister implements KeyInterface {

    private KeyRepo keyRepository;

    public KeyRegister() {
        this.keyRepository = new KeyRepo();
    }

    @Override
    public void insertKey(Key newKey) throws FullVectorException {
        this.keyRepository.insertKey(newKey);
    }

    @Override
    public void removeKey(String number) throws KeyNotFoundException, EmptyVectorException {
        this.keyRepository.removeKey(number);
    }

    @Override
    public void changeKey(String number, Integer op, String newValue) throws EmptyVectorException, KeyNotFoundException {
        this.keyRepository.changeKey(number, op, newValue);
    }

    @Override
    public void updateKey(String number) throws EmptyVectorException, KeyNotFoundException {
        this.keyRepository.updateKey(number);
    }

    @Override
    public Key consultKey(String number) throws KeyNotFoundException, EmptyVectorException {
        return this.keyRepository.consultKey(number);
    }

    @Override
    public Key[] list() throws EmptyVectorException {
        return this.keyRepository.list();
    }
}
