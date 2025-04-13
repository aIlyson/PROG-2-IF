package negocio;

import dados.Key;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.KeyNotFoundException;

public interface KeyInterface {
    public void insertKey(Key newKey) throws FullVectorException;
    public void removeKey(String number) throws KeyNotFoundException, EmptyVectorException;
    public void changeKey(String number, Integer op, String newValue) throws EmptyVectorException, KeyNotFoundException;
    public void updateKey(String number) throws EmptyVectorException, KeyNotFoundException;
    public Key consultKey(String number) throws KeyNotFoundException, EmptyVectorException;
    public Key[] list() throws EmptyVectorException;
}
