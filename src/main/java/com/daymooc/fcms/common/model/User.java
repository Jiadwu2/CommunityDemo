package com.daymooc.fcms.common.model;

import com.daymooc.fcms.common.model.base.BaseUser;
import com.daymooc.fcms.common.safe.JsoupFilter;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User().dao();
	
	public static final String AVATAR_NO_AVATAR = "/assets/images/avatar/default.jpg";
	
	public static final int STATUS_LOCK_ID = -1;	// 锁定账号，无法做任何事情
	public static final int STATUS_REG = 0;			// 注册、未激活
	public static final int STATUS_OK = 1;			// 正常、已激活

	public boolean isStatusOk() {
		return getStatus() == STATUS_OK;
	}

	public boolean isStatusReg() {
		return getStatus() == STATUS_REG;
	}

	public boolean isStatusLockId() {
		return getStatus() == STATUS_LOCK_ID;
	}

	/**
	 * 过滤掉 nickName 中的 html 标记，恶意脚本
	 */
	protected void filter(int filterBy) {
		JsoupFilter.filterAccountNickName(this);
	}

	public User removeSensitiveInfo() {
		remove("password", "salt");
		return this;
	}
}
