package com.etiya.ecommercedemo4.core.util.messages;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessagesManager implements IMessagesService {
    private MessageSource messageSource;


    @Override
    public String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode,null, LocaleContextHolder.getLocale());
    }
}
