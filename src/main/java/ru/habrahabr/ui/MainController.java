package ru.habrahabr.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.habrahabr.entity.Contact;
import ru.habrahabr.service.ContactService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Date: 27.08.15
 * Time: 11:10
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 * @author http://mruslan.com
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    // Autowired beans
    @Autowired private ContactService contactService;

    // FXML fields
    @FXML private TableView<Contact> table;
    @FXML private TextField txtName;
    @FXML private TextField txtPhone;
    @FXML private TextField txtEmail;

    // Variables
    private ObservableList<Contact> data;

    @FXML
    public void fxmlInit() {
        // Имейте ввиду, что такие методы инициализации UI от JavaFX не пройдут.
        // Инициализация UI, в данном случае, происходит в методе init() (@PostConstruct);

        // Хотя поведение элементов, такое как setOnAction, лучше описывать в FXML файле.
        // Например: onAction="#onButtonPress"
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        List<Contact> contacts = contactService.findAll();
        data = FXCollections.observableArrayList(contacts);

        // Столбцы таблицы
        TableColumn<Contact, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Contact, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Contact, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Contact, String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().setAll(idColumn, nameColumn, phoneColumn, emailColumn);

        // Данные таблицы
        table.setItems(data);
    }

    @FXML
    public void addContact() {
        Contact contact = new Contact(txtName.getText(), txtPhone.getText(), txtEmail.getText());
        contactService.save(contact);
        data.add(contact);

        // чистим поля
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }
}
