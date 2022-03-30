package com.web.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.agenda.service.AgendaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/agenda")
public class AgendaController {
	
	private AgendaService agendaService;
	
	@Autowired
	public AgendaController(AgendaService agendaService) {
		this.agendaService = agendaService;
	}

}
