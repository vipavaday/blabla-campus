package com.example.cedriclingom.blablacampus.security.model.forms;

import com.example.cedriclingom.blablacampus.security.model.forms.FormInput;

public class StringFormInput extends FormInput<String> {

    public StringFormInput(boolean required) {
        super(required);

        this.setValue("");
    }
}
