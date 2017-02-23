package com.soully.oneapp.Gson.yingshi.ID.Detail;

/**
 * Created by Soully on 2017/2/19.
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
    @SerializedName("indexcover")
    @Expose
    private String indexcover;
    @SerializedName("detailcover")
    @Expose
    private String detailcover;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("verse")
    @Expose
    private String verse;
    @SerializedName("verse_en")
    @Expose
    private String verseEn;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("revisedscore")
    @Expose
    private String revisedscore;
    @SerializedName("review")
    @Expose
    private String review;
    @SerializedName("keywords")
    @Expose
    private String keywords;
    @SerializedName("movie_id")
    @Expose
    private String movieId;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("officialstory")
    @Expose
    private String officialstory;
    @SerializedName("hide_flag")
    @Expose
    private String hideFlag;
    @SerializedName("charge_edt")
    @Expose
    private String chargeEdt;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("praisenum")
    @Expose
    private Integer praisenum;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("releasetime")
    @Expose
    private String releasetime;
    @SerializedName("scoretime")
    @Expose
    private String scoretime;
    @SerializedName("maketime")
    @Expose
    private String maketime;
    @SerializedName("last_update_date")
    @Expose
    private String lastUpdateDate;
    @SerializedName("read_num")
    @Expose
    private String readNum;
    @SerializedName("directors")
    @Expose
    private String directors;
    @SerializedName("editor_email")
    @Expose
    private String editorEmail;
    @SerializedName("related")
    @Expose
    private String related;
    @SerializedName("directors_id")
    @Expose
    private String directorsId;
    @SerializedName("start_video")
    @Expose
    private String startVideo;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("photo")
    @Expose
    private List<String> photo = null;
    @SerializedName("next_id")
    @Expose
    private String nextId;
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
    @SerializedName("servertime")
    @Expose
    private Integer servertime;

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

    public String getIndexcover() {
        return indexcover;
    }

    public void setIndexcover(String indexcover) {
        this.indexcover = indexcover;
    }

    public String getDetailcover() {
        return detailcover;
    }

    public void setDetailcover(String detailcover) {
        this.detailcover = detailcover;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getVerseEn() {
        return verseEn;
    }

    public void setVerseEn(String verseEn) {
        this.verseEn = verseEn;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRevisedscore() {
        return revisedscore;
    }

    public void setRevisedscore(String revisedscore) {
        this.revisedscore = revisedscore;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getOfficialstory() {
        return officialstory;
    }

    public void setOfficialstory(String officialstory) {
        this.officialstory = officialstory;
    }

    public String getHideFlag() {
        return hideFlag;
    }

    public void setHideFlag(String hideFlag) {
        this.hideFlag = hideFlag;
    }

    public String getChargeEdt() {
        return chargeEdt;
    }

    public void setChargeEdt(String chargeEdt) {
        this.chargeEdt = chargeEdt;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getScoretime() {
        return scoretime;
    }

    public void setScoretime(String scoretime) {
        this.scoretime = scoretime;
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

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getEditorEmail() {
        return editorEmail;
    }

    public void setEditorEmail(String editorEmail) {
        this.editorEmail = editorEmail;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getDirectorsId() {
        return directorsId;
    }

    public void setDirectorsId(String directorsId) {
        this.directorsId = directorsId;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

    public String getNextId() {
        return nextId;
    }

    public void setNextId(String nextId) {
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

    public Integer getServertime() {
        return servertime;
    }

    public void setServertime(Integer servertime) {
        this.servertime = servertime;
    }

}
