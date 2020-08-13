package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.entity.Link;
import com.company.repository.LinkRepository;

@Service
public class LinkService {

	private static List<Link> links = new ArrayList<>();
	
	public LinkService() {
	
		links.add(new Link("https://football.ua/"));
		links.add(new Link("https://gooool.tv/"));
		links.add(new Link("https://www.ua-football.com/"));
		links.add(new Link("https://terrikon.com/"));
		links.add(new Link("https://ua.tribuna.com/"));
		links.add(new Link("https://sportarena.com/"));
		links.add(new Link("https://sport.ua/"));
		links.add(new Link("https://football24.ua/"));
		links.add(new Link("https://xsport.ua/"));
		links.add(new Link("https://www.footboom.com/"));
	}

	@Autowired
	private LinkRepository linkRepository;
	
	@Transactional
	public void addLinks() {
		linkRepository.saveAll(links);
	}
	
	@Transactional
	public List<Link> getAllLinks() {
		return linkRepository.findAll();
	}
	
	@Transactional
	public void addLink(Link link) {
		linkRepository.save(link);
	}
	
	@Transactional
	public Link getLinkById(long id) {
		return linkRepository.findLinkById(id);
	}

}
