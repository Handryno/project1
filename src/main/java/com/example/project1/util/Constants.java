package com.example.project1.util;

public class Constants {
    public enum RESPONSE {
        HTTP_INTERNAL_ERROR("X5", "Service Internal Error");

        private String code, description;

        RESPONSE(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return this.code;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
