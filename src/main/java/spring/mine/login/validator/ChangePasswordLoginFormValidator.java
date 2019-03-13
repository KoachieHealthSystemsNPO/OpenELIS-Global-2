package spring.mine.login.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spring.mine.common.validator.ValidationHelper;
import spring.mine.login.form.ChangePasswordLoginForm;
import us.mn.state.health.lims.common.provider.validation.ILoginPasswordValidation;
import us.mn.state.health.lims.common.provider.validation.PasswordValidationFactory;

@Component
public class ChangePasswordLoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePasswordLoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ChangePasswordLoginForm form = (ChangePasswordLoginForm) target;

		ValidationHelper.validateFieldAndCharset(form.getLoginName(), "loginName", errors, true, 20,
				"a-zA-Z0-9_@�������������������������Ԍ��ܟ�");

		ILoginPasswordValidation passValidator = PasswordValidationFactory.getPasswordValidator();

		if (!form.getNewPassword().equals(form.getConfirmPassword())) {
			errors.reject("login.error.password.notmatch");
		}
		if (!passValidator.passwordValid(form.getNewPassword()) || !passValidator.passwordValid(form.getPassword())) {
			errors.reject("login.error.message");
		}

	}

}