package com.github.jml1977.heroku;

import org.apache.commons.dbcp.BasicDataSource;

public class HerokuBasicDataSource extends BasicDataSource {
	@Override
	public synchronized void setUrl(String url) {
		if (url != null && url.startsWith("postgres://")) {
			int userBegin = url.indexOf("://") + 3;
			int userEnd = url.indexOf(":", userBegin);
			int passwordBegin = userEnd + 1;
			int passwordEnd = url.indexOf("@", passwordBegin);
			String userName = url.substring(userBegin, userEnd);
			String password = url.substring(passwordBegin, passwordEnd);

			String remaining = url.substring(passwordEnd + 1);

			String newUrl = "jdbc:postgresql://" + remaining;
			setUsername(userName);
			setPassword(password);
			// recursive, but now should be ok format-wise
			setUrl(newUrl);
		} else {
			super.setUrl(url);
		}
	}
}
