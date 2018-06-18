package cn.tietou.ssh.service;

import cn.tietou.ssh.entity.Person;

/**
 * Created by XRom
 * On 11/16/2017.11:57 PM
 */
public interface PersonService {
    Long savePerson();
    Person selectPerson(String id);
}
