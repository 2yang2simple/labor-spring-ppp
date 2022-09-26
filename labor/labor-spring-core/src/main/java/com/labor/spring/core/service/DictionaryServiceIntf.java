package com.labor.spring.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.labor.spring.core.entity.Dictionary;




public interface DictionaryServiceIntf {

	
	public String createTopDictionarys();
	
	public Dictionary create(Dictionary ditionary);
	public Dictionary update(Dictionary ditionary);
	
	public Long countByExample(Dictionary ditionary);
	public Optional<Dictionary> findByExample(Dictionary ditionary);
	public Optional<Dictionary> findById(Integer id);
	
	public List<Dictionary> findListByExample(Dictionary ditionary);
	public Page<Dictionary> findListByExample(Dictionary ditionary, Pageable pageable);

	public List<Dictionary> findSubList(String code, String status);
	public List<Dictionary> findSubList();
	public List<Dictionary> findTopList();
}
