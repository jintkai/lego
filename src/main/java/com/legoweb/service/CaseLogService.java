package com.legoweb.service;

import com.legoapi.utils.MongoDBTool;
import com.legoweb.dao.CaseLogMapper;
import com.legoweb.entity.CaseLog;
import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Resp;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseLogService {

    @Autowired
    private CaseLogMapper caseLogMapper;

    @Autowired
    private MongoDBTool mongoDBTool;

    public Resp insertLog(CaseLog caseLog) {
        int id = caseLogMapper.insert(caseLog);
        return Resp.SuccessResp(caseLogMapper.selectByPrimaryKey(id));
    }

    public Resp selectLogs(CaseLog caseLog, Integer page, Integer pageSize) {
        int count = caseLogMapper.selectCount(caseLog);
        PageCondition pageCondition = new PageCondition();
        pageCondition.setTotal(count);
        pageCondition.setPage(page);
        pageCondition.setPageSize(pageSize);
        pageCondition.setData(caseLog);
        pageCondition.setList(caseLogMapper.selectList(pageCondition));
        return Resp.SuccessResp(pageCondition);
    }


    public Resp selectResponseLog(Integer id){
        CaseLog caseLog = caseLogMapper.selectByPrimaryKey(id);
        if(caseLog == null){
            return Resp.ErrorResp(500,"查询结果空，请确认id是否正确！",null);
        }
        Document document = mongoDBTool.findDocument("lego","caselog",caseLog.getResponseId());
        return Resp.SuccessResp(document);
    }
}
