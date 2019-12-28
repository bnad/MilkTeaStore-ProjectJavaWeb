/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

/**
 *
 * @author Bui Be Bong
 */
public class ErrorTeaBean {
    private String teaIDError, teaNameError, priceError;
    private String errorMsg;

    public ErrorTeaBean() {
    }

    public String getTeaIDError() {
        return teaIDError;
    }

    public void setTeaIDError(String teaIDError) {
        this.teaIDError = teaIDError;
    }

    public String getTeaNameError() {
        return teaNameError;
    }

    public void setTeaNameError(String teaNameError) {
        this.teaNameError = teaNameError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
}
