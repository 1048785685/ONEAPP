package com.soully.oneapp.Gson.shouye.Question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

@SerializedName("res")
@Expose
private Integer res;
@SerializedName("data")
@Expose
private Data data;

public Integer getRes() {
return res;
}

public void setRes(Integer res) {
this.res = res;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

}