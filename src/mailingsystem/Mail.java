/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailingsystem;

/**
 *
 * @author vinee
 */
class Mail {
    private Account fromAccount;
    private Account toAccount;
    private String subject;
    private String content;
    Mail(Account fromAccount,Account toAccount, String subject, String content){
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.subject = subject;
        this.content = content;
    }

    

    /**
     * @return the fromAccount
     */
    public Account getFromAccount() {
        return fromAccount;
    }

    /**
     * @param fromAccount the fromAccount to set
     */
    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    /**
     * @return the toAccount
     */
    public Account getToAccount() {
        return toAccount;
    }

    /**
     * @param toAccount the toAccount to set
     */
    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the sNo
     */
}
