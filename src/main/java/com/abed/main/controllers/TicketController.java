package com.abed.main.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abed.main.models.Ticket;
import com.abed.main.services.TicketService;

@Controller
@RequestMapping("/api/tickets")
public class TicketController {
	
	final static String defaultUrlPattern="/api/tickets";
	@Autowired
	TicketService tService;
	
	
	@RequestMapping("/home")
	public String welcome()
	{
		return "welcome" ;
	}
	@PostMapping(value ="/create" , consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Boolean> createTicket(@Valid @RequestBody Ticket ticket)
	{
		if(ticket!=null)
		{
		HttpHeaders headers= new HttpHeaders();
		headers.add("location", ServletUriComponentsBuilder
								.fromCurrentRequest()
								.path("{/id}")
								.buildAndExpand(ticket.getId())
								.toString());
		tService.createTicket(ticket);
		
		return new ResponseEntity<Boolean>(true,headers,HttpStatus.CREATED);
		}
		else return null ; 
		
	}
	
	
	
	
	
	@GetMapping("/ticket")
	public String GetTicketById(@RequestParam(value="Student_Id" , required=false ,defaultValue="")Integer id,Model mav)
	{
		Ticket ticket = null ; 
		List<Ticket> allTickets = null ; 
		if(id !=null)
		{ticket = tService.getTicketById(id);
		mav.addAttribute("ticket_info", ticket);
		}
		else 
		{
			allTickets = tService.getAllTickets();
			mav.addAttribute("allTickets", allTickets);
		}
		return "searchResult";
	}
	
	@DeleteMapping("/deleteall")
	public String deleteAllTickets()
	{
		tService.deleteAllTickets();
		return "redirect:"+defaultUrlPattern+"/ticket"; 
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteTicketById(@PathVariable("id") int id)
	{
		Ticket ticket = tService.getTicketById(id);
		tService.deleteTicket(ticket);
		return "redirect:"+defaultUrlPattern+"/ticket"; 
	}
	
	@PostMapping("/update")
	public String updateTicket(@Valid @ModelAttribute Ticket ticket , Errors error,Model mod)
	{
		
		if(error.hasErrors())
		{
			mod.addAttribute("id", ticket.getId());
			mod.addAttribute("id", ticket.getId());

			return "updatePage";
		}
		tService.updateTicket(ticket);
		return  "redirect:"+defaultUrlPattern+"/ticket"; 
	}
	
	@GetMapping("/updatePage/{id}")
	public String getUpdatePage (@PathVariable ("id")Integer id ,Model mod)
	{
		mod.addAttribute("id", id);
		return "updatePage"; 
	}

	@GetMapping("/createTicket")
	public String getCreatePage ()
	{
		
		return "createTicketPage"; 
	}
	

}
