package iq.ven.accessmanipulations.service;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.objects.AccessObjectDiscrete;
import iq.ven.accessmanipulations.users.Admin;
import iq.ven.accessmanipulations.users.Client;
import iq.ven.accessmanipulations.users.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by netcracker on 30.03.2017.
 */
public class UserGenerator {
    private Random random = new Random();

    public List<User> generateUserList(int size) {
        List<User> userList = new ArrayList<>();
        userList.add(generateAdmin());
        for (int i = 1; i < size; i++) {
            userList.add(generateClient());
        }
        return userList;
    }

    private Client generateClient() {
        Client client = new Client(String.valueOf(random.nextInt(1000) + 1000), random.nextInt(100));
        return client;
    }

    private Admin generateAdmin() {
        Admin admin = new Admin(String.valueOf(random.nextInt(20000) + 10000));
        return admin;
    }


    public void generateAccessMatrix(List<AccessObject> accessObjectDiscreteList, List<User> userList) {

        for (AccessObject accessObject : accessObjectDiscreteList) {
            List<Integer> integers;

            //generating amounts of users to read and write
            int usersToReadAmount = random.nextInt(userList.size());
            int usersToWriteAmount = random.nextInt(userList.size());

            //generating and setting users of certain amount to read and write
            integers = getListOfRandomUsers(userList.size());
            for (int i = 0; i < usersToReadAmount; i++) {
                accessObject.addRead(userList.get(integers.get(i)));
            }
            integers = getListOfRandomUsers(userList.size());
            for (int i = 0; i < usersToWriteAmount; i++) {
                accessObject.addWrite(userList.get(integers.get(i)));

            }
        }
    }

    private List<Integer> getListOfRandomUsers(int userAmount) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < userAmount; i++) {
            integers.add(i);
        }
        Collections.shuffle(integers);
        return integers;
    }


}

