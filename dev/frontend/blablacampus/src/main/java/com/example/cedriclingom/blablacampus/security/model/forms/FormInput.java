package com.example.cedriclingom.blablacampus.security.model.forms;

public class FormInput<T> {

    private T value;
    private boolean required;
    private Integer error;

    public FormInput(boolean required){
        this.required = required;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public boolean isRequired() {
        return required;
    }

    Integer getError(){
        return  error;
    }

    public void setError(Integer errorMsg){
        error = errorMsg;
    }

    public void clearError(){
        error = null;
    }
}
