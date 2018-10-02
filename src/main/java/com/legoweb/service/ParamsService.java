package com.legoweb.service;

import com.legoweb.dao.ParamsMapper;
import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Params;
import com.legoweb.entity.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamsService {
    @Autowired
    private ParamsMapper paramsMapper;

    public Resp selectParams(Params params, Integer page, Integer pageSize) {
        Resp resp;
        PageCondition<Params> pageCondition = new PageCondition<>();
        pageCondition.setPage(page);
        pageCondition.setData(params);
        pageCondition.setPageSize(pageSize);
        List list = paramsMapper.selectParams(pageCondition);
        pageCondition.setTotal(list.size());
        pageCondition.setList(list);
        resp = Resp.SuccessResp(pageCondition);
        return resp;
    }

    public Resp insertParams(Params params) {
        Resp resp;
        int unique = paramsMapper.uniqueParams(params);
        if (unique != 0) {
            resp = Resp.ErrorResp(500, "参数名称不唯一", null);
            return resp;
        }
        int id = paramsMapper.insert(params);
        Params p = paramsMapper.selectByPrimaryKey(id);
        resp = Resp.SuccessResp(p);
        return resp;
    }


}
