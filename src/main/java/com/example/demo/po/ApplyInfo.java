package com.example.demo.po;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * User: xiaoed
 * Date: 2018/10/10
 * Time: 10:58
 */
@Data
public class ApplyInfo implements Serializable {


    private List<ApplyContactItem> contactList;


}
