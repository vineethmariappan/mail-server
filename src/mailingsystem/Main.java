/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailingsystem;

import java.util.Scanner;

/**
 *
 * @author vinee
 */
public class Main {
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         MailingSystem mailingSystem = new MailingSystem();
         int choice;
         do{
             projectMenu();
             choice = scan.nextInt();
             switch(choice){
                 case 1:
                     mailingSystem.createUserAccount(scan);
                     break;
                 case 2:
                     mailingSystem.createGroupAccount(scan);
                     break;
                 case 3:
                     mailingSystem.groupAssignment(scan);
                     break;
                 case 4: 
                     mailingSystem.composeMail(scan);
                     break;
                 case 5:
                     mailingSystem.viewInbox(scan);
                     break;
                 case 6:
                     mailingSystem.viewSentMails(scan);
                     break;
                 case 7:
                     mailingSystem.deleteMail(scan);
                     break;
                 case 10:
                     System.exit(0);
             }
         }while(true);
    }
     public static void projectMenu(){
         System.out.println("-------------------Mailing-System-------------------");
         System.out.println("1. Create User");
         System.out.println("2. Create Group");
         System.out.println("3. Group Assignment");
         System.out.println("4. Compose Mail");
         System.out.println("5. Inbox");
         System.out.println("6. Sent Mail");
         System.out.println("7. Delete Mail");
         System.out.println("8. Recall");
         System.out.println("9. Share Inbox");
         System.out.println("10. Exit");
         System.out.println("Select an Option");
     }
}

// user1          g1@g.com
// user2