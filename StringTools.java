package com.highershine.gdna2.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 自定义字符串处理工具类
 * <p>
 * <p>
 * 
 * @author jacky
 */
public class StringTools {

	private static final String zeros = "00000000000000000000000";

	/**
	 * 将int数转换为位数为size的String字符串 <br>
	 * 如size为4时，数字1会被转换为"0001"
	 * @param number
	 * @param size
	 * @return
	 */
	public static String convertIntToString(int number, int size) {
		String ins = Integer.toString(number);
		int len = ins.length();
		if (len >= size) {
			return ins;
		} else {
			return zeros.substring(0, size - len) + ins;
		}
	}
	
	/**
	 * 将下划线拼起来的字段名转为首字母小写，后面单词首字母大写的格式
	 * @param columnStr
	 * @return
	 */
	public static String convertColumnToProperty(String columnStr) {
		StringBuffer result = new StringBuffer();
		if (!StringUtils.isEmpty(columnStr)) {
			String[] strs = columnStr.split("_");
			result.append(strs[0].toLowerCase());
			if (strs.length > 1) {
				for (int i = 1; i < strs.length; i++) {
					result.append(strs[i].substring(0, 1).toUpperCase())
							.append(strs[i].substring(1).toLowerCase());
				}
			}
		}
		return result.toString();
	}

	public static String getUtf8FromIso8859_1(String value) throws UnsupportedEncodingException {
		return new String(value.getBytes("ISO-8859-1"),"utf-8");
	}

	public static String convertListToString(List<? extends Object> list,String separator) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < list.size(); i++) {
			String str = String.valueOf((Integer) list.get(i));
			sb.append(str).append(separator);
		}
		String returnVal = sb.toString().substring(0,
				sb.toString().length() - 1);
		returnVal = returnVal + "]";
		return returnVal;
	}
	
	//字符串转化为List
	public static List<String> converStringToList(String str,String regex){
		List<String> strList = new ArrayList<String>();
		if(str != null && str != ""){
			String[] strArr = str.split(regex);
			for(String s : strArr){
				strList.add(s);
			}
		}
		return strList;
	}
	
	//生成num个cha的字符串
	public static String dupeString(char cha, int num){
		StringBuffer rtnStr = new StringBuffer();
		for(int i = 0; i < num; i++){
			rtnStr = rtnStr.append(cha);
		}
		return rtnStr.toString();
	}
	
	/*
	 * yyyy-MM-dd格式的日期验证
	 */
	public static boolean checkStringForMatch(String str){
		String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);  
		return matcher.matches();
	}
	
	public static Map<String,String> transStringToMap(String mapString){
		Map<String,String> map = new HashMap<String,String>();
		//去掉前后括号
		mapString = mapString.substring(1,mapString.length()-1);
		//按“，”将其分为字符数组
		String[] arraydata = mapString.split(",");
		for(int i=0;i<arraydata.length;i++){
			int j = arraydata[i].indexOf(":");
			map.put(arraydata[i].substring(1,j-1),arraydata[i].substring(j+1,arraydata[i].length()));
		} 
		return map;
	}
	
	/**
	 * mapString to map
	 * @param mapString
	 * @return
	 */
	public static Map<String,String> transferStringToMap(String mapString){
		Map<String,String> map = new HashMap<String,String>();
		//去掉前后括号
		mapString = mapString.substring(1,mapString.length()-1);
		//按“，”将其分为字符数组
		String[] arraydata = mapString.split(",");
		for(int i=0;i<arraydata.length;i++){
			String[] arr = arraydata[i].split("=");
			map.put(arr[0].trim(), arr[1].trim());
		} 
		return map;
	}
	
	/**
	 * 把sourceObj的属性拷贝到targetObj，包括父类属性，如果属性类型是字符串，需要去首尾空格
	 * @param sourceObj 源对象 
	 * @param targetObj 目标对象
	 */
	public static void copyTrimValue(Object sourceObj,Object targetObj,Class<?> classType){
		try{
			if(sourceObj==null||targetObj==null){
				throw new RuntimeException("源对象和目标对象都不能为null！");
			}
			Field[] declaredFields = classType.getDeclaredFields();
			if(declaredFields!=null&&declaredFields.length>0){
				for(int i=0;i<declaredFields.length;i++){
					Field declaredField = declaredFields[i];
					declaredField.setAccessible(true);
					Object sourceValue = declaredField.get(sourceObj);
					if(declaredField.getType().getName().equals("java.lang.String")&&sourceValue!=null){
						declaredField.set(targetObj,sourceValue.toString().trim());
					}else{
						declaredField.set(targetObj,sourceValue);
					}
				}
			}
			if(classType.getSuperclass()==Object.class){
				return;
			}else{
				//递归复制
				copyTrimValue(sourceObj,targetObj,classType.getSuperclass());
			}
		}catch(Exception e){
			//异常信息，务必向上抛出！
			throw new RuntimeException(e);
		}
	}
	
	//测试copyTrimValue方法的代码
	public static void main(String[] args){
	}

    /**
     * map转string(key1=value1&key2=value2…)
     * @param map
     * @return
     */
    public static String getMapToString(Map<String,Object> map){
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if ((String.valueOf(map.get(keyArray[i]))).trim().length() > 0) {
                sb.append(keyArray[i]).append("=").append(String.valueOf(map.get(keyArray[i])).trim());
            }
            if(i != keyArray.length-1){
                sb.append("&");
            }
        }
        return sb.toString();
    }
	
}