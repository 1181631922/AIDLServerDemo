package com.fanyafeng.aidlserverdemo.main;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.fanyafeng.aidlserverdemo.IMyAidlInterface;
import com.fanyafeng.aidlserverdemo.StudentBean;

import java.util.ArrayList;
import java.util.List;

public class MyAIDLService extends Service {

    private List<StudentBean> studentBeanList = new ArrayList<>();

    private final IMyAidlInterface.Stub iMyAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public List<StudentBean> getStudents() throws RemoteException {
            synchronized (this) {
                if (studentBeanList != null) {
                    return studentBeanList;
                }
                return new ArrayList<>();
            }
        }

        @Override
        public void addStudent(StudentBean studentBean) throws RemoteException {
            synchronized (this) {
                if (studentBeanList == null) {
                    studentBeanList = new ArrayList<>();
                }
                if (studentBean == null) {
                    studentBean = new StudentBean();
                }

                studentBean.setAge(24);
                if (!studentBeanList.contains(studentBean)) {
                    studentBeanList.add(studentBean);
                }
            }
        }
    };

    @Override
    public void onCreate() {
        StudentBean studentBean = new StudentBean();
        studentBean.setId(6);
        studentBean.setName("小樊");
        studentBean.setAge(26);
        studentBeanList.add(studentBean);
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iMyAidlInterface;
    }
}
