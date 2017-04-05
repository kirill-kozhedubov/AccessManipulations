package iq.ven.accessmanipulations.users;

import iq.ven.accessmanipulations.objects.AccessObject;

/**
 * Created by netcracker on 30.03.2017.
 */
public class Client extends User {

    public Client(String userId, int rights) {
        super(userId, rights);
    }

    @Override
    public String toString() {
        return "User id: " + userId + " lvl: " + rights;
    }

}
