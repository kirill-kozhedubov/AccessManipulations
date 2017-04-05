package iq.ven.accessmanipulations.objects;

import iq.ven.accessmanipulations.users.User;

import java.util.Set;

/**
 * Created by User on 05.04.2017.
 */
public class AccessObjectMandate implements AccessObject {
    private StringBuffer data;
    private int id;
    private int accessLevelToRead;

    public AccessObjectMandate(String data, int id, int accessLevelToRead) {
        this.data = new StringBuffer(data);
        this.id = id;
        this.accessLevelToRead = accessLevelToRead;
    }


    @Override
    public StringBuffer getData() {
        return data;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean canUserRead(User user) {
        if (user.getRights() >= accessLevelToRead) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canUserWrite(User user) {
        if (user.getRights() >= accessLevelToRead) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mandate id: " + id + " lvl: " + accessLevelToRead + " data: " + data;
    }





    /*Methods I dont wanna mess with*/


    @Override
    public boolean addRead(User user) {
        return false;
    }

    @Override
    public boolean addWrite(User user) {
        return false;
    }

    @Override
    public boolean removeRead(User user) {
        return false;
    }

    @Override
    public boolean removeWrite(User user) {
        return false;
    }

/*   //access object test matrix
 @Override
    public Set<User> getUsersAbleToRead() {
        return null;
    }

    @Override
    public Set<User> getUsersAbleToWrite() {
        return null;
    }*/

}
