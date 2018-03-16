package com.channelsoft.springcloud.exception;

/**
 * <dl>
 * <dt>JsonErrorException</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/14</dd>
 * </dl>
 *
 * @author cuihc
 */
public class JsonErrorException extends Exception{

    public JsonErrorException(String message) {
        super(message);
    }
}
