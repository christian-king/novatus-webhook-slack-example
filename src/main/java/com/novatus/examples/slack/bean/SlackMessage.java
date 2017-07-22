package com.novatus.examples.slack.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SlackMessage {

    String text;

    public SlackMessage() {
        this.text = "";
    }

    public SlackMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
