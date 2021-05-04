package ru.currency.converter.entity;

import javax.persistence.*;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String text;
	private String tag;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getText() {
		return this.text;
	}
	
	public String getTag(String tag ) {
		return this.tag;
	}
}
