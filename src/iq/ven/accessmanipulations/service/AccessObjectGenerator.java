package iq.ven.accessmanipulations.service;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.objects.AccessObjectDiscrete;
import iq.ven.accessmanipulations.objects.AccessObjectMandate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by netcracker on 30.03.2017.
 */
public class AccessObjectGenerator {
    private Random random = new Random();

    public List<AccessObject> generateDiscreteAccessObjectList(int size) {
        List<AccessObject> accessObjectList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            AccessObject accessObject = new AccessObjectDiscrete(generateData(), random.nextInt(500));
            accessObjectList.add(accessObject);
        }
        return accessObjectList;
    }

    public List<AccessObject> generateMandateAccessObjectList(int size) {
        List<AccessObject> accessObjectList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            AccessObject accessObject = new AccessObjectMandate(generateData(), random.nextInt(500), random.nextInt(100));
            accessObjectList.add(accessObject);
        }
        return accessObjectList;
    }

    private String generateData() {
        char[] dataChars = new char[random.nextInt(10) + 5];
        for (int i = 0; i < dataChars.length; i++) {
            dataChars[i] = (char) (random.nextInt(26) + 'a');
        }
        String data = new String(dataChars);
        return data;
    }

}
