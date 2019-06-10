package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Users user = new Users();
	public String login() {
		UsersDAO udao = new UsersDAOImpl();
		System.out.println("UserAction的login中获取数据："+user.getUsername());
		if(udao.usersLogin(user)) {
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else {
			System.out.println("登陆失败"+user.getUsername());
			return "login_failure";
		}
	}
	
	//璇ction涓殑鎵�鏈夋柟娉曢兘浼氳繘琛岄獙璇侊紝鍔犱簡璇ユ爣璁扮殑闄ゅ
	@SkipValidation
	public String logout() {
		if(session.getAttribute("loginUserName")!=null) {
			session.removeAttribute("loginUsername");
		}
		return "logout_success";
	}
	
	
	//妯″瀷椹卞姩鏂瑰紡锛岀洿鎺ヨ繑鍥炲嵆鍙璞★紝涓嶇敤鍦ㄦ湰action涓啓get鍜宻et鏂规硶
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
