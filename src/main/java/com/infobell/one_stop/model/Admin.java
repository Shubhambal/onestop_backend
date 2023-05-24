package com.infobell.one_stop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents an administrator in the system.
 */
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String emailId;

    /**
     * Gets the administrator ID.
     *
     * @return The administrator ID.
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Sets the administrator ID.
     *
     * @param adminId The administrator ID to set.
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email ID.
     *
     * @return The email ID.
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email ID.
     *
     * @param emailId The email ID to set.
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
