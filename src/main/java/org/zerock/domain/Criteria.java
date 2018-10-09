package org.zerock.domain;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
	
	//검색 조건 처리
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}


	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount  = amount;
	}
	
	//검색 조건이 각 글자(T,W,C)로 구성되어 있으므로 검색 조건을 배열로 만들어서 
	//한 번에 처리하기 위함.
	public String[] getTypeArr() {
		return type == null? new String [] {}: type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.type)
				.queryParam("keyword", this.keyword);
				
		return builder.toUriString();
		
	}
}
