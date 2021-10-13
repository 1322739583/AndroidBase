package com.xzh.androidbase.mvp.model.entry;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddUserResponse {

    /**
     * url : https://api.github.com/repos/1322739583/RetrofitDemo/issues/2
     * repository_url : https://api.github.com/repos/1322739583/RetrofitDemo
     * labels_url : https://api.github.com/repos/1322739583/RetrofitDemo/issues/2/labels{/name}
     * comments_url : https://api.github.com/repos/1322739583/RetrofitDemo/issues/2/comments
     * events_url : https://api.github.com/repos/1322739583/RetrofitDemo/issues/2/events
     * html_url : https://github.com/1322739583/RetrofitDemo/issues/2
     * id : 687176652
     * node_id : MDU6SXNzdWU2ODcxNzY2NTI=
     * number : 2
     * title : Found a bug
     * user : {"login":"1322739583","id":7570668,"node_id":"MDQ6VXNlcjc1NzA2Njg=","avatar_url":"https://avatars3.githubusercontent.com/u/7570668?v=4","gravatar_id":"","url":"https://api.github.com/users/1322739583","html_url":"https://github.com/1322739583","followers_url":"https://api.github.com/users/1322739583/followers","following_url":"https://api.github.com/users/1322739583/following{/other_user}","gists_url":"https://api.github.com/users/1322739583/gists{/gist_id}","starred_url":"https://api.github.com/users/1322739583/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/1322739583/subscriptions","organizations_url":"https://api.github.com/users/1322739583/orgs","repos_url":"https://api.github.com/users/1322739583/repos","events_url":"https://api.github.com/users/1322739583/events{/privacy}","received_events_url":"https://api.github.com/users/1322739583/received_events","type":"User","site_admin":false}
     * labels : [{"id":2302043599,"node_id":"MDU6TGFiZWwyMzAyMDQzNTk5","url":"https://api.github.com/repos/1322739583/RetrofitDemo/labels/bug","name":"bug","color":"d73a4a","default":true,"description":"Something isn't working"}]
     * state : open
     * locked : false
     * assignee : null
     * assignees : []
     * milestone : null
     * comments : 0
     * created_at : 2020-08-27T11:46:30Z
     * updated_at : 2020-08-27T11:46:31Z
     * closed_at : null
     * author_association : OWNER
     * active_lock_reason : null
     * body : I'm having a problem with this.
     * closed_by : null
     * performed_via_github_app : null
     */

    private String url;
    private String repository_url;
    private String labels_url;
    private String comments_url;
    private String events_url;
    private String html_url;
    private int id;
    private String node_id;
    private int number;
    private String title;
    private UserBean user;
    private String state;
    private boolean locked;
    private Object assignee;
    private Object milestone;
    private int comments;
    private String created_at;
    private String updated_at;
    private Object closed_at;
    private String author_association;
    private Object active_lock_reason;
    private String body;
    private Object closed_by;
    private Object performed_via_github_app;
    private List<LabelsBean> labels;
    private List<?> assignees;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public void setLabels_url(String labels_url) {
        this.labels_url = labels_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Object getAssignee() {
        return assignee;
    }

    public void setAssignee(Object assignee) {
        this.assignee = assignee;
    }

    public Object getMilestone() {
        return milestone;
    }

    public void setMilestone(Object milestone) {
        this.milestone = milestone;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Object getClosed_at() {
        return closed_at;
    }

    public void setClosed_at(Object closed_at) {
        this.closed_at = closed_at;
    }

    public String getAuthor_association() {
        return author_association;
    }

    public void setAuthor_association(String author_association) {
        this.author_association = author_association;
    }

    public Object getActive_lock_reason() {
        return active_lock_reason;
    }

    public void setActive_lock_reason(Object active_lock_reason) {
        this.active_lock_reason = active_lock_reason;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Object getClosed_by() {
        return closed_by;
    }

    public void setClosed_by(Object closed_by) {
        this.closed_by = closed_by;
    }

    public Object getPerformed_via_github_app() {
        return performed_via_github_app;
    }

    public void setPerformed_via_github_app(Object performed_via_github_app) {
        this.performed_via_github_app = performed_via_github_app;
    }

    public List<LabelsBean> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelsBean> labels) {
        this.labels = labels;
    }

    public List<?> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<?> assignees) {
        this.assignees = assignees;
    }

    public static class UserBean {
        /**
         * login : 1322739583
         * id : 7570668
         * node_id : MDQ6VXNlcjc1NzA2Njg=
         * avatar_url : https://avatars3.githubusercontent.com/u/7570668?v=4
         * gravatar_id :
         * url : https://api.github.com/users/1322739583
         * html_url : https://github.com/1322739583
         * followers_url : https://api.github.com/users/1322739583/followers
         * following_url : https://api.github.com/users/1322739583/following{/other_user}
         * gists_url : https://api.github.com/users/1322739583/gists{/gist_id}
         * starred_url : https://api.github.com/users/1322739583/starred{/owner}{/repo}
         * subscriptions_url : https://api.github.com/users/1322739583/subscriptions
         * organizations_url : https://api.github.com/users/1322739583/orgs
         * repos_url : https://api.github.com/users/1322739583/repos
         * events_url : https://api.github.com/users/1322739583/events{/privacy}
         * received_events_url : https://api.github.com/users/1322739583/received_events
         * type : User
         * site_admin : false
         */

        private String login;
        private int id;
        private String node_id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private boolean site_admin;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNode_id() {
            return node_id;
        }

        public void setNode_id(String node_id) {
            this.node_id = node_id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getGravatar_id() {
            return gravatar_id;
        }

        public void setGravatar_id(String gravatar_id) {
            this.gravatar_id = gravatar_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public void setFollowers_url(String followers_url) {
            this.followers_url = followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public void setFollowing_url(String following_url) {
            this.following_url = following_url;
        }

        public String getGists_url() {
            return gists_url;
        }

        public void setGists_url(String gists_url) {
            this.gists_url = gists_url;
        }

        public String getStarred_url() {
            return starred_url;
        }

        public void setStarred_url(String starred_url) {
            this.starred_url = starred_url;
        }

        public String getSubscriptions_url() {
            return subscriptions_url;
        }

        public void setSubscriptions_url(String subscriptions_url) {
            this.subscriptions_url = subscriptions_url;
        }

        public String getOrganizations_url() {
            return organizations_url;
        }

        public void setOrganizations_url(String organizations_url) {
            this.organizations_url = organizations_url;
        }

        public String getRepos_url() {
            return repos_url;
        }

        public void setRepos_url(String repos_url) {
            this.repos_url = repos_url;
        }

        public String getEvents_url() {
            return events_url;
        }

        public void setEvents_url(String events_url) {
            this.events_url = events_url;
        }

        public String getReceived_events_url() {
            return received_events_url;
        }

        public void setReceived_events_url(String received_events_url) {
            this.received_events_url = received_events_url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isSite_admin() {
            return site_admin;
        }

        public void setSite_admin(boolean site_admin) {
            this.site_admin = site_admin;
        }
    }

    public static class LabelsBean {
        /**
         * id : 2302043599
         * node_id : MDU6TGFiZWwyMzAyMDQzNTk5
         * url : https://api.github.com/repos/1322739583/RetrofitDemo/labels/bug
         * name : bug
         * color : d73a4a
         * default : true
         * description : Something isn't working
         */

        private long id;
        private String node_id;
        private String url;
        private String name;
        private String color;
        @SerializedName("default")
        private boolean defaultX;
        private String description;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNode_id() {
            return node_id;
        }

        public void setNode_id(String node_id) {
            this.node_id = node_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isDefaultX() {
            return defaultX;
        }

        public void setDefaultX(boolean defaultX) {
            this.defaultX = defaultX;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
