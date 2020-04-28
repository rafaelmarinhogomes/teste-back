package br.com.biblioteca.controller;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@RequestMapping("/")
	public ModelAndView home() {
		List<Projeto> listProjetos = projetoService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listProjetos", listProjetos);
		return mav;
	}

	@RequestMapping("/new")
	public String newProjetoForm(Map<String, Object> model) {
		Projeto projeto = new Projeto();
		model.put("projeto", projeto);
		return "new_projeto";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProjeto(@ModelAttribute("projeto") Projeto projeto) {
		projetoService.save(projeto);
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public ModelAndView editProjetoForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_projeto");
		Projeto projeto = projetoService.get(id);
		mav.addObject("projeto", projeto);

		return mav;
	}

	@RequestMapping("/delete")
	public String deleteProjetoForm(@RequestParam long id) {
		projetoService.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Projeto> result = projetoService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);

		return mav;
	}
}
