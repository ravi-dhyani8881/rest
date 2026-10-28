package com.spring.rest.util;



import java.lang.reflect.Field;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class ModelMapperUtil {

    public static <Req, Model> Model mapCreateRequestToModel(Req requestObj, Class<Model> modelClass) {
        try {
            Model model = modelClass.getDeclaredConstructor().newInstance();

            // Copy fields where names match
            for (Field reqField : requestObj.getClass().getDeclaredFields()) {
                reqField.setAccessible(true);
                Object value = reqField.get(requestObj);

                try {
                    Field modelField = modelClass.getDeclaredField(reqField.getName());
                    modelField.setAccessible(true);

                    // Only overwrite if request value is not null
                    if (value != null)
                        modelField.set(model, value);

                } catch (NoSuchFieldException ignore) {
                    // ignore fields not present in model
                }
            }

            // Solr-required fields
            // Set ID
            try {
                Field idField = modelClass.getDeclaredField("iD");
                idField.setAccessible(true);
                idField.set(model, Utility.getUniqueId());
            } catch (NoSuchFieldException e) {
                // if some model does not have ID, ignore
            }

            // Timestamp fields
            String now = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

            try {
                Field created = modelClass.getDeclaredField("createdAt");
                created.setAccessible(true);
                created.set(model, now);
            } catch (NoSuchFieldException ignore) {}

            try {
                Field updated = modelClass.getDeclaredField("updatedAt");
                updated.setAccessible(true);
                updated.set(model, now);
            } catch (NoSuchFieldException ignore) {}

            return model;

        } catch (Exception e) {
            throw new RuntimeException("Failed to map request to model", e);
        }
    }
}