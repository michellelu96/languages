package com.michelle.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.michelle.languages.models.Language;
import com.michelle.languages.services.LanguageService;

@Controller
public class MainController {
	
	@Autowired
	private LanguageService langService;
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String allLanguages(Model model) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages",languages);
		model.addAttribute("language", new Language() );
		return "home.jsp";
	}
	
	//create one
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Language> languages = langService.allLanguages();
			model.addAttribute("languages",languages);
			return "home.jsp";
		}else {
			langService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	//get one
	@GetMapping("/languages/{id}")
	public String oneLanguage(@PathVariable("id") Long id, Model model) {
		Language oneLanguage = langService.findLanguage(id);
		model.addAttribute("language",oneLanguage);
		return "oneLanguage.jsp";
	}
	
	//edit
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = langService.findLanguage(id);
		model.addAttribute("language",language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/edit/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}else {
			langService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
