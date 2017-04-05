package iq.ven.accessmanipulations.objects;

import iq.ven.accessmanipulations.users.User;

/**
 * Created by User on 05.04.2017.
 */
public interface AccessObject {

    StringBuffer getData();

    int getId();

    boolean canUserRead(User user);

    boolean canUserWrite(User user);


    boolean addRead(User user);

    boolean addWrite(User user);

    boolean removeRead(User user);

    boolean removeWrite(User user);
}
