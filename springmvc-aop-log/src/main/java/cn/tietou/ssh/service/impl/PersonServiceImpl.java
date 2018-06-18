package cn.tietou.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tietou.ssh.entity.Person;
import cn.tietou.ssh.repository.PersonRepository;
import cn.tietou.ssh.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired(required = true)
    private PersonRepository personRepository;

    @Override
    public Long savePerson() {
        Person person = new Person();
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        return personRepository.save(person);
    }
    
    public Person selectPerson(String id) {
    	return personRepository.get(Long.valueOf(id));
    }
}
