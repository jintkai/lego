package com.legoweb.service;

import com.legoapi.entity.HttpLog;
import com.legoapi.utils.HttpClientTool;
import com.legoapi.utils.MongoDBTool;
import com.legoweb.dao.CaseLogMapper;
import com.legoweb.dao.TestCaseMapper;
import com.legoweb.entity.CaseLog;
import com.legoweb.entity.PageCondition;
import com.legoweb.entity.Resp;
import com.legoweb.entity.TestCase;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.MonitorInfo;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseMapper testCaseMapper;

    @Autowired
    private CaseLogMapper caseLogMapper;

    @Autowired
    private MongoDBTool mongoDBTool;

    public Resp selectLists(TestCase testCase, Integer page, Integer pageSize) {
        PageCondition<TestCase> pageCondition = new PageCondition<>();
        pageCondition.setData(testCase);
        pageCondition.setPage(page);
        pageCondition.setPageSize(pageSize);
        pageCondition.setTotal(testCaseMapper.selectCount(testCase));
        pageCondition.setList(testCaseMapper.selectList(pageCondition));
        Resp resp;
        resp = Resp.SuccessResp(pageCondition);
        return resp;
    }

    public Resp insertCase(TestCase testCase) {
        Resp resp;
        testCase.setCaseStatus(1);
        int i = testCaseMapper.uniqueCase(testCase);
        if (i != 0) {
            resp = Resp.ErrorResp(500, "用例名称不唯一", null);
        } else {
            int id = testCaseMapper.insert(testCase);
            resp = Resp.SuccessResp(testCaseMapper.selectByPrimaryKey(id));
        }
        return resp;
    }

    public Resp runCase(Integer caseId) {
        Resp resp = new Resp();

        TestCase testCase = testCaseMapper.selectByPrimaryKey(caseId);

        HttpLog httpResult = HttpClientTool.postClient(testCase.getCaseUrl(), 1, null);
        resp.setCode(httpResult.getCode() == 1 ? 200 : 500);
        resp.setMsg(httpResult.getMsg());
        resp.setData(httpResult);

        CaseLog caseLog = new CaseLog();
        caseLog.setCaseId(caseId);
        caseLog.setJobId(0);
        caseLog.setAssertResult(1);
        caseLog.setResponseId(httpResult.getId().toString());
        caseLogMapper.insert(caseLog);

        MongoCollection<Document> mongoCollection = mongoDBTool.getCollection("lego", "caselog");

        mongoDBTool.insertDoc("lego", "caselog", httpResult);
        return resp;
    }


}
