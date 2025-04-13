package negocio;

import dados.Reserve;
import excecao.EmptyVectorException;
import excecao.FullVectorException;
import excecao.NoLevelException;
import excecao.ReserveNotFoundException;
import repositorio.ReserveRepo;

public class ReserveRegister implements ReserveInterface{

    private ReserveRepo reserveRepository;

    public ReserveRegister() { this.reserveRepository = new ReserveRepo(); }

    @Override
    public void insertReserve(Reserve re) throws FullVectorException, NoLevelException {
        this.reserveRepository.insertReserve(re);
    }

    @Override
    public void removeReserve(String id) throws ReserveNotFoundException, EmptyVectorException {
        this.reserveRepository.removeReserve(id);
    }

    @Override
    public void changeReserve(String id, Integer op, String newValue) throws EmptyVectorException, ReserveNotFoundException {
        this.reserveRepository.changeReserve(id, op, newValue);
    }

    @Override
    public void updateReserve(String id) throws EmptyVectorException, ReserveNotFoundException {
        this.reserveRepository.updateReserve(id);
    }

    @Override
    public Reserve consultReserve(String id) throws ReserveNotFoundException, EmptyVectorException {
        return this.reserveRepository.consultReserve(id);
    }

    @Override
    public Reserve[] list() throws EmptyVectorException {
        return this.reserveRepository.list();
    }
}
