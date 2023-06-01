package com.emart.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents the customers in the system.
 * @author  Sourabh
 * @version 3.9.10
 * @since   24-05-2023
 */
@Entity
@Table(name = "customer")
public class Customer {
    
    /**
     * Default constructor for the Customer class.
     */
    public Customer() {
        super();
    }
    
    private int customer_Id;
    private String username;
    private String password;
    private boolean prime_Customer;
    private int wallet;
    private String first_Name;
    private String last_Name;
    private String email_Id;
    private String address;
    
    /**
     * Parameterized constructor for the Customer class.
     *
     * @param customer_Id     The customer ID.
     * @param username        The username.
     * @param password        The password.
     * @param prime_Customer  True if the customer is a prime customer, false otherwise.
     * @param wallet          The wallet balance.
     * @param first_Name      The first name.
     * @param last_Name       The last name.
     * @param email_Id        The email ID.
     * @param address         The address.
     */
    
    public Customer(int customer_Id, String username, String password, boolean prime_Customer, int wallet,
            String first_Name, String last_Name, String email_Id, String address) {
        super();
        this.customer_Id = customer_Id;
        this.username = username;
        this.password = password;
        this.prime_Customer = prime_Customer;
        this.wallet = wallet;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email_Id = email_Id;
        this.address = address;
    }
    
    /**
     * Get the customer ID.
     *
     * @return The customer ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getcustomer_Id() {
        return customer_Id;
    }
    
    /**
     * Set the customer ID.
     *
     * @param customer_Id The customer ID to set.
     */
    public void setcustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }
    
    /**
     * Get the username.
     *
     * @return The username.
     */
    public String getusername() {
        return username;
    }
    
    /**
     * Set the username.
     *
     * @param username The username to set.
     */
    public void setusername(String username) {
        this.username = username;
    }
    
    /**
     * Get the password.
     *
     * @return The password.
     */
    public String getpassword() {
        return password;
    }
    
    /**
     * Set the password.
     *
     * @param password The password to set.
     */
    public void setpassword(String password) {
        this.password = password;
    }
    
    /**
     * Check if the customer is a prime customer.
     *
     * @return True if the customer is a prime customer, false otherwise.
     */
    public boolean getprime_Customer() {
        return prime_Customer;
    }
    
    /**
     * Set whether the customer is a prime customer.
     *
     * @param prime_Customer True if the customer is a prime customer, false otherwise.
     */
    public void setprime_Customer(boolean prime_Customer) {
        this.prime_Customer = prime_Customer;
    }
    
    /**
     * Get the wallet balance of the customer.
     *
     * @return The wallet balance.
     */
    public int getwallet() {
        return wallet;
    }
    
    /**
     * Set the wallet balance of the customer.
     *
     * @param wallet The wallet balance to set.
     */
    public void setwallet(int wallet) {
        this.wallet = wallet;
    }
    
    /**
     * Get the first name of the customer.
     *
     * @return The first name.
     */
    public String getfirst_Name() {
        return first_Name;
    }
    
    /**
     * Set the first name of the customer.
     *
     * @param first_Name The first name to set.
     */
    public void setfirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }
    
    /**
     * Get the last name of the customer.
     *
     * @return The last name.
     */
    public String getlast_Name() {
        return last_Name;
    }
    
    /**
     * Set the last name of the customer.
     *
     * @param last_Name The last name to set.
     */
    public void setlast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
    
    /**
     * Get the email ID of the customer.
     *
     * @return The email ID.
     */
    public String getemail_Id() {
        return email_Id;
    }
    
    /**
     * Set the email ID of the customer.
     *
     * @param email_Id The email ID to set.
     */
    public void setemail_Id(String email_Id) {
        this.email_Id = email_Id;
    }
    
    /**
     * Get the address of the customer.
     *
     * @return The address.
     */
    public String getaddress() {
        return address;
    }
    
    /**
     * Set the address of the customer.
     *
     * @param address The address to set.
     */
    public void setaddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Customer [CustomerID=" + customer_Id + ", Username=" + username + ", Password=" + password
            + ", PrimeCustomer=" + prime_Customer + ", Wallet=" + wallet + ", FirstName=" + first_Name
            + ", LastName=" + last_Name + ", EmailId=" + email_Id + ", Address=" + address + "]";
    }
}
