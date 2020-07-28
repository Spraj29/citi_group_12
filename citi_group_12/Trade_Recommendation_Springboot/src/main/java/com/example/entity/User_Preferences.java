package com.example.entity;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User_Preferences {
	
@Id
@GeneratedValue
private String UserId;
private String PreferenceId;
private String time;
public User_Preferences() {
	
}
public User_Preferences(String userId, String preferenceId, String time) {
	super();
	UserId = userId;
	PreferenceId = preferenceId;
	this.time = time;
}
public String getUserId() {
	return UserId;
}
public void setUserId(String userId) {
	UserId = userId;
}
public String getPreferenceId() {
	return PreferenceId;
}
public void setPreferenceId(String preferenceId) {
	PreferenceId = preferenceId;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
@Override
public String toString() {
	return "User_Preferences [UserId=" + UserId + ", PreferenceId=" + PreferenceId + ", time=" + time + "]";
}



}
