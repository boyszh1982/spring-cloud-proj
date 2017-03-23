package com.nameless.ehcache.service;

public interface IUserService {

	String get(String userNo);

	void update(String userNo);

	void removeAll();

}
