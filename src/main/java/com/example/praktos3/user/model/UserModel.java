package com.example.praktos3.user.model;

import com.example.praktos3.order.model.OrderModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Фамилия обязательна")
    private String lastName;

    @NotBlank(message = "Имя обязательно")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Логин обязателен")
    @Column(unique = true)
    private String login;

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
    private String password;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Некорректный номер телефона")
    private String phoneNumber;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Некорректный email")
    private String email;

    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderModel> orders;


    public UserModel() {

    }

    public UserModel(Long id, String lastName, String firstName, String middleName,
                     String login, String password, String phoneNumber,
                     String email, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Фамилия обязательна") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Фамилия обязательна") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Имя обязательно") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "Имя обязательно") String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public @NotBlank(message = "Логин обязателен") String getLogin() {
        return login;
    }

    public void setLogin(@NotBlank(message = "Логин обязателен") String login) {
        this.login = login;
    }

    public @NotBlank(message = "Пароль обязателен") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Пароль обязателен") String password) {
        this.password = password;
    }

    public @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Некорректный номер телефона") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Некорректный номер телефона") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Некорректный email") String getEmail() {
        return email;
    }

    public void setEmail(@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Некорректный email") String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}