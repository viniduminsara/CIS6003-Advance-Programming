package dev.viniduminsara.pahanaedu.business.user.dto;

public class UserDTO {
    private String username;
    private String password;
    private String fullName;
    private String contactNumber;
    private String email;

    private UserDTO(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.fullName = builder.fullName;
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
    }

    public static class Builder {
        private String username;
        private String password;
        private String fullName;
        private String contactNumber;
        private String email;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
