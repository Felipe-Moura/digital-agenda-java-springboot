package com.web.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.agenda.repository.AgendaRepository;

@Service
public class AgendaService {
	
	private AgendaRepository agendaRepository;
	
	@Autowired
	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}

}
