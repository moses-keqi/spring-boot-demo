package com.pay.common.helper;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Arrays;
import java.util.List;

/**
 * Some 3rd party (for example, wechat API) and legacy systems don't set response headers correctly to
 * "application/json". We have to handle this by adding extra media types to the supported media type list of the
 * <tt>MappingJackson2HttpMessageConverter</tt>.
 */
public class PlainTextMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public PlainTextMappingJackson2HttpMessageConverter() {
        List<MediaType> types = Arrays.asList(
                //@formatter:off
                new MediaType("application", "json", DEFAULT_CHARSET),
                new MediaType("application", "*+json", DEFAULT_CHARSET),
                new MediaType("text", "html", DEFAULT_CHARSET),
                new MediaType("text", "plain", DEFAULT_CHARSET),
                new MediaType("text", "xml", DEFAULT_CHARSET));
        //@formatter:on
        super.setSupportedMediaTypes(types);
    }

}
