/**
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package my.test.notepad.dao;

import java.io.Serializable;
import java.util.List;

import my.test.notepad.lib.exception.NoteException;

public interface IDao<T, ID extends Serializable> {
    T saveOrUpdate(T pobject, String collection);

    T getByID(String id, String collection);
    
    T getByID(Long id, String collection);

    List<T> getAll(String collection);

    boolean delete(String id, String collection);
    
    boolean delete(Long id, String collection) throws NoteException;
    
    boolean deleteAll(String field, List<Long> noteIds, String noteCollection);

    void createCollection(String collection);
    
    T insert(T pobject, String collection);
}
