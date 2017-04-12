package iq.ven.accessmanipulations.controller;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.users.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.04.2017.
 */
public class AccessPanelController {


    private Label accessPanelLoginLabel;
    private Label accessPanelAnswerLabel;
    private TextField accessPanelIdTextField;
    private Button accessPanelReadButton;
    private Button accessPanelWriteButton;
    private Button accessPanelLoginButton;
    private ListView<User> usersListView;
    private ListView<AccessObject> objectsListView;

    private User loggedInUser = null;


    public AccessPanelController(Label accessPanelLoginLabel, Label accessPanelAnswerLabel,
                                 TextField accessPanelIdTextField, Button accessPanelReadButton,
                                 Button accessPanelWriteButton, Button accessPanelLoginButton,
                                 ListView<User> usersListView, ListView<AccessObject> objectsListView) {

        this.accessPanelLoginLabel = accessPanelLoginLabel;
        this.accessPanelAnswerLabel = accessPanelAnswerLabel;
        this.accessPanelIdTextField = accessPanelIdTextField;
        this.accessPanelReadButton = accessPanelReadButton;
        this.accessPanelWriteButton = accessPanelWriteButton;
        this.accessPanelLoginButton = accessPanelLoginButton;
        this.usersListView = usersListView;
        this.objectsListView = objectsListView;
        accessPanelLoginButtonSetOnAction();
        accessPanelReadButtonSetOnAction();
        accessPanelWriteButtonSetOnAction();
    }

    private void accessPanelReadButtonSetOnAction() {
        accessPanelReadButton.setOnAction(event -> {
            AccessObject accessObject = objectsListView.getSelectionModel().getSelectedItem();
            if (accessObject.canUserRead(loggedInUser)) {
                accessPanelAnswerLabel.setText(loggedInUser.getUserId() + " can read " + accessObject.getId());
            } else {
                accessPanelAnswerLabel.setText(loggedInUser.getUserId() + " can't read " + accessObject.getId());
            }

        });
    }

    private void accessPanelWriteButtonSetOnAction() {
        accessPanelWriteButton.setOnAction(event -> {
            AccessObject accessObject = objectsListView.getSelectionModel().getSelectedItem();
            if (accessObject.canUserRead(loggedInUser)) {
                accessPanelAnswerLabel.setText(loggedInUser.getUserId() + " can write " + accessObject.getId());
            } else {
                accessPanelAnswerLabel.setText(loggedInUser.getUserId() + " can't write " + accessObject.getId());
            }

        });
    }

    private void accessPanelLoginButtonSetOnAction() {
        accessPanelLoginButton.setOnAction(event -> {
            String idString = accessPanelIdTextField.getText();
            List<User> userList = new ArrayList<>(usersListView.getItems());

            for (User user : userList) {
                if (idString.equals(user.getUserId())) {
                    accessPanelLoginLabel.setText(user.getUserId());
                    loggedInUser = user;
                }
            }
            if (loggedInUser == null) System.out.println("Error in signing up");
        });
    }

    public void adminRead() {
        AccessObject accessObject = objectsListView.getSelectionModel().getSelectedItem();
        accessPanelAnswerLabel.setText("Admin can read " + accessObject.getId());
    }

    public void adminWrite() {
        AccessObject accessObject = objectsListView.getSelectionModel().getSelectedItem();
        accessPanelAnswerLabel.setText("Admin can write " + accessObject.getId());
    }
}
