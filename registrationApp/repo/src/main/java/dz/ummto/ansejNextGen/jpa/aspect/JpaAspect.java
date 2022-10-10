/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import dz.ummto.ansejNextGen.jpa.util.EMProvider;

/**
 * The <code>JpaAspect</code> class represents Aspect to advise some
 * Transactional operation.
 * <p>
 * <code>JpaAspect</code> use AspectJ AOP for advising
 * {@link dz.ummto.ansejNextGen.jpa.dao.AbstractJpaDao#*} or/and
 * {@link javax.persistence.EntityManager}
 * 
 * @see <a href=
 *      "https://stackoverflow.com/questions/11778499/advising-javax-persistence-entitymanager-with-aspectj-not-working">sof</a>
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@Aspect
public class JpaAspect {

	private static final Log logger = LogFactory.getLog(JpaAspect.class);

	/*
	 * 
	 * @param joinpoint
	 * 
	 * @return
	 * 
	 * @throws Throwable
	 * 
	 * @Around("execution(public * dz.ummto.ansejNextGen.jpa.dao.AbstractJpaDao.save(..))"
	 * ) public Object transactional(ProceedingJoinPoint joinpoint) throws Throwable
	 * { logger.info("-- AspectJ 1"); Object obj = joinpoint.proceed();
	 * logger.info("-- AspectJ 2"); return obj; }
	 */

	/**
	 * 
	 * @param joinpoint
	 * @return
	 * @throws Throwable
	 */
	@Around("call(* javax.persistence.EntityManager.persist(..))"
			+ "|| call(* javax.persistence.EntityManager.merge(..))"
			+ "|| call(* javax.persistence.EntityManager.remove(..))")
	public Object transactional(ProceedingJoinPoint joinpoint) throws Throwable {
		logger.info("-- AspectJ EntityManager start");
		EMProvider.beginTransaction();
		Object obj = joinpoint.proceed();
		EMProvider.commit();
		logger.info("-- AspectJ EntityManager end");
		return obj;
	}
}
