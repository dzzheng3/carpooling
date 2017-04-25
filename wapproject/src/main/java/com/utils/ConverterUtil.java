package com.utils;

import com.model.Gender;
import com.model.PostType;

public class ConverterUtil {
	
	
	public static Gender genderConvert(int gender){
		if(gender == 1){
			return Gender.FEMALE;
		}
		return Gender.MALE;
	}
	
	
	public static int typeConvertToInt(PostType type){
		if(PostType.OFFERING.equals(type)){
			return 1;
		}
		return 2;
	}
	
	public static PostType intConvertToType(int type){
		if(type == 1){
			return PostType.OFFERING;
		}
		return PostType.ASKING;
	}

}
