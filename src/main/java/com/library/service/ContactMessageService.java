package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.domain.ContactMessage;
import com.library.exception.ResourceNotFoundException;
import com.library.exception.message.ErrorMessage;
import com.library.repository.ContactMessageRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactMessageService {
	
	@Autowired
	private ContactMessageRepository repository;

	
	public void createContactMessage(ContactMessage contactMessage) {
		repository.save(contactMessage);
	}
	
	public List<ContactMessage> getAllContactMessage(){
		return repository.findAll();
	}
	
	public ContactMessage getContactMessage(Long id) {
		return repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE , id)));
	}
	
	public void deleteContactMessage(Long id) {
		ContactMessage message = getContactMessage(id);
		repository.deleteById(message.getId());
	}
	
	public void updateContactMessage(Long id , ContactMessage newContactMessage ) {
		ContactMessage foundMessage = getContactMessage(id);
		
		foundMessage.setName(newContactMessage.getName());
		foundMessage.setSubject(newContactMessage.getSubject());
		foundMessage.setBody(newContactMessage.getBody());
		foundMessage.setEmail(newContactMessage.getEmail());
		
		repository.save(foundMessage);
		
	}
	
}
