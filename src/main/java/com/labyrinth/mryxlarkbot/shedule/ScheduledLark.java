package com.labyrinth.mryxlarkbot.shedule;

import com.alibaba.fastjson.JSONObject;
import com.labyrinth.mryxlarkbot.tools.RestTemplateTools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Slf4j
public class ScheduledLark {


    static int lineNumber = 1;

    @Resource
    RestTemplateTools restTemplateTools;


    @Scheduled(cron = "0 0 0,1,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23 * * ? ")
    public void execute(){

        String mess = "";
        String botAPI = "https://open.feishu.cn/open-apis/bot/v2/hook/83f9c3ce-100d-49a0-b915-767c5fe208b4";
        try {
            Date date= new Date();
            long timeStamp = date.getTime();
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式

            //time
            String timeText=format.format(timeStamp);
            String[] timeSplit = timeText.split(" ");
            String time = timeSplit[1];

            //text
            LineNumberReader lineNumberReader = new LineNumberReader(new BufferedReader(new FileReader("./template/repository.txt")));
            for(int i=0; i<lineNumber; i++) mess = lineNumberReader.readLine();
            mess.replaceAll("―", "\n" + "―");
            lineNumber++;


            //第四层
            List<List<Map<String,Object>>> innerContentList = new ArrayList<>();
            List<Map<String,Object>> innerContent = new ArrayList<>();
            innerContentList.add(innerContent);
            Map<String,Object> innerContent1 = new HashMap();
            innerContent1.put("tag", "text");
            innerContent1.put("text", mess );
            innerContent.add(innerContent1);

            //第三层
            Map<String,Object> zhInner = new HashMap();
            zhInner.put("title", time);
            zhInner.put("content", innerContentList);

            Map<String,Object> postInner = new HashMap();
            postInner.put("zh_cn", zhInner);

            //第二层
            Map<String,Object> content = new HashMap();
            content.put("post",postInner);


            //外层json
            Map<String,Object> json = new HashMap();
            json.put("msg_type", "post");
            json.put("content", content);
            System.out.println(JSONObject.toJSONString(json));

            ResponseEntity<String> result = restTemplateTools.sendJson(botAPI, JSONObject.toJSONString(json));



            if(HttpStatus.OK.equals(result.getStatusCode())){
                log.info("发送成功"+mess);
            }else {
                log.info("发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
