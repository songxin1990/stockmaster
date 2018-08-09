package com.songxin.stock.qiniu;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.StringMap;




public class UpDownUtil {
	
	private static final UploadManager uploadManager = new UploadManager();

	
	/**
	 * 上传数据
	 * 
	 * @param data
	 *            上传的数据 byte[]、File、filePath
	 * @param key
	 *            上传数据保存的文件名
	 * @param token
	 *            上传凭证
	 * @param params
	 *            自定义参数，如 params.put("x:foo", "foo")
	 * @param mime
	 *            指定文件mimetype
	 * @param checkCrc
	 *            是否验证crc32
	 * @return response 响应Response中包含响应头、响应体及其它状态。如 reqId、xvia 等，
	 *         Response#body()返回请求体，Response#bodyString()获得body字符串表示。
	 *         七牛返回内容均是json，Response#jsonToObject(Class<T> classOfT)
	 *         将请求体转为为对应的类实例。
	 * @throws QiniuException
	 */
	public static Response put(File data, String key, String token, StringMap params,
			String mime, boolean checkCrc) throws QiniuException {
		return uploadManager.put(data, key, token, params, mime, checkCrc);
	}
	
	public static MyRet getMyRet(Response res) throws QiniuException{
		
		return res==null?null:res.jsonToObject(MyRet.class);
	}
	public static StringMap getStringMap(Response res) throws QiniuException{
		return res==null?null:res.jsonToMap();
	}
	public static Map<String,Object> getMap(Response res) throws QiniuException{
		return res==null?null:res.jsonToObject(HashMap.class);
	}
	public static void upload(File file,String key) throws QiniuException{
		uploadManager.put(file, key, Uptoken.getUpToken());
	}
	
//	默认uptoken以及其它“没有”设置returnbody、callback、预处理的上传，可直接使用 DefaultPutRet：
//	DefaultPutRet ret = res.jsonToObject(DefaultPutRet.class);
	public static  void upload(File file,String key,String upToken) {
		try {
			Response res = uploadManager.put(file, key, upToken);
			MyRet ret = res.jsonToObject(MyRet.class);
//			log.info(res.toString());
			System.out.println(res.toString());
//			log.info(res.bodyString());
			System.out.println(res.bodyString());
			
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时简单状态信息
//			log.error(r.toString());
			System.out.println(r.toString());
			try {
				// 响应的文本信息
//				log.error(r.bodyString());
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
	}
	//上传内存中数据
	public static void upload(byte[] bytes, String key, String upToken){
	  try {
	        Response res = uploadManager.put(bytes, key, upToken);
	        // log.info(res);
	        // log.info(res.bodyString());
	        // Ret ret = res.jsonToObject(Ret.class);
	        if(res.isOK()){
	            //success
	        }else {
	            //
	        }
	    } catch (QiniuException e) {
	        Response r = e.response;
	        // 请求失败时简单状态信息
//	        log.error(r.toString());
//	        try {
//	            // 响应的文本信息
////	            log.error(r.bodyString());
//	        } catch (QiniuException e1) {
//	            //ignore
//	        }
	    }
	}
	public static Response upload(String filePath, String key) {
		Response result = null;
		  try {
		        Response res = uploadManager.put(filePath, key, Uptoken.getUpToken());
		        // log.info(res);
		        System.out.println(res);
		        // log.info(res.bodyString());
		        System.out.println(res.bodyString());
		        // Ret ret = res.jsonToObject(Ret.class);
		        if(res.isOK()){
		            //success
		        }else {
		            //
		        }
		        result = res;
		    } catch (QiniuException e) {
		        Response r = e.response;
		        // 请求失败时简单状态信息
//		        log.error(r.toString());
		        try {
//		            // 响应的文本信息
////		            log.error(r.bodyString());\
		        System.out.println(r.bodyString());
		        } catch (QiniuException e1) {
//		            //ignore
		        }
		        result = r;
		    }
		  return result;
		}
	
	public static void upload(String filePath, String key, String upToken){
		  try {
		        Response res = uploadManager.put(filePath, key, upToken);
		        // log.info(res);
		        // log.info(res.bodyString());
		        // Ret ret = res.jsonToObject(Ret.class);
		        if(res.isOK()){
		            //success
		        }else {
		            //
		        }
		    } catch (QiniuException e) {
		        Response r = e.response;
		        // 请求失败时简单状态信息
//		        log.error(r.toString());
//		        try {
//		            // 响应的文本信息
////		            log.error(r.bodyString());
//		        } catch (QiniuException e1) {
//		            //ignore
//		        }
		    }
		}

	/**
	 * 测试上传图片
	 * @param args
	 */
	public static void main(String[] args) {
//		String filePath = "D://home//globex-project//imagesupload//24385//small";
		String filePath2 = "C://Users//Administrator//Desktop//des.jpg";
		File file = new File(filePath2);
		//key要带上文件后最
		String key = "testUploadImag.jpg";
		String token = Uptoken.getUpToken();
		upload(file, key, token);
		
		
	}

}
