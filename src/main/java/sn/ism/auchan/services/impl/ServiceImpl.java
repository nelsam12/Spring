package sn.ism.auchan.services.impl;

import jakarta.persistence.MappedSuperclass;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.auchan.services.Service;

import java.util.List;

@RequiredArgsConstructor
public abstract class ServiceImpl<T, R extends JpaRepository<T, Long>> implements Service<T> {

    protected final R repository;

    public ServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T create(T itemRequest) {
        return repository.save(itemRequest);
    }

    @Override
    public T update(Long id, T itemRequest) {
        T updatedItem = repository.findById(id).orElse(null);
        if (updatedItem == null) {
            return null;
        }
        updatedItem = setValues(itemRequest, updatedItem);
        return repository.save(updatedItem);
    }

    public abstract T setValues(T itemRequest, T itemFound);

    @Override
    public T getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        T itemDeleted = repository.findById(id).orElse(null);
        if (itemDeleted != null) {
            repository.delete(itemDeleted);
            return true;
        }
        return false;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }
}
