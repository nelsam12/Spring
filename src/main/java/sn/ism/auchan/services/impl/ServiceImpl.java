package sn.ism.auchan.services.impl;

import lombok.RequiredArgsConstructor;
import sn.ism.auchan.services.Service;

import java.util.List;

@RequiredArgsConstructor
public class ServiceImpl<T, R> implements Service<T> {

    private final R repository;

    @Override
    public T create(T itemRequest) {
        return null;
    }

    @Override
    public T update(Long id, T itemRequest) {
        return null;
    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<T> getAll() {
        return List.of();
    }
}
