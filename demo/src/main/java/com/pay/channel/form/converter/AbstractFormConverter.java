package com.pay.channel.form.converter;

import org.springframework.stereotype.Component;

/**
 * po和form的对象的互转
 * 转换的目的是为了让controller少些代码
 * @author HanKeQi
 *
 * @param <E>
 * @param <F>
 */
@Component
public interface AbstractFormConverter<E, F> {

    abstract F fromEntity(E e) throws Exception;

    abstract E toEntity(F f) throws Exception;

}
