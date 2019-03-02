package com.example.cedriclingom.blablacampus.security.viewmodel;

import com.google.android.material.textfield.TextInputLayout;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T> extends ViewModel {

    @BindingAdapter("app:error")
    public static void setError(TextInputLayout editText, Object strOrResId) {

        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }
    }

    public abstract MutableLiveData<T> getFields();
    public abstract void init();
}
