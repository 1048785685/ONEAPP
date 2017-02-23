package com.soully.oneapp.Gson.yuedu.Serial;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Serial {

@SerializedName("res")
@Expose
private Integer res;
@SerializedName("data")
@Expose
private List<Datum> data = null;

public Integer getRes() {
return res;
}

public void setRes(Integer res) {
this.res = res;
}

public List<Datum> getData() {
return data;
}

public void setData(List<Datum> data) {
this.data = data;
}

}