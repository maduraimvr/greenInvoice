/**
 * 
 */
package com.company.greeninvoice.entity;

/**
 * @author Venkatraman
 *
 */
public class Product {
String firstName;
String LastName;
boolean male;
/**
 * @return the firstName
 */
public String getFirstName() {
    return firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
    return LastName;
}
/**
 * @return the male
 */
public boolean isMale() {
    return male;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
    LastName = lastName;
}
/**
 * @param male the male to set
 */
public void setMale(boolean male) {
    this.male = male;
}
}
