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
abstract class Account {
    protected List<Mail> listOfMails;
    private String name;
    private String email;
    private String password;
    Account(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
        listOfMails = new LinkedList<>();
    }
//    public void composeMail(Account toAccount, String subject, String content);
    
    public void displayInboxTable(){
        System.out.printf("%5s %5s %5s %8s %12s\n","S.No","From","To","Subject","Content");
        List<Mail> mailList= getListOfMails();
        for(int i=getListOfMails().size()-1;i>=0;i--){
            if(mailList.get(i).getFromAccount()==this) continue;
            String fromAccount = mailList.get(i).getFromAccount().getEmail();
            String toAccount = mailList.get(i).getToAccount().getEmail();
            String subject = mailList.get(i).getSubject();
            String content = mailList.get(i).getContent();
            System.out.printf("%5d %5s %5s %8s %12s\n",i,fromAccount,toAccount,subject,content);
        }
    }
    public void displaySentMails(){
        System.out.printf("%5s %5s %5s %8s %12s\n","S.No","From","To","Subject","Content");
        List<Mail> mailList= getListOfMails();
        for(int i=getListOfMails().size()-1;i>=0;i--){
            if(mailList.get(i).getFromAccount()!=this) continue;
            String fromAccount = mailList.get(i).getFromAccount().getEmail();
            String toAccount = mailList.get(i).getToAccount().getEmail();
            String subject = mailList.get(i).getSubject();
            String content = mailList.get(i).getContent();
            System.out.printf("%5d %5s %5s %8s %12s\n",getListOfMails().size()-i-1,fromAccount,toAccount,subject,content);
        }
    }
    public void deleteMailFromInbox(int sNo){
        Mail mail = getInboxMailsNo(sNo);
        listOfMails.remove(mail);
    }
    public Mail getInboxMailsNo(int sNo){
        List<Mail> mailList= getListOfMails();
        int sNoInbox=-1;
        for(int i=getListOfMails().size()-1;i>=0;i--){
            if(mailList.get(i).getFromAccount()==this) continue;
            if(sNoInbox==-1){
                sNoInbox=getListOfMails().size()-i-1;
            }
            else
                sNoInbox++;
            if(sNoInbox==sNo){
                return mailList.get(i);
            }
        }
        return null;
    }
    public void deleteMailFromSent(int sNo){
        Mail mail = getInboxMailsNo(sNo);
        listOfMails.remove(mail);
    }
    public Mail getSentMailsNo(int sNo){
        List<Mail> mailList= getListOfMails();
        int sNoInbox=-1;
        for(int i=getListOfMails().size()-1;i>=0;i--){
            if(mailList.get(i).getFromAccount()!=this) continue;
            if(sNoInbox==-1){
                sNoInbox=getListOfMails().size()-i-1;
            }
            else
                sNoInbox++;
            if(sNoInbox==sNo){
                return mailList.get(i);
            }
        }
        return null;
    }

    /**
     * @return the listOfMails
     */
    public List<Mail> getListOfMails() {
        return listOfMails;
    }

    /**
     * @param listOfMails the listOfMails to set
     */
    public void setListOfMails(List<Mail> listOfMails) {
        this.listOfMails = listOfMails;
    }

    /**
     * @return the userName
     */
    public String getName() {
        return name;
    }

    /**
     * @param userName the userName to set
     */
    public void setName(String userName) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return the mailID
     */
  

   
    abstract public void composeMail(Account fromAccount,String subject, String content);
    
}
