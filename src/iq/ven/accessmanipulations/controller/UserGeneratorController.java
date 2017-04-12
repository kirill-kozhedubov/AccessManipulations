package iq.ven.accessmanipulations.controller;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.objects.AccessObjectDiscrete;
import iq.ven.accessmanipulations.service.UserGenerator;
import iq.ven.accessmanipulations.users.User;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.04.2017.
 */
public class UserGeneratorController {
    private ListView<User> usersListView;
    private ListView<AccessObject> objectsListView;
    private TextField userGeneratorAmountTextField;
    private Button generateUsersButton;
    private Button generateAccessMatrixButton;
    private UserGenerator userGenerator;

     UserGeneratorController(ListView<User> usersListView, ListView<AccessObject> objectsListView, TextField userGeneratorAmountTextField, Button generateAccessMatrixButton, Button generateUsersButton) {
        this.generateAccessMatrixButton = generateAccessMatrixButton;
        this.usersListView = usersListView;
        this.objectsListView = objectsListView;
        this.userGeneratorAmountTextField = userGeneratorAmountTextField;
        this.generateUsersButton = generateUsersButton;
        userGenerator = new UserGenerator();
        generateUsersButtonSetOnAction();
        generateAccessMatrixButtonSetOnAction();
    }


    private void generateUsersButtonSetOnAction() {
        generateUsersButton.setOnAction(event -> {
            if (userGeneratorAmountTextField.getText().trim() != "") {
                usersListView.setItems(FXCollections.observableArrayList(userGenerator.generateUserList(Integer.parseInt(userGeneratorAmountTextField.getText()))));
            }
        });
    }

    private void generateAccessMatrixButtonSetOnAction() {
        generateAccessMatrixButton.setOnAction(event -> {
            List<AccessObject> accessObjectList = new ArrayList<>(objectsListView.getItems());
            List<User> userList = new ArrayList<User>(usersListView.getItems());
            userGenerator.generateAccessMatrix(accessObjectList, userList);




        });
    }

}