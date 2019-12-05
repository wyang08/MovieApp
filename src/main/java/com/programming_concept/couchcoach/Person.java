package com.programming_concept.couchcoach;

public class Person
{
    private String title;
    private String publish_day;
    private String director;
    private String imaURL;

    public Person(String title, String publish_day, String director, String imaURL)
    {
        this.title = title;
        this.publish_day = publish_day;
        this.director = director;
        this.imaURL = imaURL;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getPublish_day()
    {
        return publish_day;
    }
    public void setPublish_day(String publish_day)
    {
        this.publish_day = publish_day;
    }
    public String getDirector()
    {
        return director;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
    public String getImaURL()
    {
        return imaURL;
    }
    public void setImaURL(String imaURL)
    {
        this.imaURL = imaURL;
    }
}
