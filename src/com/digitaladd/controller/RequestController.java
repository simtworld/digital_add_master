package com.digitaladd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.digitaladd.dao.productdao.ProductDao;
import com.digitaladd.dao.registrationdao.RegistrationDao;
import com.digitaladd.model.OtpMO;
import com.digitaladd.model.ProductDetailsMO;
import com.digitaladd.model.UserMO;
import com.digitaladd.service.emailservice.EmailService;
import com.digitaladd.service.otpservice.OtpService;
import com.digitaladd.service.password.PasswordService;
import com.digitaladd.service.product.ProductService;
import com.digitaladd.service.smsservice.SmsService;
import com.digitaladd.service.userservice.UserService;
import com.digitaladd.util.emailAPI.EmailAPIConfigVO;
import com.digitaladd.util.emailAPI.EmailAPITemplateDetailsVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class RequestController {
	/*
	 * @GetMapping("/hello") public String hello(Model model) {
	 * 
	 * model.addAttribute("name", "John Doe");
	 * 
	 * return "welcome"; }
	 * 
	 * 
	 * @RequestMapping(path= "/greet/{name}",method=RequestMethod.GET)
	 * 
	 * @ResponseBody public String foo(HttpServletRequest request, @PathVariable
	 * String name) {
	 * 
	 * return "Response!"+request.getParameter("name"); }
	 */

	// Dependency management
	@Autowired
	EmailService emailService;

	@Autowired
	SmsService smsService;

	@Autowired
	UserService userService;

	@Autowired
	OtpService otpService;
	
	@Autowired
	PasswordService passwordService;
	
	@Autowired
	ProductService productService;

	@Autowired
	ProductDao productDao;

	@Autowired
	RegistrationDao registrationDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePageView(ModelMap model) {
		model.addAttribute("name", "Melcow");
		return "home.tiles";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String registrationView(ModelMap model) {
		return "registration.tiles";
	}

	@RequestMapping(value = { "/email-settings" }, method = RequestMethod.GET)
	public String emailSettingsView(ModelMap model) {
		return "email-settings.tiles";
	}

	@RequestMapping(value = { "/sharing-options" }, method = RequestMethod.GET)
	public String shareToSocialView(ModelMap model) {
		return "sharing-options.tiles";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginView(ModelMap model) {
		return "login.tiles";
	}

	@RequestMapping(value = { "/my-profile" }, method = RequestMethod.GET)
	public String myProfileView(HttpServletRequest request, ModelMap model) {
		String returnVal = "login.tiles";
		try {
			HttpSession session = request.getSession();

			if (session.getAttribute("bean") != null) {
				UserMO user = (UserMO) session.getAttribute("bean");
				
				model.addAttribute("user", user);

				returnVal = "my-profile.tiles";
			} else {
				returnVal = "login.tiles";
			}
		} catch (Exception e) {
			System.out.println("RequestController > myProfile() > exception >" + e);
		}
		return returnVal;
	}
	
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public String dashboardView(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("bean") != null) {
			UserMO userMO = (UserMO) session.getAttribute("bean");
			if (userMO.getUserTypeId().equals("USER_05")) {
				return "dashboard.tiles";
			} else {
				return "user-pannel.tiles";
			}
		} else {
			return "login.tiles";
		}
	}

	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String changePasswordView(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("bean") != null) {
			return "changePassword.tiles";
		} else {
			return "login.tiles";
		}
	}
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("bean") != null) {
			session.removeAttribute("bean");
		}
		return "home.tiles";
	}
	
	@RequestMapping(path = "/getallcountries", method = RequestMethod.GET)
	public @ResponseBody List<UserMO> getAllCountries() {
		List<UserMO> countriesList = null;
		try {
			countriesList = registrationDao.getCountreies();

		} catch (Exception e) {
			System.out.println("RequestController > getAllCountries() > exception >" + e);
		}
		return countriesList;
	}

	@RequestMapping(path = "/getallstates", method = RequestMethod.GET)
	public @ResponseBody List<UserMO> getAllStates(@RequestParam(value = "countryCode") String countryCode) {
		List<UserMO> countriesList = null;

		try {
			countriesList = registrationDao.getAllStates(countryCode);

		} catch (Exception e) {
			System.out.println("RequestController > getAllStates() > exception >" + e);
		}
		return countriesList;
	}

	@RequestMapping(path = "/getallcities", method = RequestMethod.GET)
	public @ResponseBody List<UserMO> getAllCities(HttpServletRequest request) {
		List<UserMO> countriesList = null;
		String stateCode = request.getParameter("stateCode");
		try {
			countriesList = registrationDao.getAllCities(stateCode);

		} catch (Exception e) {
			System.out.println("RequestController > getAllCities() > exception >" + e);
		}
		return countriesList;
	}

	@RequestMapping(path = "/customer-registration", method = RequestMethod.GET)
	public @ResponseBody JSONObject customerRegistration(UserMO userMO) {
		JSONObject json = new JSONObject();
		json.putAll(userService.customerRegistrationService(userMO));
		return json;
	}

	@RequestMapping(path = "/check-otp", method = RequestMethod.GET)
	public @ResponseBody JSONObject checkOtp(HttpServletRequest request, OtpMO otpMO) {

		JSONObject json = new JSONObject();
		Map<String, Object> map = otpService.checkOtpService(otpMO);
		if ((boolean) map.get("status")) {
			HttpSession session = request.getSession();
			session.setAttribute("bean", map.get("user"));
		}

		// json.putAll((Map) map.get("jsonMap"));
		return (JSONObject) map.get("jsonMap");

		/*
		 * try { String otp = request.getParameter("otp"); String mobile =
		 * request.getParameter("mobile"); String doLogin =
		 * request.getParameter("doLogin");
		 * 
		 * boolean flag = registrationDao.deleteOtp(otp, mobile);
		 * 
		 * if (flag) { boolean statusChange = registrationDao.changeUserStatus(mobile);
		 * 
		 * if (statusChange) { json.put("status", true);
		 * 
		 * if (doLogin != null && !"".equalsIgnoreCase(doLogin)) { UserMO user =
		 * registrationDao.checkUserExistOrNot(mobile); HttpSession session =
		 * request.getSession();
		 * 
		 * session.setAttribute("bean", user); } } else { json.put("status",
		 * "exception"); } } else { json.put("status", false); } } catch (Exception e) {
		 * System.out.println("RequestController > customerRegistration() > exception >"
		 * + e); }
		 */

	}

	@RequestMapping(path = "/resend-otp", method = RequestMethod.GET)
	public @ResponseBody JSONObject resendOtp(HttpServletRequest request, OtpMO otpMO,
			@RequestParam(value = "uuid") String uuid) {
		JSONObject json = new JSONObject();
		json.putAll(otpService.resendOtpService(otpMO, uuid));
		return json;

		/*
		 * try { String mobile = request.getParameter("mobile"); String uuid =
		 * request.getParameter("uuid");
		 * 
		 * boolean flag = registrationDao.deleteOtp(null, mobile);
		 * 
		 * // if(flag){ String otp = RandomGenerator
		 * .generateNumericRandom(Integer.parseInt(ResourceUtility.getCommonConstant(
		 * "user.otp.length"))); boolean saveOtp = registrationDao.saveOtp(mobile, otp);
		 * if (saveOtp) { boolean sendSms = smsService.sendOtpSMS(mobile, otp, uuid); }
		 * 
		 * if (saveOtp) { json.put("status", true); } else { json.put("status",
		 * "exception"); }
		 * 
		 * }else{ json.put("status", false); }
		 * 
		 * } catch (Exception e) {
		 * System.out.println("RequestController > customerRegistration() > exception >"
		 * + e); json.put("status", "exception"); }
		 */

	}

	@RequestMapping(path = "/check-user-login", method = RequestMethod.GET)
	public @ResponseBody JSONObject checkUserLogin(HttpServletRequest request,@RequestParam(value="userName") String userName,@RequestParam(value="password")String password) {
		JSONObject json = new JSONObject();
		
		Map<String, Object> map= userService.checkUserLoginService(userName, password);
		if((boolean)map.get("status")) {
			HttpSession session = request.getSession();
			session.setAttribute("bean", map.get("user"));
		}
		json.putAll((Map) map.get("jsonMap"));
		System.out.println(json.toString());
		return json;
		
		/*try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			UserMO user = registrationDao.checkUserLogin(userName, password);

			if (user == null) {
				json.put("status", false);
			} else {

				if (user.getMobileStatus() != null && user.getMobileStatus()
						.equalsIgnoreCase(ResourceUtility.getCommonConstant("status.active"))) {
					json.put("status", true);

					HttpSession session = request.getSession();
					System.out.println(user.getUserTypeId());
					session.setAttribute("bean", user);

				} else {
					json.put("status", "mobileNeedToVerify");
					json.put("uuid", user.getUuid());
				}
			}
		} catch (Exception e) {
			System.out.println("RequestController > checkUserLogin() > exception >" + e);
			json.put("status", "exception");
		}*/
		
		
	}

	@RequestMapping(path = "/forgot-password", method = RequestMethod.GET)
	public @ResponseBody JSONObject forgotPassword(HttpServletRequest request,@RequestParam(value="mobile")String mobile) {
		JSONObject json = new JSONObject();
		
		json.putAll(passwordService.forgotPassword(mobile));
		return json;
		
		
		//TODO Remove this code in final release.
		/*try {
			String mobile = request.getParameter("mobile");

			UserMO retUser = registrationDao.checkUserExistOrNot(mobile);

			if (retUser != null && !"".equals(retUser)) {
				SMSAPITemplateVO smsTemplateVO = new SMSAPITemplateVO();
				SMSAPIService service = new SMSAPIService();
				SMSAPIAuditingVO smsAuditingVO = new SMSAPIAuditingVO();
				SMSAPIVO smsapivo = new SMSAPIVO();
				smsTemplateVO = service.getSmsTemplateByTemplateId(
						ResourceUtility.getCommonConstant("sms.template.id.forgot.password"));

				String smsTemplateId = smsTemplateVO.getSmsTemplateId();

				if (smsTemplateId != null && !"".equals(smsTemplateId)) {
					smsAuditingVO.setSmsTemplateId(smsTemplateId);
					smsapivo.setSmsTemplateId(smsTemplateId);
				}
				String smsbody = smsTemplateVO.getSmsTemplate();
				if (smsbody != null && !"".equals(smsbody)) {
					smsbody = smsbody.replace("{0}", retUser.getMobile());
					smsbody = smsbody.replace("{1}", retUser.getPassword());

					System.out.println("RequestController > forgotPassword > smsTemp====>" + smsbody);
					smsAuditingVO.setSms(smsbody);
				}
				// save sms in audit table
				smsAuditingVO.setUuid(retUser.getUuid());
				service.saveSmsAuditing(smsAuditingVO);

				// send sms
				List<String> vCode = new ArrayList<String>();
				List<String> mNumber = new ArrayList<String>();

				vCode.add(retUser.getMobile());
				vCode.add(retUser.getPassword());
				mNumber.add(retUser.getMobile());

				smsapivo.setSmsTo(mNumber);
				smsapivo.setParameters(vCode);

				boolean flag = service.sendSMS(smsapivo);

				json.put("status", flag);

				System.out.println("RequestController > forgotPassword > send sms > " + flag);
			} else {
				json.put("status", "Mobile Not Exists");
			}
		} catch (Exception e) {
			System.out.println("RequestController > forgotPassword() > exception >" + e);
			json.put("status", "exception");
		}*/
		
		
	}

	@RequestMapping(path = "/update-profile", method = RequestMethod.GET)
	public @ResponseBody JSONObject updateProfile(HttpServletRequest request, UserMO user) {
		JSONObject json = new JSONObject();
		try {
			HttpSession session = request.getSession();

			if (session != null) {
				
				Map<String,Object> map=userService.updateProfileService(user);
				
				if ((boolean) map.get("flag")) {
					UserMO newUser = registrationDao.checkUserExistOrNot(user.getMobile());// usr>>user
					session.setAttribute("bean", newUser);

					json.put("status", true);
				} else {
					json.put("status", false);
				}
			} else {
				json.put("status", false);
			}
		} catch (Exception e) {
			System.out.println("RequestController > updateProfile() > exception >" + e);
		}
		return json;
	}

	//TODO check before building
	@RequestMapping(path = "/update-password", method = RequestMethod.GET)
	public @ResponseBody JSONObject updatePassword(HttpServletRequest request,@RequestParam(value="currentPassword")String currentPassword,@RequestParam(value="newPassword")String newPassword) {
		JSONObject json = new JSONObject();
		try {
			HttpSession session = request.getSession();
			UserMO user = (UserMO) session.getAttribute("bean");

			boolean flag = passwordService.checkPassword(user.getUuid(), currentPassword);

			if (flag) {
				boolean updatePwd = passwordService.updatePassword(user.getUuid(), newPassword);

				if (updatePwd) {
					json.put("status", true);

					if (session.getAttribute("bean") != null) {
						session.removeAttribute("bean");
					}
				} else {
					json.put("status", "exception");
				}
			} else {
				json.put("status", "passwordWrong");
			}
		} catch (Exception e) {
			System.out.println("RequestController > updatePassword() > exception >" + e);
			json.put("status", "exception");
		}
		return json;
	}

	@RequestMapping(value = "/savefiles", method = RequestMethod.POST)
	public @ResponseBody boolean addProductDetails(@RequestParam(value = "file") MultipartFile file,
			HttpSession session, ProductDetailsMO productDetails) throws IllegalStateException, IOException {
		String filePath = session.getServletContext().getRealPath("/WEB-INF/assets/img/product/");
		String fileName = file.getOriginalFilename();
		boolean flag = false;
		
		flag=productService.addProductDetails(fileName, filePath, file, productDetails);
		
		return flag;
	}

	@RequestMapping(value = "/delete-product-list", method = RequestMethod.POST)
	public @ResponseBody boolean deleteProduct(@RequestParam("productID") String productUUID) {
		return productService.deleteProductDetails(productUUID);
	}

	/**
	 * when this url is requested, the 'getProducts' method of 'productDao' is
	 * called and get the JSONArray of products
	 */
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public @ResponseBody JSONArray getProducts() {
		JSONArray products = null;
		JSONObject jsonObject = null;
		products = new JSONArray();
		ArrayList<ProductDetailsMO> productDetailsList = new ArrayList<>();
		productDetailsList = productService.getProducts();
		for (ProductDetailsMO productDetails : productDetailsList) {
			jsonObject = new JSONObject();
			jsonObject.put("productId", productDetails.getProductUuid());
			jsonObject.put("productName", productDetails.getProductName());
			jsonObject.put("puoductUrl", productDetails.getProductUrl());
			jsonObject.put("smsDesc", productDetails.getProductDescriptionForSms());
			jsonObject.put("emailDesc", productDetails.getProductDescriptionForEmail());
			jsonObject.put("imageURL", productDetails.getProductImageExtension());
			jsonObject.put("countryId", productDetails.getCountry());
			jsonObject.put("stateId", productDetails.getState());
			jsonObject.put("cityId", productDetails.getCity());
			jsonObject.put("creationDate", productDetails.getCreatedAt().toString());
			jsonObject.put("updationDate", productDetails.getUpdatedAt().toString());
			products.add(jsonObject);
		}

		return products;
	}

	/**
	 * this url used to update the product details avelabel i product table.
	 */
	@RequestMapping(value = "/update-product-details", method = RequestMethod.POST)
	public @ResponseBody boolean updateProduct(ProductDetailsMO productDetails) {
		return productService.updateProduct(productDetails);
	}

	@RequestMapping(value = "/change-email-template", method = RequestMethod.PUT)
	public @ResponseBody boolean changeEmailTemplate(EmailAPITemplateDetailsVO emailAPITemplateDetailsVO) {
		return emailService.changeEmailTemplateService(emailAPITemplateDetailsVO);
	}

	@RequestMapping(value = "/send-product-mail", method = RequestMethod.GET)
	public @ResponseBody boolean sendProductMail(@RequestParam(value = "productUUID") String productUUID,
			@RequestParam(value = "recipiant") String recipiant) {
		return emailService.sendProductMail(productUUID, recipiant);
	}

	@RequestMapping(value = "/change-email-config", method = RequestMethod.PUT)
	public @ResponseBody boolean changeEmailConfig(EmailAPIConfigVO emailAPIConfigVO) {
		return emailService.changeEmailConfigService(emailAPIConfigVO);
	}

}
