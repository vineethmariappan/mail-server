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
class GroupAccount extends Account {
    ArrayList<Account> groupMembers; // list of users in the group
    String groupDescription;
    GroupAccount(String username, String email, String password, String groupDescription) {
        super(username,email,password);
        groupMembers = new ArrayList<>();
        this.groupDescription = groupDescription;
    }
    public void composeMail(Account fromAccount,String subject, String content){
        Mail mail= new Mail(this,fromAccount,subject,content) ; // fromAccount -> userAccount; this->groupAccount
        fromAccount.getListOfMails().add(mail);
        mail= new Mail(fromAccount,this,subject,content);
        fromAccount.getListOfMails().add(mail);
        for(int i=0;i<groupMembers.size();i++){
            if(fromAccount==groupMembers.get(i)) 
                continue;
            mail = new Mail(fromAccount,groupMembers.get(i),subject,content);
            groupMembers.get(i).getListOfMails().add(mail);
        }
    }
    public void addGroupUser(UserAccount userAccount){
        groupMembers.add(userAccount);
    }
    public void removeGroupUser(UserAccount userAccount){
        groupMembers.remove(userAccount);
    }
}
