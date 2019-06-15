
package net.adriann.coding_challenge_adrian.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ARedditPost {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
