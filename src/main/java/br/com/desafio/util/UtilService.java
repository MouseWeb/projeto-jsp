package br.com.desafio.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UtilService {

	private final MessageSource messageSource;

	@Autowired
	public UtilService(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage(String key, Object... args) {
		Locale locale = LocaleContextHolder.getLocale();
		return this.messageSource.getMessage(key, args, locale);
	}

	public String getMessage(String key) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, null, locale);
	}
}