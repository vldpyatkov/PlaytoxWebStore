package com.store.dao;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/7/13
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IGenericDao <T, PK extends Serializable> {
    /** Сохранить объект newInstance в базе данных */
    PK create(T newInstance);

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T read(PK id);

    /** Сохранить изменения, сделанные в объекте.  */
    void update(T transientObject);

    /** Удалить объект из базы данных */
    void delete(T persistentObject);
}
