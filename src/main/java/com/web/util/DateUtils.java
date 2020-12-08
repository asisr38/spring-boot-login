package com.web.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtils {

	public static Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}

}
