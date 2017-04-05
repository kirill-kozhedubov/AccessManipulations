package iq.ven.accessmanipulations.controller;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.service.AccessObjectGenerator;
import iq.ven.accessmanipulations.service.UserGenerator;
import iq.ven.accessmanipulations.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by User on 05.04.2017.
 */
public class MasterController implements Initializable {

    /* Access objects and users */
    @FXML
    ListView<User> usersListView;
    @FXML
    ListView<AccessObject> objectsListView;


    /* User generator panel components */
    @FXML
    TextField userGeneratorAmountTextField;
    @FXML
    Button generateUsersButton;
    @FXML
    Button generateAccessMatrixButton;

    /* Access object generator panel components */
    @FXML
    TextField accessObjectAmountTextField;
    @FXML
    Button generateObjectsButton;
    @FXML
    CheckBox mandateCheckBox;


    /* Access panel components */
    @FXML
    Label accessPanelLoginLabel;
    @FXML
    Label accessPanelAnswerLabel;
    @FXML
    TextField accessPanelIdTextField;
    @FXML
    Button accessPanelReadButton;
    @FXML
    Button accessPanelWriteButton;
    @FXML
    Button accessPanelLoginButton;

    /* Admin panel components */
    @FXML
    Button adminReadButton;
    @FXML
    Button adminWriteButton;
    @FXML
    Button adminGiveReadButton;
    @FXML
    Button adminGiveWriteButton;
    @FXML
    Button adminChangeLvlButton;
    @FXML
    TextField adminChangeLvlTextField;


    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        ObjectGeneratorController objectGeneratorController = new ObjectGeneratorController(objectsListView, accessObjectAmountTextField, generateObjectsButton, mandateCheckBox);
        UserGeneratorController userGeneratorController = new UserGeneratorController(usersListView, objectsListView, userGeneratorAmountTextField, generateAccessMatrixButton, generateUsersButton);

        UserGenerator userGenerator = new UserGenerator();
        List<User> userList = userGenerator.generateUserList(10);
        ObservableList<User> observableUserList = FXCollections.observableArrayList(userList);
        usersListView.setItems(observableUserList);


        AccessObjectGenerator accessObjectGenerator = new AccessObjectGenerator();
        List<AccessObject> accessObjects = accessObjectGenerator.generateDiscreteAccessObjectList(10);
        ObservableList<AccessObject> observableAccessObjects = FXCollections.observableArrayList(accessObjects);
        objectsListView.setItems(observableAccessObjects);


        objectsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("old:" + oldValue + "\nnew:" + newValue);
        });


    }

}
