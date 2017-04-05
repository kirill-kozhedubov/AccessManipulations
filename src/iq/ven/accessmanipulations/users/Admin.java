package iq.ven.accessmanipulations.users;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.objects.AccessObjectDiscrete;

/**
 * Created by netcracker on 30.03.2017.
 */
public class Admin extends User {
    public Admin(String userId) {
        super(userId, Integer.MAX_VALUE);
        this.userId = new StringBuffer(userId);
    }

    public void changeUserRightsLevel(User user, int rights) {
        int oldRights = user.getRights();
        user.setRights(rights);
        System.out.println("User " + user + " rights changed from " + oldRights + " level to " + rights + ".");
    }

    public void giveRead(User user, AccessObjectDiscrete accessObject) {
        accessObject.addRead(user);
    }

    public void giveWrite(User user, AccessObjectDiscrete accessObject) {
        accessObject.addWrite(user);
    }

    public void removeRead(User user, AccessObjectDiscrete accessObject) {
        accessObject.removeRead(user);
    }

    public void removeWrite(User user, AccessObjectDiscrete accessObject) {
        accessObject.removeWrite(user);
    }

    public void setNewRightLevel(User user, int rights) {
        user.setRights(rights);
    }

    @Override
    public boolean tryToReadObject(AccessObject accessObject) {
        return true;
    }

    @Override
    public boolean tryToWriteObject(AccessObject accessObject) {
        return true;
    }

    @Override
    public String toString() {
        return "Admin id: " + userId;
    }
}
