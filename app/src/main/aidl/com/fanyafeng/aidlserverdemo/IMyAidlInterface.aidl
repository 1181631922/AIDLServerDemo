package com.fanyafeng.aidlserverdemo;

import com.fanyafeng.aidlserverdemo.StudentBean;

interface IMyAidlInterface {
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
            List<StudentBean> getStudents();

            void addStudent(in StudentBean studentBean);

}
