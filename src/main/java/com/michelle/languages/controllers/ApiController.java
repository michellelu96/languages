package com.michelle.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michelle.languages.models.Language;
import com.michelle.languages.services.LanguageService;

@RestController
public class ApiController {
	
	@Autowired
	private LanguageService langService;
	
	public ApiController(LanguageService langService) {
		this.langService = langService;
	}
	
	//get all languages
	@GetMapping("/api/languages")
	public List<Language> findAllLanguages(){
		return langService.allLanguages();
	}
	
	//get one language
	@GetMapping("/api/language/{id}")
	public Language oneLanguage(@PathVariable("id") Long id) {
		return langService.findLanguage(id);
	}
	
	//create one
	@PostMapping("/api/languages")
	public Language createLanguage(@RequestParam("name") String name, 
			@RequestParam("creator") String creator, 
			@RequestParam("version") Double version) {
		Language newLanguage = new Language(name,creator,version);
		return langService.createLanguage(newLanguage);
	}
	
	// update one
	@PutMapping("/api/languages/{id}")
	public Language updateLanguage(@PathVariable("id") Long id,
			@RequestParam("name") String name, 
			@RequestParam("creator") String creator, 
			@RequestParam("version") Double version
			) {
		Language updateLanguage = langService.findLanguage(id);
		updateLanguage.setName(name);
		updateLanguage.setCreatorName(creator);
		updateLanguage.setVersion(version);
		return langService.updateLanguage(updateLanguage);
	}
	
	//delete One
	@DeleteMapping("/api/languages/{id}")
	public void deleteLanguage(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
	}
}
