package com.michelle.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelle.languages.models.Language;
import com.michelle.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository langRepo;
	
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language language) {
		return langRepo.save(language);
	}
	
	public Language findLanguage(Long id) {
		Optional <Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
			return null;
		}
	}
	
	public Language updateLanguage(Language language) {
		return langRepo.save(language);
	}
	
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
	
}
