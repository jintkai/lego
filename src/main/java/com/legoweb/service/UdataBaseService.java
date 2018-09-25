package com.legoweb.service;

import com.legoweb.dao.UdatabaseMapper;
import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Resp;
import com.legoweb.entity.Udatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UdataBaseService {

    @Autowired
    private UdatabaseMapper udatabaseMapper;

    public Resp insertDatabase(Udatabase udatabase){
        Resp resp;
        udatabaseMapper.insert(udatabase);
        resp = Resp.SuccessResp();
        return resp;
    }

    public Resp selectDatabases(Udatabase udatabase, Integer page, Integer pageSize) {
        Resp resp;
        PageCondition pageCondition = new PageCondition();
        pageCondition.setData(udatabase);
        pageCondition.setPageSize(pageSize);
        pageCondition.setPage(page);
        List list = udatabaseMapper.selectList(pageCondition);
        pageCondition.setTotal(list.size());
        pageCondition.setList(list);
        resp = Resp.SuccessResp(pageCondition);
        return resp;
    }


}
