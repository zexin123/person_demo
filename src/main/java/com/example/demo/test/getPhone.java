package com.example.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.po.ApplyAuditRequest;
import com.example.demo.po.ApplyContactItem;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.List;

/**
 * @author xuzexin
 * @Description:
 * @date 2020/4/8 0008 下午 15:14
 */
public class getPhone  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop/pp.txt")));
        PrintWriter writer = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop/aatest.txt")));
        String line;
        StringBuilder commend = new StringBuilder();
        String modle="INSERT INTO t_collect_phone_repository(customer_id,name,mobile,phone_type,state) VALUES(%s,\'%s\',\'%s\',3,1);";
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) {
                continue;
            }
            String strs[] = line.split("\t");
            String customerId=strs[0];
            String auditInfo=strs[1];
            ApplyAuditRequest request = JSONObject.parseObject(auditInfo, ApplyAuditRequest.class);
            List<ApplyContactItem> contactList = request.getApplyInfo().getContactList();
            if(!CollectionUtils.isEmpty(contactList)){
                if(contactList.size()!=2){
                    ApplyContactItem applyContactItem = contactList.get(2);
                    if(applyContactItem!=null){
                        String name = applyContactItem.getName();
                        String phoneNum = applyContactItem.getPhoneNum();
                        commend.append(String.format(modle, customerId, name,phoneNum)).append("\n");
                    }
                }
                continue;
            }

        }


        writer.write(commend.toString());
        writer.flush();

        writer.close();
        bufferedReader.close();

    }
}
