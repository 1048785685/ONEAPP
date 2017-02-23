package com.soully.oneapp.Gson.shouye.Question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qq {

@SerializedName("title")
@Expose
private String title;
@SerializedName("desc")
@Expose
private String desc;
@SerializedName("link")
@Expose
private String link;
@SerializedName("imgUrl")
@Expose
private String imgUrl;

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDesc() {
return desc;
}

public void setDesc(String desc) {
this.desc = desc;
}

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getImgUrl() {
return imgUrl;
}

public void setImgUrl(String imgUrl) {
this.imgUrl = imgUrl;
}

}