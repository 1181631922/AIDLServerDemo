package com.fanyafeng.aidlserverdemo;//注意此包名需要与aidl下的StudentBean.aidl的包名相对应，否则提示找不到

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author： fanyafeng
 * Data： 16/12/21 下午3:51
 * Email: fanyafeng@live.cn
 */
public class StudentBean implements Parcelable {
    private int id;
    private String name;
    private int age;

    public StudentBean() {
    }

    protected StudentBean(Parcel in) {
        id = in.readInt();
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<StudentBean> CREATOR = new Creator<StudentBean>() {
        @Override
        public StudentBean createFromParcel(Parcel in) {
            return new StudentBean(in);
        }

        @Override
        public StudentBean[] newArray(int size) {
            return new StudentBean[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(age);
    }
}
