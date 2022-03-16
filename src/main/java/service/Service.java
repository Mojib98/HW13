package service;

import Entity.BaseClass;

import java.util.List;

public interface Service <T extends BaseClass> {
    void add(T t);
    void remove(T t);
    //List<T> findAll();
    T showInformation(int id);

}
