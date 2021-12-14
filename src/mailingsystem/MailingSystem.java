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
public class MailingSystem {
    ArrayList<Account> accounts;
    MailingSystem(){
        accounts = new ArrayList();
    }
    public void createUserAccount(Scanner scan){
        Account userAccount;
        do{
            System.out.print("Enter username : ");
            String userName = scan.next();
            System.out.print("Enter email : ");
            String email = scan.next();
            System.out.print("Enter password");
            String password = scan.next();
            userAccount = new UserAccount(userName,email,password);
        }while(containsAccount(userAccount));
        accounts.add(userAccount);
        System.out.println("Account successfully created!");
    }
    public void createGroupAccount(Scanner scan){
        Account groupAccount;
        do{
            System.out.print("Enter Group Name : ");
            String groupName = scan.next();
            System.out.print("Enter email : ");
            String email = scan.next();
            System.out.print("Enter password: ");
            String password = scan.next();
            scan.nextLine();
            System.out.print("Enter Group Description : ");
            String groupDescription = scan.nextLine();
            groupAccount = new GroupAccount(groupName,email,password, groupDescription);
        }while(containsAccount(groupAccount));
        accounts.add(groupAccount);
        System.out.println("Account successfully created!");
    }
    public boolean containsAccount(Account account){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getName().compareTo(account.getName())==0){
                System.out.println("Name already Exists!, Please try again with different username");
                return true;
            }
            else if(accounts.get(i).getEmail().compareTo(account.getEmail())==0){
                System.out.println("Email already Exists!, Please try again with different Email");
                return true;
            }
        }
        return false;
    }
    public Account getAccountWithName(String name){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getName().compareTo(name)==0){
                return accounts.get(i);
            }
        }
        System.out.println("Account does not exists, Please Enter a valid name");
        return  null;
    }
    public Account getAccountWithEmail(String email){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getEmail().compareTo(email)==0){
                return accounts.get(i);
            }
        }
        System.out.println("Account does not exists, Please Enter a valid email address!");
        return  null;
    }
    public void groupAssignment(Scanner scan){
        String groupName, username;
        GroupAccount groupAccount;
        UserAccount userAccount;
        int choice;
        do{ 
            System.out.println("Enter Group Name : ");
            groupName = scan.next();
        }while((groupAccount=(GroupAccount)getAccountWithName(groupName))==null);
        do{ 
            System.out.println("Enter Username : ");
            username = scan.next();
        }while((userAccount=(UserAccount)getAccountWithName(username))==null);
        do{
            System.out.println("1. Add\n2.Remove");
            choice=scan.nextInt();
            if(choice==1){
                groupAccount.addGroupUser(userAccount);
            }
            else {
                groupAccount.removeGroupUser(userAccount);
            }
            if(choice<1 || choice>2){
                System.out.println("Please Enter Valid Input!");
            }
        }while(choice<1 || choice>2);
        System.out.println("User successfully added to the group!");
    }
    public void composeMail(Scanner scan){
        Account fromAccount, toAccount;
        String name,subject,content;
        do{ 
            System.out.println("Enter from User : ");
            name = scan.next();
        }while((fromAccount=getAccountWithName(name))==null);
        do{ 
            System.out.println("Enter to Address : ");
            name = scan.next();
        }while((toAccount=getAccountWithEmail(name))==null);
        scan.nextLine();
        System.out.println("Enter Subject : ");
        subject=scan.nextLine();
        System.out.println("Enter Content : ");
        content = scan.nextLine();
        if(toAccount instanceof GroupAccount)
            toAccount.composeMail(fromAccount,subject, content); 
        else
            fromAccount.composeMail(toAccount, subject, content);
        System.out.println("Mail sent Successfully!");
    }
   public void viewInbox(Scanner scan){
       String username;
       Account account;
       do{ 
            System.out.println("Enter Username : ");
            username = scan.next();
        }while((account=getAccountWithName(username))==null);
       account.displayInboxTable();
   }
   public void viewSentMails(Scanner scan){
       String username;
       Account account;
       do{ 
            System.out.println("Enter Username : ");
            username = scan.next();
        }while((account=getAccountWithName(username))==null);
       account.displaySentMails();
   }
   public void deleteMail(Scanner scan){
       String username;
       Account account;
       int sNo;
       int choice;
       do{ 
            System.out.println("Enter Username : ");
            username = scan.next();
        }while((account=getAccountWithName(username))==null);
       do{
            System.out.println("1. Inbox\n2.Sent");
            choice=scan.nextInt();
            if(choice==1){
                account.displayInboxTable();
                System.out.println("Enter S.No : ");
                sNo=scan.nextInt();
                account.deleteMailFromInbox(sNo);
            }
            else {
                account.displaySentMails();
                System.out.println("Enter S.No : ");
                sNo=scan.nextInt();
                account.deleteMailFromSent(sNo);
            }
            if(choice<1 || choice>2){
                System.out.println("Please Enter Valid Input!");
            }
        }while(choice<1 || choice>2);
   }
}

// USER1 mails to group1
// should the inbox of the members of the group1 receive the FROM ADDRESS as groupMailID or the USER1
