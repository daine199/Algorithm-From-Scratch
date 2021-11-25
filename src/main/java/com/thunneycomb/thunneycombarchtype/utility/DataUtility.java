package com.thunneycomb.thunneycombarchtype.utility;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * thunneycomb-archtype
 * 2019-07-25 18:50
 * 用于组装驱动测试的数据
 * testNG标准实现
 *
 * @author Daine.H
 * @since 2015
 **/

public class DataUtility {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataUtility.class);


    /**
     * 获取json 中的数据，DataProvider基础方法
     * @param filename
     * @return
     */
    public static Object[][] getData (String filename) {

        try {
            String filePathOri = Thread.currentThread().getContextClassLoader().getResource(filename).getFile();
            String filePath = java.net.URLDecoder.decode(filePathOri, "UTF-8");
            String filecontent = readFile(filePath);

            JSONArray testArray = JSONArray.parseArray(filecontent);
            Object[][] objects = new Object[testArray.size()][4];

            for (int i = 0 ; i < testArray.size(); i++) {

                // 1. 组装CaseInfo 用例index + 级别 + 用例名
                String index = testArray.getJSONObject(i).getString("CaseIndex");
                String priority = testArray.getJSONObject(i).getString("Priority");
                String caseName = testArray.getJSONObject(i).getString("CaseName");
                objects[i][0] = String.format("ID:%s [%s] =%s= ", index, priority, caseName);

                // 2. 组装请求 Json 格式便于组装
                objects[i][1] = testArray.getJSONObject(i).getJSONObject("Req");
                // 3. 组装期望结果 Json 格式便于格式化和比对
                objects[i][2] = testArray.getJSONObject(i).getJSONObject("Exp");
                // 4. 组装其他信息 Done
                objects[i][3] = testArray.getJSONObject(i).getString("Comment");
            }

            return objects;

        } catch (Exception e) {
            throw new RuntimeException(String.format("classpath 中未找到测试数据文件 %s，请检查classpath配置或profile配置,", filename), e);
        }

    }

    public static Object[][] getArrays (String filename) {
        try {
            String filePathOri = Thread.currentThread().getContextClassLoader().getResource(filename).getFile();
            String filePath = java.net.URLDecoder.decode(filePathOri, "UTF-8");
            String filecontent = readFile(filePath);

            JSONArray testArray = JSONArray.parseArray(filecontent);
            Object[][] objects = new Object[testArray.size()][1];
            for (int i = 0 ; i < testArray.size(); i++) {
                int[] prices = testArray.getJSONObject(i).getObject("prices", int[].class);
                objects[i][0] = prices;
            }
            return objects;
        } catch (Exception e) {
            throw new RuntimeException(String.format("classpath 中未找到测试数据文件 %s，请检查classpath配置或profile配置,", filename), e);
        }
    }

    public static String readFile(String fileName) {

        File file = new File(fileName);
        Long length = file.length();
        byte[] content = new byte[length.intValue()];

        try {
            FileInputStream in = new FileInputStream(file);
            in.read(content);
            in.close();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        try {
            return new String(content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("The OS does not support UTF-8" + "; " + e.getMessage(), e);
            return null;
        }
    }

}
