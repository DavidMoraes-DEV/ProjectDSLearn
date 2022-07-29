package com.devsuperior.dslearnbds.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
Quando é uma classe que herda de outra é necessário apenas colocar as anottations de definição que ela será uma entidade componente
e definir o nome dessa classe no banco o conteúdo dentro dessa classe é conteúdo adicional que não precisa de annotations
*/
@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
	private static final long serialVersionUID = 1L;

	private String textContent;
	private String videoUri;
	
	public Content() {
	}

	public Content(Long id, String title, Integer position, Section section, String textContent, String videoUri) {
		super(id, title, position, section);
		this.textContent = textContent;
		this.videoUri = videoUri;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public String getVideoUri() {
		return videoUri;
	}

	public void setVideoUri(String videoUri) {
		this.videoUri = videoUri;
	}
}
