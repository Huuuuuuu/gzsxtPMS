package com.gzsxt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//系统配置工具
public class ConfigUtil {
	//1.获取配置文件中的每页数据数量
	public static int getLoadCount(String name) {
		//读取配置文件
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取指定列表的每页数据数量设置
		int loadCount = Integer.parseInt(prop.getProperty(name));
		//返回数量
		return loadCount;
	}
}
