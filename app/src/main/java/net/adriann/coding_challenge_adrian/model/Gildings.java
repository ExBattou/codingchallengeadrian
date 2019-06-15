
package net.adriann.coding_challenge_adrian.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gildings {

    @SerializedName("gid_1")
    @Expose
    private Integer gid1;

    public Integer getGid1() {
        return gid1;
    }

    public void setGid1(Integer gid1) {
        this.gid1 = gid1;
    }

}
