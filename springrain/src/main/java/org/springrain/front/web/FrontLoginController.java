package org.springrain.front.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.subject.WebSubject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.shiro.FrameAuthenticationToken;
import org.springrain.frame.shiro.ShiroUser;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.frame.util.SecUtils;
import org.springrain.front.utils.PinyinUtil;
import org.springrain.system.common.SystemEnum;
import org.springrain.system.entity.User;
import org.springrain.system.service.IUserService;


/**
 * 用户登录、注册、修改密码、退出controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/front")
public class FrontLoginController extends BaseController {
	@Resource
	IUserService userService;
	/**
	 * 映射登录提交操作
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ReturnDatas loginPost(User currUser, HttpServletRequest request, Model model,
			HttpSession session, Object object) {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();

		Subject user = SecurityUtils.getSubject();
		// 通过账号和密码获取 UsernamePasswordToken token
		FrameAuthenticationToken token = new FrameAuthenticationToken(currUser.getAccount(),
				currUser.getPassword());

		String rememberme = request.getParameter("rememberme");
		if (StringUtils.isNotBlank(rememberme)) {
			token.setRememberMe(true);
		} else {
			token.setRememberMe(false);
		}
		// 仅限前台会员登录
		token.setUserType(SystemEnum.UserType.前台用户.getType());
		try {
			// 会调用 shiroDbRealm 的认证方法
			// org.springrain.frame.shiro.ShiroDbRealm.doGetAuthenticationInfo(AuthenticationToken)
			user.login(token);
		} catch (UnknownAccountException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("账号不存在!");
		} catch (IncorrectCredentialsException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("密码错误!");
		} catch (LockedAccountException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("未知错误,请联系管理员.");
		}
		session.setAttribute("loginUser", currUser);
		// 设置tokenkey
		String springraintoken = "f_" + SecUtils.getUUID();
		session.setAttribute(GlobalStatic.tokenKey, springraintoken);
		model.addAttribute(GlobalStatic.tokenKey, springraintoken);
		return returnDatas;
	}

	/**
	 * 注册
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/register")
	@ResponseBody
	public ReturnDatas register(HttpServletRequest request, User user) {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		if (StringUtils.isBlank(user.getAccount())) {
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("账号不能为空！");
			return returnDatas;
		}
		if (StringUtils.isBlank(user.getPassword())) {
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("密码不能为空！");
			return returnDatas;
		}
		if (StringUtils.isBlank(user.getEmail())) {
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("邮箱不能为空！");
			return returnDatas;
		}
		if (StringUtils.isBlank(user.getMobile())) {
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("手机号不能为空！");
			return returnDatas;
		}
		user.setUserType(SystemEnum.UserType.前台用户.getType());
		user.setPassword(SecUtils.encoderByMd5With32Bit(user.getPassword()));
		user.setActive(SystemEnum.Active.可用.getType());
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("注册失败！");
		}
		return returnDatas;
	}

	/**
	 * 退出
	 * 
	 * @param request
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			subject.logout();
		}
		return super.redirect + "/front/movie/index";
	}

	/**
	 * 根据汉字生成首字母
	 */
	@RequestMapping("/getHeadCode")
	@ResponseBody
	public ReturnDatas getHeadCode(HttpServletRequest request) {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		String name = request.getParameter("name");
		if (StringUtils.isBlank(name)) {
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("请输入要转换的字符串!");
			return returnDatas;
		}
		String upper = PinyinUtil.getPinYinHeadUpper(name);
		returnDatas.setData(upper);
		return returnDatas;
	}

	@SuppressWarnings("unused")
	private void autoLogin(User user, HttpServletRequest request, HttpServletResponse response) {
		// 模拟登陆
		ShiroUser shiroUser = new ShiroUser();
		shiroUser.setId(user.getId());
		shiroUser.setName(user.getName());
		shiroUser.setAccount(user.getAccount());
		shiroUser.setUserType(user.getUserType());

		SimplePrincipalCollection principals = new SimplePrincipalCollection(shiroUser,
				GlobalStatic.authorizingRealmName);

		WebSubject.Builder builder = new WebSubject.Builder(request, response);

		builder.principals(principals);
		builder.authenticated(true);

		WebSubject subject = builder.buildWebSubject();
		ThreadContext.bind(subject);
	}

}
