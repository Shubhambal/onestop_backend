package com.emart.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "config")
public class Configuration {
    
    private int config_Id;
    private String config_Name;
    private String config_Details;
    private Set<ProductDetails> pd_Id;
    
    /**
     * Parameterized constructor for the Configuration class.
     *
     * @param config_Name     The configuration name.
     * @param config_Details  The configuration details.
     * @param pd_Id           The set of product details associated with the configuration.
     */
    public Configuration(String config_Name, String config_Details, Set<ProductDetails> pd_Id) {
        super();
        this.config_Name = config_Name;
        this.config_Details = config_Details;
        this.pd_Id = pd_Id; // prodtl id
    }
    /**
     * Default constructor for the Configuration class.
     */
    public Configuration() {
        super();
    }
    
    @Override
    public String toString() {
        return "Configuration [config_Id=" + config_Id + ", config_Name=" + config_Name + ", config_Details="
            + config_Details + ", pd_Id=" + pd_Id + "]";
    }
    
    /**
     * Get the configuration ID.
     *
     * @return The configuration ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getConfig_Id() {
        return config_Id;
    }
    
    /**
     * Set the configuration ID.
     *
     * @param config_Id The configuration ID to set.
     */
    public void setConfig_Id(int config_Id) {
        this.config_Id = config_Id;
    }
    
    /**
     * Get the configuration name.
     *
     * @return The configuration name.
     */
    public String getConfig_Name() {
        return config_Name;
    }
    
    /**
     * Set the configuration name.
     *
     * @param config_Name The configuration name to set.
     */
    public void setConfig_Name(String config_Name) {
        this.config_Name = config_Name;
    }
    
    /**
     * Get the configuration details.
     *
     * @return The configuration details.
     */
    public String getConfig_Details() {
        return config_Details;
    }
    
    /**
     * Set the configuration details.
     *
     * @param config_Details The configuration details to set.
     */
    public void setConfig_Details(String config_Details) {
        this.config_Details = config_Details;
    }
    
    /**
     * Get the set of product details associated with the configuration.
     *
     * @return The set of product details.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conf_Id", referencedColumnName = "config_Id")
    public Set<ProductDetails> getPd_Id() {
        return pd_Id;
    }
    
    /**
     * Set the set of product details associated with the configuration.
     *
     * @param pd_Id The set of product details to set.
     */
    public void setPd_Id(Set<ProductDetails> pd_Id) {
        this.pd_Id = pd_Id;
    }
}
