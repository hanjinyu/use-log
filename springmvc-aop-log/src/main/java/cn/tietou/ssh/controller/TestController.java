package cn.tietou.ssh.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tietou.ssh.entity.Person;
import cn.tietou.ssh.service.PersonService;

/**
 * Created by XRom
 * On 11/16/2017.11:59 PM
 */
@Controller
public class TestController {
	
	private static final Logger logger = LogManager.getLogger();
	
    @Autowired(required=true)
    private PersonService personService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
    	logger.info("调用:", this.getClass().getName(), "test()");
    	//TODO 一些业务处理
    	logger.info("调用结束:", this.getClass().getName(), "test()", "-耗时:", "122124141212ms");
        return "test";
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson() {
        personService.savePerson();
        return "success!";
    }
    
    @RequestMapping(value = "/selectPerson", method = RequestMethod.GET)
    @ResponseBody
    public Person selectPerson(@RequestParam(name = "id") String id) {
    	Person p = personService.selectPerson(id);
    	return p;
    }
    
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception() throws Exception {
    	logger.error("异常：", new Exception("我的一个异常记录到日志."));
    	throw new Exception("deploy a exception");
    }
    
}
