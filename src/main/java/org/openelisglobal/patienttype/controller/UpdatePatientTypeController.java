package org.openelisglobal.patienttype.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.openelisglobal.common.controller.BaseController;
import org.openelisglobal.common.validator.BaseErrors;
import org.openelisglobal.patienttype.form.PatientTypeForm;

//seemingly unused controller
@Controller
public class UpdatePatientTypeController extends BaseController {
	@RequestMapping(value = "/UpdatePatientType", method = RequestMethod.GET)
	public ModelAndView showUpdatePatientType(HttpServletRequest request,
			@ModelAttribute("form") PatientTypeForm form) {
		String forward = FWD_SUCCESS;
		if (form == null) {
			form = new PatientTypeForm();
		}
		form.setFormAction("");
		Errors errors = new BaseErrors();

		return findForward(forward, form);
	}

	@Override
	protected String findLocalForward(String forward) {
		if (FWD_SUCCESS_INSERT.equals(forward)) {
			return "/PatientType.do";
		} else if (FWD_SUCCESS.equals(forward)) {
			return "/PatientTypeMenu.do";
		} else if (FWD_FAIL.equals(forward)) {
			return "patientTypeDefinition";
		} else {
			return "PageNotFound";
		}
	}

	@Override
	protected String getPageTitleKey() {
		return null;
	}

	@Override
	protected String getPageSubtitleKey() {
		return null;
	}
}