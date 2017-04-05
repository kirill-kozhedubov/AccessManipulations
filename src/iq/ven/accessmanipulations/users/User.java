package iq.ven.accessmanipulations.users;

import iq.ven.accessmanipulations.objects.AccessObject;

/**
 * Created by netcracker on 30.03.2017.
 */
public abstract class User {
    protected StringBuffer userId;
    protected int rights;

    public User(String userId, int rights) {
        this.userId = new StringBuffer(userId);
        this.rights = rights;
    }

    public String getUserId() {
        return userId.toString();
    }

    public int getRights() {
        return rights;
    }

    public void setRights(int rights) {
        this.rights = rights;
    }

    public boolean tryToReadObject(AccessObject accessObject) {
        return accessObject.canUserRead(this);
    }

    public boolean tryToWriteObject(AccessObject accessObject) {
        return accessObject.canUserWrite(this);
    }

}
