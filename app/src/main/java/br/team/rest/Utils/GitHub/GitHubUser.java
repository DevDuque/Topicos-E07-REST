package br.team.rest.Utils.GitHub;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {
    @SerializedName("name")
    private String name;

    @SerializedName("login")
    private String login;

    @SerializedName("company")
    private String company;

    @SerializedName("blog")
    private String blog;

    @SerializedName("location")
    private String location;

    @SerializedName("email")
    private String email;

    @SerializedName("bio")
    private String bio;

    @SerializedName("public_repos")
    private int publicRepos;

    @SerializedName("followers")
    private int followers;

    // Getters
    public String getName() { return name; }

    public String getLogin() { return login; }

    public String getCompany() { return company; }

    public String getBlog() { return blog; }

    public String getLocation() { return location; }

    public String getEmail() { return email; }

    public String getBio() { return bio; }

    public int getPublicRepos() { return publicRepos; }

    public int getFollowers() { return followers; }
}
