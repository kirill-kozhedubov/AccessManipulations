package iq.ven.accessmanipulations.objects;

import iq.ven.accessmanipulations.users.Admin;
import iq.ven.accessmanipulations.users.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by netcracker on 30.03.2017.
 */
public class AccessObjectDiscrete implements AccessObject {
    private StringBuffer data;
    private int id;
    private Set<User> usersAbleToRead;
    private Set<User> usersAbleToWrite;

    public AccessObjectDiscrete(String data, int id) {
        this.data = new StringBuffer(data);
        this.id = id;
        usersAbleToRead = new HashSet<>();
        usersAbleToWrite = new HashSet<>();
    }

    public StringBuffer getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public boolean addRead(User user) {
        usersAbleToRead.add(user);
        return true;
    }

    public boolean addWrite(User user) {
        usersAbleToWrite.add(user);
        return true;
    }

    public boolean removeRead(User user) {
        usersAbleToRead.remove(user);
        return true;
    }

    public boolean removeWrite(User user) {
        usersAbleToWrite.remove(user);
        return true;
    }

    public boolean canUserRead(User user) {
        if (user == null) {
            return false;
        }
        if (user instanceof Admin) {
            return true;
        }
        for (User reader : usersAbleToRead) {
            if (user.equals(reader)) {
                return true;
            }
        }
        return false;
    }

    public boolean canUserWrite(User user) {
        if (user == null) {
            return false;
        }
        if (user instanceof Admin) {
            return true;
        }
        for (User writer : usersAbleToWrite) {
            if (user.equals(writer)) {
                return true;
            }
        }
        return false;
    }

    public Set<User> getUsersAbleToRead() {
        return usersAbleToRead;
    }

    public Set<User> getUsersAbleToWrite() {
        return usersAbleToWrite;
    }

    @Override
    public String toString() {
        return "Discrete id: " + id + " data: " + data;
    }
}
