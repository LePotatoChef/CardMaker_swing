package org.wpi.cardmaker.Model;
import org.wpi.cardmaker.Model.Page;

public class Card {

    public String[] eventOption = { "Default", "Birthday", "Anniversary", "Halloween", "Christmas", "Easter" };
    public String eventType;
    public String recipient;
    public Page frontPage;
    public Page backPage;
    public Page leftPage;
    public Page rightPage;
    public String name;



    public Card(){
        this.eventType = this.eventOption[0];
        this.recipient = "jone doe";
        this.name = "Card1";
        this.frontPage = new Page();
        this.backPage = new Page();
    }

    public Card(String name, String eventType, String recipient){
        this.name = name;
        this.eventType = eventType;
        this.recipient = recipient;
    }

    public Card(String name, String eventType, String recipient, Page frontPage, Page BackPage, Page LeftPage, Page rightPage){
        this.name = name;
        this.eventType = eventType;
        this.recipient = recipient;
        this.frontPage = frontPage;
        this.backPage = BackPage;
        this.leftPage = LeftPage;
        this.rightPage = rightPage;
    }

    // setter, getter
    public String[] getEventOption() {
        return eventOption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Page getFrontPage() {
        return frontPage;
    }

    public void setFrontPage(Page frontPage) {
        this.frontPage = frontPage;
    }

    public Page getBackPage() {
        return backPage;
    }

    public void setBackPage(Page backPage) {
        this.backPage = backPage;
    }

    public Page getLeftPage() {
        return leftPage;
    }

    public void setLeftPage(Page leftPage) {
        this.leftPage = leftPage;
    }

    public Page getRightPage() {
        return rightPage;
    }

    public void setRightPage(Page rightPage) {
        this.rightPage = rightPage;
    }



}
