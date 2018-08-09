package com.songxin.stock.qiniu;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class Uptoken {
	
	private static final Auth auth = Auth.create(Config.ACCESS_KEY, Config.SECRET_KEY);
	
	public static String getUpToken(){
		 return auth.uploadToken(Config.BUCKET);
	}
	public static String getUpToken(String key){
		 return auth.uploadToken(Config.BUCKET,key);
	}
	
	// 简单上传，使用默认策略
	public static String getUpToken0(String bucket){
	    return auth.uploadToken(bucket);
	}

	// 覆盖上传
	public static String getUpToken(String bucket,String key){
	    return auth.uploadToken(bucket, key);
	}
	
	// 设置指定上传策略
	/**
	 * 
	 * @param bucket  空间名
	 * @param key 资源的key(图片名) 可为 null
	 * @param expires 有效时长，单位秒。默认3600s
	 * @param callbackUrl 回调的URL
	 * @param callbackHost 回调的HOST 非空
	 * @param callbackBody 回调返回的body
	 * @return
	 */
	public static  String getUpToken2(String bucket,String key,long expires,String callbackUrl,String callbackHost,String callbackBody){
//	    return auth.uploadToken("bucket", null, 3600, new StringMap()
//	         .put("callbackUrl", "call back url").putNotEmpty("callbackHost", "")
//	         .put("callbackBody", "key=$(key)&hash=$(etag)"));
		StringMap policy = new StringMap();
		policy.put("callbackUrl", callbackUrl).putNotEmpty("callbackHost", callbackHost)
        .put("callbackBody", callbackBody);
		
		if(expires==0){
			expires = 3600;
		}
		return auth.uploadToken(bucket, key, expires, policy);
	}

	// 设置预处理、去除非限定的策略字段
	public static  String getUpToken3(String bucket,String key,long expires,String persistentOps,String persistentNotifyUrl,String persistentPipeline){
//	    return auth.uploadToken("bucket", null, 3600, new StringMap()
//	            .putNotEmpty("persistentOps", "").putNotEmpty("persistentNotifyUrl", "")
//	            .putNotEmpty("persistentPipeline", ""), true);
		
		StringMap policy = new StringMap();
		policy.putNotEmpty("persistentOps", persistentOps).putNotEmpty("persistentNotifyUrl", persistentNotifyUrl)
        .putNotEmpty("persistentPipeline", persistentPipeline);
		
		return auth.uploadToken(bucket, null, 3600, policy,true);
	}

	/**
	* 生成上传token
	*
	* @param bucket  空间名
	* @param key     key，可为 null
	* @param expires 有效时长，单位秒。默认3600s
	* @param policy  上传策略的其它参数，如 new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "")。
	*        scope通过 bucket、key间接设置，deadline 通过 expires 间接设置
	* @param strict  是否去除非限定的策略字段，默认true
	* @return 生成的上传token
	*/
	public String getUploadToken(String bucket, String key, long expires, StringMap policy, boolean strict){
		return auth.uploadToken(bucket, key, expires, policy, strict);
	}
		
	/**
	 * 简单测试下获取的token
	 * @param args
	 */
	public static void main(String[] args) {
		String token01 = getUpToken();
		System.out.println(token01);
	}
			

}
