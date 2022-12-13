package com.etiya.ecommercedemo4;

import com.etiya.ecommercedemo4.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo4.core.util.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemo4Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemo4Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		//veritabanı veya dosyadan çekme.
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		//konfig
		messageSource.setBasename("messages");

		return messageSource;
	}

	//Kullanıcıdan dil tercihini header alanında al.
	//Accept-Language
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors  = new HashMap<String, String>();
		for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}

		return new ErrorDataResult<Object>(validationErrors,"VALIDATION_EXCEPTION");
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		return new ErrorDataResult<>(businessException.getMessage(),"BUSINESS_EXCEPTION");
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDataResult<Object> handleNoSuchElementException(NoSuchElementException exception){
		return new ErrorDataResult<>(exception.getMessage(),"NO_SUCH_ELEMENT_EXCEPTION");
	}

}
