package com.soully.oneapp.Gson.yuedu.SerialDetail;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by amanda on 2017/2/16.
 */

public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("serial_id")
    @Expose
    private String serialId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("excerpt")
    @Expose
    private String excerpt;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("charge_edt")
    @Expose
    private String chargeEdt;
    @SerializedName("read_num")
    @Expose
    private String readNum;
    @SerializedName("maketime")
    @Expose
    private String maketime;
    @SerializedName("last_update_date")
    @Expose
    private String lastUpdateDate;
    @SerializedName("hide_flag")
    @Expose
    private String hideFlag;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("input_name")
    @Expose
    private String inputName;
    @SerializedName("last_update_name")
    @Expose
    private String lastUpdateName;
    @SerializedName("anchor")
    @Expose
    private String anchor;
    @SerializedName("editor_email")
    @Expose
    private String editorEmail;
    @SerializedName("top_media_type")
    @Expose
    private String topMediaType;
    @SerializedName("top_media_file")
    @Expose
    private String topMediaFile;
    @SerializedName("top_media_image")
    @Expose
    private String topMediaImage;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("lastid")
    @Expose
    private String lastid;
    @SerializedName("nextid")
    @Expose
    private Integer nextid;
    @SerializedName("author_list")
    @Expose
    private List<AuthorList> authorList = null;
    @SerializedName("tag_list")
    @Expose
    private List<Object> tagList = null;
    @SerializedName("share_list")
    @Expose
    private ShareList shareList;
    @SerializedName("praisenum")
    @Expose
    private Integer praisenum;
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

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChargeEdt() {
        return chargeEdt;
    }

    public void setChargeEdt(String chargeEdt) {
        this.chargeEdt = chargeEdt;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
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

    public String getHideFlag() {
        return hideFlag;
    }

    public void setHideFlag(String hideFlag) {
        this.hideFlag = hideFlag;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getLastUpdateName() {
        return lastUpdateName;
    }

    public void setLastUpdateName(String lastUpdateName) {
        this.lastUpdateName = lastUpdateName;
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

    public String getTopMediaType() {
        return topMediaType;
    }

    public void setTopMediaType(String topMediaType) {
        this.topMediaType = topMediaType;
    }

    public String getTopMediaFile() {
        return topMediaFile;
    }

    public void setTopMediaFile(String topMediaFile) {
        this.topMediaFile = topMediaFile;
    }

    public String getTopMediaImage() {
        return topMediaImage;
    }

    public void setTopMediaImage(String topMediaImage) {
        this.topMediaImage = topMediaImage;
    }

    public String getStartVideo() {
        return startVideo;
    }

    public void setStartVideo(String startVideo) {
        this.startVideo = startVideo;
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

    public String getLastid() {
        return lastid;
    }

    public void setLastid(String lastid) {
        this.lastid = lastid;
    }

    public Integer getNextid() {
        return nextid;
    }

    public void setNextid(Integer nextid) {
        this.nextid = nextid;
    }

    public List<AuthorList> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorList> authorList) {
        this.authorList = authorList;
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

    public Integer getPraisenum() {
        return praisenum;
    }

    public void setPraisenum(Integer praisenum) {
        this.praisenum = praisenum;
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