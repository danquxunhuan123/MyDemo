package com.trs.jjrb.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * creator：liufan
 * data: 2019/11/22
 */
public class TestBean implements Parcelable {
    private String a;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;

    protected TestBean(Parcel in) {
        a = in.readString();
        a1 = in.readString();
        a2 = in.readString();
        a3 = in.readString();
        a4 = in.readString();
        a5 = in.readString();
    }

    public static final Creator<TestBean> CREATOR = new Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel in) {
            return new TestBean(in);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(a);
        dest.writeString(a1);
        dest.writeString(a2);
        dest.writeString(a3);
        dest.writeString(a4);
        dest.writeString(a5);
    }
}
