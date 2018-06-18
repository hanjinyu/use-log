package cn.tietou.ssh.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessage;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component(value = "logAspect")
public class LogAspect {
	
	private static final Logger logger = LogManager.getLogger();
	
	private static Long timeConsuming = 0L;
	private static Long endTimeConsuming = 0L;
	
	public void before(JoinPoint joinPoint) {
		timeConsuming = System.currentTimeMillis();
		logger.info(new MessageFormatMessage("args : {0} - this : {1} - target : {2}", joinPoint.getArgs(), joinPoint.getThis(), joinPoint.getTarget()));
		logger.info(new MessageFormatMessage("启动时间 : {0}", String.valueOf(timeConsuming)));
	}
	
	public void after(JoinPoint joinPoint) {
		endTimeConsuming = System.currentTimeMillis();
		logger.info(new MessageFormatMessage("结束时间 : {0}, 耗时 : {1}", String.valueOf(timeConsuming), endTimeConsuming - timeConsuming));
	}
}
