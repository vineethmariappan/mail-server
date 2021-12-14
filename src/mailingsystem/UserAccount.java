/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailingsystem;

import java.util.*;

/**
 *
 * @author vinee
 */
class UserAccount extends Account {
    ArrayList<UserAccount> inboxSharedUserList;
    
    

    UserAccount(String username, String email, String password) {
        super(username,email,password);
    }
    public void composeMail(Account toAccount, String subject, String content){
        Mail mail = new Mail(this,toAccount,subject,content);
        listOfMails.add(mail);
        toAccount.getListOfMails().add(mail);
    }
    public void shareInbox(){
        
    }
    public void recallMail(){
        
    }
}
