package com.xzh.androidbase.mvp.model.entry;

public class Issue {

    /**
     * title : Found a bug
     * body : I'm having a problem with this.
     * assignees : ["octocat"]
     * milestone : 1
     * labels : ["bug"]
     */

    private String title;
    private String body;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
