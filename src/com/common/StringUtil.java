package com.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;

/**
 * 字符串相关处理操作
 * @author wangjian
 * @time 2016年7月18日
 */
public class StringUtil {
	//emoji表情符号字符值范围
	private static final Pattern EMOJI = 
			Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", 
					Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE );
	/**
	 * 字符串是否包含emoji字符
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param source
	 * @return
	 */
	public static boolean containsEmoji(String source) {
		if (StringUtils.isEmpty(source)) {
			return false;
		}
		Matcher emojiMatcher = EMOJI.matcher(source);
		if (emojiMatcher.find()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 过滤字符串中的表情符号
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) {
		if (StringUtils.isEmpty(source)) {
			return source;
		}
		String buf = null;
		Matcher matcher = EMOJI.matcher(source);
		buf = matcher.replaceAll("");
		return buf;
	}
}
