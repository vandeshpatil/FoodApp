package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;



@Controller
public class MainController {
	 @Autowired
	    private PersonDAO personDao;

	    @RequestMapping(value = "/delete")
	    @ResponseBody
	    public String delete(long id) {
	        try {
	            Person person = new Person();
	            person.setId(id);
	            personDao.delete(person);
	        } catch (Exception ex) {
	            return ex.getMessage();
	        }
	        return "Person succesfully deleted!";
	    }

	    @RequestMapping(value = "/save")
	    @ResponseBody
	    public String create(String name, String city) {
	        try {
	            Person person = new Person();
	            person.setName(name);
	            person.setCity(city);
	            personDao.savePerson(person);
	        } catch (Exception ex) {
	            return ex.getMessage();
	        }
	        return "Person succesfully saved!";
	    }
	    @RequestMapping(value = "/allPersons")
	    @ResponseBody
	    public List getAllPersons() {
	        try {
	            return personDao.getAllPersons();
	            
	        } catch (Exception ex) {
	            return null;
	        }
	    }
	    
	    
	    ///////////////
	    @GetMapping("/get/{id}")
		public ResponseEntity<Person> getEmployeeById(@PathVariable("id") long employeeId){
			return new ResponseEntity<Person>(personDao.getPerson(employeeId), HttpStatus.OK);
		}
}
