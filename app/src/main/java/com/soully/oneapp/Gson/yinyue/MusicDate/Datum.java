package com.soully.oneapp.Gson.yinyue.MusicDate;

/**
 * Created by amanda on 2017/2/20.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("story_title")
    @Expose
    private String storyTitle;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("music_id")
    @Expose
    private String musicId;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList> authorList = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<AuthorList> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList> authorList) {
        this.authorList = authorList;
    }

}