package org.example.demojsp.tag;


import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.Random;

public class RandomTag extends SimpleTagSupport {
    private static final Random RANDOM = new Random();

    private String message;
    private Integer max;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (max == null) {
            out.println(RANDOM.nextInt(10));
        } else {
            out.println(String.format("<span style=\"background:yellow\">%s=%d</span>", message, RANDOM.nextInt(max)));
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}