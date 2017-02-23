package com.soully.oneapp.Gson.yinyue.MusicDetail;

/**
 * Created by amanda on 2017/2/20.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("isfirst")
    @Expose
    private String isfirst;
    @SerializedName("story_title")
    @Expose
    private String storyTitle;
    @SerializedName("story")
    @Expose
    private String story;
    @SerializedName("lyric")
    @Expose
    private String lyric;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("music_id")
    @Expose
    private String musicId;
    @SerializedName("charge_edt")
    @Expose
    private String chargeEdt;
    @SerializedName("related_to")
    @Expose
    private String relatedTo;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("praisenum")
    @Expose
    private Integer praisenum;
    @SerializedName("hide_flag")
    @Expose
    private String hideFlag;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("maketime")
    @Expose
    private String maketime;
    @SerializedName("last_update_date")
    @Expose
    private String lastUpdateDate;
    @SerializedName("read_num")
    @Expose
    private String readNum;
    @SerializedName("story_summary")
    @Expose
    private String storySummary;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("anchor")
    @Expose
    private String anchor;
    @SerializedName("editor_email")
    @Expose
    private String editorEmail;
    @SerializedName("related_musics")
    @Expose
    private String relatedMusics;
    @SerializedName("album")
    @Expose
    private String album;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("story_author")
    @Expose
    private StoryAuthor storyAuthor;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList> authorList = null;
    @SerializedName("next_id")
    @Expose
    private Integer nextId;
    @SerializedName("previous_id")
    @Expose
    private String previousId;
    @SerializedName("tag_list")
    @Expose
    private List<Object> tagList = null;
    @SerializedName("share_list")
    @Expose
    private ShareList shareList;
    @SerializedName("sharenum")
    @Expose
    private Integer sharenum;
    @SerializedName("commentnum")
    @Expose
    private Integer commentnum;

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

    public String getIsfirst() {
        return isfirst;
    }

    public void setIsfirst(String isfirst) {
        this.isfirst = isfirst;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public String getChargeEdt() {
        return chargeEdt;
    }

    public void setChargeEdt(String chargeEdt) {
        this.chargeEdt = chargeEdt;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Integer getPraisenum() {
        return praisenum;
    }

    public void setPraisenum(Integer praisenum) {
        this.praisenum = praisenum;
    }

    public String getHideFlag() {
        return hideFlag;
    }

    public void setHideFlag(String hideFlag) {
        this.hideFlag = hideFlag;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getMaketime() {
        return maketime;
    }

    public void setMaketime(String maketime) {
        this.maketime = maketime;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    public String getStorySummary() {
        return storySummary;
    }

    public void setStorySummary(String storySummary) {
        this.storySummary = storySummary;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getEditorEmail() {
        return editorEmail;
    }

    public void setEditorEmail(String editorEmail) {
        this.editorEmail = editorEmail;
    }

    public String getRelatedMusics() {
        return relatedMusics;
    }

    public void setRelatedMusics(String relatedMusics) {
        this.relatedMusics = relatedMusics;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public StoryAuthor getStoryAuthor() {
        return storyAuthor;
    }

    public void setStoryAuthor(StoryAuthor storyAuthor) {
        this.storyAuthor = storyAuthor;
    }

    public List<AuthorList> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList> authorList) {
        this.authorList = authorList;
    }

    public Integer getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    public String getPreviousId() {
        return previousId;
    }

    public void setPreviousId(String previousId) {
        this.previousId = previousId;
    }

    public List<Object> getTagList() {
        return tagList;
    }

    public void setTagList(List<Object> tagList) {
        this.tagList = tagList;
    }

    public ShareList getShareList() {
        return shareList;
    }

    public void setShareList(ShareList shareList) {
        this.shareList = shareList;
    }

    public Integer getSharenum() {
        return sharenum;
    }

    public void setSharenum(Integer sharenum) {
        this.sharenum = sharenum;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }
}
