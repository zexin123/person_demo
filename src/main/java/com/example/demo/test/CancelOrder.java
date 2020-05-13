package com.example.demo.test;

import java.io.*;

/**
 * @author xuzexin
 * @Description:
 * @date 2020/3/27 0027 下午 14:41
 */
public class CancelOrder {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop/aa.txt")));
        PrintWriter writer = new PrintWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop/cancelLoanToFail.sh")));

        String line;

        StringBuilder commend = new StringBuilder("(");
        String modle = "sleep 0.1\necho 'invoke com.dafy.sevend.loanrepay.api.service.LoanService.activeCancelLoan(%s,\"%s\")'";
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) {
                continue;
            }

            String strs[] = line.split("\t");

            commend.append(String.format(modle, strs[0].trim(), strs[1].trim())).append("\n");

        }

        commend.append(") | telnet 127.0.0.1 51320");

        writer.write(commend.toString());
        writer.flush();

        writer.close();
        reader.close();
    }
}
