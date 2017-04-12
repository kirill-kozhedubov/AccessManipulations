package iq.ven.accessmanipulations.controller;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.users.User;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Created by User on 05.04.2017.
 */
public class AdminPanelController {

    private Button adminReadButton;
    private Button adminWriteButton;
    private Button adminGiveReadButton;
    private Button adminGiveWriteButton;
    private Button adminChangeLvlButton;
    private TextField adminChangeLvlTextField;
    private ListView<User> usersListView;
    private ListView<AccessObject> objectsListView;
    private User selectedUser;
    private AccessObject selectedObject;
    private AccessPanelController accessPanelController;


    public AdminPanelController(Button adminReadButton, Button adminWriteButton,
                                Button adminGiveReadButton, Button adminGiveWriteButton,
                                Button adminChangeLvlButton, TextField adminChangeLvlTextField,
                                ListView<User> usersListView, ListView<AccessObject> objectsListView,
                                AccessPanelController accessPanelController) {

        this.accessPanelController = accessPanelController;
        this.adminReadButton = adminReadButton;
        this.adminWriteButton = adminWriteButton;
        this.adminGiveReadButton = adminGiveReadButton;
        this.adminGiveWriteButton = adminGiveWriteButton;
        this.adminChangeLvlButton = adminChangeLvlButton;
        this.adminChangeLvlTextField = adminChangeLvlTextField;
        this.usersListView = usersListView;
        this.objectsListView = objectsListView;

        adminChangeLvlButtonSetOnAction();
        adminGiveReadButtonSetOnAction();
        adminGiveWriteButtonSetOnAction();
        adminReadButtonSetOnAction();
        adminWriteButtonSetOnAction();

    }

    private void updateSelectedUser() {
        selectedUser = usersListView.getSelectionModel().getSelectedItem();
    }

    private void updateSelectedObject() {
        selectedObject = objectsListView.getSelectionModel().getSelectedItem();
    }

    private void adminReadButtonSetOnAction() {
        adminReadButton.setOnAction(event -> {
            accessPanelController.adminRead();
        });
    }

    private void adminWriteButtonSetOnAction() {
        adminWriteButton.setOnAction(event -> {
            accessPanelController.adminWrite();
        });
    }

    private void adminGiveReadButtonSetOnAction() {
        adminGiveReadButton.setOnAction(event -> {
            updateSelectedUser();
            updateSelectedObject();
            selectedObject.addRead(selectedUser);
        });
    }

    private void adminGiveWriteButtonSetOnAction() {
        adminGiveWriteButton.setOnAction(event -> {
            updateSelectedUser();
            updateSelectedObject();
            selectedObject.addWrite(selectedUser);
        });
    }

    private void adminChangeLvlButtonSetOnAction() {
        adminChangeLvlButton.setOnAction(event -> {
            updateSelectedUser();
            selectedUser.setRights(Integer.parseInt(adminChangeLvlTextField.getText()));
            usersListView.refresh();
        });
    }


}
