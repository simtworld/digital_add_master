package com.digitaladd.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.digitaladd.registration.dao.ProductDao;
import com.digitaladd.registration.dao.RegistrationDao;
import com.digitaladd.registration.model.ProductDetails;
import com.digitaladd.registration.model.User;
import com.digitaladd.util.RandomGenerator;
import com.digitaladd.util.ResourceUtility;
import com.digitaladd.util.sms.SMSAuditingVO;
import com.digitaladd.util.sms.SMSService;
import com.digitaladd.util.sms.SMSTemplateVO;
import com.digitaladd.util.sms.SMSVO;

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

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String test(ModelMap model) {
		model.addAttribute("name", "Melcow");
		return "home.tiles";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String registration(ModelMap model) {
		return "registration.tiles";
	}

	@RequestMapping(path = "/getallcountries", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllCountries() {
		List<User> countriesList = null;
		try {
			countriesList = RegistrationDao.getInstance().getCountreies();

		} catch (Exception e) {
			System.out.println("RequestController > getAllCountries() > exception >" + e);
		}
		return countriesList;
	}

	@RequestMapping(path = "/getallstates", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllStates(HttpServletRequest request) {
		List<User> countriesList = null;
		String countryCode = request.getParameter("countryCode");
		try {
			countriesList = RegistrationDao.getInstance().getAllStates(countryCode);

		} catch (Exception e) {
			System.out.println("RequestController > getAllStates() > exception >" + e);
		}
		return countriesList;
	}

	@RequestMapping(path = "/getallcities", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllCities(HttpServletRequest request) {
		List<User> countriesList = null;
		String stateCode = request.getParameter("stateCode");
		try {
			countriesList = RegistrationDao.getInstance().getAllCities(stateCode);

		} catch (Exception e) {
			System.out.println("RequestController > getAllCities() > exception >" + e);
		}
		return countriesList;
	}

	@RequestMapping(path = "/customer-registration", method = RequestMethod.GET)
	public @ResponseBody JSONObject customerRegistration(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			String countries = request.getParameter("countries");
			String states = request.getParameter("states");
			String cities = request.getParameter("cities");

			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setPassword(password);
			user.setCountryCode(countries);
			user.setStateCode(states);
			user.setCityCode(cities);

			User retUser = RegistrationDao.getInstance().checkUserExistOrNot(user.getMobile());

			if (retUser == null || "".equals(retUser)) {
				// create user
				StringBuffer buffer = new StringBuffer(ResourceUtility.getCommonConstant("user.uuid.starts.with"));
				buffer.append(RandomGenerator.generateNumericRandom(
						Integer.parseInt(ResourceUtility.getCommonConstant("user.uuid.length"))));

				user.setUuid(buffer.toString());
				// System.out.println("inside request controller" + buffer.toString());
				boolean flag = RegistrationDao.getInstance().customerRegistration(user);

				if (flag) {
					boolean deleteOtp = RegistrationDao.getInstance().deleteOtp(null, user.getMobile());

					String otp = RandomGenerator.generateNumericRandom(
							Integer.parseInt(ResourceUtility.getCommonConstant("user.otp.length")));
					boolean saveOtp = RegistrationDao.getInstance().saveOtp(user.getMobile(), otp);
					if (saveOtp) {
						boolean sendSms = sendOtpSMS(user.getMobile(), otp, user.getUuid());
					}

					json.put("status", true);
					json.put("uuid", user.getUuid());
				} else {
					json.put("status", false);
				}
			} else {
				// user exists
				/*
				 * String mobStatus = retUser.getMobileStatus();
				 * 
				 * if(mobStatus != null && "1".equalsIgnoreCase(mobStatus)){ returnVal =
				 * "mobileEsixts"; }else{ returnVal = "mobileNeedToVerify"; }
				 */
				json.put("status", "mobileExists");
			}
		} catch (Exception e) {
			System.out.println("RequestController > customerRegistration() > exception >" + e);
		}
		return json;
	}

	@RequestMapping(path = "/check-otp", method = RequestMethod.GET)
	public @ResponseBody JSONObject checkOtp(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
			String otp = request.getParameter("otp");
			String mobile = request.getParameter("mobile");
			String doLogin = request.getParameter("doLogin");

			boolean flag = RegistrationDao.getInstance().deleteOtp(otp, mobile);

			if (flag) {
				boolean statusChange = RegistrationDao.getInstance().changeUserStatus(mobile);

				if (statusChange) {
					json.put("status", true);

					if (doLogin != null && !"".equalsIgnoreCase(doLogin)) {
						User user = RegistrationDao.getInstance().checkUserExistOrNot(mobile);
						HttpSession session = request.getSession();

						session.setAttribute("bean", user);
					}
				} else {
					json.put("status", "exception");
				}
			} else {
				json.put("status", false);
			}
		} catch (Exception e) {
			System.out.println("RequestController > customerRegistration() > exception >" + e);
		}
		return json;
	}

	@RequestMapping(path = "/resend-otp", method = RequestMethod.GET)
	public @ResponseBody JSONObject resendOtp(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
			String mobile = request.getParameter("mobile");
			String uuid = request.getParameter("uuid");

			boolean flag = RegistrationDao.getInstance().deleteOtp(null, mobile);

			// if(flag){
			String otp = RandomGenerator
					.generateNumericRandom(Integer.parseInt(ResourceUtility.getCommonConstant("user.otp.length")));
			boolean saveOtp = RegistrationDao.getInstance().saveOtp(mobile, otp);
			if (saveOtp) {
				boolean sendSms = sendOtpSMS(mobile, otp, uuid);
			}

			if (saveOtp) {
				json.put("status", true);
			} else {
				json.put("status", "exception");
			}
			/*
			 * }else{ json.put("status", false); }
			 */
		} catch (Exception e) {
			System.out.println("RequestController > customerRegistration() > exception >" + e);
			json.put("status", "exception");
		}
		return json;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login.tiles";
	}

	@RequestMapping(path = "/check-user-login", method = RequestMethod.GET)
	public @ResponseBody JSONObject checkUserLogin(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			User user = RegistrationDao.getInstance().checkUserLogin(userName, password);

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
		}
		System.out.println(json.toString());
		return json;
	}

	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public String dashboard(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("bean") != null) {
			return "dashboard.tiles";
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

	@RequestMapping(path = "/forgot-password", method = RequestMethod.GET)
	public @ResponseBody JSONObject forgotPassword(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
			String mobile = request.getParameter("mobile");

			User retUser = RegistrationDao.getInstance().checkUserExistOrNot(mobile);

			if (retUser != null && !"".equals(retUser)) {
				SMSTemplateVO smsTemplateVO = new SMSTemplateVO();
				SMSService service = new SMSService();
				SMSAuditingVO smsAuditingVO = new SMSAuditingVO();
				SMSVO smsvo = new SMSVO();
				smsTemplateVO = service.getSmsTemplateByTemplateId(
						ResourceUtility.getCommonConstant("sms.template.id.forgot.password"));

				String smsTemplateId = smsTemplateVO.getSmsTemplateId();

				if (smsTemplateId != null && !"".equals(smsTemplateId)) {
					smsAuditingVO.setSmsTemplateId(smsTemplateId);
					smsvo.setSmsTemplateId(smsTemplateId);
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

				smsvo.setSmsTo(mNumber);
				smsvo.setParameters(vCode);

				boolean flag = service.sendSMS(smsvo);

				json.put("status", flag);

				System.out.println("RequestController > forgotPassword > send sms > " + flag);
			} else {
				json.put("status", "Mobile Not Exists");
			}
		} catch (Exception e) {
			System.out.println("RequestController > forgotPassword() > exception >" + e);
			json.put("status", "exception");
		}
		return json;
	}

	public boolean sendOtpSMS(String mobile, String verificationCode, String uuid) {
		try {
			SMSService service = new SMSService();
			SMSVO smsvo = new SMSVO();
			SMSTemplateVO smsTemplateVO = new SMSTemplateVO();
			SMSAuditingVO smsAuditingVO = new SMSAuditingVO();

			smsTemplateVO = service
					.getSmsTemplateByTemplateId(ResourceUtility.getCommonConstant("sms.template.id.send.otp"));

			String smsTemplateId = smsTemplateVO.getSmsTemplateId();
			if (smsTemplateId != null && !"".equals(smsTemplateId)) {
				smsAuditingVO.setSmsTemplateId(smsTemplateId);
				smsvo.setSmsTemplateId(smsTemplateId);
			}
			String smsBody = smsTemplateVO.getSmsTemplate();
			if (smsBody != null && !"".equals(smsBody)) {
				smsBody = smsBody.replace("{0}", verificationCode);
			}
			smsAuditingVO.setSms(smsBody);
			smsAuditingVO.setUuid(uuid);
			service.saveSmsAuditing(smsAuditingVO);

			List<String> vCode = new ArrayList<String>();
			List<String> mNumber = new ArrayList<String>();

			vCode.add(verificationCode);
			mNumber.add(mobile);

			smsvo.setSmsTo(mNumber);
			smsvo.setParameters(vCode);
			service.sendSMS(smsvo);
		} catch (Exception e) {
			System.out.println("RequestController > sendOtpSMS() > exception >" + e);
		}
		return true;
	}

	@RequestMapping(value = { "/my-profile" }, method = RequestMethod.GET)
	public String myProfile(HttpServletRequest request, ModelMap model) {
		String returnVal = "login.tiles";
		try {
			HttpSession session = request.getSession();

			if (session.getAttribute("bean") != null) {
				User user = (User) session.getAttribute("bean");
				// User user =
				// RegistrationDao.getInstance().checkUserExistOrNot(usr.getMobile());
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

	@RequestMapping(path = "/update-profile", method = RequestMethod.GET)
	public @ResponseBody JSONObject updateProfile(HttpServletRequest request, User user) {
		JSONObject json = new JSONObject();
		try {
			HttpSession session = request.getSession();

			if (session != null) {
				/*
				 * User usr = (User) session.getAttribute("bean");
				 * 
				 * String firstName = request.getParameter("firstName"); String lastName =
				 * request.getParameter("lastName"); String email =
				 * request.getParameter("email"); String mobile =
				 * request.getParameter("mobile"); String countries =
				 * request.getParameter("countries"); String states =
				 * request.getParameter("states"); String cities =
				 * request.getParameter("cities"); String address =
				 * request.getParameter("address");
				 * 
				 * User user = new User(); user.setFirstName(firstName);
				 * user.setLastName(lastName); user.setEmail(email); user.setMobile(mobile);
				 * user.setCountryCode(countries); user.setStateCode(states);
				 * user.setCityCode(cities); user.setAddress(address);
				 * user.setUuid(usr.getUuid());
				 */

				boolean flag = RegistrationDao.getInstance().updateProfile(user);

				if (flag) {
					User newUser = RegistrationDao.getInstance().checkUserExistOrNot(user.getMobile());// usr>>user
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

	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String changePassword(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("bean") != null) {
			return "changePassword.tiles";
		} else {
			return "login.tiles";
		}
	}

	@RequestMapping(path = "/update-password", method = RequestMethod.GET)
	public @ResponseBody JSONObject updatePassword(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("bean");

			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");

			boolean flag = RegistrationDao.getInstance().checkPassword(user.getUuid(), currentPassword);

			if (flag) {
				boolean updatePwd = RegistrationDao.getInstance().updatePassword(user.getUuid(), newPassword);

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
	public @ResponseBody boolean addProductDetails(@RequestParam MultipartFile file, HttpSession session,
			ProductDetails productDetails) throws IllegalStateException, IOException {
		String path = session.getServletContext().getRealPath("/WEB-INF/assets/img/product/");
		String filename = file.getOriginalFilename();
		boolean flag = false;
		try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + filename));

			StringBuffer buffer = new StringBuffer(ResourceUtility.getCommonConstant("user.uuid.starts.with"));
			buffer.append(RandomGenerator
					.generateNumericRandom(Integer.parseInt(ResourceUtility.getCommonConstant("user.uuid.length"))));
			productDetails.setCreatedAt(Calendar.getInstance().getTime());
			productDetails.setUpdatedAt(Calendar.getInstance().getTime());
			productDetails.setProductUuid(buffer.toString());
			productDetails.setProductImageExtension(path + filename);
			flag = ProductDao.getInstance().addProductDetails(productDetails);
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	@RequestMapping(value = "/delete-product-list", method = RequestMethod.POST)
	public @ResponseBody boolean deleteProduct(@RequestParam("productID") String productUUID){
		return ProductDao.getInstance().deletaProductDetails(productUUID);
	}

	
	/**
	 * when this url is requested,
	 * the 'getProducts' method of 'productDao' is called and get the JSONArray of products
	 * */
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public @ResponseBody JSONArray getProducts() {
		JSONArray products = (JSONArray) ProductDao.getInstance().getProducts();
		
		return products;
	}
	
	/**
	 * this url used to update the product details avelabel i product table.
	 * */
	@RequestMapping(value = "/update-product-details", method = RequestMethod.POST)
	public @ResponseBody boolean updateProduct(ProductDetails productDetails) {
		return ProductDao.getInstance().updateProduct(productDetails);
	}

}
