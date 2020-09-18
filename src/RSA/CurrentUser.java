/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

/**
 *
 * @author Mvami N. Jonalex
 */
public class CurrentUser {
    
    //<editor-fold defaultstate="collapsed" desc="constructor">
    public CurrentUser(){
        setAll(readUserInfo("Data/Users/Users.txt"));
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="properties">
    private String firstName;
    private String lastName;
    private String identifier;
    private String passwordHash;
    private String DOB;
    private String eMail;
    private int userId;
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="set methods">
    private void setFirstName(String tmp){
        firstName = tmp;
    }
    
    private void setLastName(String tmp){
        lastName = tmp;
    }
    
    private void setIdentifier(String tmp){
        identifier = tmp;
    }
    
    private void setPasswordHash(String tmp){
        passwordHash = tmp;
    }
    
    private void setDOB(String tmp){
        DOB = tmp;
    }
    
    private void setEMail(String tmp){
        eMail = tmp;
    }
    
    private void setUserId(int tmp){
        userId = tmp;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="get methods">
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getIdentifier(){
        return identifier;
    }
    
    public String getPasswordHash(){
        return passwordHash;
    }
    
    public String getDOB(){
        return DOB;
    }
    
    public String getEMail(){
        return eMail;
    }
    
    public int getUserId(){
        return userId;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods">
    private String[] readUserInfo(String url) {
        Fichier file = new Fichier();
        // Open file in read mode
        file.openInRead(url);
        String readLine;

        // read line of current user.
        readLine = file.read();
        file.closeFile();
        
        return (new Fichier()).extractData(readLine, ";");
    }
    
    private void setAll(String[] userInfo){
        setFirstName(userInfo[0]);
        setLastName(userInfo[1]);
        setIdentifier(userInfo[2]);
        setPasswordHash(userInfo[3]);
        setDOB(userInfo[4]);
        setEMail(userInfo[5]);
        setUserId(Integer.parseInt(userInfo[6]));
    } 

//</editor-fold>
    
}
