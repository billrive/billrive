/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import java.util.List;


public interface GenericDao<T extends GenericObject> {

    public T get(Long id);

    public List<T> getAll();

    public void save(T object);

    public void delete(T object);

    public void indexEntity(T object);

    public void indexAllItems();

}
