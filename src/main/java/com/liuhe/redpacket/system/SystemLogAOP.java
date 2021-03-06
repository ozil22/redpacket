//package com.liuhe.redpacket.system;
//
//import java.lang.reflect.Method;
//import java.util.Date;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.liuhe.redpacket.domain.Employee;
//import com.liuhe.redpacket.domain.SystemException;
//import com.liuhe.redpacket.domain.SystemLog;
//import com.liuhe.redpacket.service.IEmployeeService;
//import com.liuhe.redpacket.service.ISystemExceptionService;
//import com.liuhe.redpacket.service.ISystemLogService;
//import com.liuhe.redpacket.utils.UserContext;
//
///**
// * 系统日志切点类类
// *
// * @author ozil
// *
// */
//@Aspect
//@Component
//public class SystemLogAOP {
//	@Autowired
//	private ISystemLogService systemLogService;
//	@Autowired
//	private IEmployeeService employeeService;
//	@Autowired
//	private ISystemExceptionService systemExceptionService;
//
//	// 本地异常日志记录对象
//	private static final Logger logger = LoggerFactory
//			.getLogger(SystemLogAOP.class);
//
//	// Service层切点
//	@Pointcut("execution(* com.liuhe.redpacket.service..*.*(..))")
//	public void serviceAspect() {
//	}
//
//	// Controller层切点
//	@Pointcut("@annotation(com.liuhe.redpacket.system.MethodAnnotation)")
//	public void controllerAspect() {
//	}
//
//	/**
//	 * 前置通知 用于拦截Controller层记录用户的操作
//	 *
//	 * @param joinPoint
//	 *            切点
//	 */
//	@Before("controllerAspect()")
//	public void doBefore(JoinPoint joinPoint) {
//
////		Employee employee = UserContext.getEmployee();// 获取当前登录用户
//		Employee employee = employeeService.get(1l);
//		// 请求的IP
//		String ip = UserContext.getIP();
//		// 获取用户请求方法的参数
//		String params = getParams(joinPoint);
//		try {
//			// *========控制台输出=========*//
//			System.out.println("=====前置通知开始=====");
//			// *========数据库日志=========*//
//			SystemLog log = new SystemLog();
//			log.setDescription(getControllerMethodDescription(joinPoint));
//			log.setFunction((joinPoint.getTarget().getClass().getSimpleName() + "."
//					+ joinPoint.getSignature().getName()));
//			log.setOpIP(ip);
//			log.setParams(params);
//			log.setOpUser(employee.getRealName());
//			log.setOpTime(new Date());
//			;
//			// 保存数据库
//			systemLogService.save(log);
//			System.out.println("=====前置通知结束=====");
//		} catch (Exception e) {
//			e.printStackTrace();
//			// 记录本地异常日志
//			logger.error("=====================前置通知异常===========================");
//			logger.error("异常信息:{}", e.getMessage());
//		}
//	}
//
//	/**
//	 * 异常通知 用于拦截service层记录异常日志
//	 *
//	 * @param joinPoint
//	 * @param e
//	 */
//	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
//	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
//		// 请求的IP
//		String ip = UserContext.getIP();
//		// 获取用户请求方法的参数
//		String params = getParams(joinPoint);
//		try {
//			/* ========控制台输出========= */
//			System.out.println("=====异常通知开始=====");
//			/* ==========数据库日志========= */
//			SystemException exception = new SystemException();
//			exception.setExceptionCode(e.getClass().getSimpleName());
//			exception.setExceptionDetail(e.getMessage());
//			exception.setFunction((joinPoint.getTarget().getClass().getSimpleName()
//					+ "." + joinPoint.getSignature().getName()));
//			exception.setParams(params.toString());
//			exception.setOpTime(new Date());
//			exception.setOpIP(ip);
//			// 保存数据库
//			systemExceptionService.saveException(exception);
//			System.out.println("=====异常通知结束=====");
//		} catch (Exception ex) {
//			// 记录本地异常日志
//			logger.error("==============异常通知异常=================");
//			logger.error("异常信息:{}", ex.getMessage());
//		}
//		/* ==========记录本地异常日志========== */
//		logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget()
//				.getClass().getName()
//				+ joinPoint.getSignature().getName(), e.getClass().getName(),
//				e.getMessage(), params);
//
//	}
//
//	/**
//	 * 获取注解中对方法的描述信息 用于Controller层注解
//	 *
//	 * @param joinPoint
//	 *            切点
//	 * @return 方法描述
//	 * @throws Exception
//	 */
//	public static String getControllerMethodDescription(JoinPoint joinPoint)
//			throws Exception {
//		String targetName = joinPoint.getTarget().getClass().getName();
//		String methodName = joinPoint.getSignature().getName();
//		Object[] arguments = joinPoint.getArgs();
//		Class<?> targetClass = Class.forName(targetName);
//		Method[] methods = targetClass.getMethods();
//		String description = "";
//		for (Method method : methods) {
//			if (method.getName().equals(methodName)) {
//				@SuppressWarnings("rawtypes")
//				Class[] clazzs = method.getParameterTypes();
//				if (clazzs.length == arguments.length) {
//					MethodAnnotation annotation = method
//							.getAnnotation(MethodAnnotation.class);
//					description = annotation.type().name() + "-" + annotation.name();
//					break;
//				}
//			}
//		}
//		return description;
//	}
//
//	/**
//	 * 获取请求参数
//	 *
//	 * @param joinPoint
//	 *            切点
//	 * @return 方法描述
//	 * @throws Exception
//	 */
//	public static String getParams(JoinPoint joinPoint) {
//		// 获取用户请求方法的参数
//		StringBuilder params = new StringBuilder();
//		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
//			for (int i = 0; i < joinPoint.getArgs().length; i++) {
//				Object arg = joinPoint.getArgs()[i];
//				if (i > 0) {
//					params.append(".");
//				}else if (arg == null) {
//					params.append("null");
//
//				} else if (arg instanceof String) {
//					params.append(arg);
//				} else if (arg instanceof Integer || arg instanceof Long
//						|| arg instanceof Short) {
//					params.append(arg.toString());
//				} else if (arg instanceof Boolean) {
//					params.append(arg.toString());
//				} else {
//					params.append(arg.getClass().getSimpleName());
//				}
//			}
//		}
//		return params.toString();
//	}
//}
