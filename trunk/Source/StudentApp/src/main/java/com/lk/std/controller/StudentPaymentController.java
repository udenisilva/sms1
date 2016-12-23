package com.lk.std.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.model.Branch;
import com.lk.std.model.Payments;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.ParentsService;
import com.lk.std.service.PaymentsService;
import com.lk.std.util.Session;

@Controller
@RequestMapping
public class StudentPaymentController {
	
	@Autowired
	PaymentsService paymentsService;
	
	@Autowired
	ActionLoggerService actionloggerService;

	  @RequestMapping(value = "/studentpayment", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap();  
	    long paymentId = 0;
		Payments payment = null;
		try {
			if (!StringUtils.isBlank(request.getParameter("branchid"))) {
				paymentId = Long.parseLong(request.getParameter("branchid").trim());
			}
			if (paymentId > 0) {
				payment =  paymentsService.findById(paymentId);
			} else {
				payment = new Payments();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		modelMap.addAttribute("payment", payment);	 
	    return new ModelAndView("studentpayment", modelMap);
	  }
	  
	  
	  @RequestMapping(value = "/createPayment", method = RequestMethod.POST)
		public String StaffPager(HttpServletRequest request, @ModelAttribute("branch") Payments payments, BindingResult errors) {
			if (errors.hasErrors()) {
				System.out.println("------------error occured");
			}
			Action action = null;

			try {
				if (!StringUtils.isBlank(request.getParameter("payments_id"))) {
					action = Action.USER_UPDATED;
				} else {
					action = Action.USER_CREATED;
				}

			} catch (Exception e) {
				System.out.println("------------ Exception occured");
			}

			Payments saveService = paymentsService.save(payments);

			if (saveService != null) {
				// set action logger
				actionloggerService.setActionLogger(action, "created by" + Session.getLoggedUserId(), saveService.getId(),
						Session.getLoggedUserId());
				return "redirect:studentprofile.htm?stdId=" + saveService.getId() + "&" + ApplicationConstants.MESSAGE + "="
						+ ApplicationConstants.SUCCESS;
			} else {
				return "redirect:studentprofile.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
			}
		}
}
