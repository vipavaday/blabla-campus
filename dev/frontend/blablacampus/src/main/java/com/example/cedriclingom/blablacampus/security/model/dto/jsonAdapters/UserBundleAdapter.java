package com.example.cedriclingom.blablacampus.security.model.dto.jsonAdapters;

import com.example.cedriclingom.blablacampus.security.model.dto.UserBundleDTO;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class UserBundleAdapter extends TypeAdapter<UserBundleDTO> {

    @Override
    public void write(JsonWriter writer, UserBundleDTO userBundle) throws IOException {

        if (userBundle == null) {
            writer.nullValue();
            return;
        }

        writer.beginObject();

        writer.name("firstname").value(userBundle.getFirstname());
        writer.name("lastname").value(userBundle.getLastname());
        writer.name("email").value(userBundle.getEmail());
        writer.name("password").value(userBundle.getPassword());

        writer.endObject();
    }

    @Override
    public UserBundleDTO read(JsonReader in) throws IOException {

        final UserBundleDTO userBundle = new UserBundleDTO();

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "firstname":
                    userBundle.setFirstname(in.nextString());
                    break;
                case "lastname":
                    userBundle.setLastname(in.nextString());
                    break;
                case "email":
                    userBundle.setEmail(in.nextString());
                    break;
                case "password":
                    userBundle.setPassword(in.nextString());
                    break;
            }
        }
        in.endObject();

        return userBundle;
    }
}
