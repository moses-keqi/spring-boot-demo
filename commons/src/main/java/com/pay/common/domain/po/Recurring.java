package com.pay.common.domain.po;

import com.pay.common.domain.AbstractEntity;

/**
 * Created by kaifa4 on 2017/1/17.
 */
public class Recurring extends AbstractEntity {

    private String emberCode;
    private String orderId;
    private String frequency;
    private String currencyCode;
    private String amount;
    private String period;
    private String paymentDay;
    private String newOrderNo;
    private String lastestPaymentDate;
    private String issueno;
    private String nextPaymentDate;
    private String maxFailedTimes;
    private String failedRetryDays;
    private String effFlag;
    private String createDate;
    private String updDate;
    private String strContent;
    private String lineComment;
    private String custInterface;

    public String getEmberCode() {
        return emberCode;
    }

    public void setEmberCode(String emberCode) {
        this.emberCode = emberCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(String paymentDay) {
        this.paymentDay = paymentDay;
    }

    public String getNewOrderNo() {
        return newOrderNo;
    }

    public void setNewOrderNo(String newOrderNo) {
        this.newOrderNo = newOrderNo;
    }

    public String getLastestPaymentDate() {
        return lastestPaymentDate;
    }

    public void setLastestPaymentDate(String lastestPaymentDate) {
        this.lastestPaymentDate = lastestPaymentDate;
    }

    public String getIssueno() {
        return issueno;
    }

    public void setIssueno(String issueno) {
        this.issueno = issueno;
    }

    public String getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(String nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public String getMaxFailedTimes() {
        return maxFailedTimes;
    }

    public void setMaxFailedTimes(String maxFailedTimes) {
        this.maxFailedTimes = maxFailedTimes;
    }

    public String getFailedRetryDays() {
        return failedRetryDays;
    }

    public void setFailedRetryDays(String failedRetryDays) {
        this.failedRetryDays = failedRetryDays;
    }

    public String getEffFlag() {
        return effFlag;
    }

    public void setEffFlag(String effFlag) {
        this.effFlag = effFlag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdDate() {
        return updDate;
    }

    public void setUpdDate(String updDate) {
        this.updDate = updDate;
    }

    public String getStrContent() {
        return strContent;
    }

    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }

    public String getLineComment() {
        return lineComment;
    }

    public void setLineComment(String lineComment) {
        this.lineComment = lineComment;
    }

    public String getCustInterface() {
        return custInterface;
    }

    public void setCustInterface(String custInterface) {
        this.custInterface = custInterface;
    }

}
