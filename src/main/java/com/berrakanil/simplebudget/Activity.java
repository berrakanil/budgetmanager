package com.berrakanil.simplebudget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Activity {
	
	private final float DELTA = 0.0001f;
	private float m_amount;
	private String m_date;

	public Activity(float amount) {
		if (amount < DELTA) {
			throw new IllegalArgumentException();
		}
		this.m_amount = amount;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.m_date = dateFormat.format(date);
	}
	
	public float getAmount() {
		return m_amount;
	}
	
	public String getDate() {
		return m_date;
	}
	
	public abstract Direction getDirection();
	public abstract String getName();
}
