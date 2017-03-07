package com.pay.common.helper;

import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author HanKeQi
 * jsckson常用工具类
 *
 */
public class JacksonHelper {

	private static ObjectMapper objectMapper = new ObjectMapper();

	//private static XmlMapper xmlMapper = new XmlMapper();

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public static <T> T parseToObject(InputStream is, Class<T> toClass) {
		try {
			return objectMapper.readValue(is, toClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static <T> T parseToObject(byte[] b, int offset, int len, Class<T> valueType) {
		try {
			return objectMapper.readValue(b, offset, len, valueType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static <T> T parseToObject(String json, Class<T> toClass) {
		try {
			return objectMapper.readValue(json, toClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 此方法可以用于复杂对象比如，List<P>，其他方法返回的则是List<Map>
	 */
	public static <T> T parseToObject(String json, TypeReference<T> type) {
		try {
			return objectMapper.readValue(json, type);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Map parseToMap(String json) {
		return parseToObject(json, Map.class);
	}

	public static Map parseToMapStrStr(String json) {
		return parseToObject(json, new TypeReference<Map<String, String>>() {
		});
	}

	public static Map parseToMap(byte[] b) {
		if (b == null || b.length == 0) {
			return null;
		}
		return parseToObject(b, 0, b.length, Map.class);
	}

	public static Map parseToMap(InputStream is) {
		return parseToObject(is, Map.class);
	}

	/**
	 * object convert to json string
	 */
	public static String parseToJson(Object o) {
		if (o == null) {
			return null;
		}
		try {
			return objectMapper.writeValueAsString(o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

//	/**
//	 * object convert to xml string
//	 */
//	public static String parseToXml(Object o) {
//		try {
//			return xmlMapper.writeValueAsString(o);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * xml string convert to json string 
//	 */
//	public static String xmlTojson(String xmlStr){
//		try {
//			StringWriter w = new StringWriter();
//			JsonParser jp = xmlMapper.getFactory().createParser(xmlStr);
//			JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
//			while (jp.nextToken() != null) {
//				jg.copyCurrentEvent(jp);
//			}
//			jp.close();
//			jg.close();
//			return w.toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * json string convert to xml string 
//	 */
//	public static String jsonToxml(String jsonStr){
//		try {
//			JsonNode root = objectMapper.readTree(jsonStr);
//			String xml = xmlMapper.writeValueAsString(root);
//			return xml;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}

}
