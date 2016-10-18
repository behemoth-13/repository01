package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Alex on 09.10.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    transient private HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>((int) Math.max(16, collection.size() / .75f));
        this.addAll(collection);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {
        for (E fromMap : map.keySet()) {
            if (fromMap.equals(e))
                return false;
        }
        map.put(e, PRESENT);
        return true;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object e) {
        return map.containsKey(e);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        if (!map.containsKey(o)) {
            return false;
        }
        map.remove(o);
        return true;
    }

    @Override
    public Object clone() {
        AmigoSet<E> amigoSet = new AmigoSet<>();
        try {
            amigoSet.addAll(this);
            amigoSet.map.putAll(this.map);
        }
        catch (Exception ex) {
            throw new InternalError();
        }
        return amigoSet;
    }


    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(map.size());
        for (E e : map.keySet()) {
            s.writeObject(e);
        }
        s.writeInt((int) HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        s.writeFloat((float) HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        Set<E> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add((E) s.readObject());
        }
        int capacity = s.readInt();
        float loadFactor = s.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
        }
    }
}