/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.GenericObject;
import java.util.List;

/**
 *
 * @author Prashanth
 */
public interface GenericDao<T> {

    public T get(Long id);

    public List<T> getAll();

    public void save(T object);

    public void delete(T object);

    public void indexEntity(T object);

    public void indexAllItems();
}
