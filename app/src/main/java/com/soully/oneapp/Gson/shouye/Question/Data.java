package com.soully.oneapp.Gson.shouye.Question;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

@SerializedName("question_id")
@Expose
private String questionId;
@SerializedName("question_title")
@Expose
private String questionTitle;
@SerializedName("question_content")
@Expose
private String questionContent;
@SerializedName("answer_title")
@Expose
private String answerTitle;
@SerializedName("answer_content")
@Expose
private String answerContent;
@SerializedName("question_makettime")
@Expose
private String questionMakettime;
@SerializedName("recommend_flag")
@Expose
private String recommendFlag;
@SerializedName("charge_edt")
@Expose
private String chargeEdt;
@SerializedName("charge_email")
@Expose
private String chargeEmail;
@SerializedName("last_update_date")
@Expose
private String lastUpdateDate;
@SerializedName("web_url")
@Expose
private String webUrl;
@SerializedName("read_num")
@Expose
private String readNum;
@SerializedName("guide_word")
@Expose
private String guideWord;
@SerializedName("audio")
@Expose
private String audio;
@SerializedName("anchor")
@Expose
private String anchor;
@SerializedName("cover")
@Expose
private String cover;
@SerializedName("content_bgcolor")
@Expose
private String contentBgcolor;
@SerializedName("cover_media_type")
@Expose
private String coverMediaType;
@SerializedName("cover_media_file")
@Expose
private String coverMediaFile;
@SerializedName("start_video")
@Expose
private String startVideo;
@SerializedName("copyright")
@Expose
private String copyright;
@SerializedName("answerer")
@Expose
private Answerer answerer;
@SerializedName("asker")
@Expose
private Asker asker;
@SerializedName("author_list")
@Expose
private List<AuthorList> authorList = null;
@SerializedName("asker_list")
@Expose
private List<AskerList> askerList = null;
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
@SerializedName("praisenum")
@Expose
private Integer praisenum;
@SerializedName("sharenum")
@Expose
private Integer sharenum;
@SerializedName("commentnum")
@Expose
private Integer commentnum;

public String getQuestionId() {
return questionId;
}

public void setQuestionId(String questionId) {
this.questionId = questionId;
}

public String getQuestionTitle() {
return questionTitle;
}

public void setQuestionTitle(String questionTitle) {
this.questionTitle = questionTitle;
}

public String getQuestionContent() {
return questionContent;
}

public void setQuestionContent(String questionContent) {
this.questionContent = questionContent;
}

public String getAnswerTitle() {
return answerTitle;
}

public void setAnswerTitle(String answerTitle) {
this.answerTitle = answerTitle;
}

public String getAnswerContent() {
return answerContent;
}

public void setAnswerContent(String answerContent) {
this.answerContent = answerContent;
}

public String getQuestionMakettime() {
return questionMakettime;
}

public void setQuestionMakettime(String questionMakettime) {
this.questionMakettime = questionMakettime;
}

public String getRecommendFlag() {
return recommendFlag;
}

public void setRecommendFlag(String recommendFlag) {
this.recommendFlag = recommendFlag;
}

public String getChargeEdt() {
return chargeEdt;
}

public void setChargeEdt(String chargeEdt) {
this.chargeEdt = chargeEdt;
}

public String getChargeEmail() {
return chargeEmail;
}

public void setChargeEmail(String chargeEmail) {
this.chargeEmail = chargeEmail;
}

public String getLastUpdateDate() {
return lastUpdateDate;
}

public void setLastUpdateDate(String lastUpdateDate) {
this.lastUpdateDate = lastUpdateDate;
}

public String getWebUrl() {
return webUrl;
}

public void setWebUrl(String webUrl) {
this.webUrl = webUrl;
}

public String getReadNum() {
return readNum;
}

public void setReadNum(String readNum) {
this.readNum = readNum;
}

public String getGuideWord() {
return guideWord;
}

public void setGuideWord(String guideWord) {
this.guideWord = guideWord;
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

public String getCover() {
return cover;
}

public void setCover(String cover) {
this.cover = cover;
}

public String getContentBgcolor() {
return contentBgcolor;
}

public void setContentBgcolor(String contentBgcolor) {
this.contentBgcolor = contentBgcolor;
}

public String getCoverMediaType() {
return coverMediaType;
}

public void setCoverMediaType(String coverMediaType) {
this.coverMediaType = coverMediaType;
}

public String getCoverMediaFile() {
return coverMediaFile;
}

public void setCoverMediaFile(String coverMediaFile) {
this.coverMediaFile = coverMediaFile;
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

public Answerer getAnswerer() {
return answerer;
}

public void setAnswerer(Answerer answerer) {
this.answerer = answerer;
}

public Asker getAsker() {
return asker;
}

public void setAsker(Asker asker) {
this.asker = asker;
}

public List<AuthorList> getAuthorList() {
return authorList;
}

public void setAuthorList(List<AuthorList> authorList) {
this.authorList = authorList;
}

public List<AskerList> getAskerList() {
return askerList;
}

public void setAskerList(List<AskerList> askerList) {
this.askerList = askerList;
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